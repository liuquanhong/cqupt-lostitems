package com.nmid.items.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nmid.items.other.Email;
import com.nmid.items.other.FileUpload;
import com.nmid.items.other.StringEmptyUtils;
import com.nmid.items.po.*;
import com.nmid.items.po.Json_BackMessage.JsonInfo;
import com.nmid.items.service.ItemsService;
import com.nmid.items.service.UserException.TalkException;
import com.nmid.items.service.UserException.UserException;
import com.nmid.items.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userServiceImp;

    @Autowired
    private ItemsService itemsServiceImp;

    /**********************************************************************************************************
     *
     * @param user
     * @param
     * @param request
     * @return 是否注册成功的状态码
     */
    @RequestMapping("/registr")
    public JsonInfo registr(User user,HttpServletRequest request){
        String stdnumber = user.getStdnumber();
        User _user = userServiceImp.selectUserByStdnumberRegistr(stdnumber);
        if(_user != null){
            throw new UserException("学号重复");
        }
        userServiceImp.insertUser(user);//保存用户信息到数据库
        return JsonInfo.success();
    }

    /************************************************************************************************************
     *
     * @param user
     * @param request
     * @return 用户登录后的信息
     */
    @RequestMapping("/login")
    public JsonInfo login(User user, HttpServletRequest request, HttpServletResponse response){

        /*
            它会自动依据浏览器发送过来的jsessionid
            服务器自动去缓存中寻找是否存在对应的session对象
         */
       HttpSession session = request.getSession(false);
        if(session != null){
            User _user = (User) session.getAttribute("user");
            JsonInfo jsonInfo = new JsonInfo();
            jsonInfo.setMessage("登陆成功");
            jsonInfo.setStatus(200);
            jsonInfo.add("user",session.getAttribute("user"));
            return jsonInfo;
        }
        /*
            查询数据用户信息是否存在
         */
        User _user = userServiceImp.findUserByStdNumber(user.getStdnumber(),user.getPassword());
        /*
            session域中保存登录成功用户信息，跟踪会话
             用户首次登陆就为其创建一个session
         */
        session = request.getSession();
        //把sessionID以cookie形式发给浏览器存储
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(1800);//设置其浏览器保存cookie时间为半小时
        response.addCookie(cookie);
        //给session中添加用户信息
        session.setAttribute("user",_user);
        /*
            返回前端成功登录后的用户信息
         */
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("登录成功");
        jsonInfo.add("user",session.getAttribute("user"));
        return jsonInfo;
    }

    /************************************************************************************************************
     *
     * @param request
     * @description 用户注销
     */
    @RequestMapping("/cancellation")
    public void cancellation(HttpServletRequest request){
        /*
            获取session注销
         */
        userServiceImp.cancellation(request);
    }

    /************************************************************************************************************
     *
     * @param user
     * @return 是否成功更新的状态码
     */
    @RequestMapping("/updateUser")
    public JsonInfo updateUser(User user,@RequestParam(value = "picture",required = false)MultipartFile multipartFile
                               ,HttpServletRequest request){
        if(user == null){
            throw new UserException("用户信息为空");
        }
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        //学号校验
        if(!StringEmptyUtils.ValidStringEmpty(user.getStdnumber())){
            throw new UserException("用户学号为空");
        }
        /*
            确认是否存在该用户
         */
        if(userServiceImp.selectUserByStdNumber(user.getStdnumber()) == null){
            throw new UserException("不存在该学号对应的用户");
        }
        /*
            设置用户更新时加的图片信息
         */
        FileUpload.savePicture(multipartFile,request,user);
        /*
            用户信息更新
         */
        userServiceImp.updateUserByStdNumber(user);
        /*
            返回前端状态码
         */
        User _user1 = (User) userServiceImp.selectUserByStdNumber(user.getStdnumber());
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("更新用户信息成功");
        jsonInfo.add("user",_user1);
        return jsonInfo;
    }

    /************************************************************************************************************
     *
     * @param lost
     * @param multipartFile
     * @param request
     * @return 返回用户上传失物后匹配到的拾得的物品信息
     */
    @RequestMapping("/releaseLost")
    public JsonInfo releaseLost(Lost lost,@RequestParam("lostItems")MultipartFile multipartFile,
                                HttpServletRequest request){
        if(lost == null)
            throw new UserException("失物信息为空");
        /*
                校验是否登录
                依据cookie里的jsessionid的值查找session
                用户如果误关了网页那么在有效时间内(半小时)也视登录状态
         */
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        /*
            处理失物图片信息
         */
       FileUpload.saveItemsPicture(multipartFile,request,lost,null);

       /*
            后端自动设置失物所属用户
        */
       User lostuser = (User) session.getAttribute("user");
       lost.setLostUserid(lostuser.getUid());
       /*
            用户一上传就自动设置失物状态为未找回1
        */
       lost.setLostStatus(1);//设置失物状态为未找回
       /*
            保存失物信息到数据库
       */
        userServiceImp.insertLostItems(lost);
        JsonInfo jsonInfo = new JsonInfo();
        /*
            如果失物不是一卡通或者特征无法提取就不匹配
         */
        if(!StringEmptyUtils.ValidStringEmpty(lost.getCharacterStr())) {
            jsonInfo.setStatus(500);
            jsonInfo.setMessage("物品没有特征信息");
            return jsonInfo;
        }
        /*
            否则就匹配find表中与该失物的特征和种类信息比对
         */
        FindCustom findCustom = userServiceImp.selectLostItemsWithFindUser(lost);
        User findUser = findCustom.getUser();//失物的发现者
        lost.setFindUserid(findUser.getUid());//设置失物拾得者标记
        findCustom.setLostUserid(lostuser.getUid());//设置拾物所属失主标记
        /*
            匹配成功后就以邮件给失主发拾主的联系方式
            当前登录用户就是失主
         */
        try {
            Email.sendMail(findCustom,null,request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*
            发送邮件后就设置该失物为失主待确定的状态2
         */
        lost.setLostStatus(2);//一旦匹配成功邮件发送成功后就修改失物的状态为待确定
        findCustom.setFindStatus(2);//同时也要设置拾得物品的状态为2即待确定
        /*
            返回前端拾得物品信息和拾主的个人信息（可能为空)，以及状态码
         */
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("发布失物成功");
        jsonInfo.add("lostitems",lost);
        return jsonInfo;
    }

    /************************************************************************************************************
     *
     * @param find
     * @param multipartFile
     * @param request
     * @return 返回失物及失主信息
     */
    @RequestMapping("/releaseFind")
    public JsonInfo releaseFind(Find find,@RequestParam("findItems")MultipartFile multipartFile,
                                HttpServletRequest request){
        if(find == null)
            throw new UserException("拾得物品信息为空");
        /*
                依据cookie里的jsessionid的值查找session
                用户如果误关了网页那么在有效时间内(半小时)也视登录状态
         */
        HttpSession session = request.getSession(false);
        if(session == null){
            throw new UserException("请先登录");
        }
        /*
            处理拾物图片信息
         */
        FileUpload.saveItemsPicture(multipartFile,request,null,find);
        /*
            后端自动设置拾得物品所属拾主
         */
        User finduser = (User) session.getAttribute("user");
        find.setFindUserid(finduser.getUid());
        /*
            设置拾得物品状态为未找回1
         */
        find.setFindStatus(1);
         /*
            保存拾物到数据库
         */
        userServiceImp.insertFindItems(find);

        JsonInfo jsonInfo = new JsonInfo();
        /*
            如果拾得物品没有特征信息就不匹配
         */
        if(!StringEmptyUtils.ValidStringEmpty(find.getCharacterStr())) {
            jsonInfo.setStatus(500);
            jsonInfo.setMessage("丢失物没有特征信息");
            return jsonInfo;
        }
        /*
            如果有特征就去lost表中匹配
         */
        LostCustom lostCustom = userServiceImp.selectFindItemsWithLostUser(find);
        User lostuser = lostCustom.getUser();//该物品的失主信息
        find.setLostUserid(lostuser.getUid());//设置拾得物品失主标记
        lostCustom.setFindUserid(finduser.getUid());//设置失物所属拾得者标记
        /*
            匹配成功就给失主发邮件
            当前失主是数据库里查询得到
         */
        try {
            Email.sendMail(null,lostCustom,request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*
            发送邮件后就要设置拾得物品状态为待确定2
            同时也要设置该拾得物品对应的失物的状态为2
         */
        find.setFindStatus(2);//设置拾得物状态为2
        lostCustom.setLostStatus(2);//设置丢失物状态为2
        /*
            返回前端失物及失主信息
         */
       jsonInfo.setStatus(200);
       jsonInfo.setMessage("发布拾得物品成功");
       jsonInfo.add("finditems",find);
        return jsonInfo;
    }

    /************************************************************************************************************
     *
     * @param talk
     * @return
     */
    @RequestMapping("/releaseTalk")
    public JsonInfo releaseTalk(Talk talk,HttpServletRequest request){
        if(talk == null)
            throw new TalkException("言论信息为空");
        //校验是否登录
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        /*
            数据库保存用户发布的言论
         */
        User user = (User) session.getAttribute("user");
        talk.setTalkUserid(user.getUid());//自动设置该言论所属用户ID
        userServiceImp.insertTalk(talk);

        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("发布言论成功");
        return jsonInfo;
    }

    /************************************************************************************************
     *
     * @param currentpage
     * @param pagecord
     * @return 查询最新永辉发布的言论和用户信息
     */
    @RequestMapping("/findTalks")
    public JsonInfo findTalks(@RequestParam(value = "page",defaultValue = "1") Integer currentpage,
                              @RequestParam("pagecord")Integer pagecord){

        /*
            分页处理数据
         */
        PageHelper.startPage(currentpage,pagecord);
        List<TalkCustom> talkCustomList = userServiceImp.selectTalkWithUser();
        PageInfo<TalkCustom> pageInfo = new PageInfo<TalkCustom>(talkCustomList);
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setMessage("查询成功");
        jsonInfo.setStatus(200);
        jsonInfo.add("pageInfo",pageInfo);
        return jsonInfo;
    }

    /*******************************************************************************************************
     *
     * @param request
     * @param currentPage
     * @param pageCord
     * @return 用户个未找回历史失物
     */
    @RequestMapping("/querySelfLostItems")
    public JsonInfo querySelfLostItems(HttpServletRequest request,@RequestParam(value = "page",defaultValue = "1")
            Integer currentPage,@RequestParam("pagecord")Integer pageCord){
        /*
            校验是否登录
         */
        HttpSession session = request.getSession(false);
        if(session == null){
            throw new UserException("请先登录");
        }
        /*
            分页处理
         */
        PageHelper.startPage(currentPage,pageCord);
        List<Lost> lostList = userServiceImp.selectLostItems(session);
        PageInfo<Lost> pageInfo = new PageInfo<Lost>(lostList);
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("查询个人失物历史记录成功");
        jsonInfo.add("pageInfo",pageInfo);
        return jsonInfo;
    }

    /*********************************************************************************************************
     *
     * @param id
     * @param currentPage
     * @param pageCord
     * @return 用户成功的历史记录（包含帮人归还和自己的被归还)
     */
    @RequestMapping("/queryUserLostAndFindSucess")
    public JsonInfo queryUserLostAndFindSucess(Integer id,@RequestParam(value = "page",defaultValue = "1")
            Integer currentPage,@RequestParam("pagecord")Integer pageCord){
        if(id == null)
            throw new UserException("查询用户历史记录主键为空");

        //查询用户丢失和拾得的物品历史记录
        List<UserCustomVo> userCustomVoList = userServiceImp.selectLostItemsAndFindItems(id);

        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setMessage("查询用户成功交易的历史记录成功");
        jsonInfo.setStatus(200);
        jsonInfo.add("userCustomVoList",userCustomVoList);
        return jsonInfo;
    }

    /******************************************************************************************************
     *
     * @param request
     * @return 用户总积分
     */
    @RequestMapping("/queryUserInteration")
    public String queryUserIntegration(HttpServletRequest request){

        int  integration = userServiceImp.selectUserIntegration(request);
        String str = String.valueOf(integration);
        return str;
    }

    /*******************************************************************************************************
     *
     * @param request
     * @return 主页用户信息
     */
    @RequestMapping("/queryUserByLogin")
    public JsonInfo queryUserByLogin(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先等录");
        User user = (User) session.getAttribute("user");
        if(user == null)
            throw new UserException("获取会话中用户信息失败");
        User _user = userServiceImp.selectUserByLogin(user.getStdnumber());
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("查询登录用户信息成功");
        jsonInfo.add("user",_user);
        return jsonInfo;
    }

    /********************************************************************************************
     *
     * @param id
     * @return 修改找回物品状态不加积分
     */
    @RequestMapping("/SuccessfultradingLost")
    public JsonInfo SuccessfultradingLost(Integer id,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        User user = (User) session.getAttribute("user");
        if(user == null)
            System.out.println("hhhhh");
        String stdnumber = user.getStdnumber();
        if(!StringEmptyUtils.ValidStringEmpty(stdnumber))
            throw new UserException("用户学号为空");
        //修改当前用户该丢失物品的状态信息
        itemsServiceImp.updateLostItemsStatus(id);
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("修改用户失物状态成功");
        return jsonInfo;
    }

    /*******************************************************************************************************
     *
     * @param id
     * @param request
     * @return 修改被归还物品状态和加积分
     */
    @RequestMapping("/SuccessfultradingFind")
    public JsonInfo SuccessfultradingFind(Integer id,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        User user = (User) session.getAttribute("user");
        String stdnumber = user.getStdnumber();
        if(!StringEmptyUtils.ValidStringEmpty(stdnumber))
            throw new UserException("用户学号为空");
        //修改当前用户积分
        userServiceImp.updateUserIntegration(stdnumber);
        //修改当前用户该丢失物品的状态信息
        itemsServiceImp.updateFindItemsStatus(id);
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("修改用户积分成功");
        return jsonInfo;
    }

    /************************************************************************************************
     *
     * @return 好人记录
     */
    @RequestMapping("/queryGoodManInfo")
    public JsonInfo queryGoodManInfo(){
        List<User> userList = userServiceImp.selectGoodManInfo();
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("查询好人榜记录成功");
        jsonInfo.add("userInfo",userList);
        return jsonInfo;
    }

    @RequestMapping("/queryTalkWithUser")
    public JsonInfo queryTalkWithUser(Integer id,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null)
            throw new UserException("请先登录");
        if(id == null)
            throw new UserException("言论主键为空");
        User user = userServiceImp.selectUserInfoByTalkId(id);
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setStatus(200);
        jsonInfo.setMessage("查询言论对应用户成功");
        jsonInfo.add("user",user);
        return jsonInfo;
    }
}
