package com.rjq.service;

import com.rjq.mapper.TestMapper;
import com.rjq.pojo.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

public class TestService {
    @Resource
    private TestMapper testMapper;


    public Object getPojo(String Id){
        Test object = (Test) testMapper.getObject(Id);
        return object;
    }
}
