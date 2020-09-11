package unsw.dungeon.entity;

import unsw.dungeon.Dungeon;

import java.util.List;

public class Switch extends Entity {

    private Dungeon dungeon;
    private State state;

    public Switch(Dungeon dungeon, int x, int y) {
        super(x, y, "Switch");
        this.dungeon = dungeon;
        this.state = State.OFF;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void update() {
        List<Entity> entities = dungeon.getEntities();
        for (Entity temp : entities) {
            if (temp != null) {
                if (temp.getType().equals("Boulder")) {
                    if (temp.onTop(this)) {
                        this.setState(State.ON);
                        return;
                    }
                }
            }
        }
        this.setState(State.OFF);
    }

    @Override
    public boolean checkUsed() {
        if (state == State.ON) {
            return true;
        } 
        return false;
    }

}