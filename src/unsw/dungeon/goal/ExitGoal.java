package unsw.dungeon.goal;

import unsw.dungeon.Dungeon;
import unsw.dungeon.entity.Entity;

public class ExitGoal extends ConcreteGoal {
    private Dungeon dungeon;

    public ExitGoal(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public boolean completed() {
        for (Entity entity : dungeon.getEntities()) {
            if (entity != null) {
                if (entity.getType().equals("Exit") && entity.checkUsed()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "exit";
    }
}
