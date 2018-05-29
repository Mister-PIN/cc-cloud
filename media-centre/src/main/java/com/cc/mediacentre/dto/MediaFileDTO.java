package com.cc.mediacentre.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MediaFileDTO {
    private String uuid;
    private String name;
    private String type;
    private Integer slice;
    private Long size;
    private MultipartFile file;
    private String description;
}
