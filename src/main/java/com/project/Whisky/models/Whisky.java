package com.project.Whisky.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Whiskys")
public class Whisky {

    @Column
    private String name;

    @JsonIgnoreProperties("distillery")
    @ManyToOne
    @JoinColumn(name = "distillery_id", nullable = false)
    private Distillery distillery;

    @Column
    private int year;

    @Column
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Whisky(String name,  int age, int year,  Distillery distillery) {
        this.name = name;
        this.distillery = distillery;
        this.year = year;
        this.age = age;
    }

    public Whisky() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distillery getDistillery() {
        return distillery;
    }

    public void setDistillery(Distillery distillery) {
        this.distillery = distillery;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
