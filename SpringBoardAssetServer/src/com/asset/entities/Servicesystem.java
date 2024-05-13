/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "servicesystem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicesystem.findAll", query = "SELECT s FROM Servicesystem s"),
    @NamedQuery(name = "Servicesystem.findByServicesystemid", query = "SELECT s FROM Servicesystem s WHERE s.servicesystemid = :servicesystemid"),
    @NamedQuery(name = "Servicesystem.findByAssetitemid", query = "SELECT s FROM Servicesystem s WHERE s.assetitemid = :assetitemid"),
    @NamedQuery(name = "Servicesystem.findByDatecreated", query = "SELECT s FROM Servicesystem s WHERE s.datecreated = :datecreated"),
    @NamedQuery(name = "Servicesystem.findByTimecreated", query = "SELECT s FROM Servicesystem s WHERE s.timecreated = :timecreated"),
    @NamedQuery(name = "Servicesystem.findByStatus", query = "SELECT s FROM Servicesystem s WHERE s.status = :status")})
public class Servicesystem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "servicesystemid")
    private Integer servicesystemid;
    @Column(name = "assetitemid")
    private BigInteger assetitemid;
    @Column(name = "datecreated")
    private String datecreated;
    @Column(name = "timecreated")
    private String timecreated;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicesystemid")
    private Collection<Serviceitem> serviceitemCollection;

    public Servicesystem() {
    }

    public Servicesystem(Integer servicesystemid) {
        this.servicesystemid = servicesystemid;
    }

    public Integer getServicesystemid() {
        return servicesystemid;
    }

    public void setServicesystemid(Integer servicesystemid) {
        this.servicesystemid = servicesystemid;
    }

    public BigInteger getAssetitemid() {
        return assetitemid;
    }

    public void setAssetitemid(BigInteger assetitemid) {
        this.assetitemid = assetitemid;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(String timecreated) {
        this.timecreated = timecreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Serviceitem> getServiceitemCollection() {
        return serviceitemCollection;
    }

    public void setServiceitemCollection(Collection<Serviceitem> serviceitemCollection) {
        this.serviceitemCollection = serviceitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicesystemid != null ? servicesystemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicesystem)) {
            return false;
        }
        Servicesystem other = (Servicesystem) object;
        if ((this.servicesystemid == null && other.servicesystemid != null) || (this.servicesystemid != null && !this.servicesystemid.equals(other.servicesystemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Servicesystem[ servicesystemid=" + servicesystemid + " ]";
    }
    
}
