package de.fhws.gastrocom.network;

import androidx.annotation.NonNull;

public enum Type {
    ORDER("Bestellen \u2713"), PAY("Bezahlen €");

    private String text;

    Type(String text) {
        this.text = text;
    }

    @NonNull
    @Override
    public String toString() {
        return text;
    }

    public static Type stringToType(String type) {
        switch (type) {
            case "bestellen":
                return ORDER;
            case "bezahlen":
                return PAY;
            default:
                throw new IllegalArgumentException(type + " is not a valid Type!");
        }
    }
}
