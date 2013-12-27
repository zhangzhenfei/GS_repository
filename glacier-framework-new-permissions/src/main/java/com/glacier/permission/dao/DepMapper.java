package com.glacier.permission.dao;

import com.glacier.permission.entity.Dep;
import com.glacier.permission.entity.DepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepMapper {
    int countByExample(DepExample example);

    int deleteByExample(DepExample example);

    int deleteByPrimaryKey(String depId);

    int insert(Dep record);

    int insertSelective(Dep record);

    List<Dep> selectByExample(DepExample example);

    Dep selectByPrimaryKey(String depId);

    int updateByExampleSelective(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByExample(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);
    
    //使用存储过程遍历树结构部门(本部门以及子部门的List<String>)
    List<String> selectChildrenById(String depId);
}