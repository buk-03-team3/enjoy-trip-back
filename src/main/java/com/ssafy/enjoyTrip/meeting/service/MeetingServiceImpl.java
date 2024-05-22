package com.ssafy.enjoyTrip.meeting.service;

import com.ssafy.enjoyTrip.meeting.dao.MeetingDao;
import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import java.util.List;

import com.ssafy.enjoyTrip.user.dao.UserDao;
import com.ssafy.enjoyTrip.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService{
    private final MeetingDao meetingDao;
    private final UserDao userDao;

    @Override
    public int meetingInsert(MeetingDto dto) {
        return 0;
    }

    @Override
    public MeetingDto meetingDetail(int meetingId, UserDto dto) {
        MeetingDto meetingDto = meetingDao.meetingDetail(meetingId);
        if(meetingDto.getUserId() == dto.getUserId()){
            meetingDto.setSameUser(true);
        }else{
            meetingDto.setSameUser(false);
            meetingDto.setAdmin(false);
        }
        if("1".equals(dto.getCode())){
            meetingDto.setAdmin(true);
        }
        return meetingDto;
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
