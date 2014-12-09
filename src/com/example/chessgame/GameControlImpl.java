package com.example.chessgame;


public class GameControlImpl implements GameControl{
	private  Piece[][] pieces;
	private GameConf gameconfig;
	private int turn;
	private Hero m_hero;
	private Hero e_hero;
	
	public GameControlImpl(GameConf conf) {
		this.gameconfig = conf;
		turn = 1;
	}
	
	@Override
	public void start(){
		
	}
	
	@Override
	public 	boolean hasPiece(){
		return false;
	}

	
	@Override
	public Piece[][] getPieces(){
		return this.pieces;
	}
	
	@Override
	public Piece findPiece(float touchX,float touchY){
		int relativeX = (int)touchX;
		int relativeY = (int)touchY;
		if(relativeX < 0 || relativeY < 0){
			return null;
		}
		int indexX = getIndex(relativeX, gameconfig.getPIC_WIDTH());
		int indexY = getIndex(relativeY, gameconfig.getPIC_HEIGHT());
		if(indexX < 0 || indexY < 0){
			return null;
		}
		if(indexX > (gameconfig.getRow() -1) || indexY > (gameconfig.getCol() - 1)){
			return null;
		}
		return pieces[indexX][indexY];
		
	}

	public int getIndex(int relative,int size){
		int index = -1;
		if(relative % size == 0){
			index = relative / size - 1;
		}
		else{
			index = relative / size;
		}
		
		return(index);
	}
	
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public Hero getM_hero() {
		return m_hero;
	}

	public void setM_hero(Hero m_hero) {
		this.m_hero = m_hero;
	}

	public Hero getE_hero() {
		return e_hero;
	}

	public void setE_hero(Hero e_hero) {
		this.e_hero = e_hero;
	}
	
}
