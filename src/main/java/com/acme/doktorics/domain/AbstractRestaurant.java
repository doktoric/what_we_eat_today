package com.acme.doktorics.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.25.
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance
@DiscriminatorColumn(name="REF_TYPE")
public abstract  class AbstractRestaurant {
}
