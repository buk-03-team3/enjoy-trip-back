package com.ssafy.enjoyTrip.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoyTrip.board.dao.BoardDao;
import com.ssafy.enjoyTrip.board.dto.BoardDto;

@SpringBootTest
public class BoardTest {

	@Autowired
	BoardDao boardDao;

	@Test
	public void testDi() {
		assertNotNull(boardDao);
	}

	@Test
	@Transactional
	public void testBoardInsert() {
		BoardDto dto = new BoardDto();
		dto.setContent("testDto");
		dto.setTitle("TEST");
		dto.setUserId(1);
		assertEquals(1, boardDao.boardInsert(dto));
	}

	@Test
	@Transactional
	public void testBoardUpdate() {
		BoardDto dto = new BoardDto();
		dto.setContent("testDto");
		dto.setTitle("TESTUpdate");
		dto.setUserId(1);
		assertEquals(1, boardDao.boardInsert(dto));
	}

	@Test
	@Transactional
	public void testBoardDelete() {
		int boardId = 24;
		assertEquals(1, boardDao.boardDelete(boardId));
	}

	@Test
	public void testBoardDetail() {
		int boardId = 24;
		BoardDto dto = boardDao.boardDetail(boardId);
		System.out.println(dto);
		assertNotNull(dto);
	}

	@Test
	public void testBoardListTop() {
		List<BoardDto> list = boardDao.boardListTop(8);
		System.out.println(list.size());
		assertEquals(list.size(), 5);
	}
	
	@Test
	public void testBoardList() {
		int limit = 8;
		int offset= 0;
		List<BoardDto> list = boardDao.boardList(limit, offset);
		System.out.println(list);
		assertEquals(list.size(), 5);		
	}
	
	@Test
	public void testBoardListTotalCnt() {
		assertThat(boardDao.boardListTotalCnt()).isGreaterThan(1);
	}
	
	@Test
	public void testBoardListSearchWordTotalCnt() {
		String searchWord = "번";
		assertEquals(6, boardDao.boardListSearchWordTotalCnt(searchWord));
	}
	
	@Test
	public void testBoardListSearchWord() {
		String searchWord="번";
		int limit = 8;
		int offset =0;
		List<BoardDto> list = boardDao.boardListSearchWord(limit, offset, searchWord); 
		System.out.println("testBoardListSearchWord"+list);
		assertThat(list.size()).isGreaterThan(1);
	}
}
