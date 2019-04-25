package com.nmid.items.other;

import com.nmid.items.po.FindCustom;
import com.nmid.items.po.LostCustom;
import com.nmid.items.po.User;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Email {

    private static Session session;

    private static Properties pro = new Properties();

    static{
        try {
            pro.load( Email.class.getResourceAsStream("/mail.properties"));
            //创建定义整个应用程序所需的环境信息的 Session 对象
            session = Session.getInstance(pro);
        } catch (IOException e) {
           throw new RuntimeException("读取邮件配置文件失败");
        }
    }

    public static void sendMail(FindCustom findCustom, LostCustom lostCustom,HttpServletRequest request) throws Exception {
        //创建邮件的实例对象
        Message msg = getMimeMessage(session,findCustom,lostCustom,request);
        //根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();
        //设置发件人的账户名和密码
        transport.connect(pro.getProperty("mail.senderAccount"),pro.getProperty("mail.senderPassword"));
        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(msg,msg.getAllRecipients());

        //如果只想发送给指定的人，可以如下写法
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});

        //5、关闭邮件连接
        transport.close();
    }

    /**
     * 获得创建一封邮件的实例对象
     * @param session
     * @return
     * @throws
     *
     */
    public static  MimeMessage getMimeMessage(Session session, FindCustom findCustom, LostCustom lostCustom, HttpServletRequest request) throws Exception{
        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        //设置发件人地址
        msg.setFrom(new InternetAddress(pro.getProperty("mail.senderAddress")));
        /**
         * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */

        /*
            当前登录用户就是失主
         */
        HttpSession _session = request.getSession(false);
        User user = (User) _session.getAttribute("user");
        if(lostCustom == null) {
            msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail()));
            //设置邮件正文
            msg.setContent("你好，你丢失的物品被用户"+findCustom.getUser().getUsername()+"找到，其联系电话为:"+
                    findCustom.getUser().getTelephone()+"邮箱为:"+findCustom.getUser().getEmail(), "text/html;charset=UTF-8");
        }else{
            //当前用户是拾主，要给数据库里查询出来的失主发邮件
            msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(lostCustom.getUser().getEmail()));
            //设置邮件正文
            msg.setContent("你好，你丢失的物品被用户"+user.getUsername()+"找到，其联系电话为:"+
                    user.getTelephone()+"邮箱为:"+user.getEmail(), "text/html;charset=UTF-8");
        }
        //设置邮件主题
        msg.setSubject(pro.getProperty("mail.subject"),"UTF-8");
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());
        return msg;
    }
}

