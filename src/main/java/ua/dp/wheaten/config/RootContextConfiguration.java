package ua.dp.wheaten.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.dp.wheaten.site.root.helpers.AutowireHelper;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 04.05.15
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "ua.dp.wheaten.site.root.repositories",
        entityManagerFactoryRef = "entityManagerFactoryBean",
        transactionManagerRef = "jpaTransactionManager"
)
@ComponentScan(
        basePackages = "ua.dp.wheaten.site.root"
)
public class RootContextConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/wheaten_vol_2");
      /*  JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource("jdbc/wheaten_vol_2"); */
        return dataSource;
    }

    @Bean
    public DataSource hsqlDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        Map<String, Object> properties = new Hashtable<>();
        properties.put("javax.persistence.schema-generation.database.action",
                "none");
        properties.put("hibernate.show_sql", "true");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");


        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(this.dataSource());
        factory.setPackagesToScan("ua.dp.wheaten.site.root.entities");
        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factory.setValidationMode(ValidationMode.NONE);
        factory.setJpaPropertyMap(properties);
        return factory;
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager() {
        return new JpaTransactionManager(
                this.entityManagerFactoryBean().getObject());
    }

    @Bean
    public AutowireHelper autowireHelper() {
        return new AutowireHelper();
    }

    /*@Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.
    }                  */
}
