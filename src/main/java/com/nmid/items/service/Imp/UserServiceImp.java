package com.nmid.items.service.Imp;

import com.nmid.items.mapper.*;
import com.nmid.items.other.StringEmptyUtils;
import com.nmid.items.po.*;
import com.nmid.items.service.UserException.ItemsException;
import com.nmid.items.service.UserException.TalkException;
import com.nmid.items.service.UserException.UserException;
import com.nmid.items.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserMapper userMapper;

   @Autowired
   private UserCustomMapper userCustomMapper;

    @Autowired
    private LostCustomMapper lostCustomMapper;

    @Autowired
    private LostMapper lostMapper;

    @Autowired
    private FindCustomMapper findCustomMapper;

    @Autowired
    private FindMapper findMapper;

    @Autowired
    private TalkMapper talkMapper;

    @Autowired
    private TalkCustomMapper talkCustomMapper;

    /***********************************************************************************
     *
     * @param user
     * @description 保存用户注册信息
     */
    @Override
    public void insertUser(User user) {

        if(user == null){
            throw new UserException("用户信息为空");
        }
        /*
            校验用户重要数据
            学号、邮箱、用户名
         */
        String stdNumber = user.getStdnumber();
        if(!StringEmptyUtils.ValidStringEmpty(stdNumber)){
            throw new UserException("学号为空");
        }else if(!StringEmptyUtils.ValidStringEmpty(user.getEmail())){
            throw new UserException("邮箱为空");
        }else if(!StringEmptyUtils.ValidStringEmpty(user.getPassword())){
            throw new UserException("密码为空");
        }else if(!StringEmptyUtils.ValidStringEmpty(user.getTelephone()))
            throw new UserException("联系电话为空");
        //保存信息
        userMapper.insertSelective(user);
    }

    /***********************************************************************************
     *
     * @param StdNumber
     * @param password
     * @return
     * @description 查询用户
     */
    @Override
    public User findUserByStdNumber(String StdNumber,String password) {
        /*
            校验用户学号和密码
         */
       if(!StringEmptyUtils.ValidStringEmpty(StdNumber)){
            throw new UserException("学号为空");
        }else if(!StringEmptyUtils.ValidStringEmpty(password)){
           throw new UserException("密码为空");
       }
        User _user = userCustomMapper.selectUserByStdNumber(StdNumber);
       //如果用户学号不存在该用户不存在
        if(_user == null)
            throw new UserException("不存在该学号对应的用户");
        //密码不匹配
        else if(!_user.getPassword().equals(password)){
            throw new UserException("密码错误");
        }
        //成功就返回用户信息
        return _user;
    }

    /***********************************************************************************
     *
     * @param request
     * @description 用户注销
     */
    @Override
    public void cancellation(HttpServletRequest request) {
        /*
            服务器自动依据JSESSIONID的cookie的值去缓存里查找对应的session
            如果没session，就要重新登录
         */
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        /*User user = (User) session.getAttribute("user");
        //用户没登录
        if(user == null)
            throw new UserException(ResultCode.USER_LOGIN);*/
        //用户注销
        session.invalidate();
    }

    /***********************************************************************************
     *
     * @param user
     * @description 用户信息更新
     */
    @Override
    public void updateUserByStdNumber(User user) {
        if(user == null){
            throw new UserException("用户信息为空");
        }
        //更新
        userCustomMapper.updateUserByStdNumber(user);
    }

    /***********************************************************************************
     *
     * @param stdNumber
     * @return
     */
    @Override
    public UserCustom selectUserByStdNumber(String stdNumber){
        /*
            校验关键数据：学号
         */
        if(!StringEmptyUtils.ValidStringEmpty(stdNumber))
            throw new UserException("学号为空");
        UserCustom userCustom = userCustomMapper.selectUserByStdNumber(stdNumber);
        //为空，不存在
        if(userCustom == null)
            throw new UserException("不存在该学号对应的用户");
        return userCustom;
    }

    /***********************************************************************************
     *
     * @param lost
     * @description 保存失物信息
     */
    @Override
    public void insertLostItems(Lost lost) {
        //重点校验物品图片和特征
        if(lost == null)
            throw new ItemsException("失物信息为空");
        //保存信息
        lostMapper.insertSelective(lost);
    }

    /***********************************************************************************
     *
     * @param find
     * @description 保存拾物信息
     */
    @Override
    public void insertFindItems(Find find) {
        if(find == null)
            throw new ItemsException("拾得物品信息为空");
        //保存
        findMapper.insertSelective(find);
    }

    /***********************************************************************************
     *
     * @param lost
     * @return
     * @description 查询失物及其拾主信息
     */

    public FindCustom selectLostItemsWithFindUser(Lost lost) {
        if(lost == null)
            throw new ItemsException("失物信息为空");
        /*
            检查物品特征是否为空，为空就不用查询数据库
         */
        String characterstr = lost.getCharacterStr();
        if(!StringEmptyUtils.ValidStringEmpty(characterstr))
            throw new ItemsException("失物特征为空");
        /*
            按物品特征去find表中比对拾得物品的信息并查询拾主信息
         */
        FindCustom findCustom = lostCustomMapper.selectLostItemsWithFindUser(lost);
        /*
            目前数据库没有改拾得物品
         */
        if(findCustom == null) {
            throw new ItemsException("数据库没有匹配的拾得物品");
        }
        return findCustom;
    }

    /***********************************************************************************
     *
     * @param find
     * @return
     * @description 查询丢失物品及其失主信息
     */
   @Override
    public LostCustom selectFindItemsWithLostUser(Find find) {
        if(find == null)
            throw new ItemsException("拾得物品信息为空");

            //检查拾得物品特征

        String character = find.getCharacterStr();
        if(!StringEmptyUtils.ValidStringEmpty(character))
            throw new ItemsException("拾得物品特征为空");

           // 按特征去lost表中查询失主及其失物信息

        LostCustom lostCustom = findCustomMapper.selectFindItemsWithLostUser(find);

            //目前没人上传失物信息

        if(lostCustom == null)
            throw new ItemsException("没有匹配的拾得物品");
        return lostCustom;
    }

    /***********************************************************************************
     *
     * @param talk
     * @description 保存用户发布的言论
     */
    @Override
    public void insertTalk(Talk talk) {
        if(talk == null){
            throw new TalkException("言论信息为空");
        }
        /*
            检验用户是否登录
         */

        talk.setTalkTime(new Date());//后端自动生成消息发布的时间
        String context = talk.getContext();
        /*
            校验言论内容、言论所属用户id
         */
        if(!StringEmptyUtils.ValidStringEmpty(context))
            throw new TalkException("言论内容为空");
        //保存言论
        talkMapper.insert(talk);
    }

    /***********************************************************************************
     *
     * @return
     * @description 查询言论及其用户信息按时间最新查询
     */
    @Override
    public List<TalkCustom> selectTalkWithUser() {

        List<TalkCustom> talkCustomList = talkCustomMapper.selectTalkWithUser();
        //数据库没有言论
        if(talkCustomList == null)
            throw new TalkException("没有言论");
        return talkCustomList;
    }

    /***********************************************************************************************
     *
     * @param session
     * @return 用户未找回的历史失物
     */
    @Override
    public List<Lost> selectLostItems(HttpSession session){
        if(session == null)
            throw new UserException("请先登录");
        User selfUser = (User) session.getAttribute("user");
        System.out.println(selfUser.getStdnumber());
        List<Lost> lostList = lostCustomMapper.selectLostItems(selfUser.getStdnumber());
        if(lostList == null)
            throw new UserException("当前用户没有上传过丢失物品信息");
        return lostList;
    }

    /*****************************************************************************************************
     *
     * @param id
     * @return 返回用户拾得和丢失物品的历史记录
     */
    @Override
    public List<UserCustomVo> selectLostItemsAndFindItems(Integer id) {
        if(id == null)
            throw new UserException("查询历史记录的用户主键不能为空");
        List<UserCustomVo> userCustomVoList = lostCustomMapper.selectLostItemsAndFindItemsSucess(id);
        if(userCustomVoList == null && userCustomVoList.size() == 0){
            throw new UserException("该用户的失物及其拾得历史记录为空");
        }
        return userCustomVoList;
    }

    /************************************************************************************************************
     *
     * @param request
     * @return 返回用户总积分
     */
    @Override
    public Integer selectUserIntegration(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        User user = (User) session.getAttribute("user");
        int integration = userCustomMapper.selectUserTotalIntegration(user.getStdnumber());
        return integration;
    }

    @Override
    public User selectUserByLogin(String stdnumber) {
        if(!StringEmptyUtils.ValidStringEmpty(stdnumber))
            throw new UserException("用户学号为空,请先登录");
        User user = userCustomMapper.selectUserByStdNumber(stdnumber);
        if(user == null)
            throw new UserException("不存在该学号对应的用户，请先注册");
        return user;
    }

    /*****************************************************************************************
     *
     * @param stdnumber
     */
    @Override
    public void updateUserIntegration(String stdnumber) {
        if(stdnumber == null)
            throw new UserException("用户学号为空");
        System.out.println(stdnumber);
        userCustomMapper.updateUserIntegration(stdnumber);
    }

    @Override
    public List<User> selectGoodManInfo() {

        List<User> userList = userCustomMapper.selectGoodManInfo();
        return userList;
    }

    @Override
    public User selectUserInfoByTalkId(Integer id) {
        if(id == null)
            throw new TalkException("言论主键为空");
        User user = talkCustomMapper.selectUserInfoByTalkId(id);
        return user;
    }

    @Override
    public User selectUserByStdnumberRegistr(String stdnumber) {

        User user = userCustomMapper.selectUserByStdNumber(stdnumber);
        return user;
    }

}
