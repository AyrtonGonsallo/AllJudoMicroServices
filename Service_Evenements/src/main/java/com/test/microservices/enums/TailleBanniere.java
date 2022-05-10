package com.test.microservices.enums;

public enum TailleBanniere {
	T1("160x600"),
    T2("300x250"),
    T3("300x60"),
    T4("336x280"),
    T5("728x90"),
    T6("768x90")
    		
    ;

    private final String text;

    /**
     * @param text
     */
    TailleBanniere(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
