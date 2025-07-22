import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final String X = "❌";
    static final String O = "⭕";
    static final String BLANK = "  ";
    static final String[][] board = new String[3][3];
    static {
        for (String[] row : board) {
            Arrays.fill(row, BLANK);
        }
    }

    public static void main(String[] args) {
        int emptyCells = board.length * board[0].length;
        boolean firsPlayer = true;

        Scanner sc = new Scanner(System.in);
        while (emptyCells > 0 && !Board.checkWin(board)) {
            System.out.println();
            Board.printBoard(board);
            try {
                System.out.print("Enter row and column: ");
                int row = sc.nextInt() - 1, column = sc.nextInt() - 1;
                String sign = firsPlayer ? X : O;
                if (Board.makeMove(board, row, column, sign)) {
                    emptyCells--;
                    firsPlayer = !firsPlayer;
                } else {
                    System.out.println("Invalid move");
                }
            } catch (InputMismatchException e) {
                System.err.println("Enter a valid number");
            }
        }
        sc.close();
        Board.printBoard(board);
        if (Board.checkWin(board)) {
            if (firsPlayer) {
                System.out.println(O + " Won!");
            } else {
                System.out.println(X + " Won!");
            }
        } else {
            System.out.println("Draw!");
        }
    }
}