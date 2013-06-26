package com.acme.doktorics.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.25.
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */


@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract  class AbstractRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
