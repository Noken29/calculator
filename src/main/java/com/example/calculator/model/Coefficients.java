package com.example.calculator.model;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coefficients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String a, b, c;
    private final String result;

    public Coefficients(String a, String b, String c, String result) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.result = result;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getResult() {
        return result;
    }
}
