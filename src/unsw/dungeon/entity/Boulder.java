package unsw.dungeon.entity;

import unsw.dungeon.Dungeon;

import java.util.List;

public class Boulder extends Entity {

    private Dungeon dungeon;

    public Boulder(Dungeon dungeon, int x, int y) {
        super(x, y, "Boulder");
        this.dungeon = dungeon;
    }

    @Override
    public void smash() {
        Player player = dungeon.getPlayer();
        String direction = player.getDirection();
        switch (direction) {
            case "Up":
                this.setY(this.getY() - 1);
                break;
            case "Down":
                this.setY(this.getY() + 1);
                break;
            case "Left":
                this.setX(this.getX() - 1);
                break;
            case "Right":
                this.setX(this.getX() + 1);
                break;
        }

    }

    // fix bug: when a boulder reaches the map bound
    public boolean checkMove(String direction) {
        List<Entity> entities = dungeon.getEntities();
        for (Entity temp : entities) {
            if (temp != null) {
                switch (direction) {
                    case "Up":
                        if (this.getY() == 0) {
                            return false;
                        }
                        if (temp.getY() == this.getY() - 1 && temp.getX() == this.getX()) {
                            if (temp.getType().equals("Boulder")) {
                                return false;
                            } else if (temp.checkSolid()) {
                                return false;
                            }
                        }
                        break;
                    case "Down":
                        if (this.getY() == dungeon.getHeight() - 1) {
                            return false;
                        }
                        if (temp.getY() == this.getY() + 1 && temp.getX() == this.getX()) {
                            if (temp.getType().equals("Boulder")) {
                                return false;
                            } else if (temp.checkSolid()) {
                                return false;
                            }
                        }
                        break;
                    case "Left":
                        if (this.getX() == 0) {
                            return false;
                        }
                        if (temp.getX() == this.getX() - 1 && temp.getY() == this.getY()) {
                            if (temp.getType().equals("Boulder")) {
                                return false;
                            } else if (temp.checkSolid()) {
                                return false;
                            }
                        }
                        break;
                    case "Right":
                        if (this.getX() == dungeon.getWidth() - 1) {
                            return false;
                        }
                        if (temp.getX() == this.getX() + 1 && temp.getY() == this.getY()) {
                            if (temp.getType().equals("Boulder")) {
                                return false;
                            } else if (temp.checkSolid()) {
                                return false;
                            }
                        }
                        break;
                }
            }
        }
        return true;
    }


    @Override
    public boolean checkSolid() {
        Player player = dungeon.getPlayer();
        String direction = player.getDirection();
        if (checkMove(direction)) {
            return false;
        } else {
            return true;
        }

    }
}