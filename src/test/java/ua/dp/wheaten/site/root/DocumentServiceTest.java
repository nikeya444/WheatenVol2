package ua.dp.wheaten.site.root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentDetail;
import ua.dp.wheaten.site.root.services.DocumentService;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

/**
 * Created by kkm on 06.05.2016.
 */
public class DocumentServiceTest extends AbstractIntegrationTest {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    DocumentService documentService;


    @Rollback(value = false)
    public void testUpdate() {
        DocumentDetail detail = new DocumentDetail(productRepository.findOne(1), 100, new BigDecimal(20000), storageRepository.findOne(1));
        LocalDate dateOfDocument = LocalDate.of(2016, 4, 8);
        Document source =
                new Document(
                        Document.Type.PURCHASE,
                        partnerRepository.findOne(1),
                        true,
                        dateOfDocument,
                        Collections.singletonList(detail)
                );
        documentService.update(2, source);
        logger.debug(source);

    }


    @Rollback(value = false)
    public void testCreate() {
        DocumentDetail detail = new DocumentDetail(productRepository.findOne(2), 50, new BigDecimal(9500), storageRepository.findOne(1));
        Document document = new Document(Document.Type.PURCHASE, partnerRepository.findOne(1), false, LocalDate.now(), Collections.singletonList(detail));
        documentService.save(document);
        System.err.println(document.getId());
    }


    @Rollback(value = false)
    public void testDelete() {
        documentService.delete(5);
    }


    public void testRead() {
        Document document = documentService.getOne(1);
        Assert.assertEquals(2, document.getDetails().size());
    }
}
