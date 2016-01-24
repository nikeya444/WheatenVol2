package ua.dp.wheaten.site.web.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.dp.wheaten.site.root.entities.City;
import ua.dp.wheaten.site.root.services.CityService;
import ua.dp.wheaten.site.web.CityList;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 06.09.15
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "city")
public class CityController {

    @Inject
    private CityService cityService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseBody @ResponseStatus(HttpStatus.OK)
    public CityList read() {
        List<City> cities = cityService.getAll();
        CityList cityList = new CityList();
        cityList.setValue(cities);
        return cityList;
    }

}
