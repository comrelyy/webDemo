package com.able.re.designMode.flyweight;

/**
 * @Description 棋子基础信息类，象棋中的棋子是可数，可枚举的，一旦创建后这些信息是不可变的额
 * 所有的棋局都可以共享这些棋子信息，可以把棋子信息设计成享元类
 * @Created by cairuirui
 * @Date 2020/7/4
 */
public final class ChessPieceUnit {
	private int id;
	private String text;
	private Color color;

	public ChessPieceUnit(int id, String text, Color color) {
		this.id = id;
		this.text = text;
		this.color = color;
	}

	public static enum Color{
		RED,
		BLACK,
		;
	}
}
