package com.example.chessgame;

public interface GameControl {
	void start();
	Piece[][] getPieces();
	boolean hasPiece();
	Piece findPiece(float touchX,float touchY);
	int getTurn();
	void setTurn(int turn);
	Hero getM_hero();
	void setM_hero(Hero m_hero);
	Hero getE_hero();
	void setE_hero(Hero e_hero);
}



