package pers.myz.globleexception.springbootglobleexceptiondemo.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.myz.globleexception.springbootglobleexceptiondemo.common.exception.BusinessException;
import pers.myz.globleexception.springbootglobleexceptiondemo.entity.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 * @author Yuzhe Ma
 * @date 2018/11/12
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 Exception 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error("服务错误:", e);
        return new ResponseEntity("xxx", "服务出错");
    }

    /**
     * 处理 BusinessException 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity businessExceptionHandler(HttpServletRequest httpServletRequest, BusinessException e) {
        logger.info("业务异常。code:" + e.getCode() + "msg:" + e.getMsg());
        return new ResponseEntity(e.getCode(), e.getMsg());
    }
}
