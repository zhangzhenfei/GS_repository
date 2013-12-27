package com.glacier.permission.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.glacier.permission.entity.Authority;
import com.glacier.permission.entity.AuthorityExample;
import com.glacier.permission.entity.AuthorityKey;

public interface AuthorityMapper {
    int countByExample(AuthorityExample example);

    int deleteByExample(AuthorityExample example);

    int deleteByPrimaryKey(AuthorityKey key);

    int insert(Authority record);

    int insertSelective(Authority record);

    List<Authority> selectByExample(AuthorityExample example);

    Authority selectByPrimaryKey(AuthorityKey key);

    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    List<Authority> selectByUserId(String userId);
}