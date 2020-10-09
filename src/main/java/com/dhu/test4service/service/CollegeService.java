package com.dhu.test4service.service;

import com.alibaba.fastjson.JSONArray;
import com.dhu.test4service.pojo.College;
import com.dhu.test4service.pojo.CollegeCourse;

import java.util.List;

public interface CollegeService {

    List<CollegeCourse> findAll();

    College findByName(String name);

    JSONArray findAllFormat();

    JSONArray getAllCollegeDetail();
}
