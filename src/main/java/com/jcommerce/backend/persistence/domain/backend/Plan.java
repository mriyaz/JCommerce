package com.jcommerce.backend.persistence.domain.backend;

import com.jcommerce.enums.PlansEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Riyazuddin M on 5/1/2017.
 */
@Entity
public class Plan implements Serializable {

    /*The Serial Version UID constant for Serializable classes*/
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String name;

    /*Default Constructor*/
    public Plan(){}

    public Plan(PlansEnum plansEnum) {
        this.id = plansEnum.getId();
        this.name = plansEnum.getPlanName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        return id == plan.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
