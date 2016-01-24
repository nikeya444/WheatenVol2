package ua.dp.wheaten.site;

import ua.dp.wheaten.site.root.entities.City;
import ua.dp.wheaten.site.root.entities.DeliveryCompany;
import ua.dp.wheaten.site.root.entities.DeliveryDepartment;
import ua.dp.wheaten.site.root.services.CityService;
import ua.dp.wheaten.site.root.services.DeliveryCompanyService;
import ua.dp.wheaten.site.root.services.DeliveryDepartmentService;
import ua.dp.wheaten.site.root.services.impl.CityServiceImpl;
import ua.dp.wheaten.site.root.services.impl.DeliveryCompanyServiceImpl;
import ua.dp.wheaten.site.root.services.impl.DeliveryDepartmentServiceImpl;


import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 06.09.15
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public class AddDepartments {

    private static final String CITY = "Днепропетровск";
    private static final String NOVA_POSHTA = "Новая почта";
    private static final String DELIVERY = "Деливери";

    public static void main(String[] args) {
        DeliveryDepartmentServiceImpl departmentService = new DeliveryDepartmentServiceImpl();
        CityService cityService = new CityServiceImpl();
        DeliveryCompanyService companyService = new DeliveryCompanyServiceImpl();

        City city = cityService.findByName(CITY);
        DeliveryCompany company = companyService.findByName(NOVA_POSHTA);
        departmentService.addDepartments(company, city, 100);
    }



}
