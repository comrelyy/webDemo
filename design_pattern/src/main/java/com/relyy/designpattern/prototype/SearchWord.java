package com.relyy.designpattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchWord {

	private String keyword;

	private Integer count;

	private Long lastUpdateTime;
}
