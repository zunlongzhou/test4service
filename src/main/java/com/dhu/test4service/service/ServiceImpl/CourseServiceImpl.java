package com.dhu.test4service.service.ServiceImpl;


import com.dhu.test4service.dao.CourseRepository;
import com.dhu.test4service.dao.CourseStuRepository;
import com.dhu.test4service.dao.CourseTeacherRepository;
import com.dhu.test4service.dao.userRepository;
import com.dhu.test4service.pojo.Course;
import com.dhu.test4service.pojo.CourseStu;
import com.dhu.test4service.pojo.CourseTea;
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
    private CourseTeacherRepository courseTeaRepo;
    @Autowired
    private CourseStuRepository courseStuRepo;

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id){
        return courseRepository.findById(id);
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

            jsonObject.put("teacher",findCourseTea(c.getId()));

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

    /*
    找到该课程的老师信息，因为可能会有多个老师，所以需要的信息分散到三个表，略显复杂
    //把该课程的老师信息找出来，先用课程-教师表找到ID，再用ID去User表里找
     */
    public List<User> findCourseTea(int id){
        List<CourseTea> list1=courseTeaRepo.findByCourseId(id);
        List<User> Teacher=new ArrayList<>();
        for(CourseTea ct:list1){
            int TeaID=ct.getTeaId();
            User TeaInfo=userRepo.findById(TeaID);
            Teacher.add(TeaInfo);
        }
        return Teacher;
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
            course.put("id",c.getId());
            course.put("name",c.getName());
            course.put("time",c.getTime());

            List<CourseTea> ct= courseTeaRepo.findByCourseId(courseID);
            String teacherName="";
            if(ct.size()>0){
                int teacherID=ct.get(0).getTeaId();
                teacherName=userRepo.findById(teacherID).getName();
            }
            course.put("teacher",teacherName);
            res.add(course);
        }

        return res;
    }
}
