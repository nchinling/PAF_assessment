package ibf2022.assessment.paf.batch3.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.repositories.OrderRepository;

@Service
public class BeerService {

	@Autowired
    private OrderRepository orderRepo;

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(Brewery brewery, String brewId) {
		// TODO: Task 5 

		// insertOrder
		UUID orderId = UUID.randomUUID();
        String orderId8Char = orderId.toString().substring(0, 8);
		orderRepo.insertOrder(brewery, brewId, orderId8Char);

		return orderId8Char;
	}

}
