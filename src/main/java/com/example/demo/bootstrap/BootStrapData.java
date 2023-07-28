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


        OutsourcedPart outsourcedPart1= new OutsourcedPart(1L,"bike seat",20.0,5,"Walmart");
        outsourcedPartRepository.save(outsourcedPart1);


        OutsourcedPart outsourcedPart2= new OutsourcedPart(2L,"handle bar",10.0,120,"Target");
        outsourcedPartRepository.save(outsourcedPart2);

        OutsourcedPart outsourcedPart3= new OutsourcedPart(3L,"pedal",90.0,8,"Costco");
        outsourcedPartRepository.save(outsourcedPart3);

        OutsourcedPart outsourcedPart4= new OutsourcedPart(4L,"wheel set",880.0,100000,"Dollar Store");
        outsourcedPartRepository.save(outsourcedPart4);

        OutsourcedPart outsourcedPart5= new OutsourcedPart(5L,"grips",60.0,4,"Dollar General");
        outsourcedPartRepository.save(outsourcedPart5);



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

        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        Product tricycle = new Product("tricycle", 350,8);
        Product mountainBike = new Product("mountain bike", 10000, 3);
        Product eBike = new Product("eBike",20000,50);


        if(productRepository.count()==0){
            productRepository.save(bicycle);
            productRepository.save(unicycle);
            productRepository.save(tricycle);
            productRepository.save(mountainBike);
            productRepository.save(eBike);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
