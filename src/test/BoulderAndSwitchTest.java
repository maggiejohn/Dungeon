package test;

import org.junit.Test;
import unsw.dungeon.*;
import unsw.dungeon.entity.Boulder;
import unsw.dungeon.GoalOld;
import unsw.dungeon.entity.Player;
import unsw.dungeon.entity.Switch;

import static org.junit.Assert.*;

public class BoulderAndSwitchTest {


    @Test
    public void testBoulderAndSwitch(){
        
        Dungeon dungeon = new Dungeon(5, 5);
        Player player = new Player(dungeon, 0, 0);
        dungeon.setPlayer(player);



        Boulder boulder1 = new Boulder(dungeon, 1, 0);
        Boulder boulder2 = new Boulder(dungeon, 0, 1);
        Boulder boulder3 = new Boulder(dungeon, 0, 2);
        Boulder boulder4 = new Boulder(dungeon, 3, 2);

        dungeon.addEntity(boulder1);
        dungeon.addEntity(boulder2);
        dungeon.addEntity(boulder3);
        dungeon.addEntity(boulder4);

        Switch switch1 = new Switch(dungeon, 0, 1);
        Switch switch2 = new Switch(dungeon, 0, 2);
        Switch switch3 = new Switch(dungeon, 4, 0);
        Switch switch4 = new Switch(dungeon, 3, 4);
        
        dungeon.addEntity(switch1);
        dungeon.addEntity(switch2);
        dungeon.addEntity(switch3);
        dungeon.addEntity(switch4);

        GoalOld goal  = new GoalOld("boulder", "ONE");
//        dungeon.addGoal(goal);

        assertFalse(goal.checkCompleted());
        assertEquals("boulder", goal.getType());
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        // play can not push 2 boulders at once
        player.moveDown();
        assertEquals(0, player.getY());

        TestUtil.moveRight(player, 4);
        // x is 3, because the play is blocked by the boulder
        assertEquals( 3,player.getX());
        assertEquals( 0,player.getY());
        // push the first boulder to the switch
        assertFalse(goal.checkCompleted());

        TestUtil.moveDown(player, 3);
        assertEquals(3, player.getY());
        assertEquals(3, player.getX());
        assertTrue(goal.checkCompleted());
        // push the second boulder to the switch, goal complete
        assertTrue(goal.checkCompleted());

    }
}
