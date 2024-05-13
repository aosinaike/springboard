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
@Table(name = "servicedesk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicedesk.findAll", query = "SELECT s FROM Servicedesk s"),
    @NamedQuery(name = "Servicedesk.findByServicedeskid", query = "SELECT s FROM Servicedesk s WHERE s.servicedeskid = :servicedeskid"),
    @NamedQuery(name = "Servicedesk.findByServicesid", query = "SELECT s FROM Servicedesk s WHERE s.servicesid = :servicesid"),
    @NamedQuery(name = "Servicedesk.findByDescription", query = "SELECT s FROM Servicedesk s WHERE s.description = :description"),
    @NamedQuery(name = "Servicedesk.findByDatecreated", query = "SELECT s FROM Servicedesk s WHERE s.datecreated = :datecreated"),
    @NamedQuery(name = "Servicedesk.findByTimecreate", query = "SELECT s FROM Servicedesk s WHERE s.timecreate = :timecreate"),
    @NamedQuery(name = "Servicedesk.findByCreatedby", query = "SELECT s FROM Servicedesk s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "Servicedesk.findByStatus", query = "SELECT s FROM Servicedesk s WHERE s.status = :status")})
public class Servicedesk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servicedeskid")
    private Integer servicedeskid;
    @Basic(optional = false)
    @Column(name = "servicesid")
    private int servicesid;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datecreated")
    private String datecreated;
    @Basic(optional = false)
    @Column(name = "timecreate")
    private String timecreate;
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicedeskid")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicedeskid")
    private Collection<Requestfulfillment> requestfulfillmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicedeskid")
    private Collection<Approval> approvalCollection;

    public Servicedesk() {
    }

    public Servicedesk(Integer servicedeskid) {
        this.servicedeskid = servicedeskid;
    }

    public Servicedesk(Integer servicedeskid, int servicesid, String description, String datecreated, String timecreate, String createdby, int status) {
        this.servicedeskid = servicedeskid;
        this.servicesid = servicesid;
        this.description = description;
        this.datecreated = datecreated;
        this.timecreate = timecreate;
        this.createdby = createdby;
        this.status = status;
    }

    public Integer getServicedeskid() {
        return servicedeskid;
    }

    public void setServicedeskid(Integer servicedeskid) {
        this.servicedeskid = servicedeskid;
    }

    public int getServicesid() {
        return servicesid;
    }

    public void setServicesid(int servicesid) {
        this.servicesid = servicesid;
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

    public String getTimecreate() {
        return timecreate;
    }

    public void setTimecreate(String timecreate) {
        this.timecreate = timecreate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<Requestfulfillment> getRequestfulfillmentCollection() {
        return requestfulfillmentCollection;
    }

    public void setRequestfulfillmentCollection(Collection<Requestfulfillment> requestfulfillmentCollection) {
        this.requestfulfillmentCollection = requestfulfillmentCollection;
    }

    @XmlTransient
    public Collection<Approval> getApprovalCollection() {
        return approvalCollection;
    }

    public void setApprovalCollection(Collection<Approval> approvalCollection) {
        this.approvalCollection = approvalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicedeskid != null ? servicedeskid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicedesk)) {
            return false;
        }
        Servicedesk other = (Servicedesk) object;
        if ((this.servicedeskid == null && other.servicedeskid != null) || (this.servicedeskid != null && !this.servicedeskid.equals(other.servicedeskid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Servicedesk[ servicedeskid=" + servicedeskid + " ]";
    }
    
}
