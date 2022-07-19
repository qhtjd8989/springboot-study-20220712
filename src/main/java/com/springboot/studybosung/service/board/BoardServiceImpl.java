package com.springboot.studybosung.service.board;

import org.springframework.stereotype.Service;

import com.springboot.studybosung.domain.board.Board;
import com.springboot.studybosung.domain.board.BoardRepository;
import com.springboot.studybosung.web.dto.board.CreateBoardReqDto;
import com.springboot.studybosung.web.dto.board.CreateBoardRespDto;
import com.springboot.studybosung.web.dto.board.ReadBoardRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;	
	
	@Override
	public CreateBoardRespDto createBoard(CreateBoardReqDto createBoardReqDto) throws Exception {
		Board boardEntity = createBoardReqDto.toEntity();
		boolean insertStatus = boardRepository.save(boardEntity) > 0;
		
		return boardEntity.toCreateBoardDto(insertStatus);
//		System.out.println("DB 다녀오기 전: " + board);
//		int result = boardRepository.save(board);
//		System.out.println("DB 다녀온 후: " + board);
	}
	
	@Override
	public ReadBoardRespDto readBoard(int boardcode) throws Exception {
		return boardRepository.findBoardByBoardcode(boardcode).toReadBoardDto();
	}
	
	@Override
	public ReadBoardRespDto readBoardList(int page) throws Exception {
		return null;
	}

	@Override
	public boolean updateBoard(int boardcode, CreateBoardReqDto createBoardReqDto) throws Exception {
		return false;
	}

	@Override
	public boolean deleteBoard(int boardcode) throws Exception {
		return false;
	}

	

	
	
}
