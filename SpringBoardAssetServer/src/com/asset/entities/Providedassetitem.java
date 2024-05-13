/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "providedassetitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Providedassetitem.findAll", query = "SELECT p FROM Providedassetitem p"),
    @NamedQuery(name = "Providedassetitem.findByProvidedassetitemid", query = "SELECT p FROM Providedassetitem p WHERE p.providedassetitemid = :providedassetitemid"),
    @NamedQuery(name = "Providedassetitem.findByServiceitemassetitemid", query = "SELECT p FROM Providedassetitem p WHERE p.serviceitemassetitemid = :serviceitemassetitemid"),
    @NamedQuery(name = "Providedassetitem.findByUnitprice", query = "SELECT p FROM Providedassetitem p WHERE p.unitprice = :unitprice"),
    @NamedQuery(name = "Providedassetitem.findByQuantitysupplied", query = "SELECT p FROM Providedassetitem p WHERE p.quantitysupplied = :quantitysupplied"),
    @NamedQuery(name = "Providedassetitem.findByUsedquantity", query = "SELECT p FROM Providedassetitem p WHERE p.usedquantity = :usedquantity"),
    @NamedQuery(name = "Providedassetitem.findByFaultyquantity", query = "SELECT p FROM Providedassetitem p WHERE p.faultyquantity = :faultyquantity"),
    @NamedQuery(name = "Providedassetitem.findByDatesupplied", query = "SELECT p FROM Providedassetitem p WHERE p.datesupplied = :datesupplied"),
    @NamedQuery(name = "Providedassetitem.findByTimesupplied", query = "SELECT p FROM Providedassetitem p WHERE p.timesupplied = :timesupplied"),
    @NamedQuery(name = "Providedassetitem.findByReceivedby", query = "SELECT p FROM Providedassetitem p WHERE p.receivedby = :receivedby"),
    @NamedQuery(name = "Providedassetitem.findByStatus", query = "SELECT p FROM Providedassetitem p WHERE p.status = :status")})
public class Providedassetitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "providedassetitemid")
    private Long providedassetitemid;
    @Basic(optional = false)
    @Column(name = "serviceitemassetitemid")
    private int serviceitemassetitemid;
    @Basic(optional = false)
    @Column(name = "unitprice")
    private String unitprice;
    @Basic(optional = false)
    @Column(name = "quantitysupplied")
    private String quantitysupplied;
    @Column(name = "usedquantity")
    private String usedquantity;
    @Basic(optional = false)
    @Column(name = "faultyquantity")
    private String faultyquantity;
    @Basic(optional = false)
    @Column(name = "datesupplied")
    private String datesupplied;
    @Basic(optional = false)
    @Column(name = "timesupplied")
    private String timesupplied;
    @Basic(optional = false)
    @Column(name = "receivedby")
    private int receivedby;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemid")
    private Collection<Problem> problemCollection;
    @JoinColumn(name = "providedassetid", referencedColumnName = "providedassetid")
    @ManyToOne(optional = false)
    private Providedasset providedassetid;
    @JoinColumn(name = "assetcategoryid", referencedColumnName = "assetcategoryid")
    @ManyToOne(optional = false)
    private Assetcategory assetcategoryid;
    @JoinColumn(name = "assetitemid", referencedColumnName = "assetitemid")
    @ManyToOne(optional = false)
    private Assetitem assetitemid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetitemid")
    private Collection<Serviceitemassetitem> serviceitemassetitemCollection;

    public Providedassetitem() {
    }

    public Providedassetitem(Long providedassetitemid) {
        this.providedassetitemid = providedassetitemid;
    }

    public Providedassetitem(Long providedassetitemid, int serviceitemassetitemid, String unitprice, String quantitysupplied, String faultyquantity, String datesupplied, String timesupplied, int receivedby, String status) {
        this.providedassetitemid = providedassetitemid;
        this.serviceitemassetitemid = serviceitemassetitemid;
        this.unitprice = unitprice;
        this.quantitysupplied = quantitysupplied;
        this.faultyquantity = faultyquantity;
        this.datesupplied = datesupplied;
        this.timesupplied = timesupplied;
        this.receivedby = receivedby;
        this.status = status;
    }

    public Long getProvidedassetitemid() {
        return providedassetitemid;
    }

    public void setProvidedassetitemid(Long providedassetitemid) {
        this.providedassetitemid = providedassetitemid;
    }

    public int getServiceitemassetitemid() {
        return serviceitemassetitemid;
    }

    public void setServiceitemassetitemid(int serviceitemassetitemid) {
        this.serviceitemassetitemid = serviceitemassetitemid;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getQuantitysupplied() {
        return quantitysupplied;
    }

    public void setQuantitysupplied(String quantitysupplied) {
        this.quantitysupplied = quantitysupplied;
    }

    public String getUsedquantity() {
        return usedquantity;
    }

    public void setUsedquantity(String usedquantity) {
        this.usedquantity = usedquantity;
    }

    public String getFaultyquantity() {
        return faultyquantity;
    }

    public void setFaultyquantity(String faultyquantity) {
        this.faultyquantity = faultyquantity;
    }

    public String getDatesupplied() {
        return datesupplied;
    }

    public void setDatesupplied(String datesupplied) {
        this.datesupplied = datesupplied;
    }

    public String getTimesupplied() {
        return timesupplied;
    }

    public void setTimesupplied(String timesupplied) {
        this.timesupplied = timesupplied;
    }

    public int getReceivedby() {
        return receivedby;
    }

    public void setReceivedby(int receivedby) {
        this.receivedby = receivedby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Problem> getProblemCollection() {
        return problemCollection;
    }

    public void setProblemCollection(Collection<Problem> problemCollection) {
        this.problemCollection = problemCollection;
    }

    public Providedasset getProvidedassetid() {
        return providedassetid;
    }

    public void setProvidedassetid(Providedasset providedassetid) {
        this.providedassetid = providedassetid;
    }

    public Assetcategory getAssetcategoryid() {
        return assetcategoryid;
    }

    public void setAssetcategoryid(Assetcategory assetcategoryid) {
        this.assetcategoryid = assetcategoryid;
    }

    public Assetitem getAssetitemid() {
        return assetitemid;
    }

    public void setAssetitemid(Assetitem assetitemid) {
        this.assetitemid = assetitemid;
    }

    @XmlTransient
    public Collection<Serviceitemassetitem> getServiceitemassetitemCollection() {
        return serviceitemassetitemCollection;
    }

    public void setServiceitemassetitemCollection(Collection<Serviceitemassetitem> serviceitemassetitemCollection) {
        this.serviceitemassetitemCollection = serviceitemassetitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providedassetitemid != null ? providedassetitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Providedassetitem)) {
            return false;
        }
        Providedassetitem other = (Providedassetitem) object;
        if ((this.providedassetitemid == null && other.providedassetitemid != null) || (this.providedassetitemid != null && !this.providedassetitemid.equals(other.providedassetitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Providedassetitem[ providedassetitemid=" + providedassetitemid + " ]";
    }
    
}
