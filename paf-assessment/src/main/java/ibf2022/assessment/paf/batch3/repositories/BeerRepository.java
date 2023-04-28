package ibf2022.assessment.paf.batch3.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;

import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

@Repository
public class BeerRepository {

	@Autowired 
    JdbcTemplate jdbcTemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2

		String query = GET_ALL_STYLES_WITH_QUANTITY;

		return jdbcTemplate.query(query, (rs, rownum) -> {

            Style style = new Style();
            style.setStyleId(rs.getInt("id"));
            style.setName(rs.getString("style_name"));
			//need to obtain count from query
            style.setBeerCount(rs.getInt("beercount"));
            return style; 
        });

	
	}
		
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(Integer id) {
		String query = SELECT_BREWERIES_BY_BEER;
		List<Beer> beers = new ArrayList<Beer>();

        SqlRowSet rs = null;

        rs =  jdbcTemplate.queryForRowSet(query, id);
        
        //this approach doesn't allow for wildcards
        // rs =  jdbcTemplate.queryForRowSet(SELECT_RSVP_BY_NAME, name);

        while(rs.next()){
            beers.add(create(rs));
        }
        return beers;
	}

	private static Beer create(SqlRowSet rs){
        Beer beer = new Beer();
		beer.setBeerId(rs.getInt("beerid"));
		beer.setBeerName(rs.getString("beername"));
		beer.setBeerDescription(rs.getString("description"));
		beer.setBreweryName(rs.getString("breweryname"));
		beer.setBreweryId(rs.getInt("brewId"));
        return beer;
    }

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(Integer brewId) {
		// TODO: Task 4

		int brewIdd = brewId;
		String query = SELECT_BEERS_FROM_BREWERY;
		List<Brewery> breweryList = null;
        Optional<Brewery> breweryInfo = Optional.empty();
        List<Beer> beerList = new ArrayList();

        //Get all breweries
        breweryList = jdbcTemplate.query(query, (rs, rownum) -> {

			Brewery brewery = new Brewery();
        
            brewery.setBreweryId(rs.getInt("brewid"));
            brewery.setName(rs.getString("brewname"));
            brewery.setAddress1(rs.getString("address1"));
            brewery.setAddress2(rs.getString("address2"));
            brewery.setCity(rs.getString("city"));
            brewery.setPhone(rs.getString("phone"));
            brewery.setWebsite(rs.getString("website"));
            brewery.setDescription(rs.getString("brewdescription"));
            brewery.setBeers(beerList);

            return brewery; 
        });

       
        for (Brewery brewery : breweryList) {
            if (brewery.getBreweryId() == brewIdd) {
                breweryInfo = Optional.of(brewery);
                break;
            }
        }

        return breweryInfo;


		// return Optional.empty();
		// return Optional.ofNullable(brewery);
	}
}
