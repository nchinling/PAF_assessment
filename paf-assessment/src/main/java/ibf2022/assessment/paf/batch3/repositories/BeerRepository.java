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

        System.out.println(">>>>>>>>>I am inside getBreweriesByBeer");
        
        //this approach doesn't allow for wildcards
        // rs =  jdbcTemplate.queryForRowSet(SELECT_RSVP_BY_NAME, name);

        while(rs.next()){
            beers.add(create(rs));
        }
        return beers;
	}

	private static Beer create(SqlRowSet rs){
        Beer beer = new Beer();
		beer.setBeerId(rs.getInt("beer_id"));
		beer.setBeerName(rs.getString("beer_name"));
		beer.setBeerDescription(rs.getString("beer_description"));
		beer.setBreweryName(rs.getString("brewery_name"));
		beer.setBreweryId(rs.getInt("brewery_id"));
        return beer;
    }


	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(int brewId) {
        // TODO: Task 4
    
        String query = SELECT_BEERS_FROM_BREWERY;
    
        SqlRowSet rs = jdbcTemplate.queryForRowSet(query, brewId);
        Optional<Brewery> breweryInfo = Optional.empty();
        List<Beer> beers = new ArrayList<Beer>();
    
        if (rs.next()) {
            Brewery brewery = new Brewery();
    
            brewery.setBreweryId(rs.getInt("brewery_id"));
            brewery.setName(rs.getString("brewery_name"));
            brewery.setAddress1(rs.getString("address1"));
            brewery.setAddress2(rs.getString("address2"));
            brewery.setCity(rs.getString("city"));
            brewery.setPhone(rs.getString("phone"));
            brewery.setWebsite(rs.getString("website"));
            brewery.setDescription(rs.getString("brewery_description"));

            brewery.setBeers(beers);
    
            breweryInfo = Optional.of(brewery);
        }
    
        return breweryInfo;
    }
    
}
