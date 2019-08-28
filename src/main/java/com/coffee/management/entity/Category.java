package com.coffee.management.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Author: TiDi
 * Created on 15/08/2019.
 * Class: Category.java
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "category")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cat_id;

    @Column
    @NotNull
    private String cat_name;
}
