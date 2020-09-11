package unsw.dungeon.entity;

import unsw.dungeon.Dungeon;
import unsw.dungeon.DungeonApplication;

public class Treasure extends Entity {
    private Dungeon dungeon;
    private State looted;

    public Treasure(Dungeon dungeon, int x, int y) {
        super(x, y, "Treasure");
        this.dungeon = dungeon;
        this.looted = State.OFF;
    }

    @Override
    public boolean checkUsed() {
        if (this.looted == State.ON) {
            return true;
        }
        return false;
    }

    @Override
    public void smash() {
        System.out.println("Looted Treasure!");
        DungeonApplication.giveGold(1);
        this.looted = State.ON;
        dungeon.removeEntity(this);
    }

}