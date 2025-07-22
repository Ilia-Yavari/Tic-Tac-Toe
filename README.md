# Tic Tac Toe - Java Console Game

This is a simple implementation of the classic **Tic Tac Toe** game (also known as Noughts and Crosses) using Java. The game is played in the console by two players taking turns to place their marks (`X` and `O`) on a 3×3 board.

## Features

- 3x3 board with clear text-based layout
- Input validation (prevents overwriting cells and ensures input bounds)
- Win condition checks:
  - Horizontal (row)
  - Vertical (column)
  - Diagonal
- Simple and clear console interaction

## File Structure

- `Main.java` – Contains the `main()` method and game loop logic.
- `Board.java` – Implements all game mechanics like board printing, move validation, and win checking.

## How to Run

1. **Clone or Download the Repository**

2. **Compile the Java files**  
   Open your terminal or command prompt and navigate to the project directory. Then run:
   ```bash
   javac Main.java Board.java
