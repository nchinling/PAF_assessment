package ibf2022.assessment.paf.batch3.models;

// DO NOT MODIFY THIS FILE.

public class Beer {

	private int beerId;
	private String beerName;
	private String beerDescription;

	private int breweryId;
	private String breweryName;

	public int getBeerId() {
		return beerId;
	}
	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}
	public String getBeerName() {
		return beerName;
	}
	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}
	public String getBeerDescription() {
		return beerDescription;
	}
	public void setBeerDescription(String beerDescription) {
		this.beerDescription = beerDescription;
	}
	public int getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(int breweryId) {
		this.breweryId = breweryId;
	}
	public String getBreweryName() {
		return breweryName;
	}
	public void setBreweryName(String breweryName) {
		this.breweryName = breweryName;
	}

	@Override
	public String toString() {
		return "Beer [beerId=" + beerId + ", beerName=" + beerName + ", beerDescription=" + beerDescription
				+ ", breweryId=" + breweryId + ", breweryName=" + breweryName + "]";
	}
}
