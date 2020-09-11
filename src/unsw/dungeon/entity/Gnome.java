package unsw.dungeon.entity;

import javafx.animation.Timeline;
import unsw.dungeon.Dungeon;
import javafx.animation.KeyFrame;
import javafx.util.Duration;


public class Gnome extends Entity {

    private Dungeon dungeon;
    protected Timeline timeline;
    private int tickCheck = 1;

    public Gnome(Dungeon dungeon, int x, int y) {
        super(x, y, "Enemy");
        this.dungeon = dungeon;
        this.timeline = new Timeline();
    }

    @Override
    public void triggerMovement() {
        if (dungeon.getPlayer().getX()==getX()&&dungeon.getPlayer().getY() == getY()) {
            smash();
            return;
        }
        if (tickCheck % 5 == 0) {
            move();
        }
        tickCheck += 1;
    }

    public void move() {
        int xActual = this.getX();
        int yActual = this.getY();
        int xPlayer = dungeon.getPlayer().getX();
        int yPlayer = dungeon.getPlayer().getY();
        int xBest = 0;
        int yBest = 0;
        if (Math.abs(xActual - xPlayer) > Math.abs(yActual - yPlayer)) {
            if (xActual - xPlayer < 0) {
                xBest = xActual + 1;
            } else {
                xBest = xActual - 1;
            }
            yBest = yActual;
        } else {
            if (yActual - yPlayer < 0) {
                yBest = yActual + 1;
            } else {
                yBest = yActual - 1;
            }
            xBest = xActual;
        }

        if (dungeon.validMove(this, xBest, yBest)) {
            this.setX(xBest);
            this.setY(yBest);
        } 
    }

    @Override
    public void smash() {
        Player player = dungeon.getPlayer();

        if (player.getInvincibility()) {
            System.out.println("You killed an enemy!");
            System.out.println(this);
            dungeon.removeEntity(this);
            timeline.stop();
        } else if (player.getSwordCharges() > 0) {
            System.out.println("You killed an enemy!");
            dungeon.removeEntity(this);
            player.setSwordCharges(player.getSwordCharges() - 1);
            timeline.stop();
        } else {
            System.out.println("You have died!");
            dungeon.getPlayer().fail();
//            Platform.exit();
        }
    }

    public void initialiseTimeLine() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), e -> {
            triggerMovement();
        }));
        timeline.play();
    }

    @Override
    public void pause(boolean status) {
        if (status) {
            timeline.play();
        } else {
            timeline.pause();
        }
    }
}