package com.pricemonitor.pm_backend.mapper;

import com.pricemonitor.pm_backend.bean.pojo.JdItemHistory;
import com.pricemonitor.pm_backend.bean.pojo.JdItemHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JdItemHistoryMapper {
    int countByExample(JdItemHistoryExample example);

    int deleteByExample(JdItemHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JdItemHistory record);

    int insertSelective(JdItemHistory record);

    List<JdItemHistory> selectByExample(JdItemHistoryExample example);

    JdItemHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JdItemHistory record, @Param("example") JdItemHistoryExample example);

    int updateByExample(@Param("record") JdItemHistory record, @Param("example") JdItemHistoryExample example);

    int updateByPrimaryKeySelective(JdItemHistory record);

    int updateByPrimaryKey(JdItemHistory record);
}