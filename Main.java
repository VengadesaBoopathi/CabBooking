import java.util.*;

class Main {
    public static ArrayList<String> places = new ArrayList<String>();
    static Scanner in = new Scanner(System.in);
    static public int n;
    static calltaxi[] taxiobj;
    static booking[] book = new booking[10];
    static int bookingid;

    public static void main(String args[]) {
        System.out.println("enter the total no of available taxi");
        n = in.nextInt();
        taxiobj = new calltaxi[n];
        for (int i = 0; i < n; i++) {
            taxiobj[i] = new calltaxi(i + 1, "a", 0);
        }

        places.add("a");
        places.add("b");
        places.add("c");
        places.add("d");
        places.add("e");
        places.add("f");
        int choice = 1;

        while (choice != -1) {
            System.out.println("\n\n---------------------------------------");
            System.out.println("1 for booking");
            System.out.println("2 for booking details");
            System.out.println("3 for taxi details");
            System.out.println("4 for break");
            System.out.println("---------------------------------------\n\n");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    cabbooking();
                    break;
                case 2:
                    bookingdetails();
                    break;
                case 3:
                    Taxidetails();
                    break;
                case 4:
                    choice = -1;
                    break;

                default:
                    break;
            }
        }
    }

    static int bookcount = 0;

    static void cabbooking() {
        calltaxi obj = new calltaxi();

        System.out.println("enter customerid");
        int bookingid = in.nextInt();
        System.out.println("enter source and destination");
        String source = in.next();
        String destination = in.next();
        System.out.println("enter start time");
        double starttime = in.nextDouble();

        int distance = (places.indexOf(destination) - places.indexOf(source)) * 15;
        int money = 100 + ((distance - 5) * 10);

        if (!places.contains(destination) || !places.contains(source)) {
            System.out.println("Invalid source or destination");
        } else {
            int taxiAlloted = obj.availableTaxi(places.indexOf(source));
            System.out.println("Taxi alloted No: " + taxiAlloted);
            taxiobj[taxiAlloted].Earning.set(taxiAlloted, taxiobj[taxiAlloted].Earning.get(taxiAlloted) + money);
            taxiobj[taxiAlloted].Atposition = destination;
            book[bookcount++] = new booking(source, destination, bookingid, starttime, distance, money);
        }

    }

    static void Taxidetails() {
        for (int i = 0; i < n; i++) {
            System.out.println("taxi no            " + taxiobj[i].taxi_no);
            System.out.println("taxi At position   " + taxiobj[i].Atposition);
            System.out.println("taxi Earning       " + taxiobj[i].Earning.get(i));
            System.out.println("---------------------------------------\n\n");
        }
        System.out.println("\n---------------------------------------\n\n");
    }

    static void bookingdetails() {
        for (int i = 0; i < bookcount; i++) {
            System.out.println("booking id          " + book[i].bookingid);
            System.out.println("source              " + book[i].source);
            System.out.println("destination         " + book[i].destination);
            System.out.println("starttime           " + book[i].starttime);
            System.out.println("endTime             " + book[i].endtime);
            System.out.println("distance            " + book[i].distance);
            System.out.println("money               " + book[i].money);
            System.out.println("---------------------------------------\n\n");
        }
        System.out.println("---------------------------------------\n\n");
    }
}