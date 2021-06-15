package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Move implements Movable {
    DOWN {
        @Override
        public List<Integer> move(List<Integer> initial) {
            List<Integer> copy = new ArrayList<>(initial);
            int size = (int) Math.sqrt(copy.size());
            int blank = copy.indexOf(0);
            int row = blank / size;
            int col = blank % size;
            if (validBounds(row - 1, col, size))
                return copy;
            Collections.swap(copy, (row - 1) * size + col, blank);
            return copy;
        }
    },
    UP {
        @Override
        public List<Integer> move(List<Integer> initial) {
            List<Integer> copy = new ArrayList<>(initial);
            int size = (int) Math.sqrt(copy.size());
            int blank = copy.indexOf(0);
            int row = blank / size;
            int col = blank % size;
            if (validBounds(row + 1, col, size))
                return copy;
            Collections.swap(copy, (row + 1) * size + col, blank);
            return copy;
        }
    },
    RIGHT {
        @Override
        public List<Integer> move(List<Integer> initial) {
            List<Integer> copy = new ArrayList<>(initial);
            int size = (int) Math.sqrt(copy.size());
            int blank = copy.indexOf(0);
            int row = blank / size;
            int col = blank % size;
            if (validBounds(row, col - 1, size))
                return copy;
            Collections.swap(copy, row * size + (col - 1), blank);
            return copy;
        }
    },
    LEFT {
        @Override
        public List<Integer> move(List<Integer> initial) {
            List<Integer> copy = new ArrayList<>(initial);
            int size = (int) Math.sqrt(copy.size());
            int blank = copy.indexOf(0);
            int row = blank / size;
            int col = blank % size;
            if (validBounds(row, col + 1, size))
                return copy;
            Collections.swap(copy, row * size + (col + 1), blank);
            return copy;
        }
    };

    private static boolean validBounds(int row, int col, int size) {
        return row < 0 || col < 0 || row >= size || col >= size;
    }
}
