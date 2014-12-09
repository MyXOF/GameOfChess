package com.example.chessgame;

public class GameConf {
	private int row;
	private int col;
	private int m_heroPosX;
	private int m_heroPosY;
	private int e_heroPosX;
	private int e_heroPosY;
	
	public GameConf(int m_row,int m_col,int m_X,int m_Y,int e_X,int e_Y) {
		// TODO Auto-generated constructor stub
		this.setRow(m_row);
		this.setCol(m_col);
		this.setM_heroPosX(m_X);
		this.setM_heroPosY(m_Y);
		this.setE_heroPosX(e_X);
		this.setE_heroPosY(e_Y);
	}
	
	
	

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getM_heroPosX() {
		return m_heroPosX;
	}

	public void setM_heroPosX(int m_heroPosX) {
		this.m_heroPosX = m_heroPosX;
	}

	public int getM_heroPosY() {
		return m_heroPosY;
	}

	public void setM_heroPosY(int m_heroPosY) {
		this.m_heroPosY = m_heroPosY;
	}

	public int getE_heroPosX() {
		return e_heroPosX;
	}

	public void setE_heroPosX(int e_heroPosX) {
		this.e_heroPosX = e_heroPosX;
	}

	public int getE_heroPosY() {
		return e_heroPosY;
	}

	public void setE_heroPosY(int e_heroPosY) {
		this.e_heroPosY = e_heroPosY;
	}
}
