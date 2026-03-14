package org.example.komplexjavautveckling.items.enums;

public enum ItemType {

    SWORD("Sword"),
    DAGGER("Dagger"),
    BOW("Bow"),
    STAFF("Staff"),
    POTION("Potion"),
    JEWELRY("Jewelry"),
    ARMOR("Armor");

    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
