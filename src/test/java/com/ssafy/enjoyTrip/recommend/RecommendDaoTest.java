package com.ssafy.enjoyTrip.recommend;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ssafy.enjoyTrip.recommend.dto.RecommendDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.recommend.dao.RecommendDao;

@SpringBootTest
public class RecommendDaoTest {
    @Autowired
    RecommendDao dao;

    @Test
    @DisplayName("DAO DI")
    public void DiTest(){
        assertNotNull(dao);
    }

    @Test
    @DisplayName("사용자 주소 정보 기반 여행지 추천")
    public void RecommendByUserAddr(){
        List<RecommendDto> dtoList  = dao.recommendWithAddr(4);
        System.out.println(dtoList);
        assertNotNull(dtoList
        );
    }

    @Test
    @DisplayName("사용자 즐겨찾기 타입 기반 여행지 추천")
    public void RecommendUserFavoriteType(){
        List<RecommendDto> dtoList = dao.recommendByType(4);
        assertNotNull(dtoList);
    }

    @Test
    @DisplayName("사용자 즐겨찾기 주소 기반 여행지 추천")
    public void RecommendUserFavoriteAddr(){
        List<RecommendDto> dtoList = dao.recommendFavoriteAddr(4);
        assertNotNull(dtoList);
    }

    @Test
    @DisplayName("전체 즐겨찾기 기반 여행지 추천")
    public void RecommendFavorite(){
        List<RecommendDto> dtoList = dao.recommendPopular();
        assertNotNull(dtoList);
    }

}
