import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

public class EEPV2 {
    public static void main(String[] args){

    } // end of main method

    private static void calculate(int stoppingCriteria){
        ArrayList<String[]> data = new ArrayList<String[]>(); // Stores per row
        ArrayList<String> inQueue = new ArrayList<>();
        ArrayList<String[]> arrivalList = new ArrayList<>();
        ArrayList<String[]> departureList = new ArrayList<>();
        String inService = "";
        int customerNum = 0, Interarrival = 0, arrival = 0, service = 0, time = 0, evntType = 0, 
            bt = 0, p = 0 , n = 0, swq = 0, wQ = 0, sTS = 0, tS=0, iQ = 0, q =0, iB = 0;
        //Event type = 0 (Initializing), 1 = Arrival, 2 = Departure
        
        int[] averageValues = new int[7]; // Stores the average value. Follow the arrangement on the specifications 1-7.
        data.clear(); // resets the data

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
        // Calculation area
        do{
            String[] datarow = new String[19];
            if(evntType == 0) {
                datarow[0] = Integer.toString(0);
                datarow[1] = Integer.toString(0);
                datarow[2] = Integer.toString(0);
                datarow[3] = Integer.toString(0);
                datarow[4] = Integer.toString(0);
                datarow[5] = "Initializing";
                datarow[6] = Integer.toString(0);
                datarow[7] = Integer.toString(0);
                datarow[8] = Integer.toString(0);
                datarow[9] = Integer.toString(0);
                datarow[10] = Integer.toString(0);
                datarow[11] = Integer.toString(0);
                datarow[12] = Integer.toString(0);
                datarow[13] = Integer.toString(0);
                datarow[14] = Integer.toString(0);
                datarow[15] = Integer.toString(0);
                datarow[16] = Integer.toString(0);
                datarow[17] = Integer.toString(0);
                datarow[18] = Integer.toString(0);
            } else {
    
            }

            data.add(datarow);
        } while(stoppingCriteria < time );

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
        printborder();
        System.out.printf("%10s %10s %36s %41s %88s", "\n ","Just Finished Event", "Variables", "Attributes", "Statistical Accumulators\n");
        printborder();
        System.out.printf("%10s %10s %15s %4s %10s %20s %4s %20s %27s %4s %10s %10s %10s %10s %10s %10s %10s %10s %10s","\nEntity No", "Time t",
                "Event Types","|", "Q(t)","B(t)","|","Arrival Time in Queue",
                "Arrival Time in Service", "|","P", "N", "ΣWQ", "WQ*", "ΣTS",
                "TS*", "∫Q", "Q", "∫B\n");
        printborder();


        for (int x = 0; x < data.size(); x++) {
            String eN = data.get(x)[0], tT = data.get(x)[1], eT = data.get(x)[2],
                    qT = data.get(x)[3], bT = data.get(x)[4], aTQ = data.get(x)[5],
                    aTS = data.get(x)[6], p = data.get(x)[7], n = data.get(x)[8],
                    sWQ = data.get(x)[9], wQ = data.get(x)[10], sTS = data.get(x)[11],
                    tS = data.get(x)[12], iQ = data.get(x)[13], q = data.get(x)[14],
                    iB = data.get(x)[15];

                    System.out.printf("\n%4s %12s %17s %5s %6s %9s %6s %9s %29s %14s %10s %10s %10s %9s %10s %10s %11s %10s %9s"
                    ,eN,tT,eT,"|",qT, bT,"|",aTQ,aTS,"|",p,n, sWQ, wQ, sTS, tS, iQ, q, iB);
        }

        buffer();
    }

    private static void printborder(){
        for(int i = 0; i < 233; i++){
            System.out.print("-");
        }
    }


} // end of class