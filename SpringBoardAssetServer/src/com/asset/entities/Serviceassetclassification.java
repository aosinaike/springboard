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
@Table(name = "serviceassetclassification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceassetclassification.findAll", query = "SELECT s FROM Serviceassetclassification s"),
    @NamedQuery(name = "Serviceassetclassification.findByServiceassetclassificationid", query = "SELECT s FROM Serviceassetclassification s WHERE s.serviceassetclassificationid = :serviceassetclassificationid"),
    @NamedQuery(name = "Serviceassetclassification.findByServiceclass", query = "SELECT s FROM Serviceassetclassification s WHERE s.serviceclass = :serviceclass"),
    @NamedQuery(name = "Serviceassetclassification.findByDescription", query = "SELECT s FROM Serviceassetclassification s WHERE s.description = :description"),
    @NamedQuery(name = "Serviceassetclassification.findByDatecreated", query = "SELECT s FROM Serviceassetclassification s WHERE s.datecreated = :datecreated"),
    @NamedQuery(name = "Serviceassetclassification.findByTimecreated", query = "SELECT s FROM Serviceassetclassification s WHERE s.timecreated = :timecreated"),
    @NamedQuery(name = "Serviceassetclassification.findByStatus", query = "SELECT s FROM Serviceassetclassification s WHERE s.status = :status")})
public class Serviceassetclassification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "serviceassetclassificationid")
    private Integer serviceassetclassificationid;
    @Basic(optional = false)
    @Column(name = "serviceclass")
    private String serviceclass;
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
    @JoinColumn(name = "servicetypeid", referencedColumnName = "servicetypeid")
    @ManyToOne(optional = false)
    private Servicetype servicetypeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceclassificationid")
    private Collection<Servicecosting> servicecostingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceclassificationid")
    private Collection<Service> serviceCollection;

    public Serviceassetclassification() {
    }

    public Serviceassetclassification(Integer serviceassetclassificationid) {
        this.serviceassetclassificationid = serviceassetclassificationid;
    }

    public Serviceassetclassification(Integer serviceassetclassificationid, String serviceclass, String description, String datecreated, String timecreated, int status) {
        this.serviceassetclassificationid = serviceassetclassificationid;
        this.serviceclass = serviceclass;
        this.description = description;
        this.datecreated = datecreated;
        this.timecreated = timecreated;
        this.status = status;
    }

    public Integer getServiceassetclassificationid() {
        return serviceassetclassificationid;
    }

    public void setServiceassetclassificationid(Integer serviceassetclassificationid) {
        this.serviceassetclassificationid = serviceassetclassificationid;
    }

    public String getServiceclass() {
        return serviceclass;
    }

    public void setServiceclass(String serviceclass) {
        this.serviceclass = serviceclass;
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

    public Servicetype getServicetypeid() {
        return servicetypeid;
    }

    public void setServicetypeid(Servicetype servicetypeid) {
        this.servicetypeid = servicetypeid;
    }

    @XmlTransient
    public Collection<Servicecosting> getServicecostingCollection() {
        return servicecostingCollection;
    }

    public void setServicecostingCollection(Collection<Servicecosting> servicecostingCollection) {
        this.servicecostingCollection = servicecostingCollection;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceassetclassificationid != null ? serviceassetclassificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceassetclassification)) {
            return false;
        }
        Serviceassetclassification other = (Serviceassetclassification) object;
        if ((this.serviceassetclassificationid == null && other.serviceassetclassificationid != null) || (this.serviceassetclassificationid != null && !this.serviceassetclassificationid.equals(other.serviceassetclassificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Serviceassetclassification[ serviceassetclassificationid=" + serviceassetclassificationid + " ]";
    }
    
}
