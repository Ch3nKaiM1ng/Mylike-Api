package com.mylike.controller;

import com.mylike.utils.UpdateImgNameUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/file")
public class FileUploading {
//    添加文件
    @RequestMapping("/uploading")
    public String[] ImgUploading(MultipartFile file){
//        String[] url = new String[file.length+1];
//        if (file.length>1){
//            url[0] = "success";
//            for (int i = 0;i<file.length;i++){
//                url[i+1] = UpdateImgNameUtils.UpdateImgName(file[i]);
//            }
//        }else {
//            url[0]="";
//        }
        String[] data = new String[2];
        if (file==null){
            data[0] = "";
        }
        else {
            String url = UpdateImgNameUtils.UpdateImgName(file);
            data[0] = "success";
            data[1] = url;
        }


        return data;
    }
}
