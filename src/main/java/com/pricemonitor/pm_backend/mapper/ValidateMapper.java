package com.pricemonitor.pm_backend.mapper;

import com.pricemonitor.pm_backend.bean.pojo.Validate;
import com.pricemonitor.pm_backend.bean.pojo.ValidateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ValidateMapper {
    int countByExample(ValidateExample example);

    int deleteByExample(ValidateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Validate record);

    int insertSelective(Validate record);

    List<Validate> selectByExample(ValidateExample example);

    Validate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Validate record, @Param("example") ValidateExample example);

    int updateByExample(@Param("record") Validate record, @Param("example") ValidateExample example);

    int updateByPrimaryKeySelective(Validate record);

    int updateByPrimaryKey(Validate record);
}