package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int size;
    static List<Integer> initial;
    static List<Integer> goal;
    static Node solution;

    public static void main(String[] args) {
        if (args.length > 0) {
            initial = new ArrayList<>();
            size = (int) Math.sqrt(args.length);
            for (String arg : args)
                initial.add(Integer.parseInt(arg));
            if(isSolvable()) {
                System.err.println("The puzzle is not solvable");
                solution = null;
                return;
            }
        }
        else {
            initial = new ArrayList<>();
            size = 3;
            for (int i = 0; i < size * size; i++)
                initial.add(i);
            generateRandomPuzzle();
        }
        setGoal();
        solution = null;
        for (Heuristic heuristic : Heuristics.values()) {
            Puzzle puzzle = new Puzzle(initial, goal, heuristic);
            solution = puzzle.solve();
            showSteps(solution, heuristic);
        }
    }

    private static void showSteps(Node solution, Heuristic heuristic) {
        List<Node> steps = new ArrayList<>();
        steps.add(solution);
        while (solution.getParent() != null) {
            solution = solution.getParent();
            steps.add(solution);
        }
        Collections.reverse(steps);
        System.out.println("Move tiles in the direction of the blank space:");
        for (Node step : steps)
            if (step.getMovement() != null)
                System.out.println(step.getMovement());
        System.out.println();
        System.out.println(heuristic);
        for (Node step : steps)
            System.out.println(step);
    }

    private static void setGoal() {
        goal = new ArrayList<>();
        for (int i = 1; i <= size * size; i++) {
            if (i == size * size)
                goal.add(0);
            else
                goal.add(i);
        }
    }

    private static void generateRandomPuzzle() {
        do {
            Collections.shuffle(initial);
        } while (isSolvable());
    }

    private static boolean isSolvable() {
        return oddSize() ? oddInversion() % 2 != 0 : evenInversion() % 2 != 1;
    }

    private static boolean oddSize() {
        return initial.size() % 2 == 1;
    }

    private static int oddInversion() {
        int invCount = 0;
        for (int i = 0; i < initial.size() - 1; i++)
            for (int j = i + 1; j < initial.size(); j++)
                if (initial.get(i) > initial.get(j) && initial.get(j) > 0)
                    invCount++;
        return invCount;
    }

    private static int evenInversion() {
        int blankRow = initial.indexOf(0) / size;
        return blankRow + oddInversion();
    }

    public static List<Integer> getInitial() {
        return initial;
    }

    public static Node getSolution() {
        return solution;
    }

}
