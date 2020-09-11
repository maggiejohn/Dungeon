package unsw.dungeon.goal;

public abstract class ConcreteGoal implements Goal {
    @Override
    public String achieved(){
        if (completed()) {
            return this.toString();
        }else {
            return "";
        }
    }
}
