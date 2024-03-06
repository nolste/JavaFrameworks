package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {
    }

/*    public OutsourcedPart(long id, String name, double price, int inv, String companyName, Integer minInventory) {
        super(id, name, price, inv, minInventory);
        this.companyName = companyName;
    }*/

    public OutsourcedPart(long id, String name, double price, int inv, String companyName, Integer minInventory, Integer maxInventory, LocalDate dateAdded) {
        super(id, name, price, inv, minInventory, maxInventory,dateAdded);
        this.companyName = companyName;
    }
/*    public OutsourcedPart(long id, String name, double price, int inv, String companyName) {
        super(id, name, price, inv);
        this.companyName = companyName;
    }*/

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
