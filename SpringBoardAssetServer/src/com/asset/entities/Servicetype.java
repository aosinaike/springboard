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
@Table(name = "servicetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicetype.findAll", query = "SELECT s FROM Servicetype s"),
    @NamedQuery(name = "Servicetype.findByServicetypeid", query = "SELECT s FROM Servicetype s WHERE s.servicetypeid = :servicetypeid"),
    @NamedQuery(name = "Servicetype.findByName", query = "SELECT s FROM Servicetype s WHERE s.name = :name"),
    @NamedQuery(name = "Servicetype.findByDescription", query = "SELECT s FROM Servicetype s WHERE s.description = :description"),
    @NamedQuery(name = "Servicetype.findByDatecreated", query = "SELECT s FROM Servicetype s WHERE s.datecreated = :datecreated"),
    @NamedQuery(name = "Servicetype.findByTimecreated", query = "SELECT s FROM Servicetype s WHERE s.timecreated = :timecreated"),
    @NamedQuery(name = "Servicetype.findByStatus", query = "SELECT s FROM Servicetype s WHERE s.status = :status")})
public class Servicetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "servicetypeid")
    private Integer servicetypeid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datecreated")
    private String datecreated;
    @Basic(optional = false)
    @Column(name = "timecreated")
    private int timecreated;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicetypeid")
    private Collection<Serviceassetclassification> serviceassetclassificationCollection;

    public Servicetype() {
    }

    public Servicetype(Integer servicetypeid) {
        this.servicetypeid = servicetypeid;
    }

    public Servicetype(Integer servicetypeid, String name, String description, String datecreated, int timecreated, String status) {
        this.servicetypeid = servicetypeid;
        this.name = name;
        this.description = description;
        this.datecreated = datecreated;
        this.timecreated = timecreated;
        this.status = status;
    }

    public Integer getServicetypeid() {
        return servicetypeid;
    }

    public void setServicetypeid(Integer servicetypeid) {
        this.servicetypeid = servicetypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(int timecreated) {
        this.timecreated = timecreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Serviceassetclassification> getServiceassetclassificationCollection() {
        return serviceassetclassificationCollection;
    }

    public void setServiceassetclassificationCollection(Collection<Serviceassetclassification> serviceassetclassificationCollection) {
        this.serviceassetclassificationCollection = serviceassetclassificationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicetypeid != null ? servicetypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicetype)) {
            return false;
        }
        Servicetype other = (Servicetype) object;
        if ((this.servicetypeid == null && other.servicetypeid != null) || (this.servicetypeid != null && !this.servicetypeid.equals(other.servicetypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Servicetype[ servicetypeid=" + servicetypeid + " ]";
    }
    
}
