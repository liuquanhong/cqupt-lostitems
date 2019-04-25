package com.nmid.items.service;

import com.nmid.items.po.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    //用户注册
    public void insertUser(User user);
    //用户登录查询
    public User findUserByStdNumber(String stdNumber,String password);

    //注销不涉及数据库操作
    public void cancellation(HttpServletRequest request);

    //更新用户信息
    public void updateUserByStdNumber(User user);

    //查询用户及其关联信息
    public UserCustom selectUserByStdNumber(String stdNumber);

    //失物保存
    public void insertLostItems(Lost lost);

    //拾物保存
    public void insertFindItems(Find find);

    //查询失物及拾主信息
    public FindCustom selectLostItemsWithFindUser(Lost lost);

   //查询拾物及其失主信息
    public LostCustom selectFindItemsWithLostUser(Find find);

    //保存言论
    public void insertTalk(Talk talk);

    //查询言论及其用户信息
    public List<TalkCustom> selectTalkWithUser();

    //查询用户个人失物历史记录
    public List<Lost> selectLostItems(HttpSession session);

    //查询个人失物及其拾得物品成功交易的历史记录
    public List<UserCustomVo> selectLostItemsAndFindItems(Integer id);

    //查询用户总积分
    public Integer selectUserIntegration(HttpServletRequest request);

    //跳转到主页后返回登录后的用户信息
    public User selectUserByLogin(String stdnumber);

    //修改用户积分
    public void updateUserIntegration(String stdnumber);

    //主页好人榜
    public List<User> selectGoodManInfo();

    public User selectUserInfoByTalkId(Integer id);

    public User selectUserByStdnumberRegistr(String stdnumber);
}
