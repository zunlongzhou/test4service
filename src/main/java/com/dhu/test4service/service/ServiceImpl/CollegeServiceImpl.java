package com.dhu.test4service.service.ServiceImpl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dhu.test4service.dao.*;
import com.dhu.test4service.pojo.*;
import com.dhu.test4service.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CourseExRepository courseExRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private userRepository usRepo;

    @Override
    public JSONArray getAllCollegeDetail(){
        JSONArray res=new JSONArray();
        List<College> colleges=collegeRepository.findAll();

        for(College co:colleges){
            JSONObject collegeDetail=new JSONObject();
            collegeDetail.put("id",co.getId());
            collegeDetail.put("name",co.getName());
            collegeDetail.put("tel",co.getTel());
            collegeDetail.put("address",co.getAddress());
            collegeDetail.put("introduction",co.getIntroduction());

            List<Course> cc= courseRepository.findByCollegeId(co.getId());
            JSONArray courses=new JSONArray();
            for(Course temp:cc){
                JSONObject op=new JSONObject();
                op.put("id",temp.getId());
                op.put("name",temp.getName());
                op.put("time",temp.getTime());
                op.put("teacher",temp.getTeaName());

                courses.add(op);
            }
            collegeDetail.put("course",courses);
            res.add(collegeDetail);
        }

        return res;
    }

    @Override
    public List<CourseExperiment> findAll(){
        return courseExRepository.findAll();
    }

    @Override
    public College findByName(String name) {
        return collegeRepository.findByName(name);
    }


    @Override
    public JSONArray findAllFormat(){
        JSONArray res = new JSONArray();
        List<College> college= collegeRepository.findAll();
        //遍历学院
        for(College college_id:college){
            JSONObject jsonObject=new JSONObject();
            //放学院信息
            jsonObject.put("id",college_id.getId());
            jsonObject.put("label",college_id.getName());
            List<Course> courseList= courseRepository.findByCollegeId(college_id.getId());

            //遍历该学院的所有课程
            JSONArray res_child=new JSONArray();
            for(Course course:courseList){
                JSONObject cc=new JSONObject();
                int course_id=course.getId();
                cc.put("id",course_id);
                cc.put("label",course.getName());
                List<CourseExperiment> ex_list= courseExRepository.findByCourseId(course.getId());
                JSONArray course_child=new JSONArray();
                //遍历该学院的所有课程的所有实验
                for(CourseExperiment ex:ex_list){
                    JSONObject ex_obj=new JSONObject();
                    ex_obj.put("id",ex.getExperimentId());
                    ex_obj.put("label",ex.getExperimentName());
                    course_child.add(ex_obj);
                }
                cc.put("children",course_child);

                res_child.add(cc);
            }
            jsonObject.put("children",res_child);

            res.add(jsonObject);
        }
        return res;
    }
}
