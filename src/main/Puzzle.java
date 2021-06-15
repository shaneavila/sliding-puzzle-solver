package main;

import java.util.*;

public class Puzzle {

    private Node root;
    private final Heuristic heuristic;
    private final Queue<Node> frontier = new PriorityQueue<>();
    private final Map<Integer, Node> explored = new HashMap<>();

    public Puzzle(List<Integer> initial, List<Integer> goal, Heuristic heuristic) {
        root = new Node(initial, goal, heuristic, null, null);
        this.heuristic = heuristic;
    }

    public Node solve() {
        frontier.add(root);
        while (!frontier.isEmpty()) {
            root = frontier.poll();
            explored.put(root.hashCode(), root);
            if (root.getCurrent().equals(root.getGoal())) {
                return root;
            }
            for (Movable movement : Move.values()) {
                Node next = new Node(movement.move(root.getCurrent()), root.getGoal(), heuristic, movement, root);
                if (!explored.containsKey(next.hashCode())) {
                    frontier.add(next);
                }
            }
        }
        return null;
    }
}
