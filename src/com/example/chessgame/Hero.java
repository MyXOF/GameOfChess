package com.example.chessgame;

public class Hero {
	private int health;
	private int attack;
	private int defence;
	private String name;
	private int posX;
	private int posY;
	private int attack_range;

	Hero() { // 构造函数在类设计完全过后需要重写
		this.health = 100;
		this.attack = 100;
		this.defence = 100;
		this.name = "Default";
	}

	Hero(int h, int a, int d, String s) {
		this.health = h;
		this.attack = a;
		this.defence = d;
		this.name = s;
	}

}
