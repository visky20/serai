package com.org.serai.order.restadvice;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            log.info("User '{}'' attempted to access the protected URL: {}",
                    auth.getName(), httpServletRequest.getRequestURI());
        }

        // httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + HttpStatus.FORBIDDEN);

        HttpStatus httpStatus = HttpStatus.FORBIDDEN;

        Map<String, Object> data = new HashMap<>();
        data.put("timestamp", new Date());
        data.put("code", httpStatus.value());
        data.put("status", httpStatus.name());
        data.put("message", accessDeniedException.getMessage());

        // setting the response HTTP status code
        httpServletResponse.setStatus(httpStatus.value());

        // serializing the response body in JSON
        httpServletResponse.getOutputStream().println(objectMapper.writeValueAsString(data));

    }
}