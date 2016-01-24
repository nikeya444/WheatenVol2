package ua.dp.wheaten.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.dp.wheaten.config.RootContextConfiguration;
import ua.dp.wheaten.site.root.entities.*;
import ua.dp.wheaten.site.root.repositories.*;
import ua.dp.wheaten.site.root.services.IncomingDocumentService;
import ua.dp.wheaten.site.root.services.OutgoingDocumentService;
import ua.dp.wheaten.site.root.services.impl.OutgoingDocumentServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by kkm on 19.01.2016.
 */
public class Main {

    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootContextConfiguration.class);;
    static IncomingDocumentService incomingDocumentService = (IncomingDocumentService) applicationContext.getBean("indoc");
    static IncomingDocumentRepository incomingDocumentRepository = applicationContext.getBean(IncomingDocumentRepository.class);

    static OutgoingDocumentRepository outgoingDocumentRepository = applicationContext.getBean(OutgoingDocumentRepository.class);
    static OutgoingDocumentService outgoingDocumentService = applicationContext.getBean(OutgoingDocumentService.class);

    public static void main(String[] args) {
        //saveNewIncomingDocument();
        //getAllIncomingDocuments();
        // saveNewOutDocument();
        updateStatus();
    }

    public static void saveNewIncomingDocument() {

        IncomingDetail detail1 = new IncomingDetail();
        detail1.setProduct(applicationContext.getBean(ProductRepository.class).findOne(1));
        detail1.setSum(new BigDecimal(24000));
        detail1.setQuantity(120);
        detail1.setStorageTo(applicationContext.getBean(StorageRepository.class).findOne(2));


    /*    IncomingDetail detail2 = new IncomingDetail();
        detail2.setProduct(applicationContext.getBean(ProductRepository.class).findOne(2));
        detail2.setQuantity(100);
        detail2.setSum(new BigDecimal(18500));
        detail2.setStorageTo(applicationContext.getBean(StorageRepository.class).findOne(2));
    */

        IncomingDocument document = new IncomingDocument();

        document.setDateOfDocument(new Date());
        document.setDocumentType(applicationContext.getBean(DocumentTypeRepository.class).findByType("Покупка"));
        document.setPartner(applicationContext.getBean(PartnerRepository.class).findOne(1));
        document.addDetail(detail1);
    //    document.addDetail(detail2);

        IncomingDocumentService incomingDocumentService = (IncomingDocumentService) applicationContext.getBean("indoc");
        incomingDocumentService.save(document);
    }

    public static void saveNewOutDocument() {
        Product vodka = applicationContext.getBean(ProductRepository.class).findOne(1);
        Product cogniac = applicationContext.getBean(ProductRepository.class).findOne(2);
        Storage toliati = applicationContext.getBean(StorageRepository.class).findOne(2);
        Partner sechkarev = applicationContext.getBean(PartnerRepository.class).findOne(3);
        DocumentType sale = applicationContext.getBean(DocumentTypeRepository.class).findOne(2);


        OutgoingDetail vodkaDetail = new OutgoingDetail();
        vodkaDetail.setProduct(vodka);
        vodkaDetail.setQuantity(25);
        vodkaDetail.setSum(new BigDecimal(7000));
        vodkaDetail.setStorageFrom(toliati);

        OutgoingDetail cogniacDetail = new OutgoingDetail();
        cogniacDetail.setProduct(cogniac);
        cogniacDetail.setSum(new BigDecimal(2025));
        cogniacDetail.setQuantity(9);
        cogniacDetail.setStorageFrom(toliati);

        OutgoingDocument document = new OutgoingDocument();
        document.setDateOfDocument(new Date());
        document.setPartner(sechkarev);
        document.setDocumentType(sale);

        document.addDetail(vodkaDetail);
        document.addDetail(cogniacDetail);

        outgoingDocumentService.save(document);
    }

    public static void updateStatus() {

     //   incomingDocumentService.updateStatus(7, (byte) 1);
        outgoingDocumentService.updateStatus(1, (byte) 1);

    }

    public static void getAllIncomingDocuments() {
        List<IncomingDocument> documents;
      //  documents = incomingDocumentService.getAll();
        documents = incomingDocumentRepository.findAllPosted((byte) 1);
        System.out.println("Documents size: " + documents.size());
        System.out.println(documents);
    }
}
