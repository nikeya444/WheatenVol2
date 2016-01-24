package ua.dp.wheaten.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;

import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by kkm on 18.01.2016.
 */
public class PartnerIntegerationTest extends AbstractInegrationTest {

    @Autowired
    PartnerRepository repository;

    @Test
    public void findPartnerById() {
        Partner partner = repository.findOne(1);

        assertThat(partner, is(notNullValue()));
        assertThat(partner.getId(), is(1));
        assertThat(partner.getFirstname(), is("Larisa"));
        assertThat(partner.getLastname(), is("Shpak"));
    }

    @Test
    public void saveNewPartner() {
        Partner partner = new Partner();
        partner.setFirstname("Озерка");

        Partner result = repository.save(partner);

        assertThat(result, is(notNullValue()));
        assertThat(result.getId(), is(notNullValue()));
        assertThat(result.getFirstname(), is("Озерка"));

    }

}
