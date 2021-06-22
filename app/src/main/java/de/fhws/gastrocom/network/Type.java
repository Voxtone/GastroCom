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
}
