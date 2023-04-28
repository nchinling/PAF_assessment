package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {
    
    // join another table to obtain beer count
    //to implement ascending and descending too
    
    public static final String GET_ALL_STYLES_WITH_QUANTITY ="""

        select s.id, s.cat_id, s.style_name, count(*) as beercount 
        from styles as s 
        join categories as c on s.cat_id = c.id 
        join beers as b on b.cat_id = c.id and 
        b.style_id = s.id group by s.id, s.style_name 
        ORDER BY beercount DESC, s.style_name ASC

    """;

    public static final String SELECT_BREWERIES_BY_BEER ="""
        select b.id as beerid, b.name as beername, b.descript, brew.name as brewname, b.brewery_id as brewId
        from styles as s
        left join beers as b on b.style_id = s.id
        left join breweries as brew on b.brewery_id = brew.id
        where s.id =?
        ORDER BY b.name ASC

    """;

    public static final String SELECT_BEERS_FROM_BREWERY ="""

        SELECT brew.id as brewid, brew.name as brewname, brew.descript as brewdescription, 
        brew.address1 as address1, brew.address2 as address2, brew.city as city, brew.phone as phone, brew.website as website,
        b.name as beername, b.descript as beerdescription
        FROM breweries as brew
        LEFT JOIN beers as b ON b.brewery_id = brew.id
        WHERE brew.id = ?
        ORDER BY beername ASC

    """;

}



