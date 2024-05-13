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
@Table(name = "serviceitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceitem.findAll", query = "SELECT s FROM Serviceitem s"),
    @NamedQuery(name = "Serviceitem.findByServiceitemid", query = "SELECT s FROM Serviceitem s WHERE s.serviceitemid = :serviceitemid"),
    @NamedQuery(name = "Serviceitem.findByName", query = "SELECT s FROM Serviceitem s WHERE s.name = :name"),
    @NamedQuery(name = "Serviceitem.findByStatus", query = "SELECT s FROM Serviceitem s WHERE s.status = :status")})
public class Serviceitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceitemid")
    private Long serviceitemid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemid1")
    private Collection<Problem> problemCollection;
    @OneToMany(mappedBy = "itemid")
    private Collection<Attributesitems> attributesitemsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceitemid")
    private Collection<Providedserviceitem> providedserviceitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceitemid")
    private Collection<Serviceitemassetitem> serviceitemassetitemCollection;
    @JoinColumn(name = "servicesystemid", referencedColumnName = "servicesystemid")
    @ManyToOne(optional = false)
    private Servicesystem servicesystemid;
    @JoinColumn(name = "serviceid", referencedColumnName = "serviceid")
    @ManyToOne(optional = false)
    private Service serviceid;
    @JoinColumn(name = "serviceitemportfolioid", referencedColumnName = "serviceitemportfolioid")
    @ManyToOne(optional = false)
    private Serviceitemportfolio serviceitemportfolioid;

    public Serviceitem() {
    }

    public Serviceitem(Long serviceitemid) {
        this.serviceitemid = serviceitemid;
    }

    public Serviceitem(Long serviceitemid, String name, String status) {
        this.serviceitemid = serviceitemid;
        this.name = name;
        this.status = status;
    }

    public Long getServiceitemid() {
        return serviceitemid;
    }

    public void setServiceitemid(Long serviceitemid) {
        this.serviceitemid = serviceitemid;
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
    public Collection<Problem> getProblemCollection() {
        return problemCollection;
    }

    public void setProblemCollection(Collection<Problem> problemCollection) {
        this.problemCollection = problemCollection;
    }

    @XmlTransient
    public Collection<Attributesitems> getAttributesitemsCollection() {
        return attributesitemsCollection;
    }

    public void setAttributesitemsCollection(Collection<Attributesitems> attributesitemsCollection) {
        this.attributesitemsCollection = attributesitemsCollection;
    }

    @XmlTransient
    public Collection<Providedserviceitem> getProvidedserviceitemCollection() {
        return providedserviceitemCollection;
    }

    public void setProvidedserviceitemCollection(Collection<Providedserviceitem> providedserviceitemCollection) {
        this.providedserviceitemCollection = providedserviceitemCollection;
    }

    @XmlTransient
    public Collection<Serviceitemassetitem> getServiceitemassetitemCollection() {
        return serviceitemassetitemCollection;
    }

    public void setServiceitemassetitemCollection(Collection<Serviceitemassetitem> serviceitemassetitemCollection) {
        this.serviceitemassetitemCollection = serviceitemassetitemCollection;
    }

    public Servicesystem getServicesystemid() {
        return servicesystemid;
    }

    public void setServicesystemid(Servicesystem servicesystemid) {
        this.servicesystemid = servicesystemid;
    }

    public Service getServiceid() {
        return serviceid;
    }

    public void setServiceid(Service serviceid) {
        this.serviceid = serviceid;
    }

    public Serviceitemportfolio getServiceitemportfolioid() {
        return serviceitemportfolioid;
    }

    public void setServiceitemportfolioid(Serviceitemportfolio serviceitemportfolioid) {
        this.serviceitemportfolioid = serviceitemportfolioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceitemid != null ? serviceitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceitem)) {
            return false;
        }
        Serviceitem other = (Serviceitem) object;
        if ((this.serviceitemid == null && other.serviceitemid != null) || (this.serviceitemid != null && !this.serviceitemid.equals(other.serviceitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Serviceitem[ serviceitemid=" + serviceitemid + " ]";
    }
    
}
