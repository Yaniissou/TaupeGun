package fr.yanissou.taupegun;
import java.util.Arrays;

public enum GameState {
    INITIALIZATION("Initialisation"),
    WAITING("En attente"),
    STARTING("Démarrage"),
    PLAYING("En cours"),
    FINISH("Terminé");

    private final String name;
    private static GameState currentState;

    GameState(String name) {
        this.name = name;
    }

    public static void setState(GameState gameState) {
        currentState = gameState;
    }

    public static boolean isState(GameState... gameState) {
        return Arrays.asList(gameState).contains(currentState);
    }

    public static GameState getState() {
        return currentState;
    }

    public String getName() {
        return name;
    }
}

