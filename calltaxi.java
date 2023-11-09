import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class calltaxi extends Main {
    static ArrayList<Integer> Earning = new ArrayList<Integer>(Collections.nCopies(Main.n, 0));

    String Atposition = "";
    int taxi_no;

    static Hashtable<Integer, String> taxidetails = new Hashtable<Integer, String>();

    public calltaxi() {
    };

    public calltaxi(int taxino, String atposition, int earning) {
        this.taxi_no = taxino;
        this.Atposition = atposition;
        if (taxino >= 0 && taxino < Earning.size()) {
            Earning.set(taxino, earning);
            taxidetails.put(taxino, atposition);
        }                 
    }

    int availableTaxi(int souceindex) {
        int choice = -1;
        while (choice == -1) {
            choice = taxi(Main.places.get(souceindex));
            souceindex = (souceindex + 1) % (Main.places.size() - 1);
        }
        return choice;

    }

    int taxi(String source) {
        ArrayList<Integer> FreeTaxi = new ArrayList<Integer>();
        if (taxidetails.containsValue(source)) {
            for (Integer it : taxidetails.keySet()) {
                if (source.equals(taxidetails.get(it))) {
                    FreeTaxi.add(it);
                }
            }
            if (FreeTaxi.size() == 1) {
                return FreeTaxi.get(0);
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int i = 0; i < FreeTaxi.size(); i++) {
                    temp.add(Earning.get(FreeTaxi.get(i)));
                }
                int mini = Collections.min(temp);
                return Earning.indexOf(mini);
            }
        }
        return -1;
    }

}

class booking {
    String source;
    String destination;
    double starttime;

    int distance;
    int money;
    double endtime;
    int bookingid;

    calltaxi obj=new calltaxi();
    
    public booking(String source,String destination,int bookingid,double starttime,int distance,int money){
        this.bookingid=bookingid;
        this.source=source;
        this.destination=destination;
        this.starttime=starttime;
        this.endtime=starttime+(distance/15);
        this.money=money;
        this.distance=distance;
    }
}
