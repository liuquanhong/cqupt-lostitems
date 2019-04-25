package com.nmid.items.mapper;

import com.nmid.items.po.*;

import java.util.List;

public interface LostCustomMapper {
    //查询丢失物品及拾得用户
    public FindCustom selectLostItemsWithFindUser(Lost lost);

    //保存丢失的物品
    public void insertLostItems(Lost lost);

    //依据种类查询丢失物品（分类）
    public List<Lost> selectLostBySpeciesOrdrByTime(String species);
    //失物图片进去后查看用户具体信息
    public User selectLostItemsWithLostUserByItemsId(Integer id);

    //按地点查询最新失物
    public List<Lost> selectLostByAddressOrderByTime(String address);

    //最新失物信息（最新）
    public List<Lost> selectLostOrderByTime();

    //查询按时间排序的最新的前三条记录
    public List<Lost> selectLostByNumOrderByTime();

    //查询用户个人未目前未找回的历史记录
    public List<Lost> selectLostItems(String stdnumber);

    //查询用户个人失物找回和拾得物品成功归还的历史记录
    public List<UserCustomVo> selectLostItemsAndFindItemsSucess(Integer id);

    //修改当前用户成功找回失物的状态
    public void updateLostItemsStatus(Integer id);

}
