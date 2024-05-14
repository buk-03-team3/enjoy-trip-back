package com.ssafy.enjoyTrip.auth.dto;

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
public class LoginDto {
	private int uuid;
    private String name;
    private String password;
    private String email;
    private String userProfileImageUrl;
    private int sido;
    private int gugun;
}
