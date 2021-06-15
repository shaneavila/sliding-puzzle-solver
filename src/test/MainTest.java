package test;

import main.Main;
import main.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void givenSolvablePuzzle_ThenPuzzleIsSolved() {
        String[] args = {"1", "8", "6", "7", "4", "2", "3", "5", "0"};
        Main.main(args);
        Node solution = Main.getSolution();
        assertNotNull(solution);
    }

    @Test
    void givenUnsolvablePuzzle_ThenPuzzleIsNotSolved() {
        String[] args = {"1", "6", "8", "7", "4", "2", "3", "5", "0"};
        Main.main(args);
        Node solution = Main.getSolution();
        assertNull(solution);
    }

    @Test
    void givenNoPuzzle_ThenRandomPuzzleIsGenerated() {
        String[] args = {};
        Main.main(args);
        List<Integer> initial = Main.getInitial();
        assertNotNull(initial);
    }

}