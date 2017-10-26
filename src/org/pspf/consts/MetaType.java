package org.pspf.consts;

public enum MetaType {

	PT("PMS"),
	P("PROFILE_API"),
    LT("LEGACY"),
    L("LEGACY_API")
    ;

    private final String text;

    /**
     * @param text
     */
    private MetaType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	
	
}
