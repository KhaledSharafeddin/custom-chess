package GUI;

import javax.swing.*;

import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;

import java.awt.*;
import java.util.ArrayList;

import Piece.*;

public class ChessBoardGui extends JPanel {
    
    public int tileSize = 85;

    ArrayList<Piece> pieceList = new ArrayList<>();

    int row = 8;
    int column = 8;
    public Piece selectedPiece;

    Input input = new Input(this);
    public ChessBoardGui(){

        this.setPreferredSize(new Dimension(column *tileSize, row *tileSize));
        this.setBackground(Color.green);
        addPiece();
    }

   public void addPiece(){
    
        addPieces();

        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public void addPieces(){

        //Black pieces
        pieceList.add(new Rook(this,0,0,false)); //board, row, col, isWhite
        pieceList.add(new Knight(this,1,0,false));
        pieceList.add(new Bishop(this,2,0,false));
        pieceList.add(new King(this,3,0,false));
        pieceList.add(new Queen(this,4,0,false));
        pieceList.add(new Bishop(this,5,0,false));
        pieceList.add(new Knight(this,6,0,false));
        pieceList.add(new Rook(this,7,0,false));

        pieceList.add(new Pawn(this,0,1,false));
        pieceList.add(new Pawn(this,1,1,false));
        pieceList.add(new Pawn(this,2,1,false));
        pieceList.add(new Pawn(this,3,1,false));
        pieceList.add(new Pawn(this,4,1,false));
        pieceList.add(new Pawn(this,5,1,false));
        pieceList.add(new Pawn(this,6,1,false));
        pieceList.add(new Pawn(this,7,1,false));

        //White pieces
        pieceList.add(new Rook(this,0,7,true));
        pieceList.add(new Knight(this,1,7,true));
        pieceList.add(new Bishop(this,2,7,true));
        pieceList.add(new King(this,4,7,true));
        pieceList.add(new Queen(this,3,7,true));
        pieceList.add(new Bishop(this,5,7,true));
        pieceList.add(new Knight(this,6,7,true));
        pieceList.add(new Rook(this,7,7,true));

        pieceList.add(new Pawn(this,0,6,true));
        pieceList.add(new Pawn(this,1,6,true));
        pieceList.add(new Pawn(this,2,6,true));
        pieceList.add(new Pawn(this,3,6,true));
        pieceList.add(new Pawn(this,4,6,true));
        pieceList.add(new Pawn(this,5,6,true));
        pieceList.add(new Pawn(this,6,6,true));
        pieceList.add(new Pawn(this,7,6,true));
        */
    }

    
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        //Paint the board
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                g2d.setColor((c + r) % 2 == 0 ? new Color(150, 53, 53, 255) : new Color(175, 81, 81));
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }
        //Paint the pieces
        for (Piece piece: pieceList){
            piece.paint(g2d);
        }


        //Paint the highlights
        if (selectedPiece!=null) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (isValidMove(new Move(this, selectedPiece, c, r))) {
                        g2d.setColor(new Color(2, 255, 0, 107));
                        g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
                    }
                }
            }
        }

    }
}
