package com.ssafy.enjoyTrip.meeting.controller;

import com.ssafy.enjoyTrip.meeting.dto.MeetingDto;
import com.ssafy.enjoyTrip.meeting.service.MeetingService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController {
    /*
        public int meetingInsert(MeetingDto dto);
    public MeetingDto meetingSelect(int meetingId);
    public List<MeetingDto> meetingList(int limit, int offset, String searchWord);
    public int meetingUpdate(MeetingDto dto);
    public int meetingDelete(int meetingId);
    public List<MeetingDto> myMeetingList(int userId);
     */
    private final MeetingService meetingService;

    @GetMapping("/posts")
    public ResponseEntity<Map<String,Object>> meetingList(@RequestParam("limit") int limit,
                                                          @RequestParam("offset") int offset,
                                                          @RequestParam("searchTitle") String searchTitle,
                                                          @RequestParam("searchAddr") String searchAddr,
                                                          @RequestParam("meetingStartDate") String meetingStartDate,
                                                          @RequestParam("meetingEndDate") String meetingEndDate){
        Map<String,Object> map = new HashMap<>();
        List<MeetingDto> list=meetingService.meetingList(limit,offset,searchTitle,searchAddr,meetingStartDate,meetingEndDate);
        if(!list.isEmpty()){
            map.put("list",list);
            map.put("result", "success");
            System.out.println(list);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }else{
            map.put("result","fail");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/posts")
    public ResponseEntity<Map<String,Object>> meetingInsert(@RequestBody MeetingDto dto){
        return null;
    }



}
