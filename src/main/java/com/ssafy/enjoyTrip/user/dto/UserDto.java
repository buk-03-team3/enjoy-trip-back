package com.ssafy.enjoyTrip.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
	private int uuid;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userProfileImageUrl;
    private int sido;
    private int gugun;
}
