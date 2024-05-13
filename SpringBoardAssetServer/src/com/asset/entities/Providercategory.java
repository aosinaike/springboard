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
@Table(name = "providercategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Providercategory.findAll", query = "SELECT p FROM Providercategory p"),
    @NamedQuery(name = "Providercategory.findByProvidercategoryid", query = "SELECT p FROM Providercategory p WHERE p.providercategoryid = :providercategoryid"),
    @NamedQuery(name = "Providercategory.findByName", query = "SELECT p FROM Providercategory p WHERE p.name = :name"),
    @NamedQuery(name = "Providercategory.findByStatus", query = "SELECT p FROM Providercategory p WHERE p.status = :status")})
public class Providercategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "providercategoryid")
    private Integer providercategoryid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providercategoryid")
    private Collection<Provider> providerCollection;

    public Providercategory() {
    }

    public Providercategory(Integer providercategoryid) {
        this.providercategoryid = providercategoryid;
    }

    public Providercategory(Integer providercategoryid, String name, String status) {
        this.providercategoryid = providercategoryid;
        this.name = name;
        this.status = status;
    }

    public Integer getProvidercategoryid() {
        return providercategoryid;
    }

    public void setProvidercategoryid(Integer providercategoryid) {
        this.providercategoryid = providercategoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Provider> getProviderCollection() {
        return providerCollection;
    }

    public void setProviderCollection(Collection<Provider> providerCollection) {
        this.providerCollection = providerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providercategoryid != null ? providercategoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Providercategory)) {
            return false;
        }
        Providercategory other = (Providercategory) object;
        if ((this.providercategoryid == null && other.providercategoryid != null) || (this.providercategoryid != null && !this.providercategoryid.equals(other.providercategoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Providercategory[ providercategoryid=" + providercategoryid + " ]";
    }
    
}
