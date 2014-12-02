package com.example.chessgame;

public class Piece{
	private int indexX;
	private int indexY;
	private int posX;
	private int posY;
	private int flag;
	
	
	Piece(int x,int y,int px,int py){
		this.indexX = x;
		this.indexY = y;
		this.posX = px;
		this.posY = py;
	}
}