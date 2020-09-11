package unsw.dungeon;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import unsw.dungeon.entity.Enemy;
import unsw.dungeon.entity.Entity;
import unsw.dungeon.entity.Player;
import unsw.dungeon.entity.Portal;
import unsw.dungeon.ui.LevelSelectScreen;

import java.util.List;

public class DungeonDisplay implements DungeonObserver {
    Dungeon dungeon;
    Player player;
    private final Alert alert = new Alert(Alert.AlertType.NONE);

    public DungeonDisplay(Dungeon dungeon, Player player) {
        this.dungeon = dungeon;
        this.player = player;
        this.player.addObserver(this);
        alert.getButtonTypes().setAll(new ButtonType("back"));
        alert.setTitle("Wow");
        alert.setContentText("You have completed level " + dungeon.getDungeonIndex() + 1);
        alert.setOnHidden(event -> {
            LevelSelectScreen levelSelect = new LevelSelectScreen();
            levelSelect.activate();
        });
        
        alert.setHeaderText("You win!");

    }

    @Override
    public void update() {
        List<Entity> entities = dungeon.getEntities();
        for (Entity temp : entities) {
            if (temp != null) {
                // if (temp.getType().equals("Enemy")) {
                //     Enemy enemy = (Enemy) temp;
                //     enemy.triggerMovement();
                // }
                if (temp.getType().equals("Portal")) {
                    Portal portal = (Portal) temp;
                    portal.activate();
                }
            }

        }

        for (Entity temp : dungeon.getEntities()) {
            if (temp != null) {
                if (temp.collides(player)) {
                    temp.smash();
                }

            }
        }
        dungeon.getEntitesByType("Switch").forEach(s -> s.update());
        if (dungeon.getGoal() != null && dungeon.getGoal().completed()) {
            alert.showAndWait();
            DungeonApplication.setLevelStatus(dungeon.getDungeonIndex() + 1, true);
        }
    }

    public Entity getEntity() {
        return player;
    }
}