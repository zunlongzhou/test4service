package com.dhu.test4service.controller;

import com.alibaba.fastjson.JSONArray;
import com.dhu.test4service.pojo.CourseExperiment;
import com.dhu.test4service.service.ExperimentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "实验的操作")
@CrossOrigin
@RestController
@RequestMapping("/ex")
public class CourseExController {
    @Autowired
    private ExperimentService experimentService;

    @ApiOperation("新增实验")
    @GetMapping(value = "addEx")
    public CourseExperiment findAllFormat(@RequestParam("courseid")int courseid, @RequestParam("exid")int exid, @RequestParam("experiment")String experiment){
        return experimentService.addExperiment(courseid,exid,experiment);
    }
}
