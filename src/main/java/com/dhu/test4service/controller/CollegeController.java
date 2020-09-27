package com.dhu.test4service.controller;


import com.alibaba.fastjson.JSONArray;
import com.dhu.test4service.pojo.CollegeCourse;
import com.dhu.test4service.service.CollegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "学院课程树状管理")
@CrossOrigin
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @ApiOperation("查找学院课程的所有信息")
    @GetMapping(value = "findAll")
    public List<CollegeCourse> findAll(){
        return collegeService.findAll();
    }

    @ApiOperation("按Vue的Tree控件需要的数据个数返回数据")
    @GetMapping(value = "findAllFormat")
    public JSONArray findAllFormat(){
        return collegeService.findAllFormat();
    }

    @ApiOperation("返回学院数据-包括该学院下的课程")
    @GetMapping(value = "findCollegeCourse")
    public JSONArray findCollegeCourse(){
        return collegeService.getAllCollegeDetail();
    }
}
