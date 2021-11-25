package com.relyy.game.sildingblock.block;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/11/25
 */
public abstract class Shape {

	/**
	 *     ####
	 *
	 *     #
	 *     #
	 *     #
	 *     #
	 */
	//I,
	/**
	 * #
	 * ##
	 *  #
	 */
	//S,
	/**
	 *       ##
	 *        ##
	 */
	//Z,
	/**
	 *        ##
	 *         #
	 *         #
	 */
	//J,
	/**
	 *   ##
	 *   ##
	 */
	//O,
	/**
	 *   ##
	 *   ##
	 */
	//L,
	/**
	 *    ###
	 *    #
	 */
	//T;
	//出生的位置坐标
	int x;
	int y;

	// 出生的形状 躺，卧，左立，右立
	//其实就是 旋转 0，90，180，270
	int standType;

	//private color


	public Shape(int x, int y, int standType) {
		this.x = x;
		this.y = y;
		this.standType = standType;
	}

	//旋转 一次只能旋转90度
	public abstract void rotate(int standType);

	//左移
	public abstract void left();

	//右移
	public abstract void right();

	//快速下落
	public abstract void fallDown();
}
