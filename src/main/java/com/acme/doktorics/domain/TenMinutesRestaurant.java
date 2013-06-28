package com.acme.doktorics.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "tenminutes")
public class TenMinutesRestaurant extends AbstractRestaurant {

    @Lob
    private byte[] menu;

    public TenMinutesRestaurant() {
        this.menu = new byte[1];
    }

    public TenMinutesRestaurant(byte[] menu) {
        this.menu = menu;
    }

    public void setMenu(byte[] menu) {
        this.menu = menu;
    }

    public byte[] getMenu() {
        return menu;
    }

}
