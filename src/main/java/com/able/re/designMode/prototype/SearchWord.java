package com.able.re.designMode.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
