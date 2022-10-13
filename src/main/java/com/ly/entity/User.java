package com.ly.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @className: User
 * @description:
 */
@Data
@Table(name = "user")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    @Column(name = "name",length = 30)
    private String name;
    @Column(name = "password")
    private String password;
}
