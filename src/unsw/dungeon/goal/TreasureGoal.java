package unsw.dungeon.goal;

import unsw.dungeon.Dungeon;

public class TreasureGoal extends ConcreteGoal{
    private Dungeon dungeon;

    public TreasureGoal(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public boolean completed() {
        return dungeon.getEntitesByType("Treasure").size() == 0;
    }

    @Override
    public String toString() {
        return "treasure";
    }
}
