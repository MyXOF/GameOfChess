package com.example.chessgame;

public class Hero {
	private int health;
	private int attack;
	private int defence;
	private String name;
	private int posX;
	private int posY;
	private int attack_range;

	Hero() { // ���캯�����������ȫ������Ҫ��д
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
