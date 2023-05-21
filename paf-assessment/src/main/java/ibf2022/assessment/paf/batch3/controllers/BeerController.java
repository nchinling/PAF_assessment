package ibf2022.assessment.paf.batch3.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.repositories.OrderRepository;
import ibf2022.assessment.paf.batch3.services.BeerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class BeerController {

	//TODO Task 2 - view 0
	
    public static final String ATTR_STYLES = "styles";
	public static final String ATTR_STYLE = "s";
	public static final String ATTR_BEERS = "beers";
	public static final String ATTR_BREWERY = "brewery";
	public static final String ATTR_ORDERID = "orderId";


	@Autowired
	private BeerService beerSvc;

	@Autowired
	private BeerRepository beerRepo;

	@Autowired
	private OrderRepository orderRepo;


	//start page 
	@GetMapping(path={"/", "/view0.html"})
	public String getIndex(Model model, HttpSession sess) {

		Style style= getStyle(sess);
        List<Style> styles = beerRepo.getStyles();
        
		// model.addAttribute(ATTR_ITEM, new Item());
		// model.addAttribute(ATTR_STYLES, styles);
		model.addAttribute(ATTR_STYLES, styles);
		model.addAttribute(ATTR_STYLE, style);

		return "view0";
	}

	
	//TODO Task 3 - view 1

	
	@GetMapping(path="/beer/style/{id}")
    public String getBeerStyleDetails(@PathVariable String id,  @RequestParam("styleName") String styleName,
									 Model model, HttpSession sess) {

		Style style= getStyle(sess);
		Integer cId = Integer.parseInt(id);
		List<Beer> beers = beerRepo.getBreweriesByBeer(cId);

		style.setName(styleName);
		System.out.println(">>>>>>>>StyleNameIs>>>>>>>>" + style.getName());
		model.addAttribute(ATTR_STYLE, style);
		model.addAttribute(ATTR_BEERS, beers);
 
       return "view1";
	}
	

	//TODO Task 4 - view 2

	// @GetMapping(path="/brewery/{breweryId}")
	// @GetMapping(path="/beer/style/{id}")

	@GetMapping(path="/beer/style/brewery/{breweryId}")
	// @GetMapping(path="/brewery/{breweryId}")
    public String getBeersByBreweryId(@PathVariable String breweryId, Model model, HttpSession sess) {

		System.out.println(">>>>>BreweryIdIs>>>>>" + breweryId);
		Style style= getStyle(sess);
		int cId = Integer.parseInt(breweryId);
		System.out.println(">>>>>BreweryIdIsAfterParseIs>>>>>" + cId);
		Optional<Brewery> optBrewery = beerRepo.getBeersFromBrewery(cId);
	
		Brewery brewery=optBrewery.get();
		System.out.println(">>>>>BreweryNameIs>>>>>" + brewery.getName());

		model.addAttribute(ATTR_BREWERY, brewery);
 
       return "view2";
	}
	

	
	//TODO Task 5 - view 2, place order
	@PostMapping(path="/brewery/{breweryId}/order", consumes = "application/x-www-form-urlencoded")
	public String addTodo(@PathVariable String breweryId, @ModelAttribute Brewery brewery, HttpServletRequest httpRequest, Model model, HttpSession sess) {

	
		String description = httpRequest.getParameter("description");
		
		String orderId = beerSvc.placeOrder(brewery, breweryId);
	
		

		model.addAttribute(ATTR_ORDERID, orderId);

		// return "todo_template";
		return "view3";
	}





	private Style getStyle(HttpSession sess) {
		Style style = (Style)sess.getAttribute(ATTR_STYLES);
		if (null == style){
			style = new Style();
			sess.setAttribute(ATTR_STYLES, style);
		}
		return style;
	}
	

}





