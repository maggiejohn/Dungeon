package unsw.dungeon.goal;

import java.util.List;

public abstract class ComplexGoal implements Goal {
    protected List<Goal> subGoals;
    public void addGoal(Goal goal) {
        subGoals.add(goal);
    }

    @Override
    public String achieved() {
        StringBuilder builder = new StringBuilder();
        for (Goal subGoal : subGoals) {
            if (subGoal.completed()) {
                builder.append(subGoal.toString()  + " ");
            }
        }
        return builder.toString();
    }
}
