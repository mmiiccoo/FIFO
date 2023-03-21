public class EEPV2 {
    public static void main(String[] args){

    } // end of main method

    private static void calculate(int stoppingCriteria){
        ArrayList<String[]> data = new ArrayList<String[]>(); // Stores per row
        int customerNum = 0, Interarrival = 0, arrival = 0, service = 0, serviceBegins = 0, waiting = 0, serviceEnds = 0, customerTime = 0, idle = 0, counter = 0; 
        
        int[] averageValues = new int[7]; // Stores the average value. Follow the arrangement on the specifications 1-7.
        data.clear(); // resets the data

        // Calculation area

        if(option.equals("A")){
            do{
            customerNum++;
            String[] row = new String[9];
            
            // Per row calculations 
            if(customerNum == 1) {
                Interarrival = 0;
                arrival = 0;
            } else {
                Interarrival = interArrivalTimeCompare();

                arrival = Interarrival + Integer.valueOf(data.get(data.size() - 1)[2]);
                
                if (arrival < Integer.valueOf(data.get(data.size() - 1)[6])){
                    serviceBegins = Integer.valueOf(data.get(data.size() - 1)[6]);
                } else{ // add another else if, if other situation is not anticipated
                    serviceBegins = arrival; 
                }

                if (arrival > Integer.valueOf(data.get(data.size() - 1)[6])){
                    idle = arrival - Integer.valueOf(data.get(data.size() - 1)[6]);
                } else {
                    idle = 0;
                }

            }

            service = serviceTimeCompare();

            
            waiting = serviceBegins - arrival;
            serviceEnds = service + serviceBegins;
            customerTime = serviceEnds - arrival;

            // Setting of Values;
            row[0] = Integer.toString(customerNum);
            row[1] = Integer.toString(Interarrival);
            row[2] = Integer.toString(arrival);
            row[3] = Integer.toString(service);
            row[4] = Integer.toString(serviceBegins);
            row[5] = Integer.toString(waiting);
            row[6] = Integer.toString(serviceEnds);
            row[7] = Integer.toString(customerTime);
            row[8] = Integer.toString(idle);


            
            data.add(row);
            } while(customerNum != stoppingCriteria);
        } else {
            do {

            customerNum++;
            String[] row = new String[9];
            // Per row calculations 
            if(customerNum == 1) {
                Interarrival = 0;
                arrival = 0;
            } else {
                Interarrival = interArrivalTimeCompare();

                arrival = Interarrival + Integer.valueOf(data.get(data.size() - 1)[2]);
                
                if (arrival < Integer.valueOf(data.get(data.size() - 1)[6])){
                    serviceBegins = Integer.valueOf(data.get(data.size() - 1)[6]);
                } else{ // add another else if, if other situation is not anticipated
                    serviceBegins = arrival; 
                }

                if (arrival > Integer.valueOf(data.get(data.size() - 1)[6])){
                    idle = arrival - Integer.valueOf(data.get(data.size() - 1)[6]);
                } else {
                    idle = 0;
                }

            }

            service = serviceTimeCompare();

            // Service begins, Waiting time, Service Ends, Customer Time, Idle
                //todo

            waiting = serviceBegins - arrival;
            serviceEnds = service + serviceBegins;
            customerTime = serviceEnds - arrival;
            

            // Setting of Values;
            row[0] = Integer.toString(customerNum);
            row[1] = Integer.toString(Interarrival);
            row[2] = Integer.toString(arrival);
            row[3] = Integer.toString(service);
            row[4] = Integer.toString(serviceBegins);
            row[5] = Integer.toString(waiting);
            row[6] = Integer.toString(serviceEnds);
            row[7] = Integer.toString(customerTime);
            row[8] = Integer.toString(idle);
            data.add(row);
            } while( serviceEnds < stoppingCriteria);
        }

        // Prints Table
        stringPrinter(data);
        averagePrinter(data);

        

        System.out.println("Do you want to run another simulation? (Yes/No)");
        String answer = src.next();
        if (answer.equalsIgnoreCase("Yes")) {
           terminationOption();
        } else {
            System.out.println("Thank you for using Single Channel Queuing System Simulation!");
            return;
        }
   }

    private static void terminationOption() {

        try {
            int limit;
            buffer();
            System.out.println("Enter the number of minutes: ");
            limit  = src.nextInt();
            calculate(limit);
        } catch (Exception e){
            System.out.println("Error in input try again.");
            buffer();
            terminationOption();
        }

    }

    private static void buffer(){
        System.out.println();
        System.out.println();
    }

    private static void stringPrinter(ArrayList<String[]> data){
        System.out.printf("%10s %10s %20s %15s %15s", "Just Finished Event", "Variables", "Attributes", "Statistical Accumulators");
        System.out.printf("%10s %20s %15s %15s %21s %14s %20s %35s %15s %15s %15s %15s %15s %15s %15s %15s","Entity No", "Time t",
                "Event Types", "Q(t)","B(t)","Arrival Time in Queue",
                "Arrival Time in Service", "P", "N", "ΣWQ", "WQ*", "ΣTS",
                "TS*", "∫Q", "Q", "∫B";


        for (int x = 0; x < data.size(); x++) {
            String eN = data.get(x)[0], tT = data.get(x)[1], eT = data.get(x)[2],
                    qT = data.get(x)[3], bT = data.get(x)[4], aTQ = data.get(x)[5],
                    aTS = data.get(x)[6], p = data.get(x)[7], n = data.get(x)[8],
                    sWQ = data.get(x)[9], wQ = data.get(x)[10], sTS = data.get(x)[11],
                    tS = data.get(x)[12], iQ = data.get(x)[13], q = data.get(x)[14],
                    iB = data.get(x)[15];

            System.out.printf("\n%6s %18s %18s %15s %18s %16s %18s %28s %26s %26s %26s %26s %26s %26s %26s %26s"
                                ,eN,tT,eT,qT, bT,aTQ,aTS,p,n, sWQ, wQ, sTS, tS, iQ, q, iB);
        }

        buffer();
    }


} // end of class