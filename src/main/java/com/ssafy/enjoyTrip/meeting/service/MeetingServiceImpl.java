package com.ssafy.enjoyTrip.meeting.service;

import com.ssafy.enjoyTrip.meeting.dao.MeetingDao;
import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService{
    private final MeetingDao meetingDao;

    @Override
    public int meetingInsert(MeetingDto dto) {
        return 0;
    }

    @Override
    public MeetingDto meetingSelect(int meetingId) {
        return null;
    }

    @Override
    public List<MeetingDto> meetingList(int limit, int offset, String searchWord, String searchOption) {
        List<MeetingDto> list;
        if("".equals(searchWord)){
            //전체 조회
            list = meetingDao.meetingList(limit,offset,searchWord);
        }else if("titleAndContent".equals(searchOption)){
            //제목과 내용으로 검색
            list= meetingDao.meetingList(limit,offset,searchWord);
        }else{ //다른 조건들...
            list = meetingDao.meetingList(limit,offset,searchWord);
        }
        return list;
    }

    @Override
    public int meetingUpdate(MeetingDto dto) {
        return 0;
    }

    @Override
    public int meetingDelete(int meetingId) {
        return 0;
    }

    @Override
    public List<MeetingDto> myMeetingList(int userId) {
        return null;
    }
}
