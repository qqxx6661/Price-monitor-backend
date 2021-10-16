package com.pricemonitor.pm_backend.mapper;

import com.pricemonitor.pm_backend.bean.pojo.JdItem;
import com.pricemonitor.pm_backend.bean.pojo.JdItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JdItemMapper {
    int countByExample(JdItemExample example);

    int deleteByExample(JdItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JdItem record);

    int insertSelective(JdItem record);

    List<JdItem> selectByExample(JdItemExample example);

    JdItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JdItem record, @Param("example") JdItemExample example);

    int updateByExample(@Param("record") JdItem record, @Param("example") JdItemExample example);

    int updateByPrimaryKeySelective(JdItem record);

    int updateByPrimaryKey(JdItem record);
}