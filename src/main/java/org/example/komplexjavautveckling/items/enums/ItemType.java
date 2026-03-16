package org.example.komplexjavautveckling.items.enums;

import java.util.Set;

public enum ItemType {

    SWORD("Svärd"),
    DAGGER("Dolk"),
    STAFF("Stav"),
    BOW("Pilbåge"),
    ARMOR("Rustning"),
    JEWELRY("Smycke"),
    POTION("Dryck");

    private final String displayName;

    private static final Set<ItemType> FORGE_TYPES = Set.of(
            SWORD,
            DAGGER,
            STAFF,
            BOW
    );

    ItemType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isForgeWeapon() {
        return FORGE_TYPES.contains(this);
    }
}
