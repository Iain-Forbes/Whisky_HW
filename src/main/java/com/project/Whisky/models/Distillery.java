package com.project.Whisky.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Distilleries")
public class Distillery {

    @Column
    private String name;

    @Column
    private String region;

    @OneToMany(mappedBy = "Distillery")
    private List<Whisky> Whiskys;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Distillery(String name, String region) {
        this.name = name;
        this.region = region;
        Whiskys = new ArrayList<>();

    }

    public Distillery() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Whisky> getWhiskys() {
        return Whiskys;
    }

    public void setWhiskys(List<Whisky> whiskys) {
        Whiskys = whiskys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
