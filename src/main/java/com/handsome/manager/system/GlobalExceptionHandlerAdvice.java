package com.handsome.manager.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

/**
 * @author zhanglihui
 * @date 2020-05-11 23:37
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception e) {
        log.error(e.getMessage(), e);
        model.addAttribute("contentPage", "error");
        model.addAttribute("jsPaths", new ArrayList<String>());
        return "common";
    }
}
