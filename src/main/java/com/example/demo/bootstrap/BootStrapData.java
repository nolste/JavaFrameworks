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

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        outsourcedPartRepository.deleteAll();
        //if(outsourcedPartRepository.count()==0){

            OutsourcedPart outsourcedPart1= new OutsourcedPart(1L,"cpu",20.0,5,"Walmart", 1, 10,LocalDate.now());
            outsourcedPartRepository.save(outsourcedPart1);


            OutsourcedPart outsourcedPart2= new OutsourcedPart(2L,"gpu",10.0,120,"Target",1,50,LocalDate.now());
            outsourcedPartRepository.save(outsourcedPart2);

            OutsourcedPart outsourcedPart3= new OutsourcedPart(3L,"ram",90.0,8,"Costco",1,9000,LocalDate.now());
            outsourcedPartRepository.save(outsourcedPart3);

            OutsourcedPart outsourcedPart4= new OutsourcedPart(4L,"ssd",880.0,100000,"Dollar Store",1,80,LocalDate.now());
            outsourcedPartRepository.save(outsourcedPart4);

            OutsourcedPart outsourcedPart5= new OutsourcedPart(5L,"case",60.0,4,"Dollar General",1,45,LocalDate.now());
            outsourcedPartRepository.save(outsourcedPart5);
        //}




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

        Product laptop= new Product("laptop",100.0,15);
        Product desktop= new Product("desktop",100.0,15);
        Product gamingMachine = new Product("gaming machine", 350,8);
        Product videoEditor = new Product("video-editing pc", 10000, 3);
        Product VR = new Product("VR-machine",20000,50);


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
