package pers.myz.globleexception.springbootglobleexceptiondemo.common.exception;

import lombok.Data;

/**
 * 自定义业务异常类
 *
 * @author Yuzhe Ma
 * @date 2018/11/28
 */
@Data
public class BusinessException extends RuntimeException {
    private String code;
    private String msg;

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
