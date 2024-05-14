package com.ssafy.enjoyTrip.recommand.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class RecommandController {

	private final RecommandService recommandService;
	
	@GetMapping("/{uuid}")
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
