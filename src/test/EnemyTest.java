package test;

import org.junit.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.entity.Enemy;
import unsw.dungeon.entity.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnemyTest {


    @Test
    public void testEnemyMove() {
        Dungeon dungeon = new Dungeon(5, 5);
        Enemy enemy = new Enemy(dungeon, 0, 0);
        Player player = new Player(dungeon, 3, 3);

        dungeon.setPlayer(player);

        dungeon.addEntity(enemy);

        assertEquals(0, enemy.getX());
        assertEquals(0, enemy.getY());
        player.moveDown();
        assertEquals(1, enemy.getX());
        TestUtil.moveUp(player, 3);
        assertEquals(4, enemy.getX());
        player.moveUp();
        // killed by an enemy
        assertEquals(player.getX(), enemy.getX());
        assertEquals(player.getY(), enemy.getY());
        assertTrue(player.failed());
    }
}
