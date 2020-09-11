package unsw.dungeon.goal;

import unsw.dungeon.Dungeon;

public class BouldersGoal extends ConcreteGoal {
    private Dungeon dungeon;

    public BouldersGoal(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public boolean completed() {
        System.out.println("check");
        dungeon.getEntitesByType("Switch").forEach(e-> System.out.println(e.checkUsed()));
        return dungeon.getEntitesByType("Switch").stream().allMatch(e -> e.checkUsed());
    }

    @Override
    public String toString() {
        return "boulders";
    }
}
