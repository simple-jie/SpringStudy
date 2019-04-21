package com.example.fileupload.web;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Springboot 文件上传
 */
@RestController //@Controller @ResponseBody的组合, 该类下所有的方法返回值都会做Json转换
public class FileUploadController {

    @RequestMapping("/fileUploadController")
    public Map<String, Object> fileUpload(MultipartFile filename) throws Exception {
        System.out.printf("上传文件名称:[%s]", filename.getOriginalFilename());

        filename.transferTo(new File("/Users/JieXingbo/ND/" + filename.getOriginalFilename()));

        Map<String, Object> result = new HashMap<>();
        result.put("msg", "ok");
        return result;
    }
}
