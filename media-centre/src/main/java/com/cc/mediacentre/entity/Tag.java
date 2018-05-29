package com.cc.mediacentre.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cc_tag")
public class Tag extends BaseObject {

    @Column(name = "name_")
    private String name;

}
