package com.relyy.game.sildingblock;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/11/25
 */
public class SlidingBlocks {

	//shapeStyle.put("I",I_shape);
	public static void main(String[] args) {
		MyView myView = new MyView();


		///board.paint(graphics);
		//jPanel.repaint();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MyView extends JFrame{
	public MyView()  {
		board board = new board();
		//Graphics g = jPanel.getGraphics().create();
		//board.setBounds(120,220,300,400);

		this.add(board);
		this.setTitle("俄罗斯方块");
		//Graphics graphics = frame.getGraphics();
		this.setBounds(100,200,600,800);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}

class board extends JPanel{
	final static int SIDE = 15;    //每一格的像素
	String[] shape = {"I","S","Z","L","J","o","T"};
	Map<String,Integer[][]> shapeStyle = new HashMap<>();
	final static Integer[][] i_shape={{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
			{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
			{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}};

	public void paint(Graphics g) {
		super.paint(g);
		//g.fillRect(0,0,400,300);
		g.setColor(Color.green);
		for (int i = 0; i < 16; i++) {
			if (i_shape[0][i] == 1) {
				g.fill3DRect((i % 4 + 15 + 1) * SIDE, (0 + i / 4) * SIDE, SIDE, SIDE, true);
			}
		}
	}

	public class Shape{

	}
}
