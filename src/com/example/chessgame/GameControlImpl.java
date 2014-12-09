package com.example.chessgame;

public class GameControlImpl implements GameControl{
	private  Piece[][] pieces;
	private GameConf gameconfig;
	public GameControlImpl(GameConf conf) {
		this.gameconfig = conf;
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
		
	}
	
}
