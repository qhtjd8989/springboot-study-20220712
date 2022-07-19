package com.springboot.studybosung.web.controller.api.board;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studybosung.service.board.BoardService;
import com.springboot.studybosung.web.dto.CMRespDto;
import com.springboot.studybosung.web.dto.board.CreateBoardReqDto;
import com.springboot.studybosung.web.dto.board.CreateBoardRespDto;
import com.springboot.studybosung.web.dto.board.ReadBoardRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor // 필수항목들
public class BoardController {
	
	private final BoardService boardService;
	
	//게시글 작성
	@PostMapping("/content") // 동사는 사용하지 않는게 좋다
	// key값과 변수명이 같으면 생략가능(@RequestParam , key값)
	// JSON으로 데이터를 받을 때는 Dto앞에 @RequestBody를 꼭 입력해야 한다
	public ResponseEntity<?> addBoard(@RequestBody CreateBoardReqDto createBoardReqDto) { 
		CreateBoardRespDto createBoardRespDto = null;
		try {
			createBoardRespDto = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "게시글 등록 실패", createBoardRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 등록 성공", createBoardRespDto));
		
//		System.out.println("게시글 작성 요청");
//		System.out.println("title: " + createBoardReqDto.getTitle());
//		System.out.println("usercode: " + createBoardReqDto.getUsercode());
//		System.out.println("content: " + createBoardReqDto.getContent());
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", "text/html;charset=utf-8");
//		return new ResponseEntity<>(title + "게시글 작성 성공", headers, HttpStatus.BAD_REQUEST);
	}
	
	//게시글 조회
	@GetMapping("/content/{boardcode}")
	public ResponseEntity<?> getBoard(@PathVariable int boardcode){
		ReadBoardRespDto readBoardRespDto = null;
		try {
			readBoardRespDto = boardService.readBoard(boardcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "게시글 조회 실패", readBoardRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 조회 성공", readBoardRespDto));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getBoardList(@RequestParam int page){
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 리스트" + page + "페이지 불러오기 성공", null));
	}
	
	//게시글 수정
	
	
	//게시글 삭제
	
	
}
