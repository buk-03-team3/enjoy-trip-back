package com.ssafy.enjoyTrip.meeting;

import com.ssafy.enjoyTrip.meeting.dao.ParticipantDao;
import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import com.ssafy.enjoyTrip.meeting.dto.ParticipantDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class ParticipantsTest {
    @Autowired
    ParticipantDao dao;
    @Test
    public void DITestParticipantDao(){
        assertNotNull(dao);
    }

    @Test
    @Transactional
    public void insert(){
        ParticipantDto dto = new ParticipantDto();
        dto.setUserId(4);
        dto.setMeetingId(23);
        dto.setAuthority("0");
        int result = dao.participantInsert(dto);
        assertEquals(1, result);
        }

    @Test
    @Transactional
    public void delete(){
        ParticipantDto dto = new ParticipantDto();
        dto.setUserId(4);
        dto.setMeetingId(23);
        dto.setAuthority("0");
        int result = dao.deleteParticipant(dto.getUserId(), dto.getMeetingId());
        assertEquals(1,result);
    }

    @Test
    @Transactional
    public void deleteAll(){
        int meetingId = 20;
        int result = dao.deleteAllParticipant(meetingId);
        assertEquals(1,result);
    }

    @Test
    public void isParticipant(){
        int userId = 4;
        int meetingId= 11;
        int result = dao.isParticipant(userId,meetingId);
        assertEquals(result,1);
    }

    @Test
    public void getAuthority(){
        int userId = 4;
        int meetingId= 11;
        String authority = dao.getAuthority(userId, meetingId);
        System.out.println(authority);
        assertEquals("01",authority);
    }

    @Test
    public void getParticipatingMeetings(){
        int userId = 4;
        List<ParticipantDto> dto = dao.getParticipatingMeetings(userId);
        System.out.println(dto);
        assertEquals(dto.size() , 8);
    }

    @Test
    @Transactional
    public void joinedParticipants(){
        int meetingId =4;
        List<ParticipantDto> dto = dao.joinedParticipants(meetingId);
        System.out.println(dto);
        assertEquals(dto.size() ,1);
    }
}
