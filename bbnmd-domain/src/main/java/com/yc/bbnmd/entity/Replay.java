package com.yc.bbnmd.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data      //  lombok 注解，节省getter, setter
@Table(name = "replay")
public class Replay {
    @Id  // JPA注解,指定此属性为表中的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private String content;
    private String time;
    private Integer tid;
}