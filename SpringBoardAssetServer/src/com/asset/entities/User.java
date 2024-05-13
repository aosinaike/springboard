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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
    @NamedQuery(name = "User.findByStaffid", query = "SELECT u FROM User u WHERE u.staffid = :staffid"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByIsstaff", query = "SELECT u FROM User u WHERE u.isstaff = :isstaff"),
    @NamedQuery(name = "User.findByIscustomer", query = "SELECT u FROM User u WHERE u.iscustomer = :iscustomer"),
    @NamedQuery(name = "User.findByUsertypeid", query = "SELECT u FROM User u WHERE u.usertypeid = :usertypeid"),
    @NamedQuery(name = "User.findByDatecreated", query = "SELECT u FROM User u WHERE u.datecreated = :datecreated"),
    @NamedQuery(name = "User.findByTimecreated", query = "SELECT u FROM User u WHERE u.timecreated = :timecreated"),
    @NamedQuery(name = "User.findByCreatedby", query = "SELECT u FROM User u WHERE u.createdby = :createdby"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "staffid")
    private int staffid;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "isstaff")
    private short isstaff;
    @Basic(optional = false)
    @Column(name = "iscustomer")
    private short iscustomer;
    @Basic(optional = false)
    @Column(name = "usertypeid")
    private int usertypeid;
    @Basic(optional = false)
    @Column(name = "datecreated")
    private String datecreated;
    @Basic(optional = false)
    @Column(name = "timecreated")
    private String timecreated;
    @Basic(optional = false)
    @Column(name = "createdby")
    private int createdby;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Requester> requesterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "changerequestedby")
    private Collection<Requestforchange> requestforchangeCollection;
    @JoinColumn(name = "userid", referencedColumnName = "staffid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Staff staff;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne(optional = false)
    private Customer customerid;
    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    @ManyToOne(optional = false)
    private Roles roleid;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public User(Integer userid, int staffid, String username, String password, short isstaff, short iscustomer, int usertypeid, String datecreated, String timecreated, int createdby, String status) {
        this.userid = userid;
        this.staffid = staffid;
        this.username = username;
        this.password = password;
        this.isstaff = isstaff;
        this.iscustomer = iscustomer;
        this.usertypeid = usertypeid;
        this.datecreated = datecreated;
        this.timecreated = timecreated;
        this.createdby = createdby;
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getIsstaff() {
        return isstaff;
    }

    public void setIsstaff(short isstaff) {
        this.isstaff = isstaff;
    }

    public short getIscustomer() {
        return iscustomer;
    }

    public void setIscustomer(short iscustomer) {
        this.iscustomer = iscustomer;
    }

    public int getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(int usertypeid) {
        this.usertypeid = usertypeid;
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

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Requester> getRequesterCollection() {
        return requesterCollection;
    }

    public void setRequesterCollection(Collection<Requester> requesterCollection) {
        this.requesterCollection = requesterCollection;
    }

    @XmlTransient
    public Collection<Requestforchange> getRequestforchangeCollection() {
        return requestforchangeCollection;
    }

    public void setRequestforchangeCollection(Collection<Requestforchange> requestforchangeCollection) {
        this.requestforchangeCollection = requestforchangeCollection;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.User[ userid=" + userid + " ]";
    }
    
}
