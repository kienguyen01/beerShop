package nl.inholland.demo.controller;

import nl.inholland.demo.model.Beer;
import nl.inholland.demo.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "beers")
public class BeerController {
    private BeerService service;

    public BeerController(BeerService service) {
        this.service = service;
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Beer>> getBeers(){
//        return ResponseEntity.status(200).body(service.getBeers());
        return new ResponseEntity<>(service.getBeers(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Beer> createBeer(@RequestBody Beer beer){
        service.addBeer(beer);
//        return ResponseEntity.status(201).body(beer);
        return new ResponseEntity<>(beer, HttpStatus.CREATED);

    }

    @RequestMapping(value = "", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Beer>> deleteBeer(@RequestBody Beer beer){
        service.deleteBeer(beer);
//        return ResponseEntity.noContent().build();
        return new ResponseEntity<>(service.getBeers(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Beer>> updateBeer(@RequestBody Beer beer){
        service.updateBeer(beer);
        return new ResponseEntity<>(service.getBeers(), HttpStatus.OK);
    }
}
