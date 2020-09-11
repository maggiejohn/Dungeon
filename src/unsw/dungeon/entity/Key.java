package unsw.dungeon.entity;

import unsw.dungeon.Dungeon;

public class Key extends Entity {
    
    private Dungeon dungeon;

    private int id;

    public Key(Dungeon dungeon, int x, int y, int keyID) {
        super(x, y, "Key");
        this.dungeon = dungeon;
        this.id = keyID;
    }

    @Override
    public void smash() {
        dungeon.getPlayer().setKey(this);
        dungeon.removeEntity(this);
    }

    @Override
    public void update() {
        if (dungeon.getPlayer().getKeyInventory() == 0) {
            return;
        } else if (this.equals(dungeon.getPlayer().getKey())) {
            this.setX(dungeon.getPlayer().getX());
            this.setY(dungeon.getPlayer().getY());
        }
        return;
    }

    @Override
    public int getID() {
        return this.id;
    }
}