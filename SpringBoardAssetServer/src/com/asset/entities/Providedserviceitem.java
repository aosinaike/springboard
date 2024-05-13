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
@Table(name = "providedserviceitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Providedserviceitem.findAll", query = "SELECT p FROM Providedserviceitem p"),
    @NamedQuery(name = "Providedserviceitem.findByProvidedserviceitemid", query = "SELECT p FROM Providedserviceitem p WHERE p.providedserviceitemid = :providedserviceitemid"),
    @NamedQuery(name = "Providedserviceitem.findByStatus", query = "SELECT p FROM Providedserviceitem p WHERE p.status = :status")})
public class Providedserviceitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "providedserviceitemid")
    private Long providedserviceitemid;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providedserviceassetitemid")
    private Collection<Contract> contractCollection;
    @JoinColumn(name = "serviceitemid", referencedColumnName = "serviceitemid")
    @ManyToOne(optional = false)
    private Serviceitem serviceitemid;
    @JoinColumn(name = "providerid", referencedColumnName = "providerid")
    @ManyToOne(optional = false)
    private Provider providerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providedserviceitemid")
    private Collection<Servicecosting> servicecostingCollection;

    public Providedserviceitem() {
    }

    public Providedserviceitem(Long providedserviceitemid) {
        this.providedserviceitemid = providedserviceitemid;
    }

    public Providedserviceitem(Long providedserviceitemid, int status) {
        this.providedserviceitemid = providedserviceitemid;
        this.status = status;
    }

    public Long getProvidedserviceitemid() {
        return providedserviceitemid;
    }

    public void setProvidedserviceitemid(Long providedserviceitemid) {
        this.providedserviceitemid = providedserviceitemid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Contract> getContractCollection() {
        return contractCollection;
    }

    public void setContractCollection(Collection<Contract> contractCollection) {
        this.contractCollection = contractCollection;
    }

    public Serviceitem getServiceitemid() {
        return serviceitemid;
    }

    public void setServiceitemid(Serviceitem serviceitemid) {
        this.serviceitemid = serviceitemid;
    }

    public Provider getProviderid() {
        return providerid;
    }

    public void setProviderid(Provider providerid) {
        this.providerid = providerid;
    }

    @XmlTransient
    public Collection<Servicecosting> getServicecostingCollection() {
        return servicecostingCollection;
    }

    public void setServicecostingCollection(Collection<Servicecosting> servicecostingCollection) {
        this.servicecostingCollection = servicecostingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providedserviceitemid != null ? providedserviceitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Providedserviceitem)) {
            return false;
        }
        Providedserviceitem other = (Providedserviceitem) object;
        if ((this.providedserviceitemid == null && other.providedserviceitemid != null) || (this.providedserviceitemid != null && !this.providedserviceitemid.equals(other.providedserviceitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Providedserviceitem[ providedserviceitemid=" + providedserviceitemid + " ]";
    }
    
}
