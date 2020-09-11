package unsw.dungeon.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import unsw.dungeon.Dungeon;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

    private Dungeon dungeon;
    private StringProperty direction;
    private int swordCharges;
    private boolean invincible;
    private boolean fail = false;
    private Key key;

    private static boolean startingSword;

    private int keyInventory = 0;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y, "Player");
        this.dungeon = dungeon;
        swordCharges = 0;
        if (Player.startingSword) {
            swordCharges = 5;
        }
        invincible = false;

    }

    public int getSwordCharges() {
        return swordCharges;
    }

    public void setSwordCharges(int charges) {
        swordCharges = charges;
    }

    public boolean getInvincibility() {
        return invincible;
    }

    public void setInvincibility(boolean status) {
        invincible = status;
    }

    public String getDirection() {
        return direction.get();
    }

    public void moveUp() {
        int newY = getY() - 1;
        int newX = getX();
        direction = new SimpleStringProperty("Up");
        if (dungeon.validMove(this, newX, newY)) {
            y().set(newY);
            pingObservers();
        }
    }

    public void moveDown() {
        int newY = getY() + 1;
        int newX = getX();
        direction = new SimpleStringProperty("Down");
        if (dungeon.validMove(this, newX, newY)) {
            y().set(newY);
            pingObservers();
        }

    }

    public void moveLeft() {
        int newY = getY();
        int newX = getX() - 1;
        direction = new SimpleStringProperty("Left"); 
        if (dungeon.validMove(this, newX, newY)) {
            x().set(newX);           
            pingObservers();
        }
    }

    public void moveRight() {
        int newY = getY();
        int newX = getX() + 1;
        direction = new SimpleStringProperty("Right");
        if (dungeon.validMove(this, newX, newY)) {
            x().set(newX);
            direction = new SimpleStringProperty("Right");
            pingObservers();
        }

    }

    public void fail() {
        fail = true;
        removeAllObservers();
    }
    public boolean failed(){
        return fail;
    }

    public void setKey(Key key) {
        this.key = key;
        this.keyInventory = 1;
    }

    public Key getKey() {
        return this.key;
    }
    public void delKey() {
        this.keyInventory = 0;
        dungeon.removeEntity(this.key);
    }

    public int getKeyInventory() {
        return this.keyInventory;
    }

    public static boolean getStartingSword() {
        return Player.startingSword;
    }
    public static void setStartingSword() {
        Player.startingSword = true;
    }
}
