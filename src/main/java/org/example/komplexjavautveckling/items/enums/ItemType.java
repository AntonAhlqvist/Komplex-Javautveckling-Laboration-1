package org.example.komplexjavautveckling.items.enums;

public enum ItemType {

    SWORD("Svärd"),
    DAGGER("Dolk"),
    STAFF("Stav"),
    BOW("Pilbåge"),
    ARMOR("Rustning"),
    JEWELRY("Smycke"),
    POTION("Dryck");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
