package com.nmid.items.mapper;

import com.nmid.items.po.Find;
import com.nmid.items.po.FindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FindMapper {
    long countByExample(FindExample example);

    int deleteByExample(FindExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Find record);

    int insertSelective(Find record);

    List<Find> selectByExample(FindExample example);

    Find selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Find record, @Param("example") FindExample example);

    int updateByExample(@Param("record") Find record, @Param("example") FindExample example);

    int updateByPrimaryKeySelective(Find record);

    int updateByPrimaryKey(Find record);
}