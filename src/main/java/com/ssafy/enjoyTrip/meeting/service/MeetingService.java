package com.ssafy.enjoyTrip.meeting.service;

import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import com.ssafy.enjoyTrip.user.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetingService {
    public int meetingInsert(MeetingDto dto);
    public MeetingDto meetingDetail(int meetingId, UserDto dto);
    public List<MeetingDto> meetingList(int limit, int offset, String searchTitle,
                                        String searchAddr,
                                        String meetingStartDate,
                                        String meetingEndDate);
    public int meetingUpdate(MeetingDto dto);
    public int meetingDelete(int meetingId);
    public List<MeetingDto> myMeetingList(int userId);
}
