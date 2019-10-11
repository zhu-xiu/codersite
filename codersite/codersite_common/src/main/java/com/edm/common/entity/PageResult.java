package com.edm.common.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
	private Long total;
	private List<T> rows;
}

