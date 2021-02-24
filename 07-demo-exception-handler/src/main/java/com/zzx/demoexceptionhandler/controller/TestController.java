package com.zzx.demoexceptionhandler.controller;

import com.zzx.demoexceptionhandler.constant.Status;
import com.zzx.demoexceptionhandler.exception.JsonException;
import com.zzx.demoexceptionhandler.exception.PageException;
import com.zzx.demoexceptionhandler.model.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException() {
        throw new PageException(Status.UNKNOWN_ERROR);
    }
}
