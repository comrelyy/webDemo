package com.relyy.game.sildingblock;

import io.netty.util.internal.StringUtil;

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
//		myView.initView();
//
//		myView.setTitle("俄罗斯方块");
//		//Graphics graphics = frame.getGraphics();
//		myView.setBounds(100,200,600,800);
//
//		myView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		myView.setVisible(true);
		///board.paint(graphics);
		//jPanel.repaint();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MyView extends JFrame{

	public MyView()  {
		Board board = new Board();
		//board.setPreferredSize(new Dimension(300, 400));
		//Graphics g = jPanel.getGraphics().create();
		//board.setBounds(120,220,300,400);
		JButton bstart = new JButton("开始");
		bstart.setBounds(250, 260, 80, 20);
		this.add(bstart);
		this.add(board);
		this.setTitle("俄罗斯方块");
		//Graphics graphics = frame.getGraphics();
		this.setBounds(100,200,600,800);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);


		while (board.creatBlock("I",0)){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			board.normalDown();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	public void initView() {

	}
}

class Board extends JPanel{
	final static int SIDE = 15;    //每一格的像素
	String shapes = "ISZLJOT";
	Map<String,Integer[][]> shapeStyle = new HashMap<>();
	Integer[][] i_shape={{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
			{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
			{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}};
	int[][] map;
	int curY = 1;
	int curX = 9;
	private String shape;
	private int state;
	public Board() {
		shapeStyle.put("I",i_shape);
		initMap();
	}


	private void initMap() {
		map = new int[20][40];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 40; j++) {
				if (i == 0 || i == 19 || j == 0 || j == 39){
					map[i][j] = 1;
				}else {
					map[i][j] = 0;
				}
			}
		}
	}

	public boolean creatBlock(String shape,int state){
		this.shape = shape;
		this.state = state;
		return true;
	}
	public void paint(Graphics g) {
		super.paint(g);

		//g.fillRect(0,0,400,300);
		int xIndex = 10;
		int yIndex = 75;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 40; j++) {
				switch(map[i][j]){
					case 0: //活动区域，深蓝色
						g.setColor(new Color(10, 14, 41));
						g.fill3DRect(i * SIDE + xIndex, j * SIDE + yIndex, SIDE, SIDE, true);
						break;
					case 1: //堆积区，方块颜色
						g.setColor(Color.gray);
						g.fill3DRect(i * SIDE+ xIndex, j * SIDE + yIndex, SIDE, SIDE, true);
						//g.setColor(CTYPE[4]);
						break;
					case 2: //边框区，灰色
						//g.setColor(CTYPE[3]);
						g.fill3DRect(i * SIDE + xIndex, j * SIDE + yIndex, SIDE, SIDE, true);
						break;
				}
			}
		}
		if (shape != null && shapes.contains(shape)) {
			g.setColor(Color.green);
			for (int i = 0; i < 16; i++) {
				if (shapeStyle.get(shape)[state][i] == 1) {
					g.fill3DRect((i % 4 + curX) * SIDE + xIndex, (curY + i / 4) * SIDE + yIndex, SIDE, SIDE, true);
				}
			}
		}
	}

	public void normalDown() {
		if (shape == null || !shapes.contains(shape)) return;
		if(ifCanMove(curX,curY)) {
			curY += 1;
			super.repaint();
		}
	}

	private boolean ifCanMove(int x, int y) {
		for (int a = 0; a< 4; a++){
			for (int b = 0; b < 4; b++) {
				if (shapeStyle.get(shape)[state][a * 4 + b] == 1 && map[x + b][y + a + 1] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
