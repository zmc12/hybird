package com.jsut.hybird.service.serviceImpl;

import com.jsut.hybird.mapper.KnowMapper;
import com.jsut.hybird.mapper.NoticeMapper;
import com.jsut.hybird.mapper.StudentMapper;
import com.jsut.hybird.pojo.Know;
import com.jsut.hybird.pojo.Notice;
import com.jsut.hybird.pojo.Sign;
import com.jsut.hybird.pojo.Student;
import com.jsut.hybird.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 15:10
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private KnowMapper knowMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Notice> selectAll() {

        return noticeMapper.selectAll();
    }

    @Override
    public Notice selectById(Integer id) {
        return noticeMapper.selectById(id);
    }

    @Override
    public List<Notice> deleteById(Integer id) {
        noticeMapper.deleteById(id);
        return noticeMapper.selectAll();
    }

    @Override
    public List<Notice> updateById(Notice notice) {
        noticeMapper.updateById(notice);
        knowMapper.deleteById(notice.getId());
        List<Student> students = studentMapper.selectByGrade(notice.getGrade());
        for(int j=0;j<students.size();j++){
            knowMapper.insert(new Know(notice.getId(),students.get(j).getName(),"未确认"));
        }
        return noticeMapper.selectAll();
    }

    @Override
    public List<Notice> insertT(Notice notice) {
        noticeMapper.insertT(notice);
        return noticeMapper.selectAll();
    }

    @Override
    public void updateY(Integer id) {
        noticeMapper.updateY(id);
    }

    @Override
    public List<Notice> selectNoNotice(String name) {
        return noticeMapper.selectNoNotice(name);
    }

}
