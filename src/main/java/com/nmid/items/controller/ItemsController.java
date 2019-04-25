package com.nmid.items.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nmid.items.other.StringEmptyUtils;
import com.nmid.items.po.*;
import com.nmid.items.po.Json_BackMessage.JsonInfo;
import com.nmid.items.service.ItemsService;
import com.nmid.items.service.UserException.ItemsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    ItemsService itemsServiceImp;

    /***********************************************************************************
     *
     * @param species
     * @return 返回前端失物
     * @description 按种类查询失物以时间最新返回
     */
    @RequestMapping("/findLostItemsWithBySpecies")
    public JsonInfo findLostItemsWithBySpecies(String species,@RequestParam(value = "page",defaultValue = "1")
                                                       Integer currentPage,@RequestParam("pagecord")Integer pageCord){
        /*
            检查重要数据：物品种类
         */
        if(!StringEmptyUtils.ValidStringEmpty(species))
            throw new ItemsException("物品种类信息为空");

        //查询失物及其失主信息
        PageHelper.startPage(currentPage,pageCord);
        List<Lost> lostList = itemsServiceImp.selectLostBySpeciesOrderByTime(species);
        PageInfo<Lost> pageInfo = new PageInfo<Lost>(lostList);
        /*
            返回前端失物及其失主信息
         */
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.add("pageInfo",pageInfo);
        jsonInfo.setMessage("依据种类查询最新失物信息成功");
        jsonInfo.setStatus(200);
        return jsonInfo;
    }

    /**************************************************************************************************************
     *
     * @param id
     * @return 依据失物主键ID返回失物对应的具体失主信息（分类与最新失物共用）
     */
    @RequestMapping("/queryLostItemsWithLostUserByItemsId")
    public JsonInfo queryLostItemsWithLostUserByItemsId(Integer id){
        if(id == null)
            throw new ItemsException("失物主键为空");
       User user = itemsServiceImp.selectLostItemsWithLostUserByItemsId(id);
       JsonInfo jsonInfo = new JsonInfo();
       jsonInfo.setStatus(200);
       jsonInfo.setMessage("查询失物对应失主信息成功");
       jsonInfo.add("user",user);
       return jsonInfo;
    }

    /***********************************************************************************
     *
     * @return 返回前端失物
     * @description 查询失物并按时间最新返回
     */
    @RequestMapping("/findLostItems")
    public JsonInfo findLostItems(@RequestParam(value = "page",defaultValue = "1")Integer currentPage,
                                              @RequestParam("pagecord")Integer pageCord){
        PageHelper.startPage(currentPage,pageCord);
        /*
            查询失物
         */
        List<Lost> lostList = itemsServiceImp.selectLostOrderByTime();
        PageInfo<Lost> pageInfo = new PageInfo<Lost>(lostList);
        /*
            返回前端失物
         */
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("查询最新失物成功");
        jsonInfo.add("pagInfo",pageInfo);
        return jsonInfo;
    }

    /***********************************************************************************
     *
     * @return 返回拾物信息
     * @description 最新拾得物品
     */
    @RequestMapping("/queryFindItems")
    public JsonInfo queryFindItems(@RequestParam(value = "page",defaultValue = "1")
                                                           Integer currentPage, @RequestParam("pagecord")Integer pageCord){
        PageHelper.startPage(currentPage,pageCord);
        //查询及其拾物信息
        List<Find> findList = itemsServiceImp.selectFindOrderByTime();
        PageInfo<Find> pageInfo = new PageInfo<Find>(findList);
        //返回拾物信息
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setMessage("查询最新拾物信息成功");
        jsonInfo.setStatus(200);
        jsonInfo.add("pageInfo",pageInfo);
        return jsonInfo;
    }

    /**********************************************************************************************************
     *
     * @param id
     * @return 拾得物品对应拾主信息
     */
    @RequestMapping("/queryFindItemsWithFindUserByFindItemsId")
    public JsonInfo queryFindItemsWithFindUserByFindItemsId(Integer id){
        if(id == null)
            throw new ItemsException("拾得物品主键为空");
        User user = itemsServiceImp.selectFindItemsWithFindUserByItemsId(id);
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("查询拾得物品对应失主信息成功");
        jsonInfo.add("user",user);
        return jsonInfo;
    }

    /*************************************************************************************************
     *
     * @param address
     * @param currentPage
     * @param pageCord
     * @return 按地点查询最新失物信息
     */
    @RequestMapping("/queryLostItemsByAddress")
    public JsonInfo queryLostItemsByAddress(String address, @RequestParam(value = "page",defaultValue = "1")
            Integer currentPage, @RequestParam("pagecord")Integer pageCord){
        if(!StringEmptyUtils.ValidStringEmpty(address))
            throw new ItemsException("请选择物品丢失地点");
        PageHelper.startPage(currentPage,pageCord);
        List<Lost> lostList = itemsServiceImp.selectLostByAddressOrderByTime(address);
        PageInfo<Lost> pageInfo = new PageInfo<Lost>(lostList);
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("查询失物成功");
        jsonInfo.add("pageInfo",pageInfo);
        return jsonInfo;
    }

    /***************************************************************************************************
     *
     * @return
     */
    @RequestMapping("/queryLostItemsOrderByNum")
    public JsonInfo queryLostItemsOrderByNum(){

        /*
            查询最新的三条失物信息
         */
        List<Lost> lostList = itemsServiceImp.selectLostByNumOrderByTime();

        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.add("lostList",lostList);
        jsonInfo.setMessage("查询最新的四条失物信息成功");
        jsonInfo.setStatus(200);
        return jsonInfo;
    }
}
