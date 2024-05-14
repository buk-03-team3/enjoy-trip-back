package com.ssafy.enjoyTrip.board.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ssafy.enjoyTrip.board.dao.BoardDao;
import com.ssafy.enjoyTrip.board.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    static BoardDto sorted[];
    private final BoardDao boardDao;

    @Override
    public int boardInsert(BoardDto dto) {
        return boardDao.boardInsert(dto);
    }

    @Override
    public int boardUpdate(BoardDto dto) {
        return boardDao.boardUpdate(dto);
    }

    @Override
    public int boardDelete(int boardId) {
        return boardDao.boardDelete(boardId);
    }

    @Override
    public BoardDto boardDetail(int boardId, int userSeq) { // 현재 세션 사용자의 userSeq
        BoardDto boardDto = boardDao.boardDetail(boardId);
        if (boardDto.getUserSeq() == userSeq) {
            boardDto.setSameUser(true);
        } else {
            boardDto.setSameUser(false);
        }

        return boardDto;
    }

    @Override
    public List<BoardDto> boardList(int limit, int offset) {
        return boardDao.boardList(limit, offset);
    }

    @Override
    public int boardListTotalCnt() {
        return boardDao.boardListTotalCnt();
    }

    @Override
    public List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord) {
        return boardDao.boardListSearchWord(limit, offset, searchWord);
    }

    @Override
    public int boardListSearchWordTotalCnt(String searchWord) {
        return boardDao.boardListSearchWordTotalCnt(searchWord);
    }

    @Override
    public List<BoardDto> boardListTop(int limit) {
        ArrayList<BoardDto> dto = (ArrayList<BoardDto>) boardDao.boardListTop(limit);
        Collections.sort(dto, (o1, o2) -> o1.getReadCount() - o2.getReadCount());
        System.out.println("service : " + dto);
        ArrayList<BoardDto> sortDto = (ArrayList<BoardDto>) sort(dto);
        
        return sortDto.stream().limit(limit).collect(Collectors.toList());
    }

    public List<BoardDto> sort(List<BoardDto> list) {
        // 사이즈가 1보다 크다면
        if (list.size() > 1) {
            // 왼쪽 오른쪽을 merge 합니다.
            return merge(
                    // 왼쪽 / 오른쪽으로 배열을 나누고 다시 sort하도록 합니다.
                    sort(list.subList(0, list.size() / 2)), sort(list.subList(list.size() / 2, list.size())));
        } else {
            // 사이즈가 1 이하라면 재귀가 종료됩니다.
            return list;
        }
    }

    /**
     * 병합합니다.
     *
     * @param list  왼쪽 배열
     * @param list2 오른쪽 배열
     * @return
     */
    public List<BoardDto> merge(List<BoardDto> list, List<BoardDto> list2) {
        // 결과가 될 임시 배열입니다.
        List<BoardDto> result = new ArrayList<>();
        int rightIdx = 0;

        // 왼쪽 배열을 순환하면서
        for (BoardDto l : list) {

            // right를 끝까지 돌았는지 / right배열의 값이 l보다 작은지 확인하고,
            while (list2.size() > rightIdx && l.getReadCount() >list2.get(rightIdx).getReadCount()) {
                // 작은 값을 결과에 넣습니다.
                result.add(list2.get(rightIdx));
                rightIdx++;
            }
            // left가 작다면 left element를 넣습니다.
            result.add(l);
        }
        // 오른쪽 배열의 남은 숫자를 결과에 넣습니다.
        for (int i = rightIdx; i < list2.size(); i++) {
            result.add(list2.get(i));
        }
        return result;
    }
}