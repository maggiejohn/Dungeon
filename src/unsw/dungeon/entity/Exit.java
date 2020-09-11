package unsw.dungeon.entity;

import unsw.dungeon.Dungeon;

public class Exit extends Entity {
    
    private boolean accessed;

    public Exit(Dungeon dungeon, int x, int y) {
        super(x, y, "Exit");
        this.accessed = false;
    }

    @Override
    public void smash() {
        this.accessed = true;
    }

    @Override
    public boolean checkUsed() {
        return this.accessed;
    }

}