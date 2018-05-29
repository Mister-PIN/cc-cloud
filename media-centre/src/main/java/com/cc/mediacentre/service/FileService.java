package com.cc.mediacentre.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     *
     * @param targetPath
     * @param dir
     * @return
     */
    String mdkDir(String targetPath, String dir);

    /**
     *
     * @param file
     * @param datePath
     * @param uuid
     * @return
     */
    boolean saveFile(MultipartFile file, String datePath, String uuid);

    /**
     * 切片存储
     * @param file
     * @param datePath
     * @param uuid
     * @param slice
     * @return
     */
    boolean saveSlipFile(MultipartFile file, String datePath, String uuid, Integer slice);


    /**
     * 合并
     * @param datePath
     * @param uuid
     */
    boolean slipMerge(String datePath, String uuid);

}
