package com.cc.mediacentre.service;

import com.cc.mediacentre.dto.MediaFileDTO;

public interface MediaUploadService {

    /**
     * 创建
     * @param dto
     * @return
     */
    String mdkFile(MediaFileDTO dto);


    /**
     * @param dto
     * @return
     */
    boolean splitUpload(MediaFileDTO dto);


    /**
     * 文件上传
     * @param dto
     * @return
     */
    Integer upload(MediaFileDTO dto);


    /**
     * 合并
     * @param uuid
     * @return
     */
    boolean merge(String uuid);

}
