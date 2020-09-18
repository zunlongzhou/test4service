package com.dhu.test4service.controller;


import com.alibaba.fastjson.JSONArray;
import com.dhu.test4service.pojo.CourseStu;
import com.dhu.test4service.service.CourseStuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "课程-学生关系的相关操作")
@CrossOrigin
@RestController
@RequestMapping("/courseStu")
public class CourseStuController {
    @Autowired
    private CourseStuService courseStuService;

    @ApiOperation("学生选课，添加学生-课程关系")
    @GetMapping(value = "/add")
    public CourseStu add(@RequestParam("courseID") int courseID,@RequestParam("StuID") int StuID){
        CourseStu courseStu=new CourseStu();
        courseStu.setCourseId(courseID);
        courseStu.setStuId(StuID);
        return courseStuService.save(courseStu);
    }
}
