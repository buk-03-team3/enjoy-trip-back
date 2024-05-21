package com.ssafy.enjoyTrip.meeting.service;

import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import java.util.List;

public interface MeetingService {
    public int meetingInsert(MeetingDto dto);
    public MeetingDto meetingSelect(int meetingId);
    public List<MeetingDto> meetingList(int limit, int offset, String searchWord, String searchOptionsss);
    public int meetingUpdate(MeetingDto dto);
    public int meetingDelete(int meetingId);
    public List<MeetingDto> myMeetingList(int userId);
}
