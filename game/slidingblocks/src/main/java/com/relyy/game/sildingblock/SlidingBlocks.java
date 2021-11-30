package com.relyy.game.sildingblock;

import io.netty.util.internal.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

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

class MyView extends JFrame implements KeyListener {

	private Timer timer;
	private Board board;
	//block 下落的速度
	private int speed = 100;
	public MyView()  {

		board = new Board();
		board.setLayout(null);
		//board.setPreferredSize(new Dimension(300, 400));
		//Graphics g = jPanel.getGraphics().create();
		//board.setBounds(120,220,300,400);
		JButton bstart = new JButton("开始");
		bstart.setBounds(400, 300, 80, 20);
		this.addKeyListener(this);
		board.addKeyListener(this);
		board.add(bstart);
		this.add(board);

		this.setTitle("俄罗斯方块");
		//Graphics graphics = frame.getGraphics();
		this.setBounds(100,200,600,800);
		//this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		bstart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				String[] shapes = {"I","S","Z","L","J","O","T"};
				board.creatBlock(shapes[random.nextInt(7)],random.nextInt(4));
				timer.start();
			}
		});

		timer = new Timer(speed, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (null != board.getShape()){
					bstart.setFocusable(false);
					board.setFocusable(true);
					board.normalDown();
				}
			}
		});


	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}



	public void initView() {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//if (null != board.getShape()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN: {
					if (board.canfallingDown()) {
						break;
					}else {
						board.saveBlock();
					}
//					else {
//						saveBlockToStore(curX, curY);
//						delline();
//						createBlock();
//					}
					break;
				}
				case KeyEvent.VK_RIGHT: {
					board.canMoveRight();
					break;
				}
				case KeyEvent.VK_LEFT: {
					board.canMoveLeft();
					break;
				}
				//顺时针变换方块的形态
				case KeyEvent.VK_UP: {
					board.changeState();
					break;
				}
			}
		//board.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	//	public void actionPerformed(ActionEvent event){
//		JButton button = (JButton)event.getSource();
//		if (button.getText().equals("开始")){
//			timer.start();
//			button.setFocusable(false);
//		}
//	}

//	public void toStart(Board board){
//		board.setFocusable(true);
//		while (true) {
//			if (null != board.getShape()) {
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				board.normalDown();
//				board.repaint();
//			}
//		}
//	}
}

class Board extends JPanel{
	final static int SIDE = 15;    //每一格的像素
	String shapes = "ISZLJOT";
	Map<String,Integer[][]> shapeStyle = new HashMap<>();
	private Random random = new Random();
	int[][] map;
	int curY = 0;
	int curX = 9;
	private String shape;
	private int state;
	public Board() {
		initShapeStyle();
		initMap();
	}

	private void initShapeStyle() {
		Integer[][] i_shape={{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}};
		shapeStyle.put("I",i_shape);
		Integer[][] s_shape= {{0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}};
		shapeStyle.put("S",s_shape);

		Integer[][] z_shape= {{1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}};
		shapeStyle.put("Z",z_shape);

		Integer[][] j_shape=  {{0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		shapeStyle.put("J",j_shape);

		Integer[][] l_shape= {{1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		shapeStyle.put("L",l_shape);

		Integer[][] o_shape= {{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		shapeStyle.put("O",o_shape);

		Integer[][] t_shape= {{0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0}};
		shapeStyle.put("T",t_shape);

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
		this.curX = 9;
		this.curY = 0;
		return true;
	}

	public String getShape(){
		return this.shape;
	}
	public void saveBlock(){
		for (int a = 0; a< 4; a++){
			for (int b = 0; b < 4; b++) {
				if (shapeStyle.get(shape)[state][a * 4 + b] == 1) {
					map[curX + b][curY + a + 1] = 2;
				}
			}
		}
		creatBlock(String.valueOf(shapes.charAt(random.nextInt(7))),random.nextInt(4));
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
					case 2: //堆积区，橙色
						g.setColor(Color.orange);
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
		this.setFocusable(true);
	}

	public void normalDown() {
		if (shape == null || !shapes.contains(shape)) return ;
		if(ifCanMove(curX,curY+1)) {
			curY += 1;
		}else {
			saveBlock();
			clearOffFullLine();
		}
		super.repaint();
	}

	public void clearOffFullLine(){
		boolean clearOff = false;
		for (int i = 38; i > 0; i--) {
			int c = 0;
			for (int j = 1; j < 19; j++) {
				if (map[j][i] == 2){
					c++;
				}
			}

			if (c == 18){
				clearOff = true;
			}

			if (clearOff && c != 0){
				int b = i;
				for (int j = 0; j < 20; j++) {
					map[j][b] =  map[j][b - 1];
				}
				if (c == 18) {
					i++;
				}
			}

			if (c == 0) {
				break;
			}

		}
	}

	public boolean canfallingDown(){
		if(ifCanMove(curX,curY+1)){
			curY++;
			return true;
		}
		return false;
	}

	public boolean canMoveLeft(){
		if(ifCanMove(curX - 1,curY)) {
			curX--;
			return true;
		}
		return false;
	}
	public boolean canMoveRight(){
		if(ifCanMove(curX + 1,curY)) {
			curX++;
			return true;
		}
		return false;
	}

	public boolean changeState(){
		int oldState = this.state;
		this.state = (this.state + 1) % 4;
		if (ifCanMove(curX,curY)){
			return true;
		}else {
			this.state = oldState;
		}
		return false;
	}
	private boolean ifCanMove(int x, int y) {
		for (int a = 0; a< 4; a++){
			for (int b = 0; b < 4; b++) {
				if (shapeStyle.get(shape)[state][a * 4 + b] == 1
						&& (map[x + b][y + a + 1] == 1 || map[x + b][y + a + 1] == 2)) {
					return false;
				}
			}
		}
		return true;
	}

}
