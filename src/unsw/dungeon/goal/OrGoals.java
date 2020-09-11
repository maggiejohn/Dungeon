package unsw.dungeon.goal;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrGoals extends ComplexGoal{
    public OrGoals() {
        subGoals = new ArrayList<>();
    }

    @Override
    public boolean completed() {
        for (Goal subGoal : subGoals) {
            if (subGoal.completed()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{ ");
        builder.append(String.join(" or ", subGoals.stream().map(g -> g.toString()).collect(Collectors.toList())));

        builder.append(" }");
        return builder.toString();
    }


}
