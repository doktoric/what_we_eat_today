package com.acme.doktorics.controller;

import com.acme.doktorics.domain.*;
import com.acme.doktorics.parser.*;
import com.acme.doktorics.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static com.acme.doktorics.parser.AbstractRestaurantParser.DAYS;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


    @Autowired
    private IFiktivService fiktivService;
    @Autowired
    private IKompotService kompotService;
    @Autowired
    private IClubCaffeService clubCaffeService;
    @Autowired
    private IStexService stexService;
    @Autowired
    private ITenMinutesService tenMinutesService;


    BaseRestaurantParser fiktivParser = new FiktivParser();
    BaseRestaurantParser clubCaffeParser = new ClubCaffeParser();
    BaseRestaurantParser kompotParser = new KompotParser();
    BaseRestaurantParser stexParser = new StexParser();
    BaseRestaurantParser tenMinutesParser = new TenMinutesParser();


    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws IOException {
        logger.info("Start webapp");

        //fiktivService.saveRestaurant(testFiktiv());
        //stexService.saveRestaurant(testStex());
        //tenMinutesService.saveRestaurant(testTenMinutes());
        //kompotService.saveRestaurant(testKompot());

        model.addAttribute("fiktiv", fiktivService.getMenu());
        model.addAttribute("stex", stexService.getMenu());
        model.addAttribute("tenminutes", tenMinutesService.getMenu());
        model.addAttribute("kompot", kompotService.getMenu());

        return "home";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGet(Model model) throws IOException {
        logger.info("Start webapp");
        model.addAttribute("restaurants", Restaurant.values());
        model.addAttribute("days", DAYS);

        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost1(HttpServletRequest request) throws IOException {
        logger.info("Start webapp");
        request.setCharacterEncoding("UTF-8");
        Restaurant restaurant = Restaurant.getRestaurantByName(request.getParameter("restaurant"));

        String day = request.getParameter("day");
        String appetizer = request.getParameter("appetizer");
        String mainDish = request.getParameter("mainDish");
        String dessert = request.getParameter("dessert");

        DailyMenu menu = new DailyMenu.Builder()
                .withDay(day)
                .withDessert(dessert)
                .withMainDish(mainDish)
                .withAppetizer(appetizer)
                .build();

        if (Restaurant.FIKTIV.equals(restaurant)) {
            fiktivService.saveNewMenu(menu);
        } else if (Restaurant.STEX.equals(restaurant)) {
            stexService.saveNewMenu(menu);
        } else if (Restaurant.CLUBCAFFE.equals(restaurant)) {
            clubCaffeService.saveNewMenu(menu);
        } else if (Restaurant.KOMPOT.equals(restaurant)) {
            kompotService.saveNewMenu(menu);
        } else if (Restaurant.TENMINUTES.equals(restaurant)) {
            logger.info("Not supported...");
        }
        return "home";
    }


    public FiktivRestaurant testFiktiv() throws IOException {
        fiktivService.truncate();
        List<DailyMenu> menus = (List<DailyMenu>) fiktivParser.getMenu();
        for (DailyMenu menu : menus) {
            System.out.println(menu.toString());
        }
        return new FiktivRestaurant(menus);
    }

    public StexRestaurant testStex() throws IOException {
        stexService.truncate();
        List<DailyMenu> menus = (List<DailyMenu>) stexParser.getMenu();
        for (DailyMenu menu : menus) {
            System.out.println(menu.toString());
        }
        return new StexRestaurant(menus);
    }

    public TenMinutesRestaurant testTenMinutes() throws IOException {
        tenMinutesService.truncate();
        byte[] menus = (byte[]) tenMinutesParser.getMenu();
        System.out.println(menus);
        return new TenMinutesRestaurant(menus);
    }

    public KompotRestaurant testKompot() throws IOException {
        kompotService.truncate();
        List<DailyMenu> menus = (List<DailyMenu>) kompotParser.getMenu();
        for (DailyMenu menu : menus) {
            System.out.println(menu.toString());
        }
        return new KompotRestaurant(menus);
    }

}
