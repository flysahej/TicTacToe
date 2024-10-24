//Sahej Chawla
//CS2210A

public class Configurations {
    private char[][] board;
    private int tilesToWin;

    public Configurations(int boardSize, int tilesToWin, int maxLevels) {
        board = new char[boardSize][boardSize];
        this.tilesToWin = tilesToWin;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public HashDictionary createDictionary() {
        return new HashDictionary(8999);
    }

    public int repeatedConfiguration(HashDictionary hashTable) {
        String config = boardToString();
        return hashTable.get(config);
    }

    public void addConfiguration(HashDictionary hashTable, int score) {
        String config = boardToString();
        try {
            hashTable.put(new Data(config, score));
        } catch (DictionaryException e) {
            // Handle exception if needed
        }
    }

    public void savePlay(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean squareIsEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    public boolean wins(char symbol) {
        int count;
        // Check rows
        for (int i = 0; i < board.length; i++) {
            count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == symbol) {
                    count++;
                    if (count == tilesToWin) return true;
                } else {
                    count = 0;
                }
            }
        }
        // Check columns
        for (int j = 0; j < board.length; j++) {
            count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == symbol) {
                    count++;
                    if (count == tilesToWin) return true;
                } else {
                    count = 0;
                }
            }
        }
        // Check diagonals
        for (int k = 0; k <= board.length * 2; k++) {
            count = 0;
            for (int j = 0; j < board.length; j++) {
                int i = k - j;
                if (i >= 0 && i < board.length) {
                    if (board[i][j] == symbol) {
                        count++;
                        if (count == tilesToWin) return true;
                    } else {
                        count = 0;
                    }
                }
            }
        }
        // Check anti-diagonals
        for (int k = -board.length; k < board.length; k++) {
            count = 0;
            for (int j = 0; j < board.length; j++) {
                int i = k + j;
                if (i >= 0 && i < board.length) {
                    if (board[i][j] == symbol) {
                        count++;
                        if (count == tilesToWin) return true;
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int evalBoard() {
        if (wins('O')) {
            return 3;
        } else if (wins('X')) {
            return 0;
        } else if (isDraw()) {
            return 2;
        } else {
            return 1;
        }
    }

    private String boardToString() {
        StringBuilder boardString = new StringBuilder();
        for (char[] row : board) {
            for (char cell : row) {
                boardString.append(cell);
            }
        }
        return boardString.toString();
    }
}