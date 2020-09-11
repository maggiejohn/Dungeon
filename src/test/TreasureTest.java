package test;


import org.junit.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.entity.Player;
import unsw.dungeon.entity.Treasure;
import unsw.dungeon.goal.Goal;
import unsw.dungeon.goal.TreasureGoal;

import static org.junit.Assert.assertEquals;

public class TreasureTest {
    @Test
    public void treasurePickUp() {
        Dungeon dungeon = new Dungeon(5, 5);
        Player player = new Player(dungeon, 1, 1);
        Goal goal = new TreasureGoal(dungeon);
        Treasure treasure = new Treasure(dungeon, 2, 1);
        dungeon.setPlayer(player);
        dungeon.addEntity(treasure);
        dungeon.setGoal(goal);
        player.moveRight();
        player.moveRight();
        assertEquals(2, treasure.getX());
    }

}
