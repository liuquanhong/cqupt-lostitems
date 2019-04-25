package com.nmid.items.service.Imp;

import com.nmid.items.mapper.FindCustomMapper;
import com.nmid.items.mapper.LostCustomMapper;
import com.nmid.items.other.StringEmptyUtils;
import com.nmid.items.po.*;
import com.nmid.items.service.ItemsService;
import com.nmid.items.service.UserException.ItemsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImp implements ItemsService {

    @Autowired
    private LostCustomMapper lostCustomMapper;

    @Autowired
    private FindCustomMapper findCustomMapper;

    /**********************************************************************************************************
     *
     * @param species
     * @return 返回最新的每种种类的失物及其失主信息
     * @description 按种类查询最新失物及其失主信息
     */
    @Override
    public List<Lost> selectLostBySpeciesOrderByTime(String species) {
        /*
            重点校验物品种类信息：species
         */
        if(!StringEmptyUtils.ValidStringEmpty(species))
            throw new ItemsException("物品种类信息为空");

        //查询失物及其失主信息
        List<Lost> lostList = lostCustomMapper.selectLostBySpeciesOrdrByTime(species);
        //该种类失物为空
        if(lostList == null)
            throw new ItemsException("该种类失物为空");
        return lostList;
    }


    @Override
    public User selectLostItemsWithLostUserByItemsId(Integer id) {
        if(id == null)
            throw new ItemsException("失物主键为空");
        User user = lostCustomMapper.selectLostItemsWithLostUserByItemsId(id);
        return user;
    }

    /**********************************************************************************************************
     *
     * @return 返回最新拾物及其拾主用户信息
     * @description 查询最新拾物及其拾主用户信息
     */
    @Override
    public List<Find> selectFindOrderByTime() {
        //查询最新拾物用户信息
        List<Find> findList = findCustomMapper.selectFindItemsOrderByTime();

        //当前没有拾物信息
        if(findList == null)
            throw new ItemsException("没有拾得物品信息");
        return findList;
    }

    /***********************************************************************************************************
     *
     * @param id
     * @return 拾得物品对应的拾主信息
     */
    @Override
    public User selectFindItemsWithFindUserByItemsId(Integer id) {
        if(id == null)
            throw new ItemsException("拾得物品主键为空");
        User user = findCustomMapper.selectFindItemsWithFindUserByItemsId(id);
        return user;
    }

    /**********************************************************************************************************
     *
     * @return 返回最新失物及其失主信息
     * @description 查询最新失物
     */
    @Override
    public List<Lost> selectLostOrderByTime() {
        //查询最新失物及其失主信息
        List<Lost> lostList = lostCustomMapper.selectLostOrderByTime();
        //当前数据库没有失物信息
        if(lostList == null)
            throw new ItemsException("没有失物信息");
        return lostList;
    }

    /**********************************************************************************************************
     *
     * @param address
     * @return
     */
    @Override
    public List<Lost> selectLostByAddressOrderByTime(String address) {
        if(!StringEmptyUtils.ValidStringEmpty(address))
            throw new ItemsException("请选择物品丢失地点");
        List<Lost> lostList = lostCustomMapper.selectLostByAddressOrderByTime(address);
        if(lostList == null && lostList.size()== 0){
            throw new ItemsException("当前数据库没有该地点失物数据");
        }
        return lostList;
    }

    @Override
    public List<Lost> selectLostByNumOrderByTime(){
        List<Lost> lostList = lostCustomMapper.selectLostByNumOrderByTime();
        return lostList;
    }

    @Override
    public void updateLostItemsStatus(Integer id) {
        if(id == null)
            throw new ItemsException("修改物品主键为空");
        lostCustomMapper.updateLostItemsStatus(id);
    }

    @Override
    public void updateFindItemsStatus(Integer id) {
        if(id == null)
            throw new ItemsException("修改物品主键为空");
        findCustomMapper.updateFindItemsStatus(id);
    }
}
