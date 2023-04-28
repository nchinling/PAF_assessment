package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.services.BeerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class BeerController {

	//TODO Task 2 - view 0
	
    public static final String ATTR_STYLES = "styles";
	public static final String ATTR_STYLE = "s";
    
	@Autowired
	private BeerService beerSvc;

	@Autowired
	private BeerRepository beerRepo;

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
    public String getBeerStyleDetails(@PathVariable String id, Model m, HttpSession session) {

		Integer cId = Integer.parseInt(id);
		beerRepo.getBreweriesByBeer(cId);


		// model.addAttribute(ATTR_ITEM, new Item());
		// m.addAttribute (ATTR_STYLE, style);
		// m.addAttribute ("description", description);
		// m.addAttribute("breweryName", breweryName);

		//Added 2 Account objects and 1 Transaction object to view1
		//Account objects added as Transaction doesn't have name of customer. 
       return "view1";
	}
	

	//TODO Task 4 - view 2

	
	//TODO Task 5 - view 2, place order


	private Style getStyle(HttpSession sess) {
		Style style = (Style)sess.getAttribute(ATTR_STYLES);
		if (null == style){
			style = new Style();
			sess.setAttribute(ATTR_STYLES, style);
		}
		return style;
	}
	

}





