package com.test.microservices.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.test.microservices.SharedLib;

public class JwtAutorisationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// elle va verifier les token si on est deja authentifier
		System.out.println("Filter Before actif...\nRequete vers "+request.getServletPath());
		if(request.getServletPath().equals("/refreshToken")) {
			filterChain.doFilter(request, response);//tu passes au filtre suivant car le
			//refresh token n'a pas de roles pour faire la verification du bas
		}else {
			String authToken=request.getHeader(SharedLib.header);
			if(authToken!=null&&authToken.startsWith(SharedLib.prefix)) {
				
				try {
					String jwt=authToken.substring(7);
					Algorithm algorithm =Algorithm.HMAC256(SharedLib.secret);
					JWTVerifier verifier=JWT.require(algorithm).build();
					DecodedJWT decoded= verifier.verify(jwt);
					String username=decoded.getSubject();
					String[] roles=decoded.getClaim("roles").asArray(String.class);
					Collection<GrantedAuthority>gats=new ArrayList<>();
					for(String r:roles) {
						gats.add(new SimpleGrantedAuthority(r));
					}
					UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(username, null,gats);
					SecurityContextHolder.getContext().setAuthentication(upat);
					System.out.println("Votre token est valide !");
					filterChain.doFilter(request, response);//tu passes au filtre suivant 
				} catch (Exception e) {
					// TODO: handle exception
					response.setHeader("error message", e.getMessage());
					System.out.println(e.getMessage());
					response.sendError(HttpServletResponse.SC_FORBIDDEN);
				}
				
			}else {
				System.out.println("Pas de token dans la requette");
				filterChain.doFilter(request, response);
			}
		}
		
		
	}

}
