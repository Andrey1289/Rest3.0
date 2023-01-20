package com.andrey.rest.entity;

import javax.persistence.*;

@Entity
@Table(name = "Attraction")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nameAttraction;
    @Column
    private String dateOfConstruction;
    @Column
    private String description;
    @Column
    @Enumerated(EnumType.STRING)
    private TypeAttraction typeAttraction;
    @Column
    private Long city_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id" ,insertable=false, updatable=false)
    private City city;

    public Attraction() {
    }

    public Attraction(Long id, String nameAttraction, String dateOfConstruction, String description, TypeAttraction typeAttraction, Long city_id) {
        this.id = id;
        this.nameAttraction = nameAttraction;
        this.dateOfConstruction = dateOfConstruction;
        this.description = description;
        this.typeAttraction = typeAttraction;
        this.city_id = city_id;
    }

    public City getCity() {
        return city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAttraction() {
        return nameAttraction;
    }

    public void setNameAttraction(String nameAttraction) {
        this.nameAttraction = nameAttraction;
    }

    public String getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(String dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeAttraction getTypeAttraction() {
        return typeAttraction;
    }

    public void setTypeAttraction(TypeAttraction typeAttraction) {
        this.typeAttraction = typeAttraction;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", nameAttraction='" + nameAttraction + '\'' +
                ", dateOfConstruction='" + dateOfConstruction + '\'' +
                ", description='" + description + '\'' +
                ", typeAttraction=" + typeAttraction +
                ", city_id=" + city_id +
                '}';
    }
}
