package com.ssafy.enjoyTrip.notice.service;

import com.ssafy.enjoyTrip.notice.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    public int noticeInsert(NoticeDto dto);
    public int noticeUpdate(NoticeDto dto);
    public NoticeDto noticeDetail(int noticeId, int userId);
    public int noticeDelete(int noticeId);
    public List<NoticeDto> noticeList( int limit, int offset);
    public int noticeListTotalCnt();
    public int noticeListSearchWordTotalCnt(String searchWord);
    public List<NoticeDto> noticeListSearchWord(String searchWord ,int limit, int offset);

}
