package com.rjq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TestController {

    public String test(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        return "";
    }
}
