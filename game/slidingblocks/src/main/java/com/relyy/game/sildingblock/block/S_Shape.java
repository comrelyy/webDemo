package com.relyy.game.sildingblock.block;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/11/25
 */
public class S_Shape extends Shape{

	private int[][] blockArr= {{}};
	public S_Shape(int x,int y,int standType) {
		super(x,y,standType);
	}

	@Override
	public void rotate(int standType) {
		standType=standType%4+1;
	}

	@Override
	public void left() {
		x--;
	}

	@Override
	public void right() {
		x++;
	}

	@Override
	public void fallDown() {
		y--;
	}
}
