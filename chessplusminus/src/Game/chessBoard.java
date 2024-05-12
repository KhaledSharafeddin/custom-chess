package Game;
//chessBoard.java
import Piece.Pawn;
import Piece.Piece;

public class chessBoard {
    private Box[][] boxes;
    

    public chessBoard(int width, int height) {
        boxes = new Box[width][height];
        // Initialize the board with Box objects as needed
        // Optionally, initialize pieces on the board. I think we should initialize pieces on the board. -Emir
    }

    public Piece getPiece(Box box) {
        return box.getPiece();
    }



    public Box getBox(int column, int row) {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'getBox'");
    }

    public void replacePiece(Pawn pawn, Piece newPiece) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replacePiece'");
    }
}
