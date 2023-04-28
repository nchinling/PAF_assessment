package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {
    
    // join another table to obtain beer count
    //to implement ascending and descending too
    
    public static final String GET_ALL_STYLES_WITH_QUANTITY ="""
        select * from s.id, s.cat_id, s.style_name, c.id, c.cat_name
        from styles as s 
        left join categories as c on s.cat_id = c.id 
        left join beers as b on c.id = b.cat_id
        ORDER BY count() DESC, s.style_name ASC

    """;

    public static final String SELECT_BREWERIES_BY_BEER ="""
        select * from s.id, s.cat_id, s.style_name, c.id, c.cat_name
        from styles as s 
        left join categories as c on s.cat_id = c.id 
        left join beers as b on c.id = b.cat_id

    """;

    

}
