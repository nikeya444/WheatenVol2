package ua.dp.wheaten.site.root.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.dp.wheaten.site.root.entities.City;
import ua.dp.wheaten.site.root.entities.DeliveryCompany;
import ua.dp.wheaten.site.root.entities.DeliveryDepartment;
import ua.dp.wheaten.site.root.repositories.DeliveryDepartmentRepository;
import ua.dp.wheaten.site.root.services.DeliveryDepartmentService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 05.09.15
 * Time: 1:35
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DeliveryDepartmentServiceImpl
    extends AbstractGenericService<DeliveryDepartment, Integer>
        implements DeliveryDepartmentService {

    private DeliveryDepartmentRepository repository;

    @Override
    protected CrudRepository<DeliveryDepartment, Integer> getRepository() {
        return repository;
    }

    @Inject
    public void setRepository(DeliveryDepartmentRepository repository) {
        this.repository = repository;
    }

    public void addDepartments(DeliveryCompany company, City city, Integer number) {
        List<DeliveryDepartment> departments = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            DeliveryDepartment department = new DeliveryDepartment();
            department.setCity(city);
            department.setCompany(company);
            department.setNumberOfDepartment(i);
            departments.add(department);
        }
        this.saveList(departments);
    }
}
