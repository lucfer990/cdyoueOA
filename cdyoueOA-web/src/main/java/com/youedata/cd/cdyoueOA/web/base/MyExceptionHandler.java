package com.youedata.cd.cdyoueOA.web.base;

import com.youedata.cd.cdyoueOA.common.util.ExceptionsMapping;
import com.youedata.cd.cdyoueOA.common.util.SimpleHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(HttpServletRequest req,
                                               HttpServletResponse resp, Exception e) {
        if (e instanceof IllegalArgumentException) {
            LOGGER.error(e.getMessage(), e);
            return new SimpleHashMap(e.getMessage(), 1004);
        } else {
            return new SimpleHashMap(ExceptionsMapping.retrieveAndPrint(e));
        }
    }
}