/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffid", query = "SELECT s FROM Staff s WHERE s.staffid = :staffid"),
    @NamedQuery(name = "Staff.findByFirstname", query = "SELECT s FROM Staff s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Staff.findByLastname", query = "SELECT s FROM Staff s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Staff.findByMiddlename", query = "SELECT s FROM Staff s WHERE s.middlename = :middlename"),
    @NamedQuery(name = "Staff.findByDateofbirth", query = "SELECT s FROM Staff s WHERE s.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Staff.findByMaritalstatus", query = "SELECT s FROM Staff s WHERE s.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "Staff.findByGender", query = "SELECT s FROM Staff s WHERE s.gender = :gender"),
    @NamedQuery(name = "Staff.findByStatus", query = "SELECT s FROM Staff s WHERE s.status = :status")})
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staffid")
    private Integer staffid;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "middlename")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "dateofbirth")
    private String dateofbirth;
    @Basic(optional = false)
    @Column(name = "maritalstatus")
    private int maritalstatus;
    @Basic(optional = false)
    @Column(name = "gender")
    private int gender;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "unitid", referencedColumnName = "unitid")
    @ManyToOne
    private Unit unitid;
    @JoinColumn(name = "departmentid", referencedColumnName = "departmentid")
    @ManyToOne(optional = false)
    private Department departmentid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "staff")
    private User user;

    public Staff() {
    }

    public Staff(Integer staffid) {
        this.staffid = staffid;
    }

    public Staff(Integer staffid, String firstname, String lastname, String middlename, String dateofbirth, int maritalstatus, int gender, String status) {
        this.staffid = staffid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.dateofbirth = dateofbirth;
        this.maritalstatus = maritalstatus;
        this.gender = gender;
        this.status = status;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(int maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Unit getUnitid() {
        return unitid;
    }

    public void setUnitid(Unit unitid) {
        this.unitid = unitid;
    }

    public Department getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Department departmentid) {
        this.departmentid = departmentid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffid != null ? staffid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffid == null && other.staffid != null) || (this.staffid != null && !this.staffid.equals(other.staffid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Staff[ staffid=" + staffid + " ]";
    }
    
}
