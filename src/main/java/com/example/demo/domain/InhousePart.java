package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

    public InhousePart(long id, String name, double price, int inv, int partId, Integer MinInventory, Integer MaxInventory) {
        super(id, name, price, inv);
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
