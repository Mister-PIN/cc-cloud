package com.cc.mediacentre.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cc_channel")
public class Channel extends BaseObject{

    @Column(name = "name_")
    private String name;


}
