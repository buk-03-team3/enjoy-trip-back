package com.ssafy.enjoyTrip.meeting.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class MeetingDto {
	int meetingId;
	int userId;
	String title;
	String content;
	String meetingPassword;
	int attractionId;
	LocalDateTime meetingStartDate;
	LocalDateTime meetingEndDate;
}
