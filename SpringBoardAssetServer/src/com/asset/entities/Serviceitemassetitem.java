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
@Table(name = "serviceitemassetitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceitemassetitem.findAll", query = "SELECT s FROM Serviceitemassetitem s"),
    @NamedQuery(name = "Serviceitemassetitem.findByServiceitemassetitemid", query = "SELECT s FROM Serviceitemassetitem s WHERE s.serviceitemassetitemid = :serviceitemassetitemid"),
    @NamedQuery(name = "Serviceitemassetitem.findByConnecteditemsids", query = "SELECT s FROM Serviceitemassetitem s WHERE s.connecteditemsids = :connecteditemsids"),
    @NamedQuery(name = "Serviceitemassetitem.findByRelationship", query = "SELECT s FROM Serviceitemassetitem s WHERE s.relationship = :relationship"),
    @NamedQuery(name = "Serviceitemassetitem.findByRole", query = "SELECT s FROM Serviceitemassetitem s WHERE s.role = :role")})
public class Serviceitemassetitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "serviceitemassetitemid")
    private Integer serviceitemassetitemid;
    @Basic(optional = false)
    @Column(name = "connecteditemsids")
    private String connecteditemsids;
    @Basic(optional = false)
    @Column(name = "relationship")
    private String relationship;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @JoinColumn(name = "serviceitemid", referencedColumnName = "serviceitemid")
    @ManyToOne(optional = false)
    private Serviceitem serviceitemid;
    @JoinColumn(name = "assetitemid", referencedColumnName = "providedassetitemid")
    @ManyToOne(optional = false)
    private Providedassetitem assetitemid;

    public Serviceitemassetitem() {
    }

    public Serviceitemassetitem(Integer serviceitemassetitemid) {
        this.serviceitemassetitemid = serviceitemassetitemid;
    }

    public Serviceitemassetitem(Integer serviceitemassetitemid, String connecteditemsids, String relationship, String role) {
        this.serviceitemassetitemid = serviceitemassetitemid;
        this.connecteditemsids = connecteditemsids;
        this.relationship = relationship;
        this.role = role;
    }

    public Integer getServiceitemassetitemid() {
        return serviceitemassetitemid;
    }

    public void setServiceitemassetitemid(Integer serviceitemassetitemid) {
        this.serviceitemassetitemid = serviceitemassetitemid;
    }

    public String getConnecteditemsids() {
        return connecteditemsids;
    }

    public void setConnecteditemsids(String connecteditemsids) {
        this.connecteditemsids = connecteditemsids;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Serviceitem getServiceitemid() {
        return serviceitemid;
    }

    public void setServiceitemid(Serviceitem serviceitemid) {
        this.serviceitemid = serviceitemid;
    }

    public Providedassetitem getAssetitemid() {
        return assetitemid;
    }

    public void setAssetitemid(Providedassetitem assetitemid) {
        this.assetitemid = assetitemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceitemassetitemid != null ? serviceitemassetitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceitemassetitem)) {
            return false;
        }
        Serviceitemassetitem other = (Serviceitemassetitem) object;
        if ((this.serviceitemassetitemid == null && other.serviceitemassetitemid != null) || (this.serviceitemassetitemid != null && !this.serviceitemassetitemid.equals(other.serviceitemassetitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Serviceitemassetitem[ serviceitemassetitemid=" + serviceitemassetitemid + " ]";
    }
    
}
