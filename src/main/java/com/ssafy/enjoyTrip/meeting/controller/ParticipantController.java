package com.ssafy.enjoyTrip.meeting.controller;

import com.ssafy.enjoyTrip.meeting.dto.ParticipantDto;
import com.ssafy.enjoyTrip.meeting.service.ParticipantService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participants")
public class ParticipantController {
    private final ParticipantService participantService;
    //INSERT 소모임 가입
    @PostMapping("/join")
    public ResponseEntity<Map<String,Object>> participantInsert(@RequestBody ParticipantDto dto){
        Map<String,Object> map = new HashMap<>();
        int result = participantService.participantInsert(dto);
        System.out.println(result);
        if(result==1){
            map.put("result","success");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }else{
            map.put("result","fail");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE 소모임 탈퇴

    //SELECT 내가 속한 소모임
}
