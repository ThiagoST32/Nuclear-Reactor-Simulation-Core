package com.projeto.simulacao.FissaoNuclear.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity(name = "reactor_size")
@Table(name = "reactor_size")
@AllArgsConstructor
public class ReactorSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalSize;

    private double diameter;

    private double radius;

    private double wallThickness;

    @OneToOne(mappedBy = "reactorSize")
    @JsonIgnore
    private Reactor reactor;

    public ReactorSize(double totalSize, double diameter, double radius, double wallThickness) {
        this.totalSize = totalSize;
        this.diameter = diameter;
        this.radius = radius;
        this.wallThickness = wallThickness;
    }

    public ReactorSize() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(double totalSize) {
        this.totalSize = totalSize;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getWallThickness() {
        return wallThickness;
    }

    public void setWallThickness(double wallThickness) {
        this.wallThickness = wallThickness;
    }

    public Reactor getReactor() {
        return reactor;
    }

    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
    }
}
