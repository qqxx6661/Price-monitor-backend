package com.pricemonitor.pm_backend.mapper;

import com.pricemonitor.pm_backend.bean.pojo.ClassTop;
import com.pricemonitor.pm_backend.bean.pojo.ClassTopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassTopMapper {
    int countByExample(ClassTopExample example);

    int deleteByExample(ClassTopExample example);

    int insert(ClassTop record);

    int insertSelective(ClassTop record);

    List<ClassTop> selectByExample(ClassTopExample example);

    int updateByExampleSelective(@Param("record") ClassTop record, @Param("example") ClassTopExample example);

    int updateByExample(@Param("record") ClassTop record, @Param("example") ClassTopExample example);
}