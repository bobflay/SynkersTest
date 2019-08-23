package synkers.test.transportation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/demo")
public class DemoController {


    private Card cards[];
    private Card start_city;
    private Card end_city;
    private ArrayList<Card> result;
    private String output;

    @ResponseBody
    @RequestMapping(method = GET, produces = "application/json")
    public String demo() {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file and convert to cities object
        try {
             this.cards = objectMapper.readValue(new File("cities.json"), Card[].class);

             this.getStartEndCity();
             this.pairingTrips();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return this.output;
    }


    public void getStartEndCity()
    {
        for (int i= 0; i<this.cards.length;i++)
        {
            Boolean hasPreviousTrip = false;
            Boolean isLastTrip = true;


            for (int j=0; j<this.cards.length;j++)
            {
                if(this.cards[i].getDeparture().equals(this.cards[j].getArrival()))
                {
                    hasPreviousTrip = true;
                }else if(this.cards[i].getArrival().equals(this.cards[j].getDeparture()))
                {
                    isLastTrip = false;
                }
            }


            // We found the start point of the trip,
            if (hasPreviousTrip==false) {
                this.start_city = this.cards[i];
            } // And the end of the trip
            else if (isLastTrip==true) {
                this.end_city = this.cards[i];
            }

        }
    }


    public void pairingTrips()
    {
        this.result = new ArrayList<Card>();
        this.result.add(this.start_city);
        while (this.result.size()<this.cards.length)
        {
            for (int i = 0; i <this.cards.length ; i++) {
                if(result.get(result.size()-1).getArrival().equals(this.cards[i].getDeparture()))
                {
                    result.add(this.cards[i]);
                }
            }
        }


        result.forEach((n) -> this.output = this.output + n.toString() + "\n");



    }



}
