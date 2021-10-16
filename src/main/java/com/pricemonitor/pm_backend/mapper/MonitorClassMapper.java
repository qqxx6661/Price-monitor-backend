package com.pricemonitor.pm_backend.mapper;

import com.pricemonitor.pm_backend.bean.pojo.MonitorClass;
import com.pricemonitor.pm_backend.bean.pojo.MonitorClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorClassMapper {
    int countByExample(MonitorClassExample example);

    int deleteByExample(MonitorClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonitorClass record);

    int insertSelective(MonitorClass record);

    List<MonitorClass> selectByExample(MonitorClassExample example);

    MonitorClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonitorClass record, @Param("example") MonitorClassExample example);

    int updateByExample(@Param("record") MonitorClass record, @Param("example") MonitorClassExample example);

    int updateByPrimaryKeySelective(MonitorClass record);

    int updateByPrimaryKey(MonitorClass record);
}