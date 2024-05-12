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

public class ChessBoardGui extends JPanel {
    
    public int squareSize = 85;
    int cols = 8;
    int rows = 8;

    ArrayList<Piece> pieceList = new ArrayList<>();

    public ChessBoardGui(){
        this.setPreferredSize(new Dimension(cols * squareSize, rows * squareSize));
        this.setBackground(Color.green);
        addPiece();
    }

   public void addPiece(){
    /* 
        pieceList.add(new Rook(this,0,0,false));
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

    //Method to generally Paint
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Board paint
        for(int r = 0; r < rows; r++)
            for(int c = 0; c<cols; c++){
                g2d.setColor((c + r) % 2 == 0 ? new Color(67,103,149) : new Color(146,205,255));
                g2d.fillRect(c*squareSize, r*squareSize, squareSize, squareSize);
            }
        //Piece paint
        for(Piece piece : pieceList) {
            piece.paint(g2d);
        }
    }
}
