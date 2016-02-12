package org.apache.olingo.jpa.processor.core.testmodel;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.olingo.jpa.metadata.core.edm.annotation.EdmDescriptionAssozation;
import org.apache.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;

@Embeddable
public class PostalAddressData {
  @Column(name = "\"Address.StreetName\"")
  private String streetName;
  @Column(name = "\"Address.StreetNumber\"")
  private String houseNumber;
  @Column(name = "\"Address.PostOfficeBox\"")
  private String POBox;
  @Column(name = "\"Address.City\"")
  private String cityName;
  @Column(name = "\"Address.PostalCode\"")
  private String postalCode;
  @EdmIgnore
  @Column(name = "\"Address.RegionCodePublisher\"", length = 10)
  private String regionCodePublisher;
  @EdmIgnore
  @Column(name = "\"Address.RegionCodeID\"", length = 10)
  private String regionCodeID;
  @Column(name = "\"Address.Region\"")
  private String region;
  @Column(name = "\"Address.Country\"")
  private String country;

  @EdmDescriptionAssozation(languageAttribute = "language", descriptionAttribute = "name")
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "\"ISOCode\"", referencedColumnName = "\"Address.Country\"")
  private Collection<Country> countryName;

  @EdmDescriptionAssozation(languageAttribute = "language", descriptionAttribute = "name")
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumns({
      @JoinColumn(name = "\"CountryISOCode\"", referencedColumnName = "\"Address.Country\""),
      @JoinColumn(name = "\"RegionISOCode\"", referencedColumnName = "\"Address.Region\"")
  })
  private Collection<Region> regionName;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumns({
      @JoinColumn(name = "\"Address.RegionCodePublisher\"", referencedColumnName = "\"CodePublisher\"",
          nullable = false,
          insertable = false, updatable = false),
      @JoinColumn(name = "\"Address.RegionCodeID\"", referencedColumnName = "\"CodeID\"", nullable = false,
          insertable = false, updatable = false),
      @JoinColumn(name = "\"Address.Region\"", referencedColumnName = "\"DivisionCode\"", nullable = false,
          insertable = false, updatable = false)
  })
  private AdministrativeDivision administrativeDivision;

  public String getStreetName() {
    return streetName;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public String getPOBox() {
    return POBox;
  }

  public String getCityName() {
    return cityName;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getRegion() {
    return region;
  }

  public String getCountry() {
    return country;
  }

  public Collection<Country> getCountryName() {
    return countryName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public void setPOBox(String pOBox) {
    POBox = pOBox;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}