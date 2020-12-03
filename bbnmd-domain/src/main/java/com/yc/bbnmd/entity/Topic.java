package com.yc.bbnmd.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Data      //  lombok 注解，节省getter, setter
@Table(name = "topic")
public class Topic {
    @Id  // JPA注解,指定此属性为表中的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;   //注意: 对应的数据表中的字段名叫 book_id
    private String content;
    private String time;
    private Integer uid;
    private Integer hot;

    public Topic() {
    }

    public Topic(String content, Integer uid, String time, Integer hot) {
        this.content = content;
        this.time = time;
        this.uid = uid;
        this.hot = hot;
    }
}
