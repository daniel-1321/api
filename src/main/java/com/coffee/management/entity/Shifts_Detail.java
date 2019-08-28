package com.coffee.management.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Author: TiDi
 * Created on 19/08/2019.
 * Class: Shift_Detail.java
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "shifts_detail")
public class Shifts_Detail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long shdt_id;

    private long shft_id;
    private long emp_id;

    private String shdt_date;
    private String shdt_login;
    private String shdt_logout;
    private String shdt_note;


}
