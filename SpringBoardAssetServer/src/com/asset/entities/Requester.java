/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "requester")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requester.findAll", query = "SELECT r FROM Requester r"),
    @NamedQuery(name = "Requester.findByRequesterid", query = "SELECT r FROM Requester r WHERE r.requesterid = :requesterid"),
    @NamedQuery(name = "Requester.findByStatus", query = "SELECT r FROM Requester r WHERE r.status = :status")})
public class Requester implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requesterid")
    private Integer requesterid;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User userid;
    @JoinColumn(name = "requestfulfillmentid", referencedColumnName = "requestfufillmentid")
    @ManyToOne(optional = false)
    private Requestfulfillment requestfulfillmentid;

    public Requester() {
    }

    public Requester(Integer requesterid) {
        this.requesterid = requesterid;
    }

    public Requester(Integer requesterid, String status) {
        this.requesterid = requesterid;
        this.status = status;
    }

    public Integer getRequesterid() {
        return requesterid;
    }

    public void setRequesterid(Integer requesterid) {
        this.requesterid = requesterid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Requestfulfillment getRequestfulfillmentid() {
        return requestfulfillmentid;
    }

    public void setRequestfulfillmentid(Requestfulfillment requestfulfillmentid) {
        this.requestfulfillmentid = requestfulfillmentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requesterid != null ? requesterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requester)) {
            return false;
        }
        Requester other = (Requester) object;
        if ((this.requesterid == null && other.requesterid != null) || (this.requesterid != null && !this.requesterid.equals(other.requesterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Requester[ requesterid=" + requesterid + " ]";
    }
    
}
