import java.util.ArrayList;

public class EEPV3 {
    public static void main(String[] args) {
        


    }

    private static void calculate(int stoppingCriteria){
        ArrayList<String[]> data = new ArrayList<String[]>(); // Stores per row
        ArrayList<String> inQueue = new ArrayList<>();
        ArrayList<String[]> arrivalList = new ArrayList<>();

        String inService = "",evntType = "",temp = "{ ";
        int customerNum = 0, qt = 0 ,bt = 0, p = 0 , n = 0, eWQ = 0, wQ = 0, eTS = 0, 
             tS=0, iQ = 0, q =0, iB = 0;
        Double Interarrival = 0.0, arrival = 0.0, service = 0.0, time = 0.0;
        
        Double[] serviceTimes = {2.90,1.76,3.39,4.52,4.46,4.36,2.07,3.36,2.37,5.38};
        Double[] interTimes = {1.73,1.35,0.71,0.62,14.28,0.7,15.52,3.15,1.76,1.0};

        do{
            String[] datarow = new String[19];
            String[] datarowDepart = new String[19];
            

            if(customerNum == 0) {
                evntType = "initializing";
            } else {
                service = serviceTimes[customerNum - 1];
                Interarrival = interTimes[customerNum - 1];

                if(customerNum == 1){
                    evntType = "Arrival";
                    n++;
                } else {

                    for (String[] e : arrivalList) {
                        if(arrival > Double.valueOf(e[3])){ // Compares arrival time of this customer to check if A previous customers leaves before they enter
                            n++;
                            p++;
                            arrivalList.remove(e); // Removes the object from arrivals
                            data.add(datarowDepart); // Adds the departure list to the data for printing
                        }
                    }


                    
                }
            }

            

            
/*
         * 0 = Customer number
         * 1 = InterArrival
         * 2 = Arrival
         * 3 = Service
         * 4 = Time
         * 5 = Event Type
         * 6 = Q(t) 
         * 7 = B(t)
         * 8 = Arrival Time in Queue
         * 9 = Arrival Time in Service
         * 10 = P
         * 11 = N
         * 12 = EWQ
         * 13 = WQ*
         * 14 = ETS
         * 15 = TS*
         * 16 = FQ
         * 17 = Q
         * 18 = FB
         */

            datarow[0] = Integer.toString(customerNum);
            datarow[1] = Double.toString(Interarrival);
            datarow[2] = Double.toString(arrival);
            datarow[3] = Double.toString(service);
            datarow[4] = Double.toString(time);
            datarow[5] = evntType;
            datarow[6] = Integer.toString(qt);
            datarow[7] = Integer.toString(bt);

            for (int x = 0 ; x < inQueue.size(); x++) {
                if(inQueue.size() == x) {
                    temp += inQueue.get(x) + " }";
                } else {
                    temp += inQueue.get(x) + " , ";
                }
            }

            datarow[8] = temp;
            datarow[9] = inService;
            datarow[10] = Integer.toString(p);
            datarow[11] = Integer.toString(n);
            datarow[12] = Integer.toString(eWQ);
            datarow[13] = Integer.toString(wQ);
            datarow[14] = Integer.toString(eTS);
            datarow[15] = Integer.toString(tS);
            datarow[16] = Integer.toString(iQ);
            datarow[17] = Integer.toString(q);
            datarow[18] = Integer.toString(iB);

            if(evntType.equals("Arrival")){
                arrivalList.add(datarow);
            }
            data.add(datarow);
        } while(stoppingCriteria < time);



    }
}
