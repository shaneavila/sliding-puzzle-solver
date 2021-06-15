package main;

import java.util.List;

public enum Heuristics implements Heuristic {
    MANHATTAN {
        @Override
        public int evaluate(List<Integer> current, List<Integer> goal) {
            int size = (int) Math.sqrt(current.size());
            int distance = 0;
            for (int i = 0; i < current.size(); i++) {
                if (!current.get(i).equals(goal.get(i)) && current.get(i) != 0)
                    distance += (Math.abs(current.get(i) / size - goal.get(i) / size)
                            + Math.abs(current.get(i) % size - goal.get(i) % size));
            }
            return distance;
        }
    },
    MISPLACED {
        @Override
        public int evaluate(List<Integer> current, List<Integer> goal) {
            int count = 0;
            for (int i = 0; i < current.size(); i++)
                if (!current.get(i).equals(goal.get(i)) && current.get(i) != 0)
                    count++;
            return count;
        }
    }
}
