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
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentid", query = "SELECT d FROM Department d WHERE d.departmentid = :departmentid"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByDepartmentcode", query = "SELECT d FROM Department d WHERE d.departmentcode = :departmentcode"),
    @NamedQuery(name = "Department.findByDescription", query = "SELECT d FROM Department d WHERE d.description = :description"),
    @NamedQuery(name = "Department.findByDatecreated", query = "SELECT d FROM Department d WHERE d.datecreated = :datecreated"),
    @NamedQuery(name = "Department.findByTimecreated", query = "SELECT d FROM Department d WHERE d.timecreated = :timecreated"),
    @NamedQuery(name = "Department.findByStatus", query = "SELECT d FROM Department d WHERE d.status = :status")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "departmentid")
    private Integer departmentid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "departmentcode")
    private String departmentcode;
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
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testingdepartmentid")
    private Collection<Testingteam> testingteamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentid")
    private Collection<Unit> unitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "implementdepartmentid")
    private Collection<Implementingteam> implementingteamCollection;
    @JoinColumn(name = "costcenterid", referencedColumnName = "costcenterid")
    @ManyToOne(optional = false)
    private Costcenter costcenterid;
    @JoinColumn(name = "branchid", referencedColumnName = "branchid")
    @ManyToOne(optional = false)
    private Branch branchid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentid")
    private Collection<Staff> staffCollection;

    public Department() {
    }

    public Department(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Department(Integer departmentid, String name, String departmentcode, String description, String datecreated, String timecreated, String status) {
        this.departmentid = departmentid;
        this.name = name;
        this.departmentcode = departmentcode;
        this.description = description;
        this.datecreated = datecreated;
        this.timecreated = timecreated;
        this.status = status;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        this.departmentcode = departmentcode;
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

    @XmlTransient
    public Collection<Unit> getUnitCollection() {
        return unitCollection;
    }

    public void setUnitCollection(Collection<Unit> unitCollection) {
        this.unitCollection = unitCollection;
    }

    @XmlTransient
    public Collection<Implementingteam> getImplementingteamCollection() {
        return implementingteamCollection;
    }

    public void setImplementingteamCollection(Collection<Implementingteam> implementingteamCollection) {
        this.implementingteamCollection = implementingteamCollection;
    }

    public Costcenter getCostcenterid() {
        return costcenterid;
    }

    public void setCostcenterid(Costcenter costcenterid) {
        this.costcenterid = costcenterid;
    }

    public Branch getBranchid() {
        return branchid;
    }

    public void setBranchid(Branch branchid) {
        this.branchid = branchid;
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
        hash += (departmentid != null ? departmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentid == null && other.departmentid != null) || (this.departmentid != null && !this.departmentid.equals(other.departmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Department[ departmentid=" + departmentid + " ]";
    }
    
}
