package com.ssafy.enjoyTrip.notice;

import com.ssafy.enjoyTrip.notice.dao.NoticeDao;
import com.ssafy.enjoyTrip.notice.dto.NoticeDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class NoticeTest {
    NoticeDto dto= new NoticeDto();
    @Autowired
    private NoticeDao noticeDao;

    @Test
    @DisplayName("noticeDao di test")
    public void testDI(){
        assertNotNull(noticeDao);
    }

    @Test
    @DisplayName("noticeList dao test")
    public void noticeList(){
        List<NoticeDto> list =noticeDao.noticeList(10,0);
        System.out.println(list);
        assertEquals(list.size(), 10);
    }

    @Test
    @DisplayName("noticeListWithUserName dao test")
    public void noticeListByUserName(){
        List<NoticeDto> list =noticeDao.noticeListByUserName("관리자1",10,0);
        System.out.println(list);
        assertEquals(list.size(), 10);
    }

    @Test
    @DisplayName("noticeListWithUserId dao test")
    public void noticeListWithNoticeID(){
        List<NoticeDto> list =noticeDao.noticeListByNoticeId("23",10,0);
        System.out.println(list);
        assertEquals(list.size(), 1);
    }


    @Test
    @DisplayName("noticeInsert dao test")
    @Transactional
    public void noticeInsert(){
        dto.setUserId(4);
        dto.setTitle("test");
        dto.setContent("test");

        int result =noticeDao.noticeInsert(dto);
        assertEquals(result,1);
    }

    @Test
    @DisplayName("noticeUpdate dao test")
    @Transactional
    public void noticeUpdate(){
        dto.setNoticeId(1);
        dto.setTitle("test2");
        dto.setContent("test2");

        int result = noticeDao.noticeUpdate(dto);
        assertEquals(result,1);
    }

    @Test
    @DisplayName("noticeDelete dao test")
    @Transactional
    public void noticeDelete(){
        int result = noticeDao.noticeDelete(32);
        assertEquals(result,1);
    }

    @Test
    @DisplayName("noticeDetail dao test")
    @Transactional
    public void noticeDetail(){
        int noticeId= 30;
        NoticeDto dto = noticeDao.noticeDetail(noticeId);
        System.out.println(dto);
        assertNotNull(dto);
    }

    @Test
    @DisplayName("noticeListTotalCnt dao test")
    public void noticeListTotalCnt(){
        int result= noticeDao.noticeListTotalCnt();
        System.out.println(result);
        assertEquals(result,31);
    }

    @Test
    @DisplayName("검색어에 대한 전체 리스트 개수  dao test")
    public void noticeListSearchWordTotalCntTest(){
        String searchWord = "test";
        int result = noticeDao.noticeListSearchWordTotalCnt(searchWord);
        System.out.println(result);
        assertEquals(result,2);
    }

    @Test
    @DisplayName("검색어에 대한 공지사항 리스트 dao test")
    public void noticeListSearchWord(){
        String searchWord = "test";
        List<NoticeDto> list = noticeDao.noticeListSearchWord(searchWord,5,0);
        System.out.println(list);
        assertEquals(list.size(),2);
    }

}
