package com.example.chessgame;

import android.graphics.Bitmap;

public class Piece{
	private int indexX;
	private int indexY;
	private int posX;
	private int posY;
	private int flag;  // «”¢–€”Î∑Ò
	private Bitmap imgBitmap;
	
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

	public Bitmap getImgBitmap() {
		return imgBitmap;
	}

	public void setImgBitmap(Bitmap imgBitmap) {
		this.imgBitmap = imgBitmap;
	}
}