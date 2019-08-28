package com.coffee.management.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: Customer.java
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cus_id;

    @Column
    @NotNull
    private String cus_name;
    @Column
    @NotNull
    private String cus_phone;
    private String cus_email;
    @Column
    @NotNull
    private String cus_password;
    private String cus_address;
    private String cus_dob;
    private String cus_gender;
    @Column
    @NotNull
    private int cus_type;
    private String cus_join;


}
