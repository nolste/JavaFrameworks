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

    public InhousePart() {
    }

    public InhousePart(long id, String name, double price, int inv, int partId, Integer MinInventory, Integer MaxInventory, LocalDate dateAdded) {
        super(id, name, price, inv,MinInventory,MaxInventory, dateAdded);
        this.minInventory=MinInventory;
        this.maxInventory=MaxInventory;
        this.partId = partId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
