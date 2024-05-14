package com.ssafy.enjoyTrip.meeting.dto;

import lombok.Data;

@Data
public class ParticipantDto {
	int travelPlanMemberSeq;
	int meetingId;
	int participantId;
	String authority;
}
