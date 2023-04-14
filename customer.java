import java.util.Set;

public class customer {
    String inService = "",evntType = "",temp = "";
    int customerNum = 0, qt = 0 ,bt = 0, p = 0 , n = 0, iQ = 0, q =0, iB = 0, stopper = 0;
    Double interArrival = 0.0, arrival = 0.0, service = 0.0, time = 0.0, wQ = 0.0, tS=0.0, eTS = 0.0, eWQ = 0.0;

    customer(){
    }

    public Double getIqTime(){
        return service - time;
    }

    public void setArrival(Double arrival) {
        this.arrival = arrival;
    }

    public void setBt(int bt) {
        this.bt = bt;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public void setEvntType(String evntType) {
        this.evntType = evntType;
    }

    public void setInService(String inService) {
        this.inService = inService;
    }

    public void setInterArrival(Double interArrival) {
        this.interArrival = interArrival;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public void setService(Double service) {
        this.service = service;
    }

    public void setStopper(int stopper) {
        this.stopper = stopper;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public void seteTS(Double eTS) {
        this.eTS = eTS;
    }
    public void seteWQ(Double eWQ) {
        this.eWQ = eWQ;
    }

    public void setiB(int iB) {
        this.iB = iB;
    }

    public void setiQ(int iQ) {
        this.iQ = iQ;
    }

    public void settS(Double tS) {
        this.tS = tS;
    }

    public void setwQ(double d) {
        this.wQ = d;
    }

    public Double getArrival() {
        return arrival;
    }

    public int getBt() {
        return bt;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public String getEvntType() {
        return evntType;
    }

    public String getInService() {
        return inService;
    }

    public Double getInterArrival() {
        return interArrival;
    }

    public int getN() {
        return n;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public int getQt() {
        return qt;
    }

    public Double getService() {
        return service;
    }

    public int getStopper() {
        return stopper;
    }

    public String getTemp() {
        return temp;
    }

    public Double getTime() {
        return time;
    }

    public Double geteTS() {
        return eTS;
    }

    public Double geteWQ() {
        return eWQ;
    }

    public int getiB() {
        return iB;
    }

    public int getiQ() {
        return iQ;
    }

    public Double gettS() {
        return tS;
    }

    public Double getwQ() {
        return wQ;
    }


}