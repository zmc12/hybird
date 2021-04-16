package com.jsut.hybird.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Author: ZhangMinCong
 * @Date: 2021/3/19 19:13
 */
public class MultipartFileToFile {

    public static File multipartFileToFile(MultipartFile multipartFile){
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        File excelFile = null;
        try {
            // 用时间作为文件名，防止生成的临时文件重复
            excelFile = File.createTempFile(UUID.randomUUID().toString(), prefix);
            multipartFile.transferTo(excelFile);
        }catch (Exception e){
            System.out.println("==========={}文件=================转换异常");
            e.printStackTrace();
        }
        return excelFile;
    }
}
