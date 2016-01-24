package ua.dp.wheaten.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.dp.wheaten.site.root.entities.IncomingDetail;
import ua.dp.wheaten.site.root.entities.IncomingDocument;
import ua.dp.wheaten.site.root.repositories.IncomingDocumentRepository;
import ua.dp.wheaten.site.root.repositories.StorageRepository;
import ua.dp.wheaten.site.root.services.IncomingDocumentService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by kkm on 18.01.2016.
 */
public class IncomingDocumentIntegrationTest extends AbstractInegrationTest {

    static Integer id;

    @Autowired
    IncomingDocumentRepository documentRepository;
    @Resource(name = "indoc")
    IncomingDocumentService documentService;

 //   @Test
    public void findsIncomingDocumentById() {
        IncomingDocument document = documentRepository.findOne(1);

        assertThat(document, is(notNullValue()));
        assertThat(document.getId(), is(1));
        assertThat(document.getUsername(), is("kkm"));
        assertThat(document.getDetails().size(), is(1));
    }

    @Test
    public void saveNewDocument() {

        IncomingDetail detail1 = new IncomingDetail();
        detail1.setProduct(productRepository.findOne(1));
        detail1.setSum(new BigDecimal(20000));
        detail1.setQuantity(100);
        detail1.setStorageTo(storageRepository.findOne(2));


        IncomingDetail detail2 = new IncomingDetail();
        detail2.setProduct(productRepository.findOne(3));
        detail2.setQuantity(50);
        detail2.setSum(new BigDecimal(9250));
        detail2.setStorageTo(storageRepository.findOne(2));


        IncomingDocument document = new IncomingDocument();

        document.setDateOfDocument(new Date());
        document.setDocumentType(documentTypeRepository.findByType("Покупка"));
        document.setPartner(partnerRepository.findOne(2));
        document.addDetail(detail1);
        document.addDetail(detail2);
        documentService.save(document);

        IncomingDocument result = documentRepository.findOne(document.getId());

        assertThat(result.getDetails().size(), is(2));


    }
}
