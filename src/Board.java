public class Board {
    public static void printBoard(String[][] board) {
        for (String[] row : board) {
            for (int j = 0; j < row.length; j++) {
                if (j == row.length - 1) {
                    System.out.println(row[j]);
                } else {
                    System.out.print(row[j] + " | ");
                }
            }
        }
    }

    public static boolean makeMove(String[][] board, int row, int col, String sign) {
        if (0 <= row && row < board.length && 0 <= col && col < board[0].length) {
            if (board[row][col].equals("  ")) {
                board[row][col] = sign;
                return true;
            }
        }
        return false;
    }

    public static boolean checkRowWin(String[][] board) {
        for (String[] row : board) {
            if (row[0].equals("  ")) {
                continue;
            }
            boolean win = true;
            for (int i = 0; i < row.length - 1; i++) {
                if (!row[i].equals(row[i + 1])) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColWin(String[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i].equals("  ")) {
                continue;
            }
            boolean win = true;
            for (int j = 0; j < board.length - 1; j++) {
                if (!board[j][i].equals(board[j + 1][i])) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagWin(String[][] board) {
        if (!board[0][0].equals("  ") && board[0][0].equals(board[1][1])) {
            if (board[1][1].equals(board[2][2])) {
                return true;
            }
        }
        if (!board[0][0].equals("  ") && board[0][2].equals(board[1][1])) {
            if (board[1][1].equals(board[2][0])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWin(String[][] board) {
        return checkRowWin(board) || checkColWin(board) || checkDiagWin(board);
    }
}
