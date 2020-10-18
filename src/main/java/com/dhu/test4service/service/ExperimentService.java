package com.dhu.test4service.service;

import com.dhu.test4service.pojo.CourseExperiment;

public interface ExperimentService {
    CourseExperiment addExperiment(int courseid, int exid, String experiment,String intro,String video,String action);
}
