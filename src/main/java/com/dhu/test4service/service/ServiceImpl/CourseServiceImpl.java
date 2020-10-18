package com.dhu.test4service.service.ServiceImpl;


import com.dhu.test4service.dao.CourseExRepository;
import com.dhu.test4service.dao.CourseRepository;
import com.dhu.test4service.dao.CourseStuRepository;
import com.dhu.test4service.dao.userRepository;
import com.dhu.test4service.pojo.CourseExperiment;
import com.dhu.test4service.pojo.Course;
import com.dhu.test4service.pojo.CourseStu;
import com.dhu.test4service.pojo.User;
import com.dhu.test4service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private userRepository userRepo;
    @Autowired
    private CourseStuRepository courseStuRepo;
    @Autowired
    private CourseExRepository courseExRepository;


    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id){
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public JSONArray findAllCourseDetail(){
        JSONArray jsonarray = new JSONArray();
        List<Course> list=courseRepository.findAll();

        for(Course c:list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",c.getId());
            jsonObject.put("name",c.getName());
            jsonObject.put("time",c.getTime());
            jsonObject.put("introduction",c.getIntroduction());

            jsonObject.put("teacher",c.getTeaName());

            jsonarray.add(jsonObject);
        }
        return jsonarray;

    }

    @Override
    public List<User> findCourseStu(int id){
        List<CourseStu> list=courseStuRepo.findByCourseId(id);
        List<User> Students=new ArrayList<>();
        for(CourseStu c:list){
            int StuID=c.getStuId();
            Students.add(userRepo.findById(StuID));
        }
        return Students;
    }


    public User findCourseTea(int id){
        Course course=courseRepository.findById(id);
        int TeaID=course.getTeaId();
        return userRepo.findById(TeaID);
    }

    public List<Boolean> findStuCourse(int id){
        List<Course> courses=courseRepository.findAll();
        List<CourseStu> stu=courseStuRepo.findByStuId(id);

        List<Boolean> res=new ArrayList<>();
        for(Course c:courses){
            Boolean flag=false;
            for(CourseStu s:stu){
                if(s.getCourseId()==c.getId()){
                    flag=true;
                    break;
                }
            }
            res.add(flag);
        }
        return res;
    }

    public JSONArray findStuCourseDetail(int id){
        JSONArray res=new JSONArray();
        List<CourseStu> stu=courseStuRepo.findByStuId(id);
        for(CourseStu cs:stu){
            JSONObject course=new JSONObject();
            int courseID=cs.getCourseId();
            Course c=courseRepository.findById(courseID);
            List<CourseExperiment> ex=courseExRepository.findByCourseId(courseID);
            course.put("id",c.getId());
            course.put("name",c.getName());
            course.put("time",c.getTime());
            course.put("teacher",c.getTeaName());
            course.put("experiment",ex);
            res.add(course);
        }

        return res;
    }

    public JSONArray getCourseAndEx(){
        JSONArray res=new JSONArray();
        List<Course> courses=courseRepository.findAll();
        for(Course c:courses){
            JSONObject course=new JSONObject();
            int courseID=c.getId();
            List<CourseExperiment> ex=courseExRepository.findByCourseId(courseID);
            course.put("id",c.getId());
            course.put("name",c.getName());
            course.put("time",c.getTime());
            course.put("teacher",c.getTeaName());
            course.put("introduction",c.getIntroduction());
            course.put("experiment",ex);
            res.add(course);
        }
        return res;
    }

}
