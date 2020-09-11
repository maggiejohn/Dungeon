package unsw.dungeon.goal;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AndGoals extends ComplexGoal{
    public AndGoals() {
        subGoals = new ArrayList<>();
    }
    @Override
    public boolean completed() {
        for (Goal subGoal : subGoals) {
            if (!subGoal.completed()) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{  ");
//        for (Goal subGoal : subGoals) {
//            builder.append(subGoal.toString()+" and ");
//        }
        builder.append(String.join(" and ", subGoals.stream().map(g -> g.toString()).collect(Collectors.toList())));
        builder.append(" }");
        return builder.toString();
    }
}
