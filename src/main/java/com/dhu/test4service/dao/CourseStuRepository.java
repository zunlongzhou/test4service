package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.CourseStu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseStuRepository extends JpaRepository<CourseStu,Integer> {

    List<CourseStu> findAll();

    List<CourseStu> findByCourseId(int courseID);

    List<CourseStu> findByStuId(int stuID);

    CourseStu save(CourseStu courseStu);
}
