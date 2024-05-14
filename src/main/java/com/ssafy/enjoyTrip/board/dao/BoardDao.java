package com.ssafy.enjoyTrip.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.enjoyTrip.board.dto.BoardDto;

@Mapper
public interface BoardDao {
	int boardInsert(BoardDto dto);
	int boardUpdate(BoardDto dto);
	int boardDelete(int boardId);
	int boardListTotalCnt();
	BoardDto boardDetail(int boardId);
	List<BoardDto> boardList(@Param("limit") int limit, @Param("offset") int offset);
	List<BoardDto> boardListTop(int limit);
	int boardListSearchWordTotalCnt(String searchWord);
	List<BoardDto> boardListSearchWord(@Param("limit") int limit, @Param("offset") int offset, @Param("searchWord") String searchWord);

}
