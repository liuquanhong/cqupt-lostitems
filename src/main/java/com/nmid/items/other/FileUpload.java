package com.nmid.items.other;

import com.nmid.items.po.Find;
import com.nmid.items.po.Lost;
import com.nmid.items.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUpload {
    /*
        用户头像上传
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileUpload.class);

    private static ServletContext servletContext;

    static{
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        servletContext = webApplicationContext.getServletContext();
    }

    public static void savePicture(MultipartFile multipartFile, HttpServletRequest request, User user) {
        if (multipartFile != null) {
            String fileName = multipartFile.getOriginalFilename();
            int index;
            index = fileName.lastIndexOf(".");
            String suffix = fileName.substring(index);
            /*
                以防重名
             */
            String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
            /*
                散列存储
             */
            String datestr = new SimpleDateFormat("yyyy/MM/dd").format(new Date()).toString();
            /*
                数据库存储路径
             */
            String sqlStorePath = "/imgs/" + datestr + "/" + newFileName;
            String rootPath = servletContext.getRealPath("/");
            /*
                物理存储路径
             */
            String storePath = rootPath + File.separator +"imgs"+File.separator + datestr + File.separator + newFileName;
            user.setImge(sqlStorePath);//设置数据库存储路径值
            File destFile = new File(storePath);
            if (!destFile.exists()) {
                destFile.mkdirs();
            }
            try {
                multipartFile.transferTo(destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            //设置默认的头像
            user.setImge("/imgs/" + "");
        }
    }
    /**************************************************************************************************
    /*
        物品图片上传
     */
    public static void saveItemsPicture(MultipartFile multipartFile, HttpServletRequest request,
                                        Lost lost, Find find) {
        if (multipartFile != null) {
            String fileName = multipartFile.getOriginalFilename();
            int index;
            index = fileName.lastIndexOf(".");
            String suffix = fileName.substring(index);
             /*
                以防重名
             */
            String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
            Date date = new Date();
            /*
                依据cookie里的jsessionid的值查找session
                用户如果误关了网页那么在有效时间内(半小时)也视登录状态
             */
            String rootPath = servletContext.getRealPath("/");
            String storePath = null;
            //调用python脚本程序得到图片特征或者描述
            if(lost != null) {
                /*
                    散列存储
                 */
                String datestr = new SimpleDateFormat("yyyy/MM/dd").format(date).toString();
                 /*
                    数据库存储路径
                */
                String sqlStorePath = "/imgs/" + "lost/" + datestr + "/" + newFileName;
                lost.setImage(sqlStorePath);
                storePath = rootPath + File.separator + "imgs" + File.separator + "lost" + File.separator + datestr + File.separator + newFileName;
                /*
                    调用Python脚本
                 */
                Process proc;
                String character;
                String[] args = new String[]{"python", "yikatong.py", storePath};
                try {
                    proc = Runtime.getRuntime().exec(args);// 执行py文件
                    BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    char[] buffersize = new char[1024];
                    in.read(buffersize);
                    character = new String(buffersize,0,buffersize.length);
                    in.close();
                    proc.waitFor();
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                /*
                    物理存储路径
                */
                lost.setCharacterStr(character);
            }
                if(find != null) {
                /*
                    散列存储
                 */
                String datestr = new SimpleDateFormat("yyyy/MM/dd").format(date).toString();
                String sqlStorePath = "/imgs/" + "find/" + datestr + "/" + newFileName;
                find.setImage(sqlStorePath);
                /*
                    物理存储路径
                */
                storePath = rootPath + File.separator+ "imgs"+File.separator + "find"+File.separator + datestr + File.separator + newFileName;
                    Process proc;
                    String character;
                    String[] args = new String[]{"python", "yikatong.py", storePath};
                    try {
                        proc = Runtime.getRuntime().exec(args);// 执行py文件
                        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        char[] buffersize = new char[1024];
                        in.read(buffersize);
                        character = new String(buffersize,0,buffersize.length);
                        in.close();
                        proc.waitFor();
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    find.setCharacterStr(character);
            }
            File destFile = new File(storePath);
            if (!destFile.exists()) {
                destFile.mkdirs();
            }
            try {
                multipartFile.transferTo(destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
