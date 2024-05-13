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
import javax.persistence.Id;
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
@Table(name = "assetcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assetcategory.findAll", query = "SELECT a FROM Assetcategory a"),
    @NamedQuery(name = "Assetcategory.findByAssetcategoryid", query = "SELECT a FROM Assetcategory a WHERE a.assetcategoryid = :assetcategoryid"),
    @NamedQuery(name = "Assetcategory.findByName", query = "SELECT a FROM Assetcategory a WHERE a.name = :name"),
    @NamedQuery(name = "Assetcategory.findByDescription", query = "SELECT a FROM Assetcategory a WHERE a.description = :description"),
    @NamedQuery(name = "Assetcategory.findByStatus", query = "SELECT a FROM Assetcategory a WHERE a.status = :status")})
public class Assetcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "assetcategoryid")
    private Integer assetcategoryid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetcategoryid")
    private Collection<Providedassetitem> providedassetitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetcategoryid")
    private Collection<Assetportfolio> assetportfolioCollection;

    public Assetcategory() {
    }

    public Assetcategory(Integer assetcategoryid) {
        this.assetcategoryid = assetcategoryid;
    }

    public Assetcategory(Integer assetcategoryid, String name, String description, String status) {
        this.assetcategoryid = assetcategoryid;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Integer getAssetcategoryid() {
        return assetcategoryid;
    }

    public void setAssetcategoryid(Integer assetcategoryid) {
        this.assetcategoryid = assetcategoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient
    public Collection<Providedassetitem> getProvidedassetitemCollection() {
        return providedassetitemCollection;
    }

    public void setProvidedassetitemCollection(Collection<Providedassetitem> providedassetitemCollection) {
        this.providedassetitemCollection = providedassetitemCollection;
    }

    @XmlTransient
    public Collection<Assetportfolio> getAssetportfolioCollection() {
        return assetportfolioCollection;
    }

    public void setAssetportfolioCollection(Collection<Assetportfolio> assetportfolioCollection) {
        this.assetportfolioCollection = assetportfolioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetcategoryid != null ? assetcategoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assetcategory)) {
            return false;
        }
        Assetcategory other = (Assetcategory) object;
        if ((this.assetcategoryid == null && other.assetcategoryid != null) || (this.assetcategoryid != null && !this.assetcategoryid.equals(other.assetcategoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Assetcategory[ assetcategoryid=" + assetcategoryid + " ]";
    }
    
}
