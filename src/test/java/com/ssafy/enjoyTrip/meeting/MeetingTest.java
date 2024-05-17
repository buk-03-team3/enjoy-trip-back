package com.ssafy.enjoyTrip.meeting;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.meeting.dao.MeetingDao;
import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;

@SpringBootTest
public class MeetingTest {
	@Autowired
	MeetingDao dao ;
	
	@Test
	public void DI() {
		assertNotNull(dao);
	}
	
	@Test
	public void insert() {
		MeetingDto dto = new MeetingDto();
		dto.setAttractionId(125266);
		dto.setContent("asdfsdfsd");
		dto.setMeetingEndDate(LocalDateTime.now());
		dto.setMeetingStartDate(LocalDateTime.now());
		dto.setTitle("Asdf");
		dto.setUserId(4);
		dto.setMeetingPassword("adfsf1213s");
		int result =dao.meetingInsert(dto);
		assertEquals(1, result);
		
	}
}
