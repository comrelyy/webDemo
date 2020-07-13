package com.able.re.designMode.flyweight;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/7/4
 */
public class ChessPieceUnitFactory {

	private static final Map<Integer, ChessPieceUnit> pieces = Maps.newHashMap();
	private static final List<String> pieceName = Lists.newArrayList("炮，马，车");
	static {
		pieceName.stream().forEach(name -> {
			int id = 0;
			pieces.put(id++,new ChessPieceUnit(id++,name,ChessPieceUnit.Color.BLACK));
			pieces.put(id++,new ChessPieceUnit(id++,name,ChessPieceUnit.Color.RED));
		});
	}

	public static ChessPieceUnit getChessPiece(int chessPieceId){
		return pieces.get(chessPieceId);
	}
}
