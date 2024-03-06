package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository,InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        outsourcedPartRepository.deleteAll();
        inhousePartRepository.deleteAll();
        //if(outsourcedPartRepository.count()==0){

            OutsourcedPart outsourcedPart1= new OutsourcedPart(1L,"cpu",20.0,5,"Walmart", 1, 10,LocalDate.now());



            OutsourcedPart outsourcedPart2= new OutsourcedPart(2L,"gpu",10.0,120,"Target",1,50,LocalDate.now());


            OutsourcedPart outsourcedPart3= new OutsourcedPart(3L,"ram",90.0,8,"Costco",1,9000,LocalDate.now());


            OutsourcedPart outsourcedPart4= new OutsourcedPart(4L,"ssd",880.0,100000,"Dollar Store",1,80,LocalDate.now());


            OutsourcedPart outsourcedPart5= new OutsourcedPart(5L,"case",60.0,4,"Dollar General",1,45,LocalDate.now());


            InhousePart inhousePart1 = new InhousePart(8L,"case",60.0,4,"Dollar Generalz",1,45,LocalDate.now());

        //}
        if(partRepository.count()==0){
            outsourcedPartRepository.save(outsourcedPart1);
            outsourcedPartRepository.save(outsourcedPart2);
            outsourcedPartRepository.save(outsourcedPart3);
            outsourcedPartRepository.save(outsourcedPart4);
            outsourcedPartRepository.save(outsourcedPart5);
            inhousePartRepository.save(inhousePart1);
        }




        /*
        //OutsourcedPart thePart=null;
        //List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
       //for(OutsourcedPart part:outsourcedParts){
       //     if(part.getName().equals("walmart"))thePart=part;

         */

        //System.out.println(thePart.getCompanyName());

/*        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }*/

        Product laptop= new Product(5L,"laptop",100.0,15,LocalDate.now());
        Product desktop= new Product(6L,"desktop",100.0,15,LocalDate.now());
        Product gamingMachine = new Product(7L,"gaming machine", 350,8,LocalDate.now());
        Product videoEditor = new Product(8L,"video-editing pc", 10000, 3,LocalDate.now());
        Product VR = new Product(9L,"VR-machine",20000,50,LocalDate.now());


        if(productRepository.count()==0){
            productRepository.save(laptop);
            productRepository.save(desktop);
            productRepository.save(gamingMachine);
            productRepository.save(videoEditor);
            productRepository.save(VR);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
