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
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceid", query = "SELECT s FROM Service s WHERE s.serviceid = :serviceid"),
    @NamedQuery(name = "Service.findByServicename", query = "SELECT s FROM Service s WHERE s.servicename = :servicename"),
    @NamedQuery(name = "Service.findByServicesdescription", query = "SELECT s FROM Service s WHERE s.servicesdescription = :servicesdescription"),
    @NamedQuery(name = "Service.findByDatecreated", query = "SELECT s FROM Service s WHERE s.datecreated = :datecreated"),
    @NamedQuery(name = "Service.findByTimecreated", query = "SELECT s FROM Service s WHERE s.timecreated = :timecreated"),
    @NamedQuery(name = "Service.findByStatus", query = "SELECT s FROM Service s WHERE s.status = :status")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "serviceid")
    private Integer serviceid;
    @Basic(optional = false)
    @Column(name = "servicename")
    private String servicename;
    @Basic(optional = false)
    @Column(name = "servicesdescription")
    private String servicesdescription;
    @Basic(optional = false)
    @Column(name = "datecreated")
    private String datecreated;
    @Basic(optional = false)
    @Column(name = "timecreated")
    private String timecreated;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceid")
    private Collection<Serviceitem> serviceitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceid")
    private Collection<Servicecosting> servicecostingCollection;
    @JoinColumn(name = "serviceclassificationid", referencedColumnName = "serviceassetclassificationid")
    @ManyToOne(optional = false)
    private Serviceassetclassification serviceclassificationid;

    public Service() {
    }

    public Service(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Service(Integer serviceid, String servicename, String servicesdescription, String datecreated, String timecreated, int status) {
        this.serviceid = serviceid;
        this.servicename = servicename;
        this.servicesdescription = servicesdescription;
        this.datecreated = datecreated;
        this.timecreated = timecreated;
        this.status = status;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServicesdescription() {
        return servicesdescription;
    }

    public void setServicesdescription(String servicesdescription) {
        this.servicesdescription = servicesdescription;
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

    @XmlTransient
    public Collection<Servicecosting> getServicecostingCollection() {
        return servicecostingCollection;
    }

    public void setServicecostingCollection(Collection<Servicecosting> servicecostingCollection) {
        this.servicecostingCollection = servicecostingCollection;
    }

    public Serviceassetclassification getServiceclassificationid() {
        return serviceclassificationid;
    }

    public void setServiceclassificationid(Serviceassetclassification serviceclassificationid) {
        this.serviceclassificationid = serviceclassificationid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceid != null ? serviceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceid == null && other.serviceid != null) || (this.serviceid != null && !this.serviceid.equals(other.serviceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Service[ serviceid=" + serviceid + " ]";
    }
    
}
