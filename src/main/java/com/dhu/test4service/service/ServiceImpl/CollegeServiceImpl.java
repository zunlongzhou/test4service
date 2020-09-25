package com.dhu.test4service.service.ServiceImpl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dhu.test4service.dao.CollegeCourseRepository;
import com.dhu.test4service.dao.CourseRepository;
import com.dhu.test4service.pojo.CollegeCourse;
import com.dhu.test4service.pojo.Course;
import com.dhu.test4service.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeCourseRepository collegeCourseRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CollegeCourse> findAll(){
        return collegeCourseRepository.findAll();
    }

    @Override
    public JSONArray findAllFormat(){
        JSONArray res = new JSONArray();
        List<CollegeCourse> collegeCourses=collegeCourseRepository.findAll();
        Set<Integer> college=new HashSet<Integer>();
        //用 set 存所有学院的信息,这里用到的两个set都是为了去重
        for(CollegeCourse c:collegeCourses){
            college.add(c.getCollegeId());
        }
        //遍历学院
        for(Integer college_id:college){
            JSONObject jsonObject=new JSONObject();
            //放学院信息
            jsonObject.put("id",college_id);
            List<CollegeCourse> courseList=collegeCourseRepository.findByCollegeId(college_id);
            jsonObject.put("label",courseList.get(0).getCollegeName());

            //遍历该学院的所有课程
            JSONArray res_child=new JSONArray();
            Set<Integer> hs_course=new HashSet<>();
            for(CollegeCourse course:courseList){
                if(!hs_course.add(course.getCourseId())){
                    continue;
                }
                JSONObject cc=new JSONObject();
                int course_id=course.getCourseId();
                cc.put("id",course_id);
                Course someOne=courseRepository.findById(course_id);
                cc.put("label",someOne.getName());
                List<CollegeCourse> ex_list=collegeCourseRepository.findByCollegeIdAndCourseId(college_id,course_id);
                JSONArray course_child=new JSONArray();
                //遍历该学院的所有课程的所有实验
                for(CollegeCourse ex:ex_list){
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
