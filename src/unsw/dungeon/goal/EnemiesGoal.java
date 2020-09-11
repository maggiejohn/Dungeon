package unsw.dungeon.goal;

import unsw.dungeon.Dungeon;

public class EnemiesGoal extends ConcreteGoal {
    private Dungeon dungeon;

    public EnemiesGoal(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public boolean completed() {
        return dungeon.getEntitesByType("Enemy").size() == 0;
    }

    @Override
    public String toString() {
        return "enemies";
    }

}
