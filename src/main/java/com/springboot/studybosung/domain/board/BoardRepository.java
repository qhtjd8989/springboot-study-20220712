package com.springboot.studybosung.domain.board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
	public int save(Board board); //insert가 건수로 나오기 때문에 int
}
