package unsw.dungeon.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;
import unsw.dungeon.DungeonObserver;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * An entity in the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class Entity implements EntitySubject{

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;
    private StringProperty type;
    private CopyOnWriteArrayList<DungeonObserver> observers;

    private ImageView original;

    /**
     * Create an entity positioned in square (x,y)
     * @param x
     * @param y
     */
    
    public Entity(int x, int y, String type) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.type = new SimpleStringProperty(type);
        this.observers = new CopyOnWriteArrayList<DungeonObserver>();
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public StringProperty type() {
        return type;
    }

    public String getType() {
        return type().get();
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }

    @Override
    public void addObserver(DungeonObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(DungeonObserver o) {
        observers.remove(o);
    }

    protected void removeAllObservers() {
        while (observers.size() > 0) {
            observers.remove(0);
        }
    }

    @Override
    public void pingObservers() {
        for (DungeonObserver o : observers) {
            o.update();
        }
    }

    public boolean collides(Entity player) {
        if (this.getType().equals("Player")) {
            return false;
        }
        if (player.getX() == this.getX() && player.getY() == this.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public void smash() {
    }

    public boolean checkUsed() {
        return false;
    }

    public boolean checkSolid() {
        String test = this.getType();
        if (test.equals("Wall")) {
            return true;
        }
        return false;
    }

    public void setX(int value) {
    	x().set(value);
    }

    public void setY(int value) {
    	y().set(value);
    }

    public boolean onTop(Entity entity) {
        if (entity.getX() == this.getX() && entity.getY() == this.getY()) {
            return true;
        }
        return false;
    }

    public void update() {
    }

    public void setOriginalImage(ImageView i) {
        this.original = i;
    }

    public ImageView getOriginal() {
        return this.original;
    }

    public int getID() {
        return 0;
    }
    
    public void pause(boolean status) {
    }

    public void triggerMovement() {
    }

}
