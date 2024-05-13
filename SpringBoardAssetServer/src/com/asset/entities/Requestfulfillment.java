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
@Table(name = "requestfulfillment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requestfulfillment.findAll", query = "SELECT r FROM Requestfulfillment r"),
    @NamedQuery(name = "Requestfulfillment.findByRequestfufillmentid", query = "SELECT r FROM Requestfulfillment r WHERE r.requestfufillmentid = :requestfufillmentid"),
    @NamedQuery(name = "Requestfulfillment.findByRequestsentdate", query = "SELECT r FROM Requestfulfillment r WHERE r.requestsentdate = :requestsentdate"),
    @NamedQuery(name = "Requestfulfillment.findByRequesttime", query = "SELECT r FROM Requestfulfillment r WHERE r.requesttime = :requesttime"),
    @NamedQuery(name = "Requestfulfillment.findByFulfillmentdate", query = "SELECT r FROM Requestfulfillment r WHERE r.fulfillmentdate = :fulfillmentdate"),
    @NamedQuery(name = "Requestfulfillment.findByFulfillmenttime", query = "SELECT r FROM Requestfulfillment r WHERE r.fulfillmenttime = :fulfillmenttime"),
    @NamedQuery(name = "Requestfulfillment.findByStatus", query = "SELECT r FROM Requestfulfillment r WHERE r.status = :status")})
public class Requestfulfillment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "requestfufillmentid")
    private Integer requestfufillmentid;
    @Basic(optional = false)
    @Column(name = "requestsentdate")
    private String requestsentdate;
    @Basic(optional = false)
    @Column(name = "requesttime")
    private String requesttime;
    @Basic(optional = false)
    @Column(name = "fulfillmentdate")
    private String fulfillmentdate;
    @Basic(optional = false)
    @Column(name = "fulfillmenttime")
    private String fulfillmenttime;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestfulfillmentid")
    private Collection<Requester> requesterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestfufillmentid")
    private Collection<Request> requestCollection;
    @JoinColumn(name = "servicedeskid", referencedColumnName = "servicedeskid")
    @ManyToOne(optional = false)
    private Servicedesk servicedeskid;

    public Requestfulfillment() {
    }

    public Requestfulfillment(Integer requestfufillmentid) {
        this.requestfufillmentid = requestfufillmentid;
    }

    public Requestfulfillment(Integer requestfufillmentid, String requestsentdate, String requesttime, String fulfillmentdate, String fulfillmenttime, String status) {
        this.requestfufillmentid = requestfufillmentid;
        this.requestsentdate = requestsentdate;
        this.requesttime = requesttime;
        this.fulfillmentdate = fulfillmentdate;
        this.fulfillmenttime = fulfillmenttime;
        this.status = status;
    }

    public Integer getRequestfufillmentid() {
        return requestfufillmentid;
    }

    public void setRequestfufillmentid(Integer requestfufillmentid) {
        this.requestfufillmentid = requestfufillmentid;
    }

    public String getRequestsentdate() {
        return requestsentdate;
    }

    public void setRequestsentdate(String requestsentdate) {
        this.requestsentdate = requestsentdate;
    }

    public String getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(String requesttime) {
        this.requesttime = requesttime;
    }

    public String getFulfillmentdate() {
        return fulfillmentdate;
    }

    public void setFulfillmentdate(String fulfillmentdate) {
        this.fulfillmentdate = fulfillmentdate;
    }

    public String getFulfillmenttime() {
        return fulfillmenttime;
    }

    public void setFulfillmenttime(String fulfillmenttime) {
        this.fulfillmenttime = fulfillmenttime;
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
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    public Servicedesk getServicedeskid() {
        return servicedeskid;
    }

    public void setServicedeskid(Servicedesk servicedeskid) {
        this.servicedeskid = servicedeskid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestfufillmentid != null ? requestfufillmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requestfulfillment)) {
            return false;
        }
        Requestfulfillment other = (Requestfulfillment) object;
        if ((this.requestfufillmentid == null && other.requestfufillmentid != null) || (this.requestfufillmentid != null && !this.requestfufillmentid.equals(other.requestfufillmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Requestfulfillment[ requestfufillmentid=" + requestfufillmentid + " ]";
    }
    
}
