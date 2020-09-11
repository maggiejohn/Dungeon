package test;

import unsw.dungeon.Dungeon;
import unsw.dungeon.entity.Player;

public class TestUtil {

    public static void moveLeft(Player player, int steps) {
        for (int i = 0; i < steps; i++) {
            player.moveLeft();
        }
    }

    public static void moveRight(Player player, int steps) {
        for (int i = 0; i < steps; i++) {
            player.moveRight();
        }
    }

    public static void moveUp(Player player, int steps) {
        for (int i = 0; i < steps; i++) {
            player.moveUp();
        }
    }

    public static void moveDown(Player player, int steps) {
        for (int i = 0; i < steps; i++) {
            player.moveDown();
        }
    }

    public static int countEnemy(Dungeon dungeon) {
        return (int) dungeon.getEntities().stream().filter(e -> e.getType().equals("Enemy")).count();
    }
}
