package unsw.dungeon.entity;


import unsw.dungeon.Dungeon;

public class Potion extends Entity {
    private Dungeon dungeon;

    public Potion(Dungeon dungeon, int x, int y) {
        super(x, y, "Potion");
        this.dungeon = dungeon;
    }
    public void smash() {
        System.out.println("You picked up a potion!");
        dungeon.getPlayer().setInvincibility(true);
        dungeon.removeEntity(this);
    }

}

