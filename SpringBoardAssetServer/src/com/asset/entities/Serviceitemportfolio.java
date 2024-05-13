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
@Table(name = "serviceitemportfolio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceitemportfolio.findAll", query = "SELECT s FROM Serviceitemportfolio s"),
    @NamedQuery(name = "Serviceitemportfolio.findByServiceitemportfolioid", query = "SELECT s FROM Serviceitemportfolio s WHERE s.serviceitemportfolioid = :serviceitemportfolioid"),
    @NamedQuery(name = "Serviceitemportfolio.findByDescription", query = "SELECT s FROM Serviceitemportfolio s WHERE s.description = :description"),
    @NamedQuery(name = "Serviceitemportfolio.findByDatecreated", query = "SELECT s FROM Serviceitemportfolio s WHERE s.datecreated = :datecreated"),
    @NamedQuery(name = "Serviceitemportfolio.findByTimecreated", query = "SELECT s FROM Serviceitemportfolio s WHERE s.timecreated = :timecreated"),
    @NamedQuery(name = "Serviceitemportfolio.findByStatus", query = "SELECT s FROM Serviceitemportfolio s WHERE s.status = :status")})
public class Serviceitemportfolio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceitemportfolioid")
    private Integer serviceitemportfolioid;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datecreated")
    private String datecreated;
    @Basic(optional = false)
    @Column(name = "timecreated")
    private String timecreated;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceitemportfolioid")
    private Collection<Serviceitem> serviceitemCollection;
    @JoinColumn(name = "providerid", referencedColumnName = "providerid")
    @ManyToOne(optional = false)
    private Provider providerid;

    public Serviceitemportfolio() {
    }

    public Serviceitemportfolio(Integer serviceitemportfolioid) {
        this.serviceitemportfolioid = serviceitemportfolioid;
    }

    public Serviceitemportfolio(Integer serviceitemportfolioid, String description, String datecreated, String timecreated, int status) {
        this.serviceitemportfolioid = serviceitemportfolioid;
        this.description = description;
        this.datecreated = datecreated;
        this.timecreated = timecreated;
        this.status = status;
    }

    public Integer getServiceitemportfolioid() {
        return serviceitemportfolioid;
    }

    public void setServiceitemportfolioid(Integer serviceitemportfolioid) {
        this.serviceitemportfolioid = serviceitemportfolioid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Serviceitem> getServiceitemCollection() {
        return serviceitemCollection;
    }

    public void setServiceitemCollection(Collection<Serviceitem> serviceitemCollection) {
        this.serviceitemCollection = serviceitemCollection;
    }

    public Provider getProviderid() {
        return providerid;
    }

    public void setProviderid(Provider providerid) {
        this.providerid = providerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceitemportfolioid != null ? serviceitemportfolioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceitemportfolio)) {
            return false;
        }
        Serviceitemportfolio other = (Serviceitemportfolio) object;
        if ((this.serviceitemportfolioid == null && other.serviceitemportfolioid != null) || (this.serviceitemportfolioid != null && !this.serviceitemportfolioid.equals(other.serviceitemportfolioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Serviceitemportfolio[ serviceitemportfolioid=" + serviceitemportfolioid + " ]";
    }
    
}
