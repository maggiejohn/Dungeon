package test;

import org.junit.Test;
import unsw.dungeon.*;
import unsw.dungeon.entity.Player;
import unsw.dungeon.entity.Portal;
import unsw.dungeon.entity.Wall;

import static org.junit.Assert.assertEquals;


public class MovementTest {
  

    @Test
    public void testMove() {

        Dungeon dungeon = new Dungeon(10, 10);

        Wall wall1 = new Wall(0, 0);
        Wall wall2 = new Wall(0, 1);
        Wall wall3 = new Wall(1, 0);
        Wall wall4 = new Wall(2, 2);

        
        dungeon.addEntity(wall1);
        dungeon.addEntity(wall2);
        dungeon.addEntity(wall3);
        dungeon.addEntity(wall4);

        Player player = new Player(dungeon, 1, 1);
        dungeon.setPlayer(player);
        
        // up and left: wall
        player.moveUp();
        player.moveLeft();
        assertEquals(1, player.getX());
        assertEquals(1, player.getY());
        player.moveDown();
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());
        // right: wall
        player.moveRight();
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());
        player.moveDown();
        TestUtil.moveRight(player, 5);
        assertEquals(6, player.getX());
        assertEquals(3, player.getY());

    }


    @Test
    public void testPortal() {

        Dungeon dungeon = new Dungeon(10, 10);

        Portal portal1 = new Portal(dungeon, 1, 3, 1);
        Portal portal2 = new Portal(dungeon, 6, 7, 1);

        dungeon.addEntity(portal1);
        dungeon.addEntity(portal2);

        Player player = new Player(dungeon, 1, 1);
        dungeon.setPlayer(player);
        
        // up and left: wall

        assertEquals(1, player.getX());
        assertEquals(1, player.getY());
        player.moveDown();
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());
        player.moveDown();
        portal1.smash();
        player.moveDown();

        assertEquals(6, player.getX());
        assertEquals(8, player.getY());

    }

    

}

