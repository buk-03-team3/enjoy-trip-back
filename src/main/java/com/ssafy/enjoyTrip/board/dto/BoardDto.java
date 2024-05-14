package com.ssafy.enjoyTrip.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
    private int boardId;
    private int userSeq;
    private String userName;
    private String userProfileImageUrl;
    private String title;
    private String content;
    private LocalDateTime regDt;
    private int readCount;
    
    private boolean sameUser;
}