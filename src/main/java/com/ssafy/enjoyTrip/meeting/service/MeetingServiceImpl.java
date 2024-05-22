package com.ssafy.enjoyTrip.meeting.service;

import com.ssafy.enjoyTrip.meeting.dao.MeetingDao;
import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
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
    public List<MeetingDto> meetingList(int limit, int offset ,String searchTitle,
                                        String searchAddr,
                                        String meetingStartDate,
                                        String meetingEndDate) {
        List<MeetingDto> list;
        list = meetingDao.meetingList(limit,offset,searchTitle,searchAddr,meetingStartDate, meetingEndDate);
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
