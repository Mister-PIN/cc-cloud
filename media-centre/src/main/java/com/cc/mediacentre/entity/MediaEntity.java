package com.cc.mediacentre.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 媒体
 *
 */
@Data
@Entity
@Table(name = "cc_media")
@GenericGenerator(name = "media-uuid", strategy = "uuid")
public class MediaEntity implements Serializable{

    @Id
    @GeneratedValue(generator = "media-uuid")
    @Column(name = "uuid_",length = 32)
    private String uuid;

    /**
     * 名称
     */
    @Column(name = "name_")
    private String name;
    /**
     * 标签, 存储方式(1,2,4)
     */
    @Column(name = "tag")
    private String tag;
    /**
     * 点赞
     */
    @Column(name = "thumbs_")
    private Long thumbs;
    /**
     * 下载数
     */
    private Long downloads;

    /**
     * 视频文件
     */
    @Column(name = "file_uuid_")
    private String fileUuid;
    /**
     * 视频描述
     */
    @Column(name = "description_")
    private String description;

    /**
     * 码率(标清，高清，720P)
     */
    @Column(name = "bps_")
    private String bps;

    /**
     * 视频地址
     */
    @Column(name = "url_")
    private String url;

    @Column(name = "status_")
    private Integer status;

    @Column(name = "create_by_")
    private Integer createBy;

    @Column(name = "create_time_")
    private Date createTime;

    @Column(name = "audit_by_")
    private Integer auditBy;

    @Column(name = "audit_time_")
    private Date auditTime;
}
