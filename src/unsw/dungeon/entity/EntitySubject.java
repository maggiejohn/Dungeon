package unsw.dungeon.entity;

import unsw.dungeon.DungeonObserver;

public interface EntitySubject {
    
	public void addObserver(DungeonObserver o);
    public void pingObservers();
	public void removeObserver(DungeonObserver o);
	public boolean checkUsed();
}