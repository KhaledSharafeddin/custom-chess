public class standardGame {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GUI.ChessBoardGui board;
    private boolean gameOver;

    public standardGame() {
        // Initialize players, board, and other variables
    }

    public void startGame() {
        while (!gameOver) {
            // Get valid moves for the current player
            List<Move> validMoves = getValidMoves(currentPlayer, board);

            // Handle player input (use methods from ChessBoardGui)
            // Perform the chosen move and update the board state
            // Check for win/loss conditions (checkmate, stalemate)
            // Switch turns to the other player
        }
    }

    private List<Move> getValidMoves(Player player, GUI.ChessBoardGui board) {
        List<Move> validMoves = new ArrayList<>();
        for (Piece piece : player.getAllyPieces(board)) {
            for (int row = 0; row < board.getRow(); row++) {
                for (int col = 0; col < board.getColumn(); col++) {
                    if (Logic.isMoveValid(board, piece, row, col)) {
                        validMoves.add(new Move(board, piece, row, col));
                    }
                }
            }
        }
        return validMoves;
    }
}
