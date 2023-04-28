package ibf2022.assessment.paf.batch3.models;

import java.util.List;
import java.util.LinkedList;

// DO NOT MODIFY THIS FILE.

public class Brewery {

	private int breweryId;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String phone;
	private String website;
	private String description;
	private List<Beer> beers = new LinkedList<>();

	public int getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(int breweryId) {
		this.breweryId = breweryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Beer> getBeers() {
		return beers;
	}
	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}
	public void addBeer(Beer beer) {
		this.beers.add(beer);
	}

	@Override
	public String toString() {
		return "Brewery [breweryId=" + breweryId + ", name=" + name + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", phone=" + phone + ", website=" + website + ", description="
				+ description + ", beers=" + beers + "]";
	}
}
