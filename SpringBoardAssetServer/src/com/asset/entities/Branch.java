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
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchid", query = "SELECT b FROM Branch b WHERE b.branchid = :branchid"),
    @NamedQuery(name = "Branch.findByName", query = "SELECT b FROM Branch b WHERE b.name = :name"),
    @NamedQuery(name = "Branch.findByLocation", query = "SELECT b FROM Branch b WHERE b.location = :location"),
    @NamedQuery(name = "Branch.findByCountryid", query = "SELECT b FROM Branch b WHERE b.countryid = :countryid"),
    @NamedQuery(name = "Branch.findByPhonenumber", query = "SELECT b FROM Branch b WHERE b.phonenumber = :phonenumber"),
    @NamedQuery(name = "Branch.findByEmail", query = "SELECT b FROM Branch b WHERE b.email = :email"),
    @NamedQuery(name = "Branch.findByDescription", query = "SELECT b FROM Branch b WHERE b.description = :description"),
    @NamedQuery(name = "Branch.findByStatus", query = "SELECT b FROM Branch b WHERE b.status = :status")})
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "branchid")
    private Integer branchid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "countryid")
    private int countryid;
    @Basic(optional = false)
    @Column(name = "phonenumber")
    private String phonenumber;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "stateid", referencedColumnName = "stateid")
    @ManyToOne(optional = false)
    private State stateid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchid")
    private Collection<Unit> unitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchid")
    private Collection<Department> departmentCollection;

    public Branch() {
    }

    public Branch(Integer branchid) {
        this.branchid = branchid;
    }

    public Branch(Integer branchid, String name, String location, int countryid, String phonenumber, String email, String description, String status) {
        this.branchid = branchid;
        this.name = name;
        this.location = location;
        this.countryid = countryid;
        this.phonenumber = phonenumber;
        this.email = email;
        this.description = description;
        this.status = status;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public State getStateid() {
        return stateid;
    }

    public void setStateid(State stateid) {
        this.stateid = stateid;
    }

    @XmlTransient
    public Collection<Unit> getUnitCollection() {
        return unitCollection;
    }

    public void setUnitCollection(Collection<Unit> unitCollection) {
        this.unitCollection = unitCollection;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchid != null ? branchid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchid == null && other.branchid != null) || (this.branchid != null && !this.branchid.equals(other.branchid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Branch[ branchid=" + branchid + " ]";
    }
    
}
