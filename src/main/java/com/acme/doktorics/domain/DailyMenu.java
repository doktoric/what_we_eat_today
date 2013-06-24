package com.acme.doktorics.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.22.
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "menu")
public class DailyMenu {
    @Id
    @GeneratedValue
    private Long id;
    public String day;
    public String appetizer;
    public String mainDish;
    public String dessert;
    @ManyToOne
    private AbstractRestaurant restaurant;

    public DailyMenu() {
    }

    public DailyMenu(Builder builder) {
        this.day = builder.dailyMenu.getDay();
        this.dessert = builder.dailyMenu.getDessert();
        this.appetizer = builder.dailyMenu.getAppetizer();
        this.mainDish = builder.dailyMenu.getMainDish();
    }

    public DailyMenu(String day, String appetizer, String mainDish, String dessert) {
        this.day = day;
        this.dessert = dessert;
        this.appetizer = appetizer;
        this.mainDish = mainDish;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDay() {

        return day;
    }

    public String getAppetizer() {
        return appetizer;
    }

    public String getMainDish() {
        return mainDish;
    }

    public AbstractRestaurant getAbstractRestaurant() {
        return restaurant;
    }

    public String getDessert() {
        return dessert;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAbstractRestaurant(AbstractRestaurant restaurant) {
        this.restaurant=restaurant;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DailyMenu{" + "day='" + day + '\'' + ", appetizer='"
                + appetizer + '\'' + ", mainDish='"
                + mainDish + '\'' + ", dessert='" + dessert + '\'' + '}';
    }

    public static class Builder {

        private final DailyMenu dailyMenu = new DailyMenu();

        public Builder withAppetizer(String appetizer) {
            dailyMenu.setAppetizer(appetizer);
            return this;
        }

        public Builder withDay(String day) {
            dailyMenu.setDay(day);
            return this;
        }

        public Builder withDessert(String dessert) {
            dailyMenu.setDessert(dessert);
            return this;
        }

        public Builder withMainDish(String mainDish) {
            dailyMenu.setMainDish(mainDish);
            return this;
        }

        public DailyMenu build() {
            return new DailyMenu(this);
        }

    }
}
