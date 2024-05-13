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
@Table(name = "servicerequesttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicerequesttype.findAll", query = "SELECT s FROM Servicerequesttype s"),
    @NamedQuery(name = "Servicerequesttype.findByServicerequesttypeid", query = "SELECT s FROM Servicerequesttype s WHERE s.servicerequesttypeid = :servicerequesttypeid"),
    @NamedQuery(name = "Servicerequesttype.findByName", query = "SELECT s FROM Servicerequesttype s WHERE s.name = :name")})
public class Servicerequesttype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "servicerequesttypeid")
    private Integer servicerequesttypeid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicerequesttypeid")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicerequesttypeid")
    private Collection<Itemattribute> itemattributeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicerequesttypeid")
    private Collection<Incident> incidentCollection;

    public Servicerequesttype() {
    }

    public Servicerequesttype(Integer servicerequesttypeid) {
        this.servicerequesttypeid = servicerequesttypeid;
    }

    public Servicerequesttype(Integer servicerequesttypeid, String name) {
        this.servicerequesttypeid = servicerequesttypeid;
        this.name = name;
    }

    public Integer getServicerequesttypeid() {
        return servicerequesttypeid;
    }

    public void setServicerequesttypeid(Integer servicerequesttypeid) {
        this.servicerequesttypeid = servicerequesttypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<Itemattribute> getItemattributeCollection() {
        return itemattributeCollection;
    }

    public void setItemattributeCollection(Collection<Itemattribute> itemattributeCollection) {
        this.itemattributeCollection = itemattributeCollection;
    }

    @XmlTransient
    public Collection<Incident> getIncidentCollection() {
        return incidentCollection;
    }

    public void setIncidentCollection(Collection<Incident> incidentCollection) {
        this.incidentCollection = incidentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicerequesttypeid != null ? servicerequesttypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicerequesttype)) {
            return false;
        }
        Servicerequesttype other = (Servicerequesttype) object;
        if ((this.servicerequesttypeid == null && other.servicerequesttypeid != null) || (this.servicerequesttypeid != null && !this.servicerequesttypeid.equals(other.servicerequesttypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Servicerequesttype[ servicerequesttypeid=" + servicerequesttypeid + " ]";
    }
    
}
