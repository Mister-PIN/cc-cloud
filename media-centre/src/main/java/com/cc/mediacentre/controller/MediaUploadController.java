package com.cc.mediacentre.controller;

import com.cc.mediacentre.dto.MediaFileDTO;
import com.cc.mediacentre.response.ResponseMessage;
import com.cc.mediacentre.response.ResponseUploadMessage;
import com.cc.mediacentre.service.MediaUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/upload")
public class MediaUploadController {

  /*  @Value("#{token.userid}")
    private String tokenHeader;*/

    @Autowired
    private MediaUploadService mediaUploadService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "this is media";
    }

    @PostMapping("/mkFile")
    public ResponseUploadMessage mdkFile(MediaFileDTO dto){
        ResponseUploadMessage message = new ResponseUploadMessage();
        return message;
    }


    @PostMapping("/splitUpload/{uuid}")
    public ResponseUploadMessage splitUpload(@PathVariable String uuid, @RequestBody MultipartFile file, HttpServletRequest request){



        return null;
    }


    @PostMapping("/file")
    public ResponseMessage file(MediaFileDTO dto, HttpServletRequest request){
        System.out.println(request.getHeader("account"));
        ResponseMessage message = new ResponseMessage();
        mediaUploadService.upload(dto);
        return message;
    }


}
