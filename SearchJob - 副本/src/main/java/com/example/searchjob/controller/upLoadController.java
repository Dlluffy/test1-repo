package com.example.searchjob.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class upLoadController {

    private static final Logger logger = LoggerFactory.getLogger(upLoadController.class);

    private final ResourceLoader resourceLoader;

    public upLoadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

//    @PostMapping("/upload")
//    @ResponseBody
//    public String up(String nickname, MultipartFile photo, HttpServletRequest request) {
//        try {
//            System.out.println("1."+nickname);
//            System.out.println("2."+photo.getOriginalFilename());
//            System.out.println("3."+request.getServletContext().getRealPath("/"));
//            System.out.println("4."+System.getProperty("user.dir"));
////            String contextPath = request.getContextPath();
////            System.out.println("5."+contextPath);
//
//            // 获取 static 文件夹的路径
//            Resource resource = resourceLoader.getResource("classpath:static/upload");
//            String path = resource.getFile().getAbsolutePath();
//            System.out.println("path="+path);
//
//            saveFile(photo, path);
//            return "上传成功";
//        } catch (IOException e) {
//            logger.error("文件上传失败", e);
//            return "上传失败: " + e.getMessage();
//        }
//    }
@PostMapping("/upload")
@ResponseBody
public String up(String nickname, MultipartFile photo, HttpServletRequest request) {
    try {
        System.out.println("1." + nickname);
        System.out.println("2." + photo.getOriginalFilename());
        System.out.println("3." + request.getServletContext().getRealPath("/"));
        System.out.println("4." + System.getProperty("user.dir"));

        // 使用项目根目录下的路径来保存上传的文件
        //上传到upload目录下
        String path = System.getProperty("user.dir") + "/src/main/resources/static/upload";
        System.out.println("path"+path);
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        saveFile(photo, path);
        return "上传成功";
    } catch (IOException e) {
        logger.error("文件上传失败", e);
        return "上传失败: " + e.getMessage();
    }
}


    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(path + File.separator + photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
