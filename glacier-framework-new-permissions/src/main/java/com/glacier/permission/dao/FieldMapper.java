package com.glacier.permission.dao;

import com.glacier.permission.entity.Field;
import com.glacier.permission.entity.FieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FieldMapper {
    int countByExample(FieldExample example);

    int deleteByExample(FieldExample example);

    int deleteByPrimaryKey(String fieldId);

    int insert(Field record);

    int insertSelective(Field record);

    List<Field> selectByExample(FieldExample example);

    Field selectByPrimaryKey(String fieldId);

    int updateByExampleSelective(@Param("record") Field record, @Param("example") FieldExample example);

    int updateByExample(@Param("record") Field record, @Param("example") FieldExample example);

    int updateByPrimaryKeySelective(Field record);

    int updateByPrimaryKey(Field record);
}