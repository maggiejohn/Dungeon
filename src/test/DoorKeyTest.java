//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//import unsw.dungeon.entity.Door;
//import unsw.dungeon.Dungeon;
//import unsw.dungeon.entity.Key;
//import unsw.dungeon.entity.Player;
//
//class DoorKeyTest {
//    @Test
//    void playerCannotWalkThroughDoorWithoutKey() {
//        Dungeon dungeon = new Dungeon(5, 5);
//        Player player = new Player(dungeon, 1, 1);
//        Door door = new Door(dungeon, 2, 1, 0);
//        dungeon.setPlayer(player);
//        dungeon.addEntity(door);
//        player.moveRight();
//        assertEquals(1, player.getX());
//        assertEquals(1, player.getY());
//    }
//
//    @Test
//    void playerCanWalkThroughDoorWithKey() {
//        Dungeon dungeon = new Dungeon(5, 5);
//        Player player = new Player(dungeon, 1, 1);
//        Key key = new Key(dungeon, 2, 1, 6);
//        Door door = new Door(dungeon, 3, 1, 6);
//        dungeon.setPlayer(player);
//        dungeon.addEntity(door);
//        dungeon.addEntity(key);
//        player.moveRight();
//        player.moveRight();
//        assertEquals(3, player.getX());
//        assertEquals(1, player.getY());
//    }
//
//}
