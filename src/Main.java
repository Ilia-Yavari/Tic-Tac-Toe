import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], "  ");
        }
        int emptyCount = 9;
        boolean firsPlayer = true;

        Scanner sc = new Scanner(System.in);
        while (emptyCount > 0 && !Board.checkWin(board)) {
            System.out.println();
            Board.printBoard(board);
            System.out.print("Enter row and column: ");
            String sign = firsPlayer ? "❌" : "⭕";
            if (Board.makeMove(board, sc.nextInt() - 1, sc.nextInt() - 1, sign)) {
                emptyCount--;
                firsPlayer = !firsPlayer;
            } else {
                System.out.println("Invalid move");
            }
        }
        sc.close();
        Board.printBoard(board);
        if (Board.checkWin(board)) {
            if (firsPlayer) {
                System.out.println("⭕ Won!");
            } else {
                System.out.println("❌ Won!");
            }
        } else {
            System.out.println("Draw!");
        }
    }
}