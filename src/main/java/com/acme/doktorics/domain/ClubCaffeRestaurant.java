package com.acme.doktorics.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ClubCaffeRestaurant extends AbstractRestaurant{

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DailyMenu> menu;

    public ClubCaffeRestaurant() {
        this.menu = new ArrayList<DailyMenu>();
    }

    public ClubCaffeRestaurant(List<DailyMenu> menu) {
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


}
