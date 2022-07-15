package com.springboot.studybosung.web.controller.api.board;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studybosung.service.board.BoardService;
import com.springboot.studybosung.web.dto.board.CreateBoardReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor // 필수항목들
public class BoardController {
	
	private final BoardService boardService;
	
	//게시글 작성
	@PostMapping("/content") // 동사는 사용하지 않는게 좋다
	// key값과 변수명이 같으면 생략가능(@RequestParam , key값)								
	public ResponseEntity<?> addBoard(@RequestBody CreateBoardReqDto createBoardReqDto) { 
		boolean responseData = false;
		try {
			responseData = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(responseData);		
		}
		return ResponseEntity.ok().body(responseData);
		
//		System.out.println("게시글 작성 요청");
//		System.out.println("title: " + createBoardReqDto.getTitle());
//		System.out.println("usercode: " + createBoardReqDto.getUsercode());
//		System.out.println("content: " + createBoardReqDto.getContent());
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", "text/html;charset=utf-8");
//		return new ResponseEntity<>(title + "게시글 작성 성공", headers, HttpStatus.BAD_REQUEST);
	}
	
	//게시글 조회
	
	
	//게시글 수정
	
	
	//게시글 삭제
	
	
}
