package edu.harvard.h2ms.domain.core;

import java.util.Set;
import javax.persistence.*;

/**
 * A location is a particular place when an event has occured (ie. the setting an observer has
 * captured an observation in the H2MS system)
 */
@Entity
@Table(name = "LOCATION")
public class Location {

  /* Properties */
  private Long id;
  private String name;
  private String type;
  private String address;
  private String country;
  private String zip;
  private Location parent;
  private Set<Location> children;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Column(name = "NAME")
  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Column(name = "TYPE")
  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  @Column(name = "ADDRESS")
  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
  }

  @Column(name = "COUNTRY")
  public String getCountry() {
    return country;
  }

  public void setCountry(final String country) {
    this.country = country;
  }

  @Column(name = "ZIP")
  public String getZip() {
    return zip;
  }

  public void setZip(final String zip) {
    this.zip = zip;
  }

  /**
   * A location can optionally have another location an it's parent Ex. LLC Headquarters may have
   * multiple entities in various locations
   */
  @ManyToOne
  @JoinColumn(name = "parent_id")
  public Location getParent() {
    return parent;
  }

  public void setParent(final Location parent) {
    this.parent = parent;
  }

  /** A location can optionally have sublocations. Ex. Departments/Multicampus Entities */
  @OneToMany
  @JoinColumn(name = "parent_id")
  public Set<Location> getChildren() {
    return children;
  }

  public void setChildren(final Set<Location> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "Location - Id: "
        + id
        + ", Name: "
        + name
        + ", Type: "
        + type
        + ", Address: "
        + address
        + ", Country: "
        + country
        + ", Zip: "
        + zip;
  }
}
