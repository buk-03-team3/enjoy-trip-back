package com.ssafy.enjoyTrip.community.service;

import java.util.List;

import com.ssafy.enjoyTrip.community.dto.CommunityDto;

public interface CommunityService {
	int communityInsert(CommunityDto dto);
	int communityUpdate(CommunityDto dto);
	int communityDelete(int communityId);
	List<CommunityDto> communityList(int limit, int offset);
	int communityListTotalCnt();
	CommunityDto communityDetail(int communityId, int userId);
	List<CommunityDto> communityListSearchWord(int limit, int offset, String searchWord);
	int communityListSearchWordTotalCnt(String searchWord);
	List<CommunityDto> communityListTop(int limit);
}