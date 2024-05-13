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
@Table(name = "providedasset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Providedasset.findAll", query = "SELECT p FROM Providedasset p"),
    @NamedQuery(name = "Providedasset.findByProvidedassetid", query = "SELECT p FROM Providedasset p WHERE p.providedassetid = :providedassetid"),
    @NamedQuery(name = "Providedasset.findByStatusid", query = "SELECT p FROM Providedasset p WHERE p.statusid = :statusid")})
public class Providedasset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "providedassetid")
    private Integer providedassetid;
    @Basic(optional = false)
    @Column(name = "statusid")
    private int statusid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providedassetid")
    private Collection<Providedassetitem> providedassetitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providedassetcatalogueid")
    private Collection<Contract> contractCollection;
    @JoinColumn(name = "assetportfolioid", referencedColumnName = "assetportfolioid")
    @ManyToOne(optional = false)
    private Assetportfolio assetportfolioid;

    public Providedasset() {
    }

    public Providedasset(Integer providedassetid) {
        this.providedassetid = providedassetid;
    }

    public Providedasset(Integer providedassetid, int statusid) {
        this.providedassetid = providedassetid;
        this.statusid = statusid;
    }

    public Integer getProvidedassetid() {
        return providedassetid;
    }

    public void setProvidedassetid(Integer providedassetid) {
        this.providedassetid = providedassetid;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    @XmlTransient
    public Collection<Providedassetitem> getProvidedassetitemCollection() {
        return providedassetitemCollection;
    }

    public void setProvidedassetitemCollection(Collection<Providedassetitem> providedassetitemCollection) {
        this.providedassetitemCollection = providedassetitemCollection;
    }

    @XmlTransient
    public Collection<Contract> getContractCollection() {
        return contractCollection;
    }

    public void setContractCollection(Collection<Contract> contractCollection) {
        this.contractCollection = contractCollection;
    }

    public Assetportfolio getAssetportfolioid() {
        return assetportfolioid;
    }

    public void setAssetportfolioid(Assetportfolio assetportfolioid) {
        this.assetportfolioid = assetportfolioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providedassetid != null ? providedassetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Providedasset)) {
            return false;
        }
        Providedasset other = (Providedasset) object;
        if ((this.providedassetid == null && other.providedassetid != null) || (this.providedassetid != null && !this.providedassetid.equals(other.providedassetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Providedasset[ providedassetid=" + providedassetid + " ]";
    }
    
}
