package com.cc.mediacentre.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_")
    private Integer id;

    @Column(name = "remark_")
    private String remark;

    @Column(name = "create_by_")
    private Integer createBy;

    @Column(name = "create_time_")
    private Date createTime;

    @Column(name = "update_by_")
    private Integer updateBy;

    @Column(name = "update_time_")
    private Date updateTime;
}
