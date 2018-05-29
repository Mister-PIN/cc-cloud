package com.cc.auth.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "cc_user_property")
public class UserProperty {
    @Column(name = "user_id_")
    private Integer userId;

    @Column(name = "name_")
    private String name;

    @Column(name = "date_type_")
    private String dataType;

    @Column(name = "text_value_")
    private String textValue;

    @Column(name = "int_value_")
    private Integer intValue;

    @Column(name = "date_value")
    private Date dateValue;
}
