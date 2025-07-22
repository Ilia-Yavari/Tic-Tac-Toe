import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final String X = "❌";
    static final String O = "⭕";
    static final String BLANK = "  ";
    static final int SIZE = 3;
    static final String[][] board = new String[SIZE][SIZE];
    static {
        for (String[] row : board) {
            Arrays.fill(row, BLANK);
        }
    }

    public static void main(String[] args) {
        int emptyCells = SIZE * SIZE;
        boolean firstPlayer = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Players take turns entering row and column numbers.");
        System.out.printf("%s goes first.%n%n", X);

        while (emptyCells > 0 && !Board.checkWin(board)) {
            System.out.println();
            String currentPlayer = firstPlayer ? X : O;
            System.out.println("Current turn: " + currentPlayer);
            Board.printBoard(board);
            try {
                System.out.print("Enter row and column: ");
                int row = sc.nextInt() - 1, column = sc.nextInt() - 1;
                String sign = firstPlayer ? X : O;
                if (Board.makeMove(board, row, column, sign)) {
                    emptyCells--;
                    firstPlayer = !firstPlayer;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter numeric values.");
                sc.nextLine();
            }
        }
        sc.close();
        Board.printBoard(board);
        if (Board.checkWin(board)) {
            String winner = firstPlayer ? O : X;
            System.out.printf("%n%s Won!", winner);
        } else {
            System.out.println("Draw!");
        }
    }
}