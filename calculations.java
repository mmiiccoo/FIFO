import java.util.ArrayList;

/**
 * calculations
 */
public class calculations {

    private static void calculate(){
        ArrayList<Double> inQueue = new ArrayList<>();
        ArrayList<customer> queueHistory = new ArrayList<>();
        ArrayList<customer> customerList = new ArrayList<>();
        Double[] serviceTimes = {2.90,1.76,3.39,4.52,4.46,4.36,2.07,3.36,2.37,5.38};
        Double[] interTimes = {1.73,1.35,0.71,0.62,14.28,0.7,15.52,3.15,1.76,1.0};
        int customerNo = 1;
        int pointer = 0;
        int cInService = 1;
        Double time = 0.0;

       do{
           customer customer = new customer();
           Double cTime = 0.0;
           String currentQueue = "";


           customer.setInterArrival(interTimes[customerList.size()]);
           
           customer.setCustomerNum(customerNo);

           //Time of Arrival
           if(customerNo == 1){
            customer.setTime(0.0);
            customer.setInService(String.valueOf(customer.getTime()));
            customer.setService(serviceTimes[0]);
            customer.setN(1);
            customer.setBt(1);
           } else if(customerNo == 2) {
            customer.setTime(customerList.get(customerList.size()-1).getInterArrival());
           } else {
            //Iterates through the InterArrival Values.
            for(customer c : customerList){
                cTime += c.getInterArrival();
            }
            customer.setTime(cTime);
           }

           customer.setEvntType("Arrival");

           // Departure Calculations
           if(customerNo!=1){
            for(int j = pointer; j < customerList.size(); j++){
                if(customerList.get(j).getService() < customer.getTime()){
                    if(customerList.get(j).getCustomerNum() >= pointer){
                        customer customer2 = new customer();
                        customer2.setCustomerNum(customerList.get(j).getCustomerNum());
                        customer2.setTime(customerList.get(j).getService());
                        customer2.setEvntType("Departure");
                        if(queueHistory.get(cInService).getEvntType().equals("Departure")){
                            cInService++;
                        }
                        
                        customer2.setInService(String.valueOf(String.format("%.2f",queueHistory.get(cInService) .getTime())));
                        customer2.setP(queueHistory.get(queueHistory.size()-1).getP()+1);
                        customer2.setN(queueHistory.get(queueHistory.size()-1).getN()+1);
                        cInService++;
                        if(customerList.get(j).getService() - customerList.get(j).getTime() > queueHistory.get(j).gettS()){
                            customer2.settS(Double.valueOf(String.format("%.2f",customerList.get(j).getService() - customerList.get(j).getTime())));
                        } else {
                            customer2.settS(queueHistory.get(j).gettS());
                        }

                        customer2.seteTS(Double.valueOf(String.format("%.2f",(customer2.gettS() + queueHistory.get(queueHistory.size()-1).geteTS()))));

                        // If in service Bt = 0
                        if(!(customer2.getInService().isBlank())){
                            customer2.setBt(1);
                           } else {
                            customer2.setBt(0);
                           }
            
                           // +1 for every adition to the queue -1 for every departure
                           if(!(customer2.getTemp().isEmpty())){
                            customer2.setQt(queueHistory.get(queueHistory.size() - 1).getQt() + 1);
                           } else {
                            customer2.setQt(queueHistory.get(queueHistory.size() - 1).getQt() - 1);
                            if(customer2.getQt() < 0) {
                                customer2.setQt(0);
                            }
                           }
                        pointer++;
                        if(customer2.getTime() > 20){
                            break;
                        }

                        queueHistory.add(customer2);
                    }
                }
            }

            inQueue.add(customer.getTime());

            customer.setInService(queueHistory.get(queueHistory.size()-1).getInService());
            for(int x = pointer; x < inQueue.size(); x++){
                currentQueue += String.valueOf(String.format("%.2f",inQueue.get(x)))+ " ";
            }
                customer.setTemp(currentQueue);
            // Q(t) and B(t): checks if either the service or queue is empty.
            if(!(customerList.get(customerList.size() - 1).getInService().isBlank())){
                customer.setBt(1);
               } else {
                customer.setBt(0);
               }

               if(!(customer.getTemp().isEmpty())){
                customer.setQt(queueHistory.get(queueHistory.size() - 1).getQt() + 1);
               } else {
                customer.setQt(queueHistory.get(queueHistory.size() - 1).getQt() - 1);
                if(customer.getQt() < 0) {
                    customer.setQt(0);
                }
               }

               //Inherits the past values
               customer.settS(queueHistory.get(queueHistory.size() -1 ).gettS());
               customer.seteTS(queueHistory.get(queueHistory.size() -1 ).geteTS());
               System.out.println(queueHistory.get(queueHistory.size() -1 ).gettS());
               customer.setService(customerList.get(customerList.size() - 1).getService() + serviceTimes[customerList.size()]);
               customer.setP(queueHistory.get(queueHistory.size() - 1).getP());
               customer.setN(queueHistory.get(queueHistory.size() - 1).getN());           
            }

            time = customer.getTime();
            if(time > 20){
                break;
            }

           queueHistory.add(customer);
           customerList.add(customer);
           customerNo++;
        } while(time < 20);

        stringPrinter(queueHistory);
    }

    // Printing Methods

    private static void buffer(){
        System.out.println();
        System.out.println();
    }

    private static void stringPrinter(ArrayList<customer> data){
        printborder();
        System.out.printf("%10s %10s %36s %41s %88s", "\n ","Just Finished Event", "Variables", "Attributes", "Statistical Accumulators\n");
        printborder();
        System.out.printf("%10s %10s %15s %4s %9s %8s %4s %27s %30s %4s %10s %10s %10s %10s %10s %10s %10s %10s %10s","\nEntity No", "Time t",
                "Event Types","|", "Q(t)","B(t)","|","Arrival Time in Queue",
                "Arrival Time in Service", "|","P", "N", "\u03A3WQ", "WQ*", "\u03A3TS",
                "TS*", "\u222BQ", "Q", "\u222BB\n");
        printborder();


        for (int x = 0; x < data.size(); x++) {
            String eN = String.valueOf(data.get(x).getCustomerNum()), tT = String.format("%.2f", (data.get(x).getTime()),data.get(x).getTime()), eT = data.get(x).getEvntType(),
                    qT = String.valueOf(data.get(x).getQt()), bT = String.valueOf(data.get(x).getBt()), aTQ = data.get(x).getTemp(),
                    aTS = data.get(x).getInService(), p = String.valueOf(data.get(x).getP()), n = String.valueOf(data.get(x).getN()),
                    sWQ = String.valueOf(data.get(x).geteWQ()), wQ = String.valueOf(data.get(x).getwQ()), sTS = String.valueOf(data.get(x).geteTS()),
                    tS = String.valueOf(data.get(x).gettS()), iQ = String.valueOf(data.get(x).getiQ()), q = String.valueOf(data.get(x).getQ()),
                    iB = String.valueOf(data.get(x).getiB());

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

    public static void main(String[] args) {
        calculate();
    }
}