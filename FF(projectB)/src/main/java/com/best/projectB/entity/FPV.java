package com.best.projectB.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="fpv_01")
public class FPV {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String fc;

    private String existed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getExisted() {
        return existed;
    }

    public void setExisted(String existed) {
        this.existed = existed;
    }

    @Override
    public String toString() {
        return "FPV{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fc='" + fc + '\'' +
                ", existed='" + existed + '\'' +
                '}';
    }
}
