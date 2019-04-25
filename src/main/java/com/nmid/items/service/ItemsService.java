package com.nmid.items.service;

import com.nmid.items.po.Find;
import com.nmid.items.po.Lost;
import com.nmid.items.po.User;

import java.util.List;

public interface ItemsService {
    //依据种类查询失物(分类)
    public List<Lost> selectLostBySpeciesOrderByTime(String species);
    //查看对应失物的失主信息
    public User selectLostItemsWithLostUserByItemsId(Integer id);

    //最新拾得物品信息(最新)
    public List<Find> selectFindOrderByTime();
    //查看拾得物品对应的拾主信息
    public User selectFindItemsWithFindUserByItemsId(Integer id);

    //最新丢失物品信息(最新)
    public List<Lost> selectLostOrderByTime();

    public List<Lost> selectLostByAddressOrderByTime(String address);

    public List<Lost> selectLostByNumOrderByTime();

    //修改丢失物成功找回的状态信息
    public void updateLostItemsStatus(Integer id);

    //被归还物品的状态信息
    public void updateFindItemsStatus(Integer id);

}
