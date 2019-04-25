package com.nmid.items.controller.ExceptionHandler;

import com.nmid.items.po.Json_BackMessage.JsonInfo;
import com.nmid.items.service.UserException.ItemsException;
import com.nmid.items.service.UserException.TalkException;
import com.nmid.items.service.UserException.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** * 全局Controller层异常处理类 */
@ControllerAdvice
public class GlobalExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    /**
     * 不可知异常，将其记录到日志文件中
     * @param e 异常
     *
     * */
        @ExceptionHandler(Exception.class)
        @ResponseBody
        public void handleException(Exception e) {
            // 打印异常堆栈信息到日志文件
            e.printStackTrace();
            LOG.error(e.getMessage(),e);
         }

         /** * 处理所有自定义的业务异常
          * @param e 业务异常
          * @return json结果
          * */
         @ExceptionHandler(UserException.class)
         @ResponseBody
         public JsonInfo handleUserException(UserException e) {
             JsonInfo jsonInfo = new JsonInfo();
             jsonInfo.setMessage(e.getMessage());
             jsonInfo.setStatus(500);
             return jsonInfo;
         }
         @ResponseBody
         @ExceptionHandler(TalkException.class)
        public  JsonInfo handleTalkException(TalkException e){
             JsonInfo jsonInfo = new JsonInfo();
             jsonInfo.setStatus(500);
             jsonInfo.setMessage(e.getMessage());
             return jsonInfo;
         }

         @ResponseBody
         @ExceptionHandler(ItemsException.class)
         public JsonInfo handleItemsException(ItemsException e){
             e.printStackTrace();
             JsonInfo jsonInfo = new JsonInfo();
             jsonInfo.setMessage(e.getMessage());
             jsonInfo.setStatus(500);
             return jsonInfo;
         }
}

