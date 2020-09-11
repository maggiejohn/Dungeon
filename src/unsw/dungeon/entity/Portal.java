package unsw.dungeon.entity;

import unsw.dungeon.Dungeon;

public class Portal extends Entity {
    
    private Dungeon dungeon;
    private int id;
    private boolean active;
    public Portal(Dungeon dungeon, int x, int y, int id) {
        super(x, y, "Portal");
        this.dungeon = dungeon;
        this.id = id;
        this.active = true;
    }

    @Override
    public int getID() {
        return this.id;
    }

    public void smash() {
        if (!active) {
            System.out.println("Portal Inactive");
            return;
        } 
        for (Entity e : dungeon.getEntities()) {
            if (e.getType() == "Portal") {
                Portal tempPortal = (Portal) e;
                if (tempPortal.getID() == id && (tempPortal.getX() != this.getX() || tempPortal.getY() != this.getY())) {
                    tempPortal.deActivate();
                    System.out.println("You teleported from" + Integer.toString(this.getX()));
                    dungeon.getPlayer().setX(tempPortal.getX());
                    dungeon.getPlayer().setY(tempPortal.getY());
                    return;
                }
            }
        }
    }
    
    public void deActivate() {
        active = false;
    }

    public void activate() {
            active = true;
    }
}