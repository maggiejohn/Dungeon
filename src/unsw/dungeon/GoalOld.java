package unsw.dungeon;

import unsw.dungeon.entity.Entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GoalOld implements GoalInterfaceOld {
    private Boolean completed;
    private String type;
    private String condition;

    private CopyOnWriteArrayList<Entity> entities;

    private Dungeon dungeon;

    public GoalOld(String type, String condition) {
        this.completed = false;
        this.type = type;
        this.condition = condition;
        this.entities = new CopyOnWriteArrayList<Entity>();
    }

    @Override
    public void updateGoal() {
        if (type.equals("exit") && entities != null) {
            for (Entity temp : entities) {
                if (temp != null) {
                    if (temp.checkUsed()) {
                        this.completed = true;
                    }
                }
            }
        } else if (type.equals("boulder") && entities != null) {
            for (Entity temp : entities) {
                if (temp != null) {
                    if (temp.getType().equals("Switch")) {
                        temp.update();
                        if (!temp.checkUsed()) {
                            return;
                        }
                    }
                }
            }
            this.completed = true;
        } else if (type.equals("treasure") && entities != null) {
            for (Entity temp : entities) {
                if (temp != null) {
                    if (temp.getType().equals("Treasure")) {
                        if (!temp.checkUsed()) {
                            return;
                        }
                    }
                }
            }
            this.completed = true;
        }
    }

    // @Override
    // public void updateGoal(Treasure treasure) {
    //     if (exit.checkAccessed() && type.equals("exit")) {
    //         this.completed = true;
    //     }
    // }

    public boolean checkCompleted() {
        return completed;
    }

    //Goals such as exit, boulders, etc
    public String getType() {
        return this.type;
    }

    //Conditionals such as AND and OR
    public String getCondition() {
        return this.condition;
    }

    public String toString() {
        if (type.equals("exit")) {
            return "Get to the exit";
        } else if (type.equals("boulder")) {
            return "Place boulders on all the switches";
        } else if (type.equals("treasure")) {
            return "Collect all the treasure";
        }
        return "TODO";
    }

    public void addEntities(List<Entity> listEntities) {
        for (Entity temp : listEntities) {
            if (temp != null) {
                if (type.equals("exit")) {
                    if (temp.getType().equals("Exit")) {
                        entities.add(temp);
                    }
                } else if (type.equals("boulder"))  {
                    if (temp.getType().equals("Switch")) {
                        entities.add(temp);
                    }
                } else if (type.equals("treasure")) {
                    if (temp.getType().equals("Treasure")) {
                        entities.add(temp);
                    }
                }
            }
        } 
    }
}