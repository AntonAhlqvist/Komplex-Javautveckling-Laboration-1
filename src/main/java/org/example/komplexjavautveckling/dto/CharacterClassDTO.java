package org.example.komplexjavautveckling.dto;

public class CharacterClassDTO {
    private String name;
    private String displayName;
    private int startingPesetas;

    public CharacterClassDTO(String name, String displayName, int startingPesetas) {
        this.name = name;
        this.displayName = displayName;
        this.startingPesetas = startingPesetas;
    }

    public String getName() { return name; }

    public String getDisplayName() { return displayName; }

    public int getStartingPesetas() { return startingPesetas; }
}
