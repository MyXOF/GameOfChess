package com.example.chessgame;

public interface GameControl {
	void start();
	Piece[][] getPieces();
	boolean hasPiece();
	Piece findPiece(float touchX,float touchY);
}



