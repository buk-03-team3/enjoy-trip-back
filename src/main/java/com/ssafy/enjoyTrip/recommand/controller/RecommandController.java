package com.ssafy.enjoyTrip.recommand.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoyTrip.recommand.dto.RecommandDto;
import com.ssafy.enjoyTrip.recommand.service.RecommandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommand")
@Tag(name = "06. 추천 관련 컨트롤러 페이지", description = "추천 관련 api")
public class RecommandController {

	private final RecommandService recommandService;
	
	@GetMapping("/{uuid}")
	@Operation(summary = "사용자 기반 여행지 추천", description = "사용자 기반에 따른 여행지를 추천하는 기능입니다.")
	public ResponseEntity<Map<String,Object>> recommandWihtAddr(@PathVariable int uuid){
		Map<String,Object> map = new HashMap<>();
		List<RecommandDto> recommandList= recommandService.recommandWithAddr(uuid);;
		
		if (recommandList != null) {
			map.put("result", "success");
			map.put("list", recommandList);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/region/{uuid}")
	@Operation(summary = "사용자 지역 기반 여행지 추천", description = "사용자가 입력한 지역 기반에 따른 여행지를 추천하는 기능입니다.")
	public ResponseEntity<Map<String,Object>> recommandPopular(@PathVariable int uuid){
		Map<String,Object> map = new HashMap<>();
		List<RecommandDto> recommandList = recommandService.recommandPopular(uuid);
		
		if (recommandList != null) {
			map.put("result", "success");
			map.put("list", recommandList);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/type/{uuid}")
	@Operation(summary = "사용자 콘텐츠 기반 여행지 추천", description = "사용자가 선호하는 콘텐츠 기반에 따른 여행지를 추천하는 기능입니다.")
	public ResponseEntity<Map<String,Object>> recommandType(@PathVariable int uuid){
		Map<String,Object> map = new HashMap<>();
		List<RecommandDto> recommandDto = recommandService.recommandByType(uuid);
		
		if (recommandDto != null) {
			map.put("result", "success");
			map.put("recommandDto", recommandDto);
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
