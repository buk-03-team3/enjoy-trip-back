package com.ssafy.enjoyTrip.favorite.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoyTrip.favorite.dto.FavoriteDto;
import com.ssafy.enjoyTrip.favorite.service.FavoriteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "03. 사용자 즐겨찾기 관련 컨트롤러 페이지", description = "즐겨찾기 관련 api")
public class FavoriteController {
	private final FavoriteService favoriteService;
	
	@GetMapping("/favorites/{userId}")
	@Operation(summary = "사용자 즐겨찾기 조회", description = "사용자의 관심 여행지 조회 기능입니다.")
	public ResponseEntity<Map<String, Object>> favoriteList(@PathVariable("userId") int userId){
		List<FavoriteDto> list = favoriteService.favoriteList(userId);
		Map<String, Object> map = new HashMap<>();
		if (list.size() != 0) {
			map.put("list", list);
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/favorites")
	@Operation(summary = "사용자 즐겨찾기 등록", description = "사용자의 관심 여행지를 등록하는 기능입니다.")
	public ResponseEntity<Map<String,String>> favoriteAdd(FavoriteDto favoriteDto){
		int ret = favoriteService.favoriteAdd(favoriteDto);
		Map<String,String> map = new HashMap<>();
		if (ret > 0) {
			// 추가 성공
			map.put("result", "success");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
		} else {
			// 추가 실패
			map.put("result", "fail");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/user/{favoriteId}")
	@Operation(summary = "사용자 즐겨찾기 삭제", description = "사용자의 관심 여행지 삭제 기능입니다.")
	public ResponseEntity<Map<String,String>> favoriteDelete(@PathVariable("favoriteId") int favoriteId){
		int ret = favoriteService.favoriteDelete(favoriteId);
		Map<String,String> map = new HashMap<>();
		if (ret > 0) {
			// 삭제 성공
			map.put("result", "success");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
		} else {
			// 삭제 실패
			map.put("result", "fail");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
