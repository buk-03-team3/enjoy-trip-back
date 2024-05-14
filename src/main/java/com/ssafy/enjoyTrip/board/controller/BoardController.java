package com.ssafy.enjoyTrip.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoyTrip.board.dto.BoardDto;
import com.ssafy.enjoyTrip.board.service.BoardService;
import com.ssafy.enjoyTrip.user.dto.UserDto;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@GetMapping("/boards")
	public ResponseEntity<Map<String, Object>> boardList(@RequestParam("limit") int limit,
			@RequestParam("offset") int offset, @RequestParam("searchWord") String searchWord) {
		Map<String, Object> map = new HashMap<>();
		List<BoardDto> boardList;

		if ("".equals(searchWord)) {
			boardList = boardService.boardList(limit, offset);
		} else {
			boardList = boardService.boardListSearchWord(limit, offset, searchWord);
		}
		
		if (!boardList.isEmpty()) {
			map.put("boardList", boardList);
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/boardListTop")
	public ResponseEntity<Map<String, Object>> boardListTop(@RequestParam("limit") int limit) {
		Map<String, Object> map = new HashMap<>();
		List<BoardDto> boardList = boardService.boardListTop(limit);
		if (!boardList.isEmpty()) {
			map.put("boardList", boardList);
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/boardListTotalCnt")
	public ResponseEntity<Map<String, Object>> boardListTotalCnt(@RequestParam("searchWord") String searchWord) {
		Map<String, Object> map = new HashMap<>();
		int totalCnt;
		if ("".equals(searchWord)) {
			totalCnt = boardService.boardListTotalCnt();
		} else {
			totalCnt = boardService.boardListSearchWordTotalCnt(searchWord);
		}

		if (totalCnt >= 0) {
			map.put("totalCnt", totalCnt);
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/boards")
	public ResponseEntity<Map<String, Object>> boardInsert(BoardDto boardDto) {
		Map<String, Object> map = new HashMap<>();
		int ret = boardService.boardInsert(boardDto);
		if (ret == 1) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else if (ret == -1) {
			map.put("result", "login");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/boards")
	public ResponseEntity<Map<String, Object>> boardUpdate(BoardDto boardDto) {
		Map<String, Object> map = new HashMap<>();
		int ret = boardService.boardUpdate(boardDto);
		if (ret == 1) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/boards/{boardId}")
	public ResponseEntity<Map<String, Object>> boardDelete(@PathVariable("boardId") int boardId) {
		Map<String, Object> map = new HashMap<>();
		int ret = boardService.boardDelete(boardId);
		if (ret == 1) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("boards/{boardId}")
	public ResponseEntity<Map<String, Object>> boardDetail(@PathVariable("boardId") int boardId, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		//postman에서는 session 존재하지 않기 때문에 error 발생함. dummy data로 test 권장
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		BoardDto boardDto = boardService.boardDetail(boardId, userDto.getUuid());
		
		map.put("boardDto",boardDto);
		map.put("result", "success");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
