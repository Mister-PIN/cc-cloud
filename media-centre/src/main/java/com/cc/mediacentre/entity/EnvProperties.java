package com.cc.mediacentre.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Data
public class EnvProperties {
    @Value("${media.file.path}")
    private String dirPath;
    @Value("${media.file.path.tbd}")
    private String tbdDirPathPath;

}
