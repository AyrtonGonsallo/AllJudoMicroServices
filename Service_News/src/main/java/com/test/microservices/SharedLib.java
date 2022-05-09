package com.test.microservices;



public class SharedLib {
	public static final String header="Authorization";
	public static final String secret="mon_secret_a_moi";
	public static final String prefix="Bearer ";
	public static final int prefixlength=prefix.length();
	public static final int expirationAccessToken=5*60*1000;
	public static final int expirationRefreshToken=15*60*1000;
	
	
}
