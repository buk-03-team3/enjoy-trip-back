package com.ssafy.enjoyTrip.common.filter;

import com.ssafy.enjoyTrip.SessionConst;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {
    private static final String[] whiteList = {"/", "/users", "/auth/login", "/auth/logout", "/error",
            "/css/*", "/ico.*", "/ping",
            "/swagger-ui.html", "/swagger-ui/*" ,"/swagger/*", "/v3/*",
            "/trip/*", "/travel/*"};
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            if(isLoginCheckPath(requestURI)) {
                HttpSession session = httpRequest.getSession(false);
                if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null){
                    // 로그인으로 redirect 나중에 바뀔 수 있음
                    httpResponse.sendRedirect("/login?redirectURL=" + requestURI);
                    return; // 여기가 중요, 미인증 사용자는 다음으로 진행하지 않고 끝
                }
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e; // 예외 로깅 가능 하지만, 톰캣까지 예외를 보내주어야 함
        }
    }

    private boolean isLoginCheckPath(String requestURI){
        return !PatternMatchUtils.simpleMatch(whiteList, requestURI);
    }

}
