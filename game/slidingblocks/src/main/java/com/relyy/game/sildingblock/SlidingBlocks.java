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
	final static int SIDE = 15;    //每一格的像素
	String[] shape = {"I","S","Z","L","J","o","T"};
	Map<String,Integer[][]> shapeStyle = new HashMap<>();
	final static Integer[][] i_shape={{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
			{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
			{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}};
	//shapeStyle.put("I",I_shape);
	public static void main(String[] args) {

		JFrame frame = new JFrame("俄罗斯方块");
		//Graphics graphics = frame.getGraphics();
		frame.setBounds(100,200,600,800);

		board board = new board();
		//Graphics g = jPanel.getGraphics().create();
		board.setBounds(120,220,300,400);

		frame.add(board);
		frame.setVisible(true);
		board.repaint();
		///board.paint(graphics);
		//jPanel.repaint();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	static class board extends JPanel{
		public void paint(Graphics g) {
			g.setColor(Color.green);
			for (int i = 0; i < 16; i++) {
				if (i_shape[0][i] == 1) {
					g.fill3DRect((i % 4 + 150 + 1) * SIDE, (250 + i / 4) * SIDE, SIDE, SIDE, true);
				}
			}
		}
	}
}
