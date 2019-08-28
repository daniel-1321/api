package com.coffee.management.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Author: TiDi
 * Created on 19/08/2019.
 * Class: Employee.java
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emp_id;

    @Column
    @NotNull
    private String emp_name;
    @Column
    @NotNull
    private String emp_phone;
    private String emp_email;
    @Column
    @NotNull
    private String emp_password;
    private String emp_address;
    private String emp_dob;
    private String emp_gender;
    @Column
    @NotNull
    private int emp_ismanager;
    private String emp_join;

}
