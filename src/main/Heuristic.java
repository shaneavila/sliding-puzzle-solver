package main;

import java.util.List;

public interface Heuristic {
    int evaluate(List<Integer> current, List<Integer> goal);
}
