package com.ssafy.enjoyTrip.notice.service;

import com.ssafy.enjoyTrip.notice.dao.NoticeDao;
import com.ssafy.enjoyTrip.notice.dto.NoticeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements  NoticeService{
    private final NoticeDao noticeDao;

    @Override
    public int noticeInsert(NoticeDto dto) {
        return noticeDao.noticeInsert(dto);
    }

    @Override
    public int noticeUpdate(NoticeDto dto) {
        return noticeDao.noticeUpdate(dto);
    }

    @Override
    public NoticeDto noticeDetail(int noticeId, int userId) {
        NoticeDto noticeDto = noticeDao.noticeDetail(noticeId);
        if(noticeDto.getUserId() == userId){
            noticeDto.setSameUser(true);
            noticeDto.setAdmin(noticeDto.getCode().equals("1"));
        } else{
            noticeDto.setSameUser(false);
            noticeDto.setAdmin(false);
        }
        return noticeDto;
    }

    @Override
    public int noticeDelete(int noticeId) {
        return noticeDao.noticeDelete(noticeId);
    }

    @Override
    public List<NoticeDto> noticeList(int limit, int offset) {
        return noticeDao.noticeList(limit,offset);
    }

    @Override
    public int noticeListTotalCnt() {
        return noticeDao.noticeListTotalCnt();
    }

    @Override
    public int noticeListSearchWordTotalCnt(String searchWord) {
        return noticeDao.noticeListSearchWordTotalCnt(searchWord);
    }

    @Override
    public List<NoticeDto> noticeListSearchWord(String searchWord, int limit, int offset) {
        return noticeDao.noticeListSearchWord(searchWord, limit, offset);
    }
}
