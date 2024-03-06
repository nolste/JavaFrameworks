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
@DiscriminatorValue("1")
public class InhousePart extends Part{
    int partId;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    String companyName;

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    LocalDate dateAdded;

    public InhousePart() {
    }

    public InhousePart(long id, String name, double price, int inv, String companyName, Integer minInventory, Integer maxInventory, LocalDate dateAdded) {
        super(id, name, price, inv,minInventory,maxInventory, dateAdded);
        this.companyName=companyName;
        this.minInventory=minInventory;
        this.maxInventory=maxInventory;
        this.dateAdded=dateAdded;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
