/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "itemattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemattribute.findAll", query = "SELECT i FROM Itemattribute i"),
    @NamedQuery(name = "Itemattribute.findByItemattributeid", query = "SELECT i FROM Itemattribute i WHERE i.itemattributeid = :itemattributeid"),
    @NamedQuery(name = "Itemattribute.findByAttribute", query = "SELECT i FROM Itemattribute i WHERE i.attribute = :attribute"),
    @NamedQuery(name = "Itemattribute.findByFeatures", query = "SELECT i FROM Itemattribute i WHERE i.features = :features"),
    @NamedQuery(name = "Itemattribute.findByStatus", query = "SELECT i FROM Itemattribute i WHERE i.status = :status")})
public class Itemattribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemattributeid")
    private Integer itemattributeid;
    @Basic(optional = false)
    @Column(name = "attribute")
    private String attribute;
    @Basic(optional = false)
    @Column(name = "features")
    private String features;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "itemattributeid")
    private Collection<Attributesitems> attributesitemsCollection;
    @JoinColumn(name = "servicerequesttypeid", referencedColumnName = "servicerequesttypeid")
    @ManyToOne(optional = false)
    private Servicerequesttype servicerequesttypeid;

    public Itemattribute() {
    }

    public Itemattribute(Integer itemattributeid) {
        this.itemattributeid = itemattributeid;
    }

    public Itemattribute(Integer itemattributeid, String attribute, String features, int status) {
        this.itemattributeid = itemattributeid;
        this.attribute = attribute;
        this.features = features;
        this.status = status;
    }

    public Integer getItemattributeid() {
        return itemattributeid;
    }

    public void setItemattributeid(Integer itemattributeid) {
        this.itemattributeid = itemattributeid;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Attributesitems> getAttributesitemsCollection() {
        return attributesitemsCollection;
    }

    public void setAttributesitemsCollection(Collection<Attributesitems> attributesitemsCollection) {
        this.attributesitemsCollection = attributesitemsCollection;
    }

    public Servicerequesttype getServicerequesttypeid() {
        return servicerequesttypeid;
    }

    public void setServicerequesttypeid(Servicerequesttype servicerequesttypeid) {
        this.servicerequesttypeid = servicerequesttypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemattributeid != null ? itemattributeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemattribute)) {
            return false;
        }
        Itemattribute other = (Itemattribute) object;
        if ((this.itemattributeid == null && other.itemattributeid != null) || (this.itemattributeid != null && !this.itemattributeid.equals(other.itemattributeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Itemattribute[ itemattributeid=" + itemattributeid + " ]";
    }
    
}
