package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {
    
    // join another table to obtain beer count
    //to implement ascending and descending too
    
    public static final String GET_ALL_STYLES_WITH_QUANTITY ="""

        select s.id, s.cat_id, s.style_name, count(*) as beercount 
        from styles as s 
        join categories as c on s.cat_id = c.id 
        join beers as b on b.cat_id = c.id and 
        b.style_id = s.id 
        GROUP BY s.id, s.style_name 
        ORDER BY beercount DESC, s.style_name ASC

    """;

    public static final String SELECT_BREWERIES_BY_BEER ="""

        select b.id as beer_id, b.name as beer_name, b.descript as beer_description, brew.name as brewery_name, b.brewery_id as brewery_id
        from beers as b
        left join styles as s on b.style_id = s.id
        left join breweries as brew on b.brewery_id = brew.id
        where s.id =?
        ORDER BY b.name ASC

    """;


    public static final String SELECT_BEERS_FROM_BREWERY ="""

    SELECT breweries.id as brewery_id, breweries.name as brewery_name, breweries.descript as brewery_description, 
    breweries.address1 as address1, breweries.address2 as address2, breweries.city as city, breweries.phone as phone, breweries.website as website,
    beers.name as beer_name, beers.descript as beer_description, beers.brewery_id
    FROM breweries
    LEFT JOIN beers ON breweries.id=beers.brewery_id
    WHERE breweries.id = ?
    ORDER BY beer_name ASC

    """;

}
