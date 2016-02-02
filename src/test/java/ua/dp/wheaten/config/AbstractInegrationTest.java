package ua.dp.wheaten.config;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.dp.wheaten.site.root.entities.Product;

import ua.dp.wheaten.site.root.repositories.PartnerRepository;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.root.repositories.StorageRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.transaction.Transactional;

/**
 * Created by kkm on 18.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootContextConfiguration.class)
@Transactional
public abstract class AbstractInegrationTest {

    @Resource(name = "dataSource")
    DataSource dataSource;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PartnerRepository partnerRepository;


   // @Before
    public void populateDatabase() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("data.sql"));
        DatabasePopulatorUtils.execute(populator, dataSource);
    }

}
