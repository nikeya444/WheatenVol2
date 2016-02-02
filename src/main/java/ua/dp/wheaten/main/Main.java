package ua.dp.wheaten.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.dp.wheaten.config.RootContextConfiguration;
import ua.dp.wheaten.site.root.dto.Remnant;
import ua.dp.wheaten.site.root.entities.Document;
import ua.dp.wheaten.site.root.entities.DocumentDetail;


import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.repositories.DocumentRepository;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;
import ua.dp.wheaten.site.root.repositories.ProductRepository;
import ua.dp.wheaten.site.root.repositories.StorageRepository;
import ua.dp.wheaten.site.root.services.DocumentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by kkm on 25.01.2016.
 */
public class Main {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootContextConfiguration.class);
    static DocumentService documentService = applicationContext.getBean(DocumentService.class);
    static DocumentRepository documentRepository = applicationContext.getBean(DocumentRepository.class);
    static ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
    static PartnerRepository partnerRepository = applicationContext.getBean(PartnerRepository.class);
    static StorageRepository storageRepository = applicationContext.getBean(StorageRepository.class);


    public static void main(String[] args) {
        //saveNewDocument();
        //getAllDocuments();
        //moveOperation();
        //findDocumentsByProduct();
        //productQuantitySum();
        //getAllRemnantsWithStorages();
        //getAveragePrice();
        findAllByDateAndStatus();


        //System.out.println("EPOCH " + new Ins);
    }

    static void saveNewDocument() {
        Document document = new Document();

        DocumentDetail cogniac = new DocumentDetail();
        cogniac.setProduct(productRepository.findOne(2));
        cogniac.setQuantity(5);
        cogniac.setSum(new BigDecimal(1400));
        cogniac.setStorage(storageRepository.findOne(1));

        DocumentDetail vodka = new DocumentDetail();
        vodka.setProduct(productRepository.findOne(1));
        vodka.setQuantity(20);
        vodka.setSum(new BigDecimal(5800));
        vodka.setStorage(storageRepository.findOne(1));

        document.setDocumentType(Document.Type.SALE);
        document.setStatus(false);
        document.setDateOfDocument(LocalDate.now());
        document.setPartner(partnerRepository.findOne(4));
        document.addDetail(cogniac);
        document.addDetail(vodka);


        documentService.save(document);
    }

    static void getAllDocuments() {
        List<Document> documents = documentRepository.findAllByStatusAndDateOfDocumentBetween(true, LocalDate.now(), LocalDate.now().plusDays(2));
        System.out.println(documents.size());
        for (Document document: documents) {
            System.out.println(document.getDetails().size());
        }
    }

    static void moveOperation() {
        Document from = documentRepository.findOne(1);

        Document move = new Document();
        move.setPartner(partnerRepository.findOne(5));
        move.setDateOfDocument(LocalDate.now());
        move.setDocumentType(Document.Type.MOVEMENT);
        move.setStatus(false);

        DocumentDetail out = new DocumentDetail();
        DocumentDetail in = new DocumentDetail();

        out.setProduct(from.getDetails().get(0).getProduct());
        in.setProduct(from.getDetails().get(0).getProduct());

        out.setQuantity(70);
        in.setQuantity(70);

        out.setStorage(from.getDetails().get(0).getStorage());
        in.setStorage(storageRepository.findOne(2));

        out.setSum(from.getDetails().get(0).getSum().divide(new BigDecimal(100), 2).multiply(new BigDecimal(70)));
        in.setSum(from.getDetails().get(0).getSum().divide(new BigDecimal(100), 2).multiply(new BigDecimal(70)));

        move.addDetail(out);
        move.addDetail(in);

        documentRepository.save(move);
    }

    static void findDocumentsByProduct() {
        Product product = productRepository.findOne(1);
        List<Document> documents = documentRepository.findByDetailsProduct(product);
        System.out.println(documents.size());
    }

    static void productQuantitySum() {
        Product vodka = productRepository.findOne(1);
        BigDecimal sum = documentRepository.findTotalQuantityOfProduct(vodka);
        System.out.println(sum);
    }

    static void getAllRemnants() {
        List<Remnant> remnants = documentRepository.getAllProductRemnants();
        for (Remnant remnant: remnants) {
            System.out.println(remnant.getProduct() + " = " + remnant.getQuantity());
        }
    }

    static void getAllRemnantsWithStorages() {
        List<Remnant> remnants = documentRepository.getAllProductRemnantsInStorages();
        for (Remnant remnant: remnants) {
            System.out.println(remnant.getProduct().getName() + " " + remnant.getStorage().getName() + " " + " = " + remnant.getQuantity());
        }
    }

    static void getAveragePrice() {
        BigDecimal result = documentRepository.calculateAveragePrice(productRepository.findOne(1), Document.Type.SALE);
        System.out.println(result);
    }

    static void findAllByDateAndStatus() {
        LocalDate localDate = LocalDate.now();
        LocalDate from = LocalDate.of(localDate.getYear(), localDate.getMonth().minus(1), 1);
        LocalDate to = LocalDate.of(localDate.getYear(), localDate.getMonth().minus(1), localDate.getMonth().minus(1).maxLength());
        List<Document> documents = documentRepository.findAllByDateBetween(from, to);
        System.out.println(documents);
    }

}
