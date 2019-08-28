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
 * Class: Shifts.java
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "shifts")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Shifts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shft_id;

    @Column
    @NotNull
    private String shft_name;
    @Column
    @NotNull
    private String shft_start_time;
    @Column
    @NotNull
    private String shft_end_time;
    @Column
    @NotNull
    private String shft_description;


}
