package com.pricemonitor.pm_backend.mapper;

import com.pricemonitor.pm_backend.bean.pojo.MonitorItem;
import com.pricemonitor.pm_backend.bean.pojo.MonitorItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorItemMapper {
    int countByExample(MonitorItemExample example);

    int deleteByExample(MonitorItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonitorItem record);

    int insertSelective(MonitorItem record);

    List<MonitorItem> selectByExample(MonitorItemExample example);

    MonitorItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonitorItem record, @Param("example") MonitorItemExample example);

    int updateByExample(@Param("record") MonitorItem record, @Param("example") MonitorItemExample example);

    int updateByPrimaryKeySelective(MonitorItem record);

    int updateByPrimaryKey(MonitorItem record);
}