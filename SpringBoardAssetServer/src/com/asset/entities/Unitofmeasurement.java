/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "unitofmeasurement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unitofmeasurement.findAll", query = "SELECT u FROM Unitofmeasurement u"),
    @NamedQuery(name = "Unitofmeasurement.findByUnitofmeasurementid", query = "SELECT u FROM Unitofmeasurement u WHERE u.unitofmeasurementid = :unitofmeasurementid"),
    @NamedQuery(name = "Unitofmeasurement.findByUnit", query = "SELECT u FROM Unitofmeasurement u WHERE u.unit = :unit"),
    @NamedQuery(name = "Unitofmeasurement.findBySymbol", query = "SELECT u FROM Unitofmeasurement u WHERE u.symbol = :symbol"),
    @NamedQuery(name = "Unitofmeasurement.findByStatus", query = "SELECT u FROM Unitofmeasurement u WHERE u.status = :status")})
public class Unitofmeasurement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unitofmeasurementid")
    private Integer unitofmeasurementid;
    @Basic(optional = false)
    @Column(name = "unit")
    private String unit;
    @Basic(optional = false)
    @Column(name = "symbol")
    private String symbol;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Unitofmeasurement() {
    }

    public Unitofmeasurement(Integer unitofmeasurementid) {
        this.unitofmeasurementid = unitofmeasurementid;
    }

    public Unitofmeasurement(Integer unitofmeasurementid, String unit, String symbol, String status) {
        this.unitofmeasurementid = unitofmeasurementid;
        this.unit = unit;
        this.symbol = symbol;
        this.status = status;
    }

    public Integer getUnitofmeasurementid() {
        return unitofmeasurementid;
    }

    public void setUnitofmeasurementid(Integer unitofmeasurementid) {
        this.unitofmeasurementid = unitofmeasurementid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitofmeasurementid != null ? unitofmeasurementid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unitofmeasurement)) {
            return false;
        }
        Unitofmeasurement other = (Unitofmeasurement) object;
        if ((this.unitofmeasurementid == null && other.unitofmeasurementid != null) || (this.unitofmeasurementid != null && !this.unitofmeasurementid.equals(other.unitofmeasurementid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Unitofmeasurement[ unitofmeasurementid=" + unitofmeasurementid + " ]";
    }
    
}
