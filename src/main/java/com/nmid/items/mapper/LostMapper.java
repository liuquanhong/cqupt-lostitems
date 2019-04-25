package com.nmid.items.mapper;

import com.nmid.items.po.Lost;
import com.nmid.items.po.LostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LostMapper {
    long countByExample(LostExample example);

    int deleteByExample(LostExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(Lost record);

    int insertSelective(Lost record);

    List<Lost> selectByExample(LostExample example);

    Lost selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") Lost record, @Param("example") LostExample example);

    int updateByExample(@Param("record") Lost record, @Param("example") LostExample example);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);
}