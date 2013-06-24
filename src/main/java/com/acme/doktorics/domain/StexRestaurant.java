package com.acme.doktorics.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "stex")
public class StexRestaurant {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<DailyMenu> menu;

    public StexRestaurant() {
        this.menu = new ArrayList<DailyMenu>();
    }

    public StexRestaurant(List<DailyMenu> menu) {
        this.menu = menu;
    }

    public void addMenu(DailyMenu dailyMenu) {
        menu.add(dailyMenu);
    }

    public void setMenu(List<DailyMenu> menu) {
        this.menu = menu;
    }

    public List<DailyMenu> getMenu() {
        return menu;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
