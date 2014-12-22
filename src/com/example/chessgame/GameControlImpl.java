package com.example.chessgame;



public class GameControlImpl implements GameControl{
	private  Piece[][] pieces;
	private GameConf gameconfig;
	private int turn;
	private Hero m_hero;
	private Hero e_hero;
	private int Row;
	private int Col;
	
	public GameControlImpl(GameConf conf) {
		this.gameconfig = conf;
		Row = conf.getRow();
		Col = conf.getCol();		
		GenerateAllPieces();
		ResetAll(conf);
				
	}
	
	public void ResetAll(GameConf conf) {
		turn = 1;
		ResetAllPieces();
		ResetHeros(conf);
	}
	
	public void ResetAllPieces() {
		for(int i = 0;i < Row;i++){
			for(int j = 0; j < Col;j++){
				pieces[i][j].setFlag(0);
			}
		}
	}
	
	public void ResetHeros(GameConf conf) {
		int e_posX,e_posY,m_posX,m_posY;
		
		m_hero = gameconfig.getM_Hero();
		e_hero = gameconfig.getE_hero();
		
		m_posX = m_hero.getPosX();
		m_posY = m_hero.getPosY();
		
		e_posX = e_hero.getPosX();
		e_posY = e_hero.getPosY();
		
		pieces[m_posX][m_posY].setFlag(1);
		pieces[e_posX][e_posY].setFlag(2);		
		
	}
	
	public void GenerateAllPieces(){
		pieces = new Piece[Row][Col];
		for(int i = 0;i < Row;i++){
			for(int j = 0; j < Col;j++){
				pieces[i][j] = new Piece();
				pieces[i][j].setIndexX(i);
				pieces[i][j].setIndexY(j);
			}
		}
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
		int indexY = getIndex(relativeX, gameconfig.getPIC_WIDTH());
		int indexX = getIndex(relativeY, gameconfig.getPIC_HEIGHT());
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
	
	public int GetRow(){
		return Row;
	}
	
	public int GetCol(){
		return Col;
	}
	
	public GameConf GetConfig(){
		return gameconfig;
	}
}
