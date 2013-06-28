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

import java.io.IOException;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
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
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) throws IOException {
        logger.info("Start webapp");

        model.addAttribute("fiktiv",fiktivService.findOne());
        model.addAttribute("stex",stexService.findOne());
        model.addAttribute("tenminutes",tenMinutesService.findOne());
        model.addAttribute("kompot",kompotService.findOne());
        //fiktivService.saveRestaurant(testFiktiv());
        //stexService.saveRestaurant(testStex());
        //tenMinutesService.saveRestaurant(testTenMinutes());
        //kompotService.saveRestaurant(testKompot());
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
