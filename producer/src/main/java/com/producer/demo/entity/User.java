package com.producer.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * @author song
 * @Entity 应该在数据库中保存的类，必须使用注解 javax.persistence.Entity
 * @Column 实体的字段将保存在数据库
 * @GeneratedValue 注解将自动生成主键
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private BigDecimal balance;
}
