package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.CourseStu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseStuRepository extends JpaRepository<CourseStu,Integer> {

    List<CourseStu> findAll();

    List<CourseStu> findByCourseId(int courseID);

    List<CourseStu> findByStuId(int stuID);

    CourseStu save(CourseStu courseStu);

    @Transactional
    @Modifying
    @Query(value = "delete from course_stu where courseID=?1 and StuID=?2",nativeQuery = true)
    Integer deleteCourseStu(int courseID,int StuID);
}
