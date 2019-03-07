package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_spec_param")
public class SpecParam {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    //定义所属的类别
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name = "`numeric`")
    private String numeric;
    private String unit;
    private Boolean  generic;
    private Boolean searching;
    private String segments;

}
