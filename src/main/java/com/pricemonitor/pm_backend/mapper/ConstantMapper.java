package com.pricemonitor.pm_backend.mapper;

import com.pricemonitor.pm_backend.bean.pojo.Constant;
import com.pricemonitor.pm_backend.bean.pojo.ConstantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConstantMapper {
    int countByExample(ConstantExample example);

    int deleteByExample(ConstantExample example);

    int insert(Constant record);

    int insertSelective(Constant record);

    List<Constant> selectByExample(ConstantExample example);

    int updateByExampleSelective(@Param("record") Constant record, @Param("example") ConstantExample example);

    int updateByExample(@Param("record") Constant record, @Param("example") ConstantExample example);
}