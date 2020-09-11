package test;

import org.junit.Test;
import unsw.dungeon.*;
import unsw.dungeon.entity.Enemy;
import unsw.dungeon.entity.Player;
import unsw.dungeon.entity.Potion;
import unsw.dungeon.entity.Sword;


import static org.junit.Assert.*;

public class EquipmentsTest {

    @Test
    public void testSword() {
        Dungeon dungeon = new Dungeon(5, 5);
        Enemy enemy1 = new Enemy(dungeon, 0, 0);
        Enemy enemy2 = new Enemy(dungeon, 1, 0);
        Enemy enemy3 = new Enemy(dungeon, 2, 0);
        Enemy enemy4 = new Enemy(dungeon, 3, 0);
        Enemy enemy5 = new Enemy(dungeon, 4, 0);

        Enemy enemy6 = new Enemy(dungeon, 0, 1);
        Enemy enemy7 = new Enemy(dungeon, 1, 1);
        Enemy enemy8 = new Enemy(dungeon, 2, 1);
        Enemy enemy9 = new Enemy(dungeon, 3, 1);
        Enemy enemy10 = new Enemy(dungeon, 4, 1);
        
        Sword sword = new Sword(dungeon, 2, 3);

        Player player = new Player(dungeon, 3, 3);
        dungeon.setPlayer(player);

        dungeon.addEntity(enemy1);
        dungeon.addEntity(enemy2);
        dungeon.addEntity(enemy3);
        dungeon.addEntity(enemy4);
        dungeon.addEntity(enemy5);
        dungeon.addEntity(enemy6);
        dungeon.addEntity(enemy7);
        dungeon.addEntity(enemy8);
        dungeon.addEntity(enemy9);
        dungeon.addEntity(enemy10);
        
        dungeon.addEntity(sword);


        int enemyCount = TestUtil.countEnemy(dungeon);
        // get the sword
        player.moveLeft();
        assertEquals(5, player.getSwordCharges());

        TestUtil.moveLeft(player, 3);
        TestUtil.moveUp(player, 2);
        TestUtil.moveLeft(player, 5);
        TestUtil.moveRight(player, 4);

        assertEquals(3, player.getSwordCharges());
        assertEquals(enemyCount - 2, TestUtil.countEnemy(dungeon));

        TestUtil.moveRight(player, 10);
        player.moveUp();
        TestUtil.moveLeft(player, 10);

        assertEquals(0, player.getSwordCharges());
        assertEquals(enemyCount- 5, TestUtil.countEnemy(dungeon));
        enemy1.smash();

        assertTrue(player.failed());
    }

    @Test
    public void testPotion(){
        Dungeon dungeon = new Dungeon(5, 5);
        Enemy enemy1 = new Enemy(dungeon, 0, 0);
        Enemy enemy2 = new Enemy(dungeon, 1, 0);
        Enemy enemy3 = new Enemy(dungeon, 2, 0);
        Enemy enemy4 = new Enemy(dungeon, 3, 0);
        Enemy enemy5 = new Enemy(dungeon, 4, 0);

        Enemy enemy6 = new Enemy(dungeon, 0, 1);
        Enemy enemy7 = new Enemy(dungeon, 1, 1);
        Enemy enemy8 = new Enemy(dungeon, 2, 1);
        Enemy enemy9 = new Enemy(dungeon, 3, 1);
        Enemy enemy10 = new Enemy(dungeon, 4, 1);
        
        Potion potion  = new Potion(dungeon, 2, 3);

        Player player = new Player(dungeon, 3, 3);
        dungeon.setPlayer(player);

        dungeon.addEntity(enemy1);
        dungeon.addEntity(enemy2);
        dungeon.addEntity(enemy3);
        dungeon.addEntity(enemy4);
        dungeon.addEntity(enemy5);
        dungeon.addEntity(enemy6);
        dungeon.addEntity(enemy7);
        dungeon.addEntity(enemy8);
        dungeon.addEntity(enemy9);
        dungeon.addEntity(enemy10);
        
        dungeon.addEntity(potion);


        int enemyCount = TestUtil.countEnemy(dungeon);
        assertEquals(10, enemyCount);
        // get the potion
        player.moveLeft();
        assertTrue(player.getInvincibility());

        TestUtil.moveLeft(player, 3);
        TestUtil.moveUp(player, 2);
        TestUtil.moveLeft(player, 5);
        TestUtil.moveRight(player, 4);

        assertEquals(enemyCount - 2, TestUtil.countEnemy(dungeon));

        TestUtil.moveRight(player, 10);
        player.moveUp();
        TestUtil.moveLeft(player, 10);

        assertEquals(enemyCount- 5, TestUtil.countEnemy(dungeon));
        enemy1.smash();

        assertFalse(player.failed());
        
        
    }
}
