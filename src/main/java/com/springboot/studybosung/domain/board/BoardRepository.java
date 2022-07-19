package com.springboot.studybosung.domain.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
	public int save(Board board); // insert가 건수로 나오기 때문에 int
	public Board findBoardByBoardcode(int boardcode); // Board로 하면 객체 하나만 들고옴
	public List<Board> getBoardListOfIndex(int index); // List로 하면 리스트를 들고옴 
}
