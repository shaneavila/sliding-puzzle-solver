# :jigsaw: Sliding Puzzle Solver
Solver for the old-fashioned sliding puzzle game. Solves 8-puzzles, 15-puzzles, etc. Stuck on a puzzle? Use this program to get step-by-step instructions to the solution.

## :inbox_tray: Clone/Download ZIP
Clone the repository:
```bash
git clone https://github.com/shaneavila/sliding-puzzle-solver
```
or download as ZIP and extract:
[https://github.com/shaneavila/sliding-puzzle-solver/archive/master.zip](https://github.com/shaneavila/sliding-puzzle-solver/archive/master.zip)

## :video_camera: Gif
![Sliding Puzzle Solver](https://media.giphy.com/media/lly8z4Bvt0a6v0UF7n/giphy.gif)

## :test_tube: Test
Delete ```'test'``` folder before compiling. ```src > test``` package is used for JUnit5. 

## :desktop_computer: Compile
To compile:
```bash
cd into 'src > main' folder
javac *.java
```

## :running_man: Run
main.Main.java has the main function. To run a random 8-puzzle:
```bash
java main.Main.java
```
To run a specific puzzle:
```bash
java main.Main.java 1 8 2 4 6 0 7 5 3
```
## :printer: Output
```bash
Move tiles in the direction of the blank space
UP
RIGHT
DOWN
DOWN
LEFT
UP
UP
RIGHT
DOWN
LEFT
UP

MANHATTAN
1 8 2 
4 6 0 
7 5 3 

1 8 2 
4 6 3 
7 5 0 

1 8 2 
4 6 3 
7 0 5 

1 8 2 
4 0 3 
7 6 5 

1 0 2 
4 8 3 
7 6 5 

1 2 0 
4 8 3 
7 6 5 

1 2 3 
4 8 0 
7 6 5 

1 2 3 
4 8 5 
7 6 0 

1 2 3 
4 8 5 
7 0 6 

1 2 3 
4 0 5 
7 8 6 

1 2 3 
4 5 0 
7 8 6 

1 2 3 
4 5 6 
7 8 0 

Move tiles in the direction of the blank space
UP
RIGHT
DOWN
DOWN
LEFT
UP
UP
RIGHT
DOWN
LEFT
UP

MISPLACED
1 8 2 
4 6 0 
7 5 3 

1 8 2 
4 6 3 
7 5 0 

  .
  .
  .

1 2 3 
4 5 0 
7 8 6 

1 2 3 
4 5 6 
7 8 0 
```
