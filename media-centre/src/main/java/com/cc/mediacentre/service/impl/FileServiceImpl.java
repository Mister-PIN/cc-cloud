package com.cc.mediacentre.service.impl;

import com.cc.mediacentre.common.CCEnum;
import com.cc.mediacentre.entity.EnvProperties;
import com.cc.mediacentre.service.FileService;
import com.cc.mediacentre.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

@Service
public class FileServiceImpl implements FileService {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private EnvProperties envProperties;
    //每个切片大小为1M
    private static Integer sliceSize = 1024 * 1024;

    @Override
    public String mdkDir(String datePath, String uuid) {
        String path = envProperties.getDirPath() + datePath + uuid + "/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }


    @Override
    public boolean saveFile(MultipartFile file, String datePath, String uuid) {
        String targetPath = mdkDir(datePath, uuid);
        String targetFile = targetPath + CCEnum.MediaBps.A.getCode();
        return save(file, targetFile);
    }


    @Override
    public boolean saveSlipFile(MultipartFile file, String datePath, String uuid, Integer slice) {
        String targetPath = mdkDir(datePath, uuid);
        String targetFile = targetPath + slice;
        return save(file, targetFile);
    }


    @Override
    public boolean slipMerge(String datePath, String uuid) {
        String targetPath = datePath + datePath + uuid;
        File file = new File(targetPath);
        if (file.isDirectory()) {
            return merge(file);
        }
        return false;
    }

    private boolean merge(File dir){
        File[] files = dir.listFiles();
        File mergeFile = new File(dir.getPath()+"/"+CCEnum.MediaBps.A.getCode());
        RandomAccessFile rafMerge = null;
        try {
            rafMerge = new RandomAccessFile(mergeFile, "rw");

            for (File tmp : files) {
                if (CommonUtils.isNumeric(tmp.getName())) {
                    File file = new File(dir.getAbsolutePath() + CCEnum.MediaBps.A.getCode());

                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    Integer slice = Integer.parseInt(tmp.getName());
                    Integer startPos = slice * sliceSize;
                    byte[] b = new byte[sliceSize];
                    int n = 0;
                    while ((n = randomAccessFile.read(b)) != -1) {
                        rafMerge.write(b, startPos, (n + startPos));
                    }
                }
            }
        }catch (IOException e){
            logger.error("media merge failure : ",e.getMessage());
            return false;
        }finally {
            if (null != rafMerge) {
                try {
                    rafMerge.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


    private boolean save(MultipartFile file, String targetFile) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(targetFile));
            outputStream.write(file.getBytes());
        }catch (IOException e){
            logger.error("save file error :" +e.getMessage());
            return false;
        }finally {
            if (null != outputStream) {
                try {
                    outputStream.flush();
                    outputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
