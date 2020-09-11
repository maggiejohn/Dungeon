/**
 *
 */
package unsw.dungeon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import unsw.dungeon.controller.DungeonController;
import unsw.dungeon.entity.Door;
import unsw.dungeon.entity.Entity;
import unsw.dungeon.entity.Player;
import unsw.dungeon.goal.Goal;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon {
    private int dungeonIndex;
    private int width, height;
    private CopyOnWriteArrayList<Entity> entities;
    private Player player;

    private DungeonDisplay dungeonDisplay;


    private Goal goal;

    private DungeonController controller;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new CopyOnWriteArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.dungeonDisplay = new DungeonDisplay(this, player);
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
    public Goal getGoal() {
        return goal;
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public void removeEntity(Entity delEntity) {
        CopyOnWriteArrayList<Entity> newEntities = new CopyOnWriteArrayList<>();

        for (Entity e : entities) {
            if (e != delEntity) {
                newEntities.add(e);
            }
        }
        entities = newEntities;
        ImageView original = delEntity.getOriginal();
        if (controller != null) {
            controller.removeImage(original);
        }
    }

    public void addEntity(Entity entity) {
        if (entity != null) {
            if (!entity.getType().equals("Player")) {
                entity.addObserver(dungeonDisplay);
            }
            entities.add(entity);
        }
    }

    public boolean validMove(Entity player, int x, int y) {
        if (x > getWidth() - 1 || y > getHeight() - 1 || x < 0 || y < 0) {
            return false;
        }
        for (Entity temp : this.entities) {
            if (temp != null) {
                if (temp.getX() == x && temp.getY() == y) {
                    if (temp.getType().equals("Boulder") && player.getType().equals("Enemy")) {
                        return false;
                    } else {
                        if (temp.checkSolid()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

//    public void addGoal(GoalOld goal) {
//        goals.add(goal);
//        goal.addEntities(this.entities);
//    }
//
//    public List<GoalOld> getGoals() {
//        return goals;
//    }

    public void printGoal() {
        System.out.println("~~~~GOALS~~~~");
//        String type = "ONE";
//        for (GoalOld temp : goals) {
//            if (temp != null) {
//                System.out.println(temp.toString());
//                type = temp.getCondition();
//            }
//        }
//        if (type.equals("ONE") || type.equals("OR")) {
//            System.out.println("~~~~Complete one of the above~~~~");
//        }

        System.out.println(goal);
    }

    public void setController(DungeonController controller) {
        this.controller = controller;
    }

    public void openDoor(Door door) {
        removeEntity(door);
        int x = door.getX();
        int y = door.getY();
        Image openDoorImage = new Image((new File("images/open_door.png")).toURI().toString());
        ImageView view = new ImageView(openDoorImage);
        GridPane.setColumnIndex(view, x);
        GridPane.setRowIndex(view, y);
        door.setOriginalImage(view);
        controller.setImage(view);
    }

    public List<Entity> getEntitesByType(String type) {
        return entities.stream().filter(e -> type.equals(e.getType())).collect(Collectors.toList());
    }

    public void setDungeonIndex(int index) {
        dungeonIndex = index;
    }

    public int getDungeonIndex() {
        return dungeonIndex;
    }

    public void pauseAll(boolean status) {
	    for (Entity temp : entities) {
            if (temp.getType().equals("Enemy")) {
                temp.pause(status);
            }
        }
    }

}
