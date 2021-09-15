package com.relyy.designpattern.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 该类描述棋子在棋盘中的位置，位置信息是可变的
 * @Created by cairuirui
 * @Date 2020/7/4
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChessPiece {
	private ChessPieceUnit chessPieceUnit;
	private int positionX;
	private int positionY;

}
