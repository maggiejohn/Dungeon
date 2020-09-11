package unsw.dungeon.goal;

import unsw.dungeon.Dungeon;

public class GoalFactory {
    private Dungeon dungeon;
    public GoalFactory(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public Goal byType(String type) {
        switch (type) {
            case "exit":
                return new ExitGoal(dungeon);
            case "enemies":
                return new EnemiesGoal(dungeon);
            case "treasure":
                return new TreasureGoal(dungeon);
            case "boulders":
                return new BouldersGoal(dungeon);
        }
        return null;
    }

}
