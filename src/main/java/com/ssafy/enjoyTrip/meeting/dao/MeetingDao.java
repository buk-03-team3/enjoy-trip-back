package com.ssafy.enjoyTrip.meeting.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;

@Mapper
public interface MeetingDao {
	public int meetingInsert(MeetingDto dto);
	public int meetingSelect(int meetingId);
}
