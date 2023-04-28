package ibf2022.assessment.paf.batch3.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Brewery;

@Repository
public class OrderRepository {

	// TODO: Task 5
	@Autowired
    private MongoTemplate mongoTemplate;


	public void insertOrder(Brewery brewery,  String brewId, String orderId8Char) {
		
		// foreign key(`brewery_id`) references breweries(`id`),

    
      
		Document orderDoc = new Document()
				.append("orderId", orderId8Char)
				.append("date",LocalDate.now().toString())
				.append("breweryId", brewery.getBreweryId())
				.append("orders", "arrayoforders");
				

		mongoTemplate.insert(orderDoc, "orders");
	}

}
