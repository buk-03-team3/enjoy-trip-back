package com.ssafy.enjoyTrip.meeting;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import java.util.List;

import com.ssafy.enjoyTrip.meeting.service.MeetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.meeting.dao.MeetingDao;
import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MeetingTest {
	@Autowired
	MeetingDao dao ;
	@Autowired
	MeetingService meetingService;
	@Test
	public void DI() {
		assertNotNull(dao);
	}
	
	@Test
	@Transactional
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

	@Test
	@Transactional
	public void detail(){
//		MeetingDto dto =new MeetingDto();
//		dto.setMeetingId(23);
//		dto.setUserId(-1);
		MeetingDto dto =dao.meetingDetail(23);
		System.out.println("dto : "+dto);
	}

	@Test
	@Transactional
	public void update(){
		MeetingDto dto = new MeetingDto();
		dto.setMeetingId(31);
		dto.setAttractionId(125266);
		dto.setContent("asdfsdfsd");
		dto.setMeetingEndDate(LocalDateTime.now());
		dto.setMeetingStartDate(LocalDateTime.now());
		dto.setTitle("Asdf");
		dto.setMeetingPassword("adfsf1213s");
		int result = dao.meetingUpdate(dto);
		assertEquals(1, result);
	}

	@Test
	@Transactional
	public void delete(){
		//participant 데이터가 먼저 삭제되어야 함
		int result =meetingService.meetingDelete(30);
		assertEquals(result,1);
	}

	@Test
	public void getMyMeetingList(){
		int userId = 20;
		List<MeetingDto> dtoList =dao.myMeetingList(userId);
		System.out.println(dtoList.size());
		assertEquals(6,dtoList.size());
	}

	@Test
	public void getMeetingList(){
		int limit =10;
		int offset =0;
		List<MeetingDto> dtoList = dao.meetingList(limit,offset);
		System.out.println(dtoList);
		assertEquals(8,dtoList.size());
	}
}
