package com.ssafy.enjoyTrip.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoyTrip.board.dto.BoardDto;
import com.ssafy.enjoyTrip.board.service.BoardService;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Test
	public void testDi() {
		assertNotNull(boardService);
	}

	@Test
	@Transactional
	public void testBoardInsert() {
		BoardDto dto = new BoardDto();
		dto.setContent("testDto22");
		dto.setTitle("TEST22");
		dto.setUserSeq(1);
		System.out.println(boardService.boardInsert(dto));
		assertEquals(1, boardService.boardInsert(dto));
	}

	@Test
	@Transactional
	public void testBoardUpdate() {
		BoardDto dto = new BoardDto();
		dto.setContent("testDto");
		dto.setTitle("TESTUpdate");
		dto.setUserSeq(1);
		assertEquals(1, boardService.boardInsert(dto));
	}

	@Test
	@Transactional
	public void testBoardDelete() {
		int boardId = 24;
		assertEquals(1, boardService.boardDelete(boardId));
	}

	@Test
	public void testBoardDetail() {
		int boardId = 24;
		int userSeq= 5;
		BoardDto dto = boardService.boardDetail(boardId, userSeq);
		System.out.println(dto);
		assertNotNull(dto);
	}

	@Test
	public void testBoardListTop() {
		List<BoardDto> list = boardService.boardListTop(8);
		System.out.println(list);
		assertEquals(list.size(), 8);
	}
	
	@Test
	public void testBoardList() {
		int limit = 8;
		int offset= 5;
		List<BoardDto> list = boardService.boardList(limit, offset);
		System.out.println(list);
		assertEquals(list.size(), 5);		
	}
	
	@Test
	public void testBoardListTotalCnt() {
		assertThat(boardService.boardListTotalCnt()).isGreaterThan(1);
	}
	
	@Test
	public void testBoardListSearchWordTotalCnt() {
		String searchWord = "번";
		assertEquals(6, boardService.boardListSearchWordTotalCnt(searchWord));
	}
	
	@Test
	public void testBoardListSearchWord() {
		String searchWord="번";
		int limit = 8;
		int offset =0;
		List<BoardDto> list = boardService.boardListSearchWord(limit, offset, searchWord); 
		System.out.println("testBoardListSearchWord"+list);
		assertThat(list.size()).isGreaterThan(1);
	}
}
