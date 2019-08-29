package com.coffee.management.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Author: TiDi
 * Created on 19/08/2019.
 * Class: Product.java
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pro_id;



    private String pro_name;
    private int pro_price_s;
    private int pro_price_m;
    private int pro_price_l;
    private String pro_image;
    private String pro_description;
    private int pro_bestseller;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id", insertable = false, updatable = false)
    private Category category;


    private int cat_id;

}
