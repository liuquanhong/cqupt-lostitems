package com.nmid.items.mapper;

import com.nmid.items.po.Find;
import com.nmid.items.po.LostCustom;
import com.nmid.items.po.User;

import java.util.List;

public interface FindCustomMapper {

    //查询拾得物品及丢失物品用户
    public LostCustom selectFindItemsWithLostUser(Find find);

    //最新拾得物品信息
    public List<Find> selectFindItemsOrderByTime();
    //最新拾得物品对应拾主信息
    public User selectFindItemsWithFindUserByItemsId(Integer id);

    //修改被归还物品状态
    public void updateFindItemsStatus(Integer id);
}
