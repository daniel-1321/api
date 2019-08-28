package com.coffee.management.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: Admin.java
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "admin")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adm_id;

    @Column
    @NotNull
    private String adm_username;
    @Column
    @NotNull
    private String adm_password;
    @Column
    @NotNull
    private String adm_name;
    @Column
    @NotNull
    private String adm_phone;
    @Column
    @NotNull
    private String adm_address;
}
