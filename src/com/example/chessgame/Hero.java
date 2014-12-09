package com.example.chessgame;

public class Hero {
	private int health;
	private int attack;
	private int defence;
	private String name;
	private int posX;
	private int posY;
	private int attack_range;
	private int move_range;

	Hero() { 
		this.setAttack(100);
		this.setDefence(100);
		this.setName("Default");
	}

	Hero(int h, int a, int d, String s) {
		this.setHealth(h);
		this.setAttack(a);
		this.setDefence(d);
		this.setName(s);
	}
	
	public void Damage(int damage){
		return;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getAttack_range() {
		return attack_range;
	}

	public void setAttack_range(int attack_range) {
		this.attack_range = attack_range;
	}

	public int getMove_range() {
		return move_range;
	}

	public void setMove_range(int move_range) {
		this.move_range = move_range;
	}

}
