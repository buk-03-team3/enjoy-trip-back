package com.ssafy.enjoyTrip.util.sidogugun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoyTrip.util.sidogugun.dto.GugunCodeDto;
import com.ssafy.enjoyTrip.util.sidogugun.dto.SidoCodeDto;
import com.ssafy.enjoyTrip.util.sidogugun.service.SidoGugunService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
public class SidoGugunController {
	private final SidoGugunService sidoGugunService;
	@GetMapping("/sidoCode")
	public ResponseEntity<Map<String,Object>> sidoCode(){
		List<SidoCodeDto> list =sidoGugunService.sidoCodeList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sidoList", list);
		if(list.size()!=0) {
			map.put("result", "success");	
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			map.put("result","fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/gugunCode/{sidoCode}")
	public ResponseEntity<Map<String,Object>> gugunCode(@PathVariable("sidoCode") String sidoCode){
		List<GugunCodeDto> list =sidoGugunService.gugunCodeList(sidoCode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gugunList", list);
		if(list.size()!=0) {
			map.put("result", "success");	
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			map.put("result","fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
