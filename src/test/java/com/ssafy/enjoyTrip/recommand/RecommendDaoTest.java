package com.ssafy.enjoyTrip.recommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ssafy.enjoyTrip.recommand.dto.RecommandDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.recommand.dao.RecommandDao;

@SpringBootTest
public class RecommendDaoTest {
    @Autowired
    RecommandDao dao;

    @Test
    @DisplayName("DAO DI")
    public void DiTest(){
        assertNotNull(dao);
    }

    @Test
    @DisplayName("사용자 주소 정보 기반 여행지 추천")
    public void RecommendByUserAddr(){
        List<RecommandDto> dtoList  = dao.recommandWithAddr(4);
        System.out.println(dtoList);
        assertNotNull(dtoList
        );
    }

    @Test
    @DisplayName("사용자 즐겨찾기 타입 기반 여행지 추천")
    public void RecommendUserFavoriteType(){
        List<RecommandDto> dtoList = dao.recommandByType(4);
        assertNotNull(dtoList);
    }

    @Test
    @DisplayName("사용자 즐겨찾기 주소 기반 여행지 추천")
    public void RecommendUserFavoriteAddr(){
        List<RecommandDto> dtoList = dao.recommendFavoriteAddr(4);
        assertNotNull(dtoList);
    }

    @Test
    @DisplayName("전체 즐겨찾기 기반 여행지 추천")
    public void RecommendFavorite(){
        List<RecommandDto> dtoList = dao.recommandPopular();
        assertNotNull(dtoList);
    }

}
