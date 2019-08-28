package com.coffee.management.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Author: TiDi
 * Created on 19/08/2019.
 * Class: Bill.java
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "bill")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Bill {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long bll_id;

    private long cus_id;
    private long emp_id;
    private String bll_datetime;
    private int bll_type;
    private int bll_total;
    private int bll_payment;
    private int bll_discount;
    private String bll_note;


}
