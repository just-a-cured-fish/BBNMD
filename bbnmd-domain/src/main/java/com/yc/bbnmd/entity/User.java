package com.yc.bbnmd.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data      //  lombok 注解，节省getter, setter
@Table(name = "user")
public class User {
    @Id  // JPA注解,指定此属性为表中的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;   //注意: 对应的数据表中的字段名叫 book_id
    private String uname;
    private String upwd;
    private String role;

    public User() {
    }

    public User(Integer uid, String uname, String role) {
        this.uid = uid;
        this.uname = uname;
        this.role = role;
    }


}
