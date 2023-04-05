import java.util.ArrayList;
import java.lang.Math;

public class calculation {
    public static void main(String[] args) {
        String inService = "",evntType = "",temp = "{ ";
        int customerNum = 0, qt = 0 ,bt = 0, p = 0 , n = 0, eWQ = 0, wQ = 0, eTS = 0, 
             tS=0, iQ = 0, q =0, iB = 0;
        Double Interarrival = 0.0, arrival = 0.0, service = 0.0, time = 0.0;
        ArrayList<String[]> data = new ArrayList<String[]>(); // Stores per row
        ArrayList<String> inQueue = new ArrayList<>();
        ArrayList<String[]> arrivalList = new ArrayList<>();
        ArrayList<String[]> toDepartList = new ArrayList<>();
        ArrayList<String> waitingTimes = new ArrayList<>();
        ArrayList<String> timeSystem = new ArrayList<>();
        Double[] serviceTimes = {2.90,1.76,3.39,4.52,4.46,4.36,2.07,3.36,2.37,5.38};
        Double[] interTimes = {1.73,1.35,0.71,0.62,14.28,0.7,15.52,3.15,1.76,1.0};
       /**
        * p = no of parts produced so far
        * n = no of parts that passed through the queue
        * eWQ = Summation of waiting time in the queue
        wq* maximum waiting time
        ts total time in the system
        ts* maximum total time in the system 
        Q(t) = no of parts in queue
        B(t) = 1 or 0, 1 if busy or 0
        */
       do{
        System.out.println("in");
        String[] datarow = new String[18];
        String[] datarowDepart = new String[18];
        customerNum++;

        time = 0.0;
            for(String[] t : arrivalList){
                time += Double.parseDouble(t[1]);
                System.out.println(Double.parseDouble(t[1]));
            }

        if(customerNum == 1) {
            Interarrival = interTimes[0];
            service = serviceTimes[0];
            inService = String.valueOf(time);
        } else {
            Interarrival = interTimes[arrivalList.size()];
            service = serviceTimes[arrivalList.size()];
            // parting methods
            
        }
        
         // Resets the time, then adds past interarrival times for time.
         

         evntType = "Arrival";

         if(customerNum == 1) {
            qt = 0;
         } else {
            if(Double.parseDouble(arrivalList.get(arrivalList.size()-1)[2]) > arrival) {
                qt++;
            }
         }

         if(customerNum == 1) {
            bt = 0;
         } else {
            bt = 1;
         }

         
         if(customerNum == 2){
            temp = "{ ";
            inQueue.add(String.valueOf(time));
            temp += String.valueOf(time) ;  
         } else if(inQueue.isEmpty()){
            temp = "{ ";
         } else {
            temp = "{ ";
                inQueue.add(String.valueOf(String.format("%.2f", time)));
            for (int x = 0 ; x < inQueue.size(); x++) {
                if(x == 0) {
                    temp += inQueue.get(x);
                } else {
                    temp += " , " + inQueue.get(x);
                }
                    
            }
        }

        if(customerNum == 1) {
            n++;
        }
         
        datarow[0] = Integer.toString(customerNum);
        datarow[1] = Double.toString(Interarrival);
        datarow[2] = Double.toString(service);
        datarow[3] = Double.toString(time);
        datarow[4] = evntType;
        datarow[5] = Integer.toString(qt);
        datarow[6] = Integer.toString(bt);
        datarow[7] = temp + " }";
        datarow[8] = inService;
        datarow[9] = Integer.toString(p);
        datarow[10] = Integer.toString(n);
        datarow[11] = Integer.toString(eWQ);
        datarow[12] = Integer.toString(wQ);
        datarow[13] = Integer.toString(eTS);
        datarow[14] = Integer.toString(tS);
        datarow[15] = Integer.toString(iQ);
        datarow[16] = Integer.toString(q);
        datarow[17] = Integer.toString(iB);
         arrivalList.add(datarow);
         toDepartList.add(datarow);
         data.add(datarow);
       } while (time < 20); 
       stringPrinter(data);


        /**
         * Q(t) 
         * if ( past service > arrival time) {
         *  qt ++
         * }
         */

        
       /**
        * 
        * bT
            if (past service time < arrival time && queue.isEmpty()){
                bT == 0;
            } else {
                bT == 1;
            }
        */

        /**
         * inQueue 
         * if ( past service > arrival time) {
         *  inQueue.add(String.valueOf(servce));
         *    }
         * 
         * for (int x = 0 ; x < inQueue.size(); x++) {
                if(inQueue.size() == x) {
                    temp += inQueue.get(x) + " }";
                } else {
                    temp += inQueue.get(x) + " , ";
                }
            }
         */

         /**
          * inService 
            if(departed) {
                arrivedList.get[departed custoner no. 1  + 1][arrival]
            }
          */

          /** p and N
           * if(departed) {
           * p++
           * n++
           * } 
           */  

        /**
         * wQ
         * if(departed){
         * current waiting = currentCustomerService - nextcustomer arrival; 
         *  if(past waitingQ* < current waiting ) {
         *      wQ* = currentwaiting;
         *  }
         * waitingQueue.add(currentwaiting);
         * }
         * 
         * eWQ 
         * double wQ = 0.0;
         * for(String b = waitingQueue) {
         *  wQ += Double.valueOf(waitingQueue)
         * }
         */

         /*
          * if(departed) {
            time Service = departed time - arrival time;
            ewQ == 0;
            double emp = time service;
            timeSystem.add(time service);

            for(String x : timeSysten) {
                if (emp <  Double.valueOf(x)){
                    emp == Double.valueOf(x);
                }
                ewQ += Double.valueOf(x);
            }

            ts* == emp;
          }
          */
            
    }

    private static void buffer(){
        System.out.println();
        System.out.println();
    }

    private static void stringPrinter(ArrayList<String[]> data){
        printborder();
        System.out.printf("%10s %10s %36s %41s %88s", "\n ","Just Finished Event", "Variables", "Attributes", "Statistical Accumulators\n");
        printborder();
        System.out.printf("%10s %10s %15s %4s %9s %8s %4s %27s %30s %4s %10s %10s %10s %10s %10s %10s %10s %10s %10s","\nEntity No", "Time t",
                "Event Types","|", "Q(t)","B(t)","|","Arrival Time in Queue",
                "Arrival Time in Service", "|","P", "N", "\u03A3WQ", "WQ*", "\u03A3TS",
                "TS*", "\u222BQ", "Q", "\u222BB\n");
        printborder();


        for (int x = 0; x < data.size(); x++) {
            String eN = data.get(x)[0], tT = String.format("%.2f", Float.valueOf(data.get(x)[3]),data.get(x)[3]), eT = data.get(x)[4],
                    qT = data.get(x)[5], bT = data.get(x)[6], aTQ = data.get(x)[7],
                    aTS = data.get(x)[8], p = data.get(x)[9], n = data.get(x)[10],
                    sWQ = data.get(x)[11], wQ = data.get(x)[12], sTS = data.get(x)[13],
                    tS = data.get(x)[14], iQ = data.get(x)[15], q = data.get(x)[16],
                    iB = data.get(x)[17];

                    System.out.printf("\n%4s %12s %17s %5s %6s %9s %6s %27s %20s %14s %10s %10s %10s %9s %10s %10s %11s %10s %9s"
                                ,eN,tT,eT,"|",qT, bT,"|",aTQ,aTS,"|",p,n, sWQ, wQ, sTS, tS, iQ, q, iB);
        }

        buffer();
    }

    private static void printborder(){
        for(int i = 0; i < 233; i++){
            System.out.print("-");
        }
    }

}
