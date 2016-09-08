package com.youedata.cd.cdyoueOA.web.base;

/**
 * 登录失败
 *
 * @author xiaqi
 * @create 2016/8/31
 */
public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
