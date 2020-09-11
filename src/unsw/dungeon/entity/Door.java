package unsw.dungeon.entity;

import unsw.dungeon.Dungeon;

public class Door extends Entity {

    private Dungeon dungeon;
    private State state;
    private int id;

    public Door(Dungeon dungeon, int x, int y, int id) {
        super(x, y, "Door");
        this.dungeon = dungeon;
        this.state = State.OFF;
        this.id = id;
    }

    @Override
    public boolean checkSolid() {
//        if (this.state == State.ON) {
//            return false;
//        }
//        if (dungeon.getPlayer().getKeyInventory() == 0) {
//            return true;
//        }
//        if (this.id == dungeon.getPlayer().getKey().getID()) {
//            this.state = State.ON;
//            dungeon.getPlayer().delKey();
//            return false;
//        } else if (this.state == State.ON) {
//            return false;
//        }
//        return true;

        return state == State.OFF && (dungeon.getPlayer().getKeyInventory() == 0 || dungeon.getPlayer().getKey().getID() != id);
    }

    public boolean getOpened() {
        return state == State.ON;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void smash() {
        dungeon.openDoor(this);
    }
}