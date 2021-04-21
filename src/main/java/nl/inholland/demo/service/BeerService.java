package nl.inholland.demo.service;

import nl.inholland.demo.model.Beer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class BeerService {


    private List<Beer> beers = new ArrayList<>();

    public BeerService(){
        this.beers = new ArrayList<>(
                List.of(
                        new Beer("Heneiken", 330, 1.20),
                        new Beer("Amstel", 300, 1.00),
                        new Beer("Corona", 330, 2.00)
                )
        );
    }
    public List<Beer> getBeers() {
        return beers;
    }

    public Beer addBeer(Beer beer){
        beers.add(beer);
        return beer;
    }

    public Beer getBeerById(UUID beerID){
        for (Beer beer : beers){
            if(beer.getUuid() == beerID){
                return beer;
            }
        }
        return null;
    }

    public Beer updateBeer(Beer newBeer){
        for(Beer beer : beers){
            if (newBeer.getUuid().equals(beer.getUuid())){
                beers.set(beers.indexOf(beer), beer);
            }
        }

        return newBeer;
    }

//    public Beer deleteBeer(UUID beerID){
//        Beer beer = getBeerById(beerID);
//        if(getBeerById(beerID) != null){
//            beers.remove(beer);
//        }
//        return beer;
//    }
    public Beer deleteBeer(Beer beer){
        beers.removeIf(x -> (beer.getUuid().equals(x.getUuid())));
        return beer;
    }

}
