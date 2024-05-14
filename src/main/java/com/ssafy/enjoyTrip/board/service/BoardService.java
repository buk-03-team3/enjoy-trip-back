package com.ssafy.enjoyTrip.board.service;

import java.util.List;

import com.ssafy.enjoyTrip.board.dto.BoardDto;

public interface BoardService {
	int boardInsert(BoardDto dto);
	int boardUpdate(BoardDto dto);
	int boardDelete(int boardId);
	List<BoardDto> boardList(int limit, int offset);
	int boardListTotalCnt();
	BoardDto boardDetail(int boardId, int userSeq);
	List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord);
	int boardListSearchWordTotalCnt(String searchWord);
	List<BoardDto> boardListTop(int limit);
}