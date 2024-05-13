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
@Table(name = "unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findByUnitid", query = "SELECT u FROM Unit u WHERE u.unitid = :unitid"),
    @NamedQuery(name = "Unit.findByName", query = "SELECT u FROM Unit u WHERE u.name = :name"),
    @NamedQuery(name = "Unit.findByUnitcode", query = "SELECT u FROM Unit u WHERE u.unitcode = :unitcode"),
    @NamedQuery(name = "Unit.findByDescription", query = "SELECT u FROM Unit u WHERE u.description = :description"),
    @NamedQuery(name = "Unit.findByDatecreated", query = "SELECT u FROM Unit u WHERE u.datecreated = :datecreated"),
    @NamedQuery(name = "Unit.findByTimecreted", query = "SELECT u FROM Unit u WHERE u.timecreted = :timecreted"),
    @NamedQuery(name = "Unit.findByStatus", query = "SELECT u FROM Unit u WHERE u.status = :status")})
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unitid")
    private Integer unitid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "unitcode")
    private String unitcode;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datecreated")
    private String datecreated;
    @Basic(optional = false)
    @Column(name = "timecreted")
    private String timecreted;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "testingunitid")
    private Collection<Testingteam> testingteamCollection;
    @JoinColumn(name = "departmentid", referencedColumnName = "departmentid")
    @ManyToOne(optional = false)
    private Department departmentid;
    @JoinColumn(name = "branchid", referencedColumnName = "branchid")
    @ManyToOne(optional = false)
    private Branch branchid;
    @JoinColumn(name = "costcenterid", referencedColumnName = "costcenterid")
    @ManyToOne(optional = false)
    private Costcenter costcenterid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "implementunit")
    private Collection<Implementingteam> implementingteamCollection;
    @OneToMany(mappedBy = "unitid")
    private Collection<Staff> staffCollection;

    public Unit() {
    }

    public Unit(Integer unitid) {
        this.unitid = unitid;
    }

    public Unit(Integer unitid, String name, String unitcode, String description, String datecreated, String timecreted, String status) {
        this.unitid = unitid;
        this.name = name;
        this.unitcode = unitcode;
        this.description = description;
        this.datecreated = datecreated;
        this.timecreted = timecreted;
        this.status = status;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
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

    public String getTimecreted() {
        return timecreted;
    }

    public void setTimecreted(String timecreted) {
        this.timecreted = timecreted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Testingteam> getTestingteamCollection() {
        return testingteamCollection;
    }

    public void setTestingteamCollection(Collection<Testingteam> testingteamCollection) {
        this.testingteamCollection = testingteamCollection;
    }

    public Department getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Department departmentid) {
        this.departmentid = departmentid;
    }

    public Branch getBranchid() {
        return branchid;
    }

    public void setBranchid(Branch branchid) {
        this.branchid = branchid;
    }

    public Costcenter getCostcenterid() {
        return costcenterid;
    }

    public void setCostcenterid(Costcenter costcenterid) {
        this.costcenterid = costcenterid;
    }

    @XmlTransient
    public Collection<Implementingteam> getImplementingteamCollection() {
        return implementingteamCollection;
    }

    public void setImplementingteamCollection(Collection<Implementingteam> implementingteamCollection) {
        this.implementingteamCollection = implementingteamCollection;
    }

    @XmlTransient
    public Collection<Staff> getStaffCollection() {
        return staffCollection;
    }

    public void setStaffCollection(Collection<Staff> staffCollection) {
        this.staffCollection = staffCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitid != null ? unitid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.unitid == null && other.unitid != null) || (this.unitid != null && !this.unitid.equals(other.unitid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Unit[ unitid=" + unitid + " ]";
    }
    
}
