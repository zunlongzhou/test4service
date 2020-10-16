package com.dhu.test4service.service.ServiceImpl;

import com.dhu.test4service.dao.CourseExRepository;
import com.dhu.test4service.dao.CourseRepository;
import com.dhu.test4service.pojo.CourseExperiment;
import com.dhu.test4service.pojo.Course;
import com.dhu.test4service.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseExRepository courseExRepository;
    @Override
    public CourseExperiment addExperiment(int courseid, int exid, String experiment){
        Course course=courseRepository.findById(courseid);
        CourseExperiment collegeCourse=new CourseExperiment();
        if(course==null){
            return collegeCourse;
        }
        collegeCourse.setCollegeId(course.getCollegeId());
        collegeCourse.setCollegeName(course.getCollegeName());
        collegeCourse.setCourseId(courseid);
        collegeCourse.setExperimentId(exid);
        collegeCourse.setExperimentName(experiment);
        return courseExRepository.save(collegeCourse);
    }
}
