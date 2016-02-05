package ua.dp.wheaten.site.web.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.dp.wheaten.site.root.entities.PersistableObject;
import ua.dp.wheaten.site.root.repositories.impl.DomainObjectRepositoryImpl;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 01.08.15
 * Time: 0:54
 * To change this template use File | Settings | File Templates.
 */

public class DomainObjectDeserializer extends JsonDeserializer<PersistableObject> {

    @Inject
    private DomainObjectRepositoryImpl rep;

    public DomainObjectDeserializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public PersistableObject deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);

        String currentName = jp.getCurrentName();

        String className = currentName.substring(0, 1).toUpperCase()
                + currentName.substring(1, currentName.length() - "Id".length());

        Integer id = node.asInt();

        return rep.getOne(id, className);
    }
}
