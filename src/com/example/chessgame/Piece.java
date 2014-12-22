package com.example.chessgame;

public class Piece{
	private int indexX;
	private int indexY;
	private int posX;
	private int posY;
	private int flag;

	Piece() {
		// TODO Auto-generated constructor stub
		this.flag = 0;
	}
	
	Piece(int x,int y,int px,int py){
		this.setIndexX(x);
		this.setIndexY(y);
		this.setPosX(px);
		this.setPosY(py);
	}

	public int getIndexY() {
		return indexY;
	}

	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}

	public int getIndexX() {
		return indexX;
	}

	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}


}