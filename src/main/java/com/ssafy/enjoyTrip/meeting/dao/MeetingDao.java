package com.ssafy.enjoyTrip.meeting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MeetingDao {
	public int meetingInsert(MeetingDto dto);
	public MeetingDto meetingSelect(int meetingId);
	public List<MeetingDto> meetingList(@Param("limit") int limit,
										@Param("offset") int offset,
										@Param("searchTitle") String searchTitle,
										@Param("searchAddr") String searchAddr,
										@Param("meetingStartDate") String meetingStartDate,
										@Param("meetingEndDate") String meetingEndDate);

	public int meetingUpdate(MeetingDto dto);
	public int meetingDelete(int meetingId);
	public List<MeetingDto> myMeetingList(int userId);
}
