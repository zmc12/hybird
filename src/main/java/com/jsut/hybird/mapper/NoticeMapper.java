package com.jsut.hybird.mapper;

import com.jsut.hybird.pojo.Notice;
import com.jsut.hybird.pojo.Sign;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/3 15:08
 */

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    public void updateY(Integer id);

    public List<Notice> selectNoNotice(String name);
}
