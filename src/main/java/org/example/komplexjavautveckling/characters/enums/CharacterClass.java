package org.example.komplexjavautveckling.characters.enums;

public enum CharacterClass {

    MYSTIC("Mystiker", 140),
    BLADEBEARER("Klingbärare", 100),
    ARROWMASTER("Pilmästare", 160),
    SHADOWDANCER("Skuggdansare", 200);

    private final String displayName;
    private final int startingPesetas;

    CharacterClass(String displayName, int startingPesetas) {

        this.displayName = displayName;
        this.startingPesetas = startingPesetas;
    }

    public String getDisplayName() { return displayName; }
    public int getStartingPesetas() { return startingPesetas; }
}
