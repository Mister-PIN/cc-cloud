package com.cc.mediacentre.utils;


import java.io.File;

/**
 *ffmpeg 视频处理
 *
 */
public class FFmpegCommandRunner{



    private int checkContentType(String inputPath) {
        String type = inputPath.substring(inputPath.lastIndexOf(".") + 1, inputPath.length()).toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi") || type.equals("mpg") || type.equals("wmv") || type.equals("3gp") || type.equals("mov")
                || type.equals("mp4") || type.equals("mkv") || type.equals("rmvb")) {
            return 1;
        } else if (type.equals("asf") || type.equals("flv") || type.equals("rm")) {
            return 0;
        }
        return 9;
    }


    /**
     * 格式转换
     * @param originPath
     * @param outPath
     * @return
     */
    public boolean convertMedia(String originPath, String outPath) {


        return true;
    }


    public boolean screenshot(String mediaPath) {


        return true;
    }


}
