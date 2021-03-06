package com.dhu.test4service.controller;


import com.alibaba.fastjson.JSONArray;
import com.dhu.test4service.pojo.College;
import com.dhu.test4service.pojo.CourseExperiment;
import com.dhu.test4service.pojo.Course;
import com.dhu.test4service.pojo.User;
import com.dhu.test4service.service.CollegeService;
import com.dhu.test4service.service.CourseService;
import com.dhu.test4service.service.UserService;
import com.dhu.test4service.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Api(tags = "课程的操作")
@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation("返回所有课程信息")
    @GetMapping(value = "/all")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @ApiOperation("根据课程ID查找课程")
    @GetMapping(value = "/findbyID")
    public Course findByID(@RequestParam("id")int id){
        return courseService.findById(id);
    }

    @ApiOperation("添加课程")
    @GetMapping("/add")
    public Course add(@RequestParam("name") String name,@RequestParam("time") String time,@RequestParam("introduction") String introduction,
                      @RequestParam("teaName") String teaName,@RequestParam("collegeName") String collegeName){
        try{
            College college=collegeService.findByName(collegeName);
            Integer collegeId=college.getId();
            User user=userService.findByName(teaName);
            Integer teaId=user.getId();
            Course course=new Course(name,time,introduction,teaId,teaName,collegeId,collegeName);
            return courseService.save(course);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @ApiOperation("返回所有课程信息-包括教师信息")
    @GetMapping(value = "/getAllDetail")
    public JSONArray findAllDetail(){
        return courseService.findAllCourseDetail();
    }

    @ApiOperation("返回某节课的所有学生信息")
    @GetMapping(value = "/getCourseStu")
    public List<User> getCourseStu(@RequestParam("id")int id){
        return courseService.findCourseStu(id);
    }

    @ApiOperation("返回某个学生的所有选课信息-布尔值-用来表示是否选了该课")
    @GetMapping(value = "/getSC")
    public List<Boolean> getSC(@RequestParam("id")int id){
        return courseService.findStuCourse(id);
    }

    @ApiOperation("返回某个学生选课信息-课程详细内容")
    @GetMapping(value = "/getSCDetail")
    public JSONArray getSCDetail(@RequestParam("id")int id){
        return courseService.findStuCourseDetail(id);
    }

    @ApiOperation("返回所有课程及其实验")
    @GetMapping(value = "/getCourseAndEx")
    public JSONArray getCourseAndEx(){
        return courseService.getCourseAndEx();
    }

    @ApiOperation("Redis的测试操作")
    @GetMapping("/redis")
    public Object redisDemo(){
        List<Course> list=new ArrayList<>();
        Course course=new Course();
        course.setTime("timemmmm");
        course.setIntroduction("innnn");
        list.add(course);

        redisUtils.del("key");
        redisUtils.lSet("key",list);
        List<Object> k=redisUtils.lGet("key",0,1);
        return k;
    }
}
