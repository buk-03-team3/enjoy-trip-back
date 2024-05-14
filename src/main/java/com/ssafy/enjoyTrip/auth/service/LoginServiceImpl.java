package com.ssafy.enjoyTrip.auth.service;

import org.springframework.stereotype.Service;

import com.ssafy.enjoyTrip.auth.dao.LoginDao;
import com.ssafy.enjoyTrip.auth.dto.LoginDto;
import com.ssafy.enjoyTrip.auth.dto.LoginResultDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
	
	private final LoginDao loginDao;
	
	@Override
	public LoginResultDto login(LoginDto dto) {
		LoginDto userDto = loginDao.login(dto.getEmail());
		LoginResultDto lrdto = new LoginResultDto();
        
		if( userDto != null && userDto.getPassword().equals(dto.getPassword())) {
            // password null setting
            userDto.setPassword(null);
        	lrdto.setLoginDto(userDto);
        	lrdto.setMessage("정상 로그인");
        	lrdto.setResult("success");
            return lrdto;
        }else if(userDto==null) {
        	lrdto.setMessage("잘못된 아이디 또는 존재하지 않는 아이디");
        	lrdto.setResult("fail");
        	return lrdto;
        }else if(userDto!=null && !dto.getPassword().equals(userDto.getPassword())){
        	lrdto.setMessage("잘못된 비밀번호");
        	lrdto.setResult("fail");
        	return lrdto;
        }
		lrdto.setMessage("알 수 없는 에러");
		lrdto.setResult("fail");
		return lrdto;
	}
}
