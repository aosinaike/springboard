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
@Table(name = "assetitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assetitem.findAll", query = "SELECT a FROM Assetitem a"),
    @NamedQuery(name = "Assetitem.findByAssetitemid", query = "SELECT a FROM Assetitem a WHERE a.assetitemid = :assetitemid"),
    @NamedQuery(name = "Assetitem.findByName", query = "SELECT a FROM Assetitem a WHERE a.name = :name"),
    @NamedQuery(name = "Assetitem.findByMarketname", query = "SELECT a FROM Assetitem a WHERE a.marketname = :marketname"),
    @NamedQuery(name = "Assetitem.findByBarcode", query = "SELECT a FROM Assetitem a WHERE a.barcode = :barcode"),
    @NamedQuery(name = "Assetitem.findByItemuniquecode", query = "SELECT a FROM Assetitem a WHERE a.itemuniquecode = :itemuniquecode"),
    @NamedQuery(name = "Assetitem.findByColor", query = "SELECT a FROM Assetitem a WHERE a.color = :color"),
    @NamedQuery(name = "Assetitem.findBySize", query = "SELECT a FROM Assetitem a WHERE a.size = :size"),
    @NamedQuery(name = "Assetitem.findByDateregistered", query = "SELECT a FROM Assetitem a WHERE a.dateregistered = :dateregistered"),
    @NamedQuery(name = "Assetitem.findByTimeregistered", query = "SELECT a FROM Assetitem a WHERE a.timeregistered = :timeregistered"),
    @NamedQuery(name = "Assetitem.findByStatus", query = "SELECT a FROM Assetitem a WHERE a.status = :status")})
public class Assetitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assetitemid")
    private Long assetitemid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "marketname")
    private String marketname;
    @Basic(optional = false)
    @Column(name = "barcode")
    private String barcode;
    @Basic(optional = false)
    @Column(name = "itemuniquecode")
    private String itemuniquecode;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "dateregistered")
    private String dateregistered;
    @Basic(optional = false)
    @Column(name = "timeregistered")
    private String timeregistered;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetitemid")
    private Collection<Providedassetitem> providedassetitemCollection;
    @OneToMany(mappedBy = "itemid1")
    private Collection<Attributesitems> attributesitemsCollection;

    public Assetitem() {
    }

    public Assetitem(Long assetitemid) {
        this.assetitemid = assetitemid;
    }

    public Assetitem(Long assetitemid, String name, String marketname, String barcode, String itemuniquecode, String color, String size, String dateregistered, String timeregistered, String status) {
        this.assetitemid = assetitemid;
        this.name = name;
        this.marketname = marketname;
        this.barcode = barcode;
        this.itemuniquecode = itemuniquecode;
        this.color = color;
        this.size = size;
        this.dateregistered = dateregistered;
        this.timeregistered = timeregistered;
        this.status = status;
    }

    public Long getAssetitemid() {
        return assetitemid;
    }

    public void setAssetitemid(Long assetitemid) {
        this.assetitemid = assetitemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getItemuniquecode() {
        return itemuniquecode;
    }

    public void setItemuniquecode(String itemuniquecode) {
        this.itemuniquecode = itemuniquecode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(String dateregistered) {
        this.dateregistered = dateregistered;
    }

    public String getTimeregistered() {
        return timeregistered;
    }

    public void setTimeregistered(String timeregistered) {
        this.timeregistered = timeregistered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Providedassetitem> getProvidedassetitemCollection() {
        return providedassetitemCollection;
    }

    public void setProvidedassetitemCollection(Collection<Providedassetitem> providedassetitemCollection) {
        this.providedassetitemCollection = providedassetitemCollection;
    }

    @XmlTransient
    public Collection<Attributesitems> getAttributesitemsCollection() {
        return attributesitemsCollection;
    }

    public void setAttributesitemsCollection(Collection<Attributesitems> attributesitemsCollection) {
        this.attributesitemsCollection = attributesitemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetitemid != null ? assetitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assetitem)) {
            return false;
        }
        Assetitem other = (Assetitem) object;
        if ((this.assetitemid == null && other.assetitemid != null) || (this.assetitemid != null && !this.assetitemid.equals(other.assetitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Assetitem[ assetitemid=" + assetitemid + " ]";
    }
    
}
