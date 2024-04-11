package com.yevhenkim.communityskillshare.controller;


import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
public class CustomErrorController implements ErrorController {
/*
    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(WebRequest webRequest) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", webRequest.getAttribute("javax.servlet.error.status_code", WebRequest.SCOPE_REQUEST));
        errorDetails.put("error", webRequest.getAttribute("javax.servlet.error.error", WebRequest.SCOPE_REQUEST));
        errorDetails.put("message", webRequest.getAttribute("javax.servlet.error.message", WebRequest.SCOPE_REQUEST));
        errorDetails.put("exception", webRequest.getAttribute("javax.servlet.error.exception", WebRequest.SCOPE_REQUEST));
        errorDetails.put("requestUri", webRequest.getAttribute("javax.servlet.error.request_uri", WebRequest.SCOPE_REQUEST));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
*/
}
