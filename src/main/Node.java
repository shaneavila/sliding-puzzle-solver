package main;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    private final List<Integer> current;
    private final List<Integer> goal;
    private final Heuristic heuristic;
    private final Movable movement;
    private final Node parent;

    public Node(List<Integer> current, List<Integer> goal, Heuristic heuristic, Movable movement, Node parent) {
        this.current = new ArrayList<>(current);
        this.goal = new ArrayList<>(goal);
        this.heuristic = heuristic;
        this.movement = movement;
        this.parent = parent;
    }

    private int calcCost() {
        return getCost() + heuristic.evaluate(current, goal);
    }

    private int getCost() {
        if (parent == null)
            return 0;
        return parent.getCost() + 1;
    }

    public List<Integer> getCurrent() {
        return current;
    }

    public List<Integer> getGoal() {
        return goal;
    }

    public Movable getMovement() { return movement; }

    public Node getParent() { return parent; }

    @Override
    public int compareTo(Node o) {
        int current = calcCost();
        int temp = o.calcCost();
        return current - temp;
    }

    @Override
    public int hashCode() {
        return current.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int size = (int) Math.sqrt(current.size());
        int counter = 0;
        for (Integer value : current) {
            builder.append(value);
            builder.append(" ");
            counter++;
            if (counter % size == 0)
                builder.append('\n');
        }
        return builder.toString();
    }

}
