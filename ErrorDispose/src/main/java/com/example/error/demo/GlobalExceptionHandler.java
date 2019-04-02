package com.example.error.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "err";

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Object customError(HttpServletRequest req, MyException e) throws Exception {
        ErrorObject o = new ErrorObject();
        o.url = req.getRequestURL().toString();
        o.msg = e.getMessage();
        return o;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.addObject("url", req.getRequestURL());
        mv.setViewName(DEFAULT_ERROR_VIEW);
        return mv;
    }


}
