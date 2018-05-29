package com.cc.mediacentre.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "cc_media_file")
@GenericGenerator(name ="media-file-uuid", strategy ="uuid")
public class MediaFileEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "media-file-uuid")
    @Column(name = "uuid_",length = 32)
    private String uuid;

    @Column(name = "name_")
    private String name;

    @Column(name = "type_")
    private String type;

    @Column(name = "path_")
    private String path;

    @Column(name = "size_")
    private Long size;

    @Column(name = "status_")
    private Integer status;

    @Column(name = "create_by_")
    private Integer createBy;

    @Column(name = "create_time_")
    private Date createTime;

    @Column(name = "update_by_")
    private Integer updateBy;

    @Column(name = "update_time_")
    private Date updateTime;

}
