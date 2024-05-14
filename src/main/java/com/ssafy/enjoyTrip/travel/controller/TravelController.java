package com.ssafy.enjoyTrip.travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoyTrip.travel.dto.TravelDto;
import com.ssafy.enjoyTrip.travel.service.TravelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/travel")
@CrossOrigin("*")
public class TravelController {
	private final TravelService travelService;
	
	@GetMapping("/content")
	public ResponseEntity<Map<String,Object>> travelListByContent(
			@RequestParam("sidoCode") int sidoCode,
			@RequestParam("gugunCode") int gugunCode,
			@RequestParam("contentType") int contentType
			){
		List<TravelDto> list =travelService.selectTravelListWithContent(sidoCode, gugunCode, contentType);
		Map<String, Object> map = new HashMap<>();
		if(list.size()!=0) {
			map.put("list",list);
			map.put("result", "success");	
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			map.put("result","fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("list")
	public ResponseEntity<Map<String,Object>> travelList(
			@RequestParam("sidoCode") int sidoCode,
			@RequestParam("gugunCode") int gugunCode
			){
		List<TravelDto> list =travelService.selectTravelList(sidoCode, gugunCode);
		Map<String, Object> map = new HashMap<>();
		if(list.size()!=0) {
			map.put("list",list);
			map.put("result", "success");	
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			map.put("result","fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/keyword")
	public ResponseEntity<Map<String,Object>> travelListByKeyword(
			@RequestParam("keyword") String keyword
			){
		List<TravelDto> list =travelService.selectTravleListWithKeyword(keyword);
		Map<String, Object> map = new HashMap<>();
		if(list.size()!=0) {
			map.put("list",list);
			map.put("result", "success");	
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			map.put("result","fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
