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
 * Class: News.java
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "news")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nws_id;

    @Column
    @NotNull
    private String nws_title;
    @Column
    @NotNull
    private String nws_content;
    @Column
    @NotNull
    private String nws_image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adm_id", referencedColumnName = "adm_id", insertable = false, updatable = false)
    private Admin admin;
    @Column
    private long adm_id;
}
