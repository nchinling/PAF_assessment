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
        select * from b.name, b.description, brewery.name
        from beers 
        left join styles as s on s.cat_id = b.id 
        left join brewery on b.brewery_id = brewery.id
        ORDER BY count() DESC, s.style_name ASC

    """;

    

}
