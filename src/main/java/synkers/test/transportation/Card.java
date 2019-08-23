package synkers.test.transportation;

public class Card {

    private Long id;
    private String departure;
    private String arrival;
    private String seat;
    private String vehicle;
    private String gate;
    private String number;
    private String baggage;


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setDeparture(String departure)
    {
        this.departure = departure;
    }

    public String getDeparture()
    {
        return this.departure;
    }

    public void setArrival(String arrival)
    {
        this.arrival = arrival;
    }

    public String getArrival()
    {
        return this.arrival;
    }

    public String getSeat()
    {
        return this.seat;
    }

    public void setSeat(String seat)
    {
        this.seat = seat;
    }

    public void setVehicle(String vehicle)
    {
        this.vehicle = vehicle;
    }

    public String getVehicle()
    {
        return this.vehicle;
    }

    public void setGate(String gate)
    {
        this.gate = gate;
    }

    public String getGate()
    {
        return this.gate = gate;
    }

    public void setBaggage(String baggage)
    {
        this.baggage = baggage;
    }

    public String getBaggage()
    {
        return this.baggage;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return this.number;
    }

    @Override
    public String toString() {

        switch (this.vehicle)
        {
            case "train":
                return this.printTrain();
            case "airplane":
                return this.printAirplane();
            case "bus":
                return this.printBus();
            default:
                return "{" +
                        "departure='" + departure + '\'' +
                        ", arrival='" + arrival + '\'' +
                        ", seat=" + seat + '\'' +
                        ", vehicle='" + vehicle + '\'' +
                        '}';
        }


    }


    public String printTrain()
    {
        String text = "Take train " + number + " from " + departure + " to  " + arrival + ". Sit in Seat "+seat;

        return text;
    }

    public String printAirplane()
    {
        String text = "From "+departure+" take flight "+number+" to "+arrival+" , Gate " + gate + " seat: "+seat +'\''+"  baggage drop at counter " + baggage;
        return text;
    }

    public String printBus()
    {
        String bus = "Take "+ number +" bus from " + departure + " to " + arrival;
        if(seat.equals(""))
        {
            bus = bus + " seat: no No seat assignment.";
        }else{
            bus = bus + " seat: " + seat;
        }
        return bus;
    }




}
