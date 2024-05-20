package com.ssafy.enjoyTrip.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.enjoyTrip.community.dto.CommunityDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.enjoyTrip.community.service.CommunityService;
import com.ssafy.enjoyTrip.user.dto.UserDto;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/community")
@Tag(name = "07. 게시판 컨트롤러 페이지", description = "게시판 관련 api")
public class CommunityController {
	private final CommunityService communityService;

	@GetMapping
	@Operation(summary = "게시글 목록을 조회합니다.", description = "limit, offset, 검색어를 파라미터로 받아 게시글을 검색하여 반환해주는 기능입니다.")
	public ResponseEntity<Map<String, Object>> communityList(@RequestParam("limit") int limit,
			@RequestParam("offset") int offset, @RequestParam("searchWord") String searchWord) {
		Map<String, Object> map = new HashMap<>();
		List<CommunityDto> communityList;

		if ("".equals(searchWord)) {
			communityList = communityService.communityList(limit, offset);
		} else {
			communityList = communityService.communityListSearchWord(limit, offset, searchWord);
		}
		
		if (!communityList.isEmpty()) {
			map.put("communityList", communityList);
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/communityListTop")
	@Operation(summary = "상단 게시글 목록을 조회합니다.", description = "limit만큼의 상단 게시글 목록을 조회하는 기능입니다.")
	public ResponseEntity<Map<String, Object>> communityListTop(@RequestParam("limit") int limit) {
		Map<String, Object> map = new HashMap<>();
		List<CommunityDto> communityList = communityService.communityListTop(limit);
		if (!communityList.isEmpty()) {
			map.put("communityList", communityList);
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/communityListTotalCnt")
	@Operation(summary = "게시글 전체 개수를 조회합니다.", description = "검색어를 파라미터로 받아 해당 게시글의 개수를 반환해주는 기능입니다.")
	public ResponseEntity<Map<String, Object>> communityListTotalCnt(@RequestParam("searchWord") String searchWord) {
		Map<String, Object> map = new HashMap<>();
		int totalCnt;
		if ("".equals(searchWord)) {
			totalCnt = communityService.communityListTotalCnt();
		} else {
			totalCnt = communityService.communityListSearchWordTotalCnt(searchWord);
		}

		if (totalCnt >= 0) {
			map.put("totalCnt", totalCnt);
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	@Operation(summary = "게시글을 등록합니다.", description = "게시글을 등록하는 기능입니다.")
	public ResponseEntity<Map<String, Object>> communityInsert(CommunityDto communityDto) {
		Map<String, Object> map = new HashMap<>();
		int ret = communityService.communityInsert(communityDto);
		if (ret == 1) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else if (ret == -1) {
			map.put("result", "login");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	@Operation(summary = "게시글을 수정합니다.", description = "게시글을 수정하는 기능입니다.")
	public ResponseEntity<Map<String, Object>> communityUpdate(CommunityDto communityDto) {
		Map<String, Object> map = new HashMap<>();
		int ret = communityService.communityUpdate(communityDto);
		if (ret == 1) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/community/{communityId}")
	@Operation(summary = "게시글을 삭제합니다.", description = "게시글을 삭제하는 기능입니다.")
	public ResponseEntity<Map<String, Object>> communityDelete(@PathVariable("communityId") int communityId) {
		Map<String, Object> map = new HashMap<>();
		int ret = communityService.communityDelete(communityId);
		if (ret == 1) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{communityId}")
	@Operation(summary = "게시글을 상세 조회합니다.", description = "게시글을 상세 조회하는 기능입니다.")
	public ResponseEntity<Map<String, Object>> communityDetail(@PathVariable("communityId") int communityId, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		//postman에서는 session 존재하지 않기 때문에 error 발생함. dummy data로 test 권장
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		CommunityDto communityDto = communityService.communityDetail(communityId, userDto.getUserId());
		
		map.put("communityDto", communityDto);
		map.put("result", "success");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
