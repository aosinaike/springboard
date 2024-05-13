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
@Table(name = "attributesitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributesitems.findAll", query = "SELECT a FROM Attributesitems a"),
    @NamedQuery(name = "Attributesitems.findByAttributesitemsid", query = "SELECT a FROM Attributesitems a WHERE a.attributesitemsid = :attributesitemsid"),
    @NamedQuery(name = "Attributesitems.findByStatus", query = "SELECT a FROM Attributesitems a WHERE a.status = :status")})
public class Attributesitems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attributesitemsid")
    private Integer attributesitemsid;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "itemid", referencedColumnName = "serviceitemid")
    @ManyToOne
    private Serviceitem itemid;
    @JoinColumn(name = "itemid", referencedColumnName = "assetitemid")
    @ManyToOne
    private Assetitem itemid1;
    @JoinColumn(name = "itemattributeid", referencedColumnName = "itemattributeid")
    @ManyToOne
    private Itemattribute itemattributeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributesitemsid")
    private Collection<Benchmark> benchmarkCollection;

    public Attributesitems() {
    }

    public Attributesitems(Integer attributesitemsid) {
        this.attributesitemsid = attributesitemsid;
    }

    public Integer getAttributesitemsid() {
        return attributesitemsid;
    }

    public void setAttributesitemsid(Integer attributesitemsid) {
        this.attributesitemsid = attributesitemsid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Serviceitem getItemid() {
        return itemid;
    }

    public void setItemid(Serviceitem itemid) {
        this.itemid = itemid;
    }

    public Assetitem getItemid1() {
        return itemid1;
    }

    public void setItemid1(Assetitem itemid1) {
        this.itemid1 = itemid1;
    }

    public Itemattribute getItemattributeid() {
        return itemattributeid;
    }

    public void setItemattributeid(Itemattribute itemattributeid) {
        this.itemattributeid = itemattributeid;
    }

    @XmlTransient
    public Collection<Benchmark> getBenchmarkCollection() {
        return benchmarkCollection;
    }

    public void setBenchmarkCollection(Collection<Benchmark> benchmarkCollection) {
        this.benchmarkCollection = benchmarkCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attributesitemsid != null ? attributesitemsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attributesitems)) {
            return false;
        }
        Attributesitems other = (Attributesitems) object;
        if ((this.attributesitemsid == null && other.attributesitemsid != null) || (this.attributesitemsid != null && !this.attributesitemsid.equals(other.attributesitemsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Attributesitems[ attributesitemsid=" + attributesitemsid + " ]";
    }
    
}
