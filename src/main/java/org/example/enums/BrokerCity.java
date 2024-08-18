package org.example.enums;

public enum BrokerCity {
    PLOVDIV ("Plovdiv"),
    SOFIA ("Sofia"),
    NESSEBAR ("Nessebar"),
    BURGAS ("Burgas"),
    VELIKO_TARNOVO ("Veliko+Tarnovo"),
    VARNA ("Varna"),
    BLAGOEBGRAD ("Blagoevgrad"),
    POMORIE ("Pomorie"),
    STARA_ZAGORA ("Stara+Zagora"),
    SLIVEN ("Sliven"),
    TSAREVO ("Tsarevo"),
    YAMBOL ("Yambol");

    private final String text;

    BrokerCity(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
