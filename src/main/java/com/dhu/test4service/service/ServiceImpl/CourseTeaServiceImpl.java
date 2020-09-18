package com.dhu.test4service.service.ServiceImpl;

import com.dhu.test4service.dao.CourseTeacherRepository;
import com.dhu.test4service.pojo.CourseTea;
import com.dhu.test4service.service.CourseService;
import com.dhu.test4service.service.CourseTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTeaServiceImpl implements CourseTeaService {
    @Autowired
    private CourseTeacherRepository courseTeaRepo;

    @Override
    public List<CourseTea> findAll(){
        return courseTeaRepo.findAll();
    }

    @Override
    public List<CourseTea> findByCourseId(int courID){
        return courseTeaRepo.findByCourseId(courID);
    }

    @Override
    public List<CourseTea> findByTeaId(int teaID){
        return courseTeaRepo.findByTeaId(teaID);
    }

}
