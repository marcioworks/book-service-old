package com.example.bookservice.response;

import javax.persistence.*;
import java.io.Serializable;


public class Cambio implements Serializable {

    private static final long serialVersionUID= 1L;

    private Long id;

    private String from;

    private String to;

    private Double conversionFactor;

    private Double convertedValue;


    private String environment;

    public Cambio(){}

    public Cambio(Long id, String from, String to, Double conversionFactor, Double convertedValue, String enviroment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = enviroment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnviroment() {
        return environment;
    }

    public void setEnviroment(String enviroment) {
        this.environment = enviroment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cambio cambio = (Cambio) o;

        return id != null ? id.equals(cambio.id) : cambio.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
