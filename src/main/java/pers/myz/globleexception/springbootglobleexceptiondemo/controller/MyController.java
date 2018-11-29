package pers.myz.globleexception.springbootglobleexceptiondemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.myz.globleexception.springbootglobleexceptiondemo.common.exception.BusinessException;
import pers.myz.globleexception.springbootglobleexceptiondemo.entity.ResponseEntity;

/**
 * @author Yuzhe Ma
 * @date 2018/9/29
 */


@RestController
public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @RequestMapping(value = "/test")
    public ResponseEntity test() {
        ResponseEntity re = new ResponseEntity();
        // 业务处理
        // ...
        return re;
    }

    @RequestMapping(value = "/test2")
    public ResponseEntity test2() {
        throw new BusinessException("3000", "账户密码错误");
    }
}
