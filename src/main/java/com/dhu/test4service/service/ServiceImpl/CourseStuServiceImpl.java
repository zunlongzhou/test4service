package com.dhu.test4service.service.ServiceImpl;

import com.dhu.test4service.dao.CourseStuRepository;
import com.dhu.test4service.pojo.CourseStu;
import com.dhu.test4service.service.CourseStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseStuServiceImpl implements CourseStuService {
    @Autowired
    private CourseStuRepository courseStuRepo;

    @Override
    public List<CourseStu> findAll(){
        return courseStuRepo.findAll();
    }

    @Override
    public List<CourseStu> findByCourseId(int courseID){
        return courseStuRepo.findByCourseId(courseID);
    }

    @Override
    public List<CourseStu> findByStuId(int stuID){
        return courseStuRepo.findByStuId(stuID);
    }

    @Override
    public CourseStu save(CourseStu courseStu){
        return courseStuRepo.save(courseStu);
    }

    @Override
    public Integer deleteCS(int courseID,int StuID){
        return courseStuRepo.deleteCourseStu(courseID,StuID);
    }
}
