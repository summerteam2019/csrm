/**
 * 选课模块服务层实体类
 *
 * @author zengjiajin
 * @version 1.0
 * @date 2019/07/05
 */
package com.kb.csrm.scConnection.service.impl;

import com.kb.csrm.course.dto.CourseDto;
import com.kb.csrm.course.mapper.CourseMapper;
import com.kb.csrm.scConnection.dto.SCConnectionDto;
import com.kb.csrm.scConnection.mapper.SCConnectionMapper;
import com.kb.csrm.scConnection.service.ISCConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCConnectionServiceImpl implements ISCConnectionService {

    @Autowired
    private SCConnectionMapper scConnectionMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDto> getSCConnectionByUserId(int userId){
        return courseMapper.getCourseByUserId(userId);
    }

    @Override
    public List<SCConnectionDto> getSCConnectionByCourseId(int courseId){
        return scConnectionMapper.getSCConnectionByCourseId(courseId);
    }

    @Override
    public void addSCConnection(SCConnectionDto scConnectionDto){
        scConnectionMapper.addSCConnection(scConnectionDto);
    }

    @Override
    public void deleteSCConnection(SCConnectionDto scConnectionDto){
        scConnectionMapper.deleteSCConnection(scConnectionDto);
    }

    @Override
    public int ifChoose(long userId, long courseId) {
        return scConnectionMapper.ifChosen(userId, courseId);
    }
}
