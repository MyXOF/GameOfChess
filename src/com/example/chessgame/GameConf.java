package com.example.chessgame;



public class GameConf {
	private int PIC_WIDTH;
	private int PIC_HEIGHT;
	
	private int row;
	private int col;

	private Hero m_hero;
	private Hero e_hero;
	
	public GameConf() {
		// TODO Auto-generated constructor stub
		this.setRow(12);
		this.setCol(12);
		m_hero = new Hero();
		e_hero = new Hero();
		SetMyHero();
		SetEnemyHero();
	}
	

	
	public void SetMyHero() {
		m_hero.setName("Light");
		m_hero.setAttack(10);
		m_hero.setAttack_range(2);
		m_hero.setDefence(5);
		m_hero.setHealth(10);
		m_hero.setMove_range(3);
		m_hero.setPosX(1);
		m_hero.setPosY(1);
		m_hero.setDeath(false);
	}
	
	public void SetEnemyHero(){
		e_hero.setName("Dark");
		e_hero.setAttack(20);
		e_hero.setAttack_range(1);
		e_hero.setDefence(5);
		e_hero.setHealth(15);
		e_hero.setMove_range(2);
		e_hero.setPosX(10);
		e_hero.setPosY(10);
		e_hero.setDeath(false);
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


	public int getPIC_WIDTH() {
		return PIC_WIDTH;
	}

	public void setPIC_WIDTH(int pIC_WIDTH) {
		PIC_WIDTH = pIC_WIDTH;
	}

	public int getPIC_HEIGHT() {
		return PIC_HEIGHT;
	}
	public void setPIC_HEIGHT(int pIC_HEIGHT) {
		PIC_HEIGHT = pIC_HEIGHT;
	}
	
	public Hero getM_Hero() {
		return m_hero;
	}
	
	public Hero getE_hero() {
		return e_hero;
		
	}
}
