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
@Table(name = "assetportfolio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assetportfolio.findAll", query = "SELECT a FROM Assetportfolio a"),
    @NamedQuery(name = "Assetportfolio.findByAssetportfolioid", query = "SELECT a FROM Assetportfolio a WHERE a.assetportfolioid = :assetportfolioid"),
    @NamedQuery(name = "Assetportfolio.findByAssetname", query = "SELECT a FROM Assetportfolio a WHERE a.assetname = :assetname"),
    @NamedQuery(name = "Assetportfolio.findByMarketname", query = "SELECT a FROM Assetportfolio a WHERE a.marketname = :marketname"),
    @NamedQuery(name = "Assetportfolio.findByManufacturer", query = "SELECT a FROM Assetportfolio a WHERE a.manufacturer = :manufacturer"),
    @NamedQuery(name = "Assetportfolio.findByDescription", query = "SELECT a FROM Assetportfolio a WHERE a.description = :description"),
    @NamedQuery(name = "Assetportfolio.findByStatus", query = "SELECT a FROM Assetportfolio a WHERE a.status = :status")})
public class Assetportfolio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assetportfolioid")
    private Integer assetportfolioid;
    @Basic(optional = false)
    @Column(name = "assetname")
    private String assetname;
    @Basic(optional = false)
    @Column(name = "marketname")
    private String marketname;
    @Basic(optional = false)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "assetcategoryid", referencedColumnName = "assetcategoryid")
    @ManyToOne(optional = false)
    private Assetcategory assetcategoryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetportfolioid")
    private Collection<Providedasset> providedassetCollection;

    public Assetportfolio() {
    }

    public Assetportfolio(Integer assetportfolioid) {
        this.assetportfolioid = assetportfolioid;
    }

    public Assetportfolio(Integer assetportfolioid, String assetname, String marketname, String manufacturer, String description, String status) {
        this.assetportfolioid = assetportfolioid;
        this.assetname = assetname;
        this.marketname = marketname;
        this.manufacturer = manufacturer;
        this.description = description;
        this.status = status;
    }

    public Integer getAssetportfolioid() {
        return assetportfolioid;
    }

    public void setAssetportfolioid(Integer assetportfolioid) {
        this.assetportfolioid = assetportfolioid;
    }

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Assetcategory getAssetcategoryid() {
        return assetcategoryid;
    }

    public void setAssetcategoryid(Assetcategory assetcategoryid) {
        this.assetcategoryid = assetcategoryid;
    }

    @XmlTransient
    public Collection<Providedasset> getProvidedassetCollection() {
        return providedassetCollection;
    }

    public void setProvidedassetCollection(Collection<Providedasset> providedassetCollection) {
        this.providedassetCollection = providedassetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetportfolioid != null ? assetportfolioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assetportfolio)) {
            return false;
        }
        Assetportfolio other = (Assetportfolio) object;
        if ((this.assetportfolioid == null && other.assetportfolioid != null) || (this.assetportfolioid != null && !this.assetportfolioid.equals(other.assetportfolioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Assetportfolio[ assetportfolioid=" + assetportfolioid + " ]";
    }
    
}
