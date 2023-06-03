import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Passenger {
    static int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0,count6 = 0 , full = 6600, num = 0;
    static FuelQueue[] array1 = new FuelQueue[6]; //Queue 1
    static FuelQueue[] array2 = new FuelQueue[6]; //Queue 2
    static FuelQueue[] array3 = new FuelQueue[6]; //Queue 3
    static FuelQueue[] array4 = new FuelQueue[6]; //Queue 4
    static FuelQueue[] array5 = new FuelQueue[6]; //Queue 5
    static FuelQueue[] waiting = new FuelQueue[1000]; //Waiting Queue

    static String firstName,secondName,VNo;
    static int liters;

    static int removed = 0;

    static int minQ;
    static String removeName,name1,name2,name3;
    static int index,name4;




    public static void main() {
        //Initialize arrays
        initialize(array1);
        initialize(array2);
        initialize(array3);
        initialize(array4);
        initialize(array5);
        initialize(waiting);


        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("100 or VFQ: View all Fuel Queues.\n" +
                    "101 or VEQ: View all Empty Queues.\n" +
                    "102 or ACQ: Add customer to a Queue.\n" +
                    "103 or RCQ: Remove a customer from a Queue. (From a specific location)\n" +
                    "104 or PCQ: Remove a served customer.\n" +
                    "105 or VCS: View Customers Sorted in alphabetical order.\n" +
                    "106 or SPD: Store Program Data into file.\n" +
                    "107 or LPD: Load Program Data from file.\n" +
                    "108 or STK: View Remaining Fuel Stock.\n" +
                    "109 or AFS: Add Fuel Stock.\n" +
                    "110 or IFQ: Income of each Fuel Queue.\n" +
                    "999 or EXT: Exit the Program.");
            System.out.println("----------------------------------------------------");
            System.out.println("");

            Scanner code = new Scanner(System.in);
            System.out.print("Enter the code : ");
            String menu = code.nextLine().toUpperCase();
            System.out.println();


            switch (menu) {
                case "100":
                case "VFQ":
                    //View all Fuel Queues
                    viewAllFuelQueues(array1, count1, 1);
                    viewAllFuelQueues(array2, count2, 2);
                    viewAllFuelQueues(array3, count3, 3);
                    viewAllFuelQueues(array4, count4, 4);
                    viewAllFuelQueues(array5, count5, 5);
                    viewAllFuelQueues(waiting, count6, 6);

                    break;
                case "101":
                case "VEQ":
                    //View all Empty Queues
                    viewEmptyQueues(array1, 1);
                    viewEmptyQueues(array2, 2);
                    viewEmptyQueues(array3, 3);
                    viewEmptyQueues(array4, 4);
                    viewEmptyQueues(array5, 5);

                    break;

                case "102":
                case "ACQ":
                    //Add customer to a Queue
                    minQ();
                    addCustomer(array1, firstName, secondName, VNo, liters);

                    break;
                case "103":
                case "RCQ":
                    //Remove a customer from a Queue. (From a specific location)
                    removeCustomer();

                    break;
                case "104":
                case "PCQ":
                    //Remove a served customer.
                    removeServedCustomer();

                    break;
                case "105":
                case "VCS":
                    //View Customers Sorted in alphabetical order
                    alphabeticalOrder(array1, 1);
                    alphabeticalOrder(array2, 2);
                    alphabeticalOrder(array3, 3);
                    alphabeticalOrder(array4, 4);
                    alphabeticalOrder(array5, 5);

                    break;
                case "106":
                case "SPD":
                    //Store Program Data into file
                    storeProgramData();

                    break;
                case "107":
                case "LPD":
                    //Load Program Data from file
                    loadProgramData();

                    break;
                case "108":
                case "STK":
                    //View Remaining Fuel Stock
                    remainingFuelStock();

                    break;
                case "109":
                case "AFS":
                    //Add Fuel Stock
                    addFuel();

                    break;
                case "110":
                case "IFQ":
                    //Add Fuel Stock
                    income(array1, count1, 1);
                    income(array2, count2, 2);
                    income(array3, count3, 3);
                    income(array4, count4, 4);
                    income(array5, count5, 5);

                    break;
                case "999":
                case "EXT":
                    //Exit the Program
                    return;

                default:
                    System.out.println("invalid input");

            }
        }
    }

    //100 or VFQ: View all Fuel Queues.
    public static void viewAllFuelQueues(FuelQueue[] ra2, int count, int number) {
        System.out.println("Pump " + number + " : ");


        for (int i = 0; i < count; ++i) {
            int num1 = i + 1;
            System.out.println(num1 + " : " + ra2[i].getFirstName() + " " + ra2[i].getSecondName());

        }
    }

    //101 or VEQ: View all Empty Queues.
    public static void viewEmptyQueues(FuelQueue[] ra, int number2) {

        int count = 0;
        for (int i = 0; i < 6; ++i) {
            if (ra[i].getFirstName().equals("firstName")) {
                count++;

            }
        }
        if (count == 6) {
            System.out.println("Pump " + number2 + " is Empty ");
        } else if (count == 5) {
            System.out.println("Pump " + number2 + " left 5 spaces ");
        } else if (count == 4) {
            System.out.println("Pump " + number2 + " left 4 spaces ");
        } else if (count == 3) {
            System.out.println("Pump " + number2 + " left 3 spaces ");
        } else if (count == 2) {
            System.out.println("Pump " + number2 + " left 2 spaces ");
        } else if (count == 1) {
            System.out.println("Pump " + number2 + " left 1 spaces ");
        } else if (count == 0) {
            System.out.println("Pump " + number2 + " is full ");
        }
    }

    //102 or ACQ: Add customer to a Queue.
    public static void addCustomer(FuelQueue[] ra, String firstName, String secondName, String VNo, int liters) {

        Scanner cs1 = new Scanner(System.in);
        System.out.print("Enter firstName : ");
        name1 = cs1.nextLine();
        System.out.print("Enter SecondName : ");
        name2 = cs1.nextLine();
        System.out.print("Enter Vehicle No : ");
        name3 = cs1.nextLine();
        while (true){
            try{
                System.out.print("Enter liters : ");
                 name4 = cs1.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Please Enter Liters : ");
                cs1.next();
            }
        }


        if (count1 <= 5 || count2 <=5 ||  count3 <=5 || count4 <=5 || count5 <=5 ) {

            if (minQ == 1) {
                FuelQueue object1 = new FuelQueue(firstName, secondName, VNo, liters);
                object1.setFirstName(name1);
                object1.setSecondName(name2);
                object1.setVehicleNo(name3);
                object1.setLitersRequired(name4);
                array1[count1] = object1;
                count1++;
                full = full - name4;

            } else if (minQ == 2) {
                FuelQueue object2 = new FuelQueue(firstName, secondName, VNo, liters);
                object2.setFirstName(name1);
                object2.setSecondName(name2);
                object2.setVehicleNo(name3);
                object2.setLitersRequired(name4);
                array2[count2] = object2;
                count2++;
                full = full - name4;

            } else if (minQ == 3) {
                FuelQueue object3 = new FuelQueue(firstName, secondName, VNo, liters);
                object3.setFirstName(name1);
                object3.setSecondName(name2);
                object3.setVehicleNo(name3);
                object3.setLitersRequired(name4);
                array3[count3] = object3;
                count3++;
                full = full - name4;

            } else if (minQ == 4) {
                FuelQueue object4 = new FuelQueue(firstName, secondName, VNo, liters);
                object4.setFirstName(name1);
                object4.setSecondName(name2);
                object4.setVehicleNo(name3);
                object4.setLitersRequired(name4);
                array4[count4] = object4;
                count4++;
                full = full - name4;

            } else if (minQ == 5) {
                FuelQueue object5 = new FuelQueue(firstName, secondName, VNo, liters);
                object5.setFirstName(name1);
                object5.setSecondName(name2);
                object5.setVehicleNo(name3);
                object5.setLitersRequired(name4);
                array5[count5] = object5;
                count5++;
                full = full - name4;
            }
        }
        else {
            FuelQueue object6 = new FuelQueue(firstName, secondName, VNo, liters);
            object6.setFirstName(name1);
            object6.setSecondName(name2);
            object6.setVehicleNo(name3);
            object6.setLitersRequired(name4);
            waiting[count6] = object6;
            count6++;
        }
        {
            System.out.println("");
            System.out.println("Successfully added to the queue.");
            System.out.println("");
        }
        if (full <= 500) {
            System.out.println("---500 Liters Warning---");
            System.out.println();
        }
    }

    //103 or RCQ: Remove a customer from a Queue. (From a specific location)
    static void removeCustomer() {


        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter pump number : ");
        int num1 = input1.nextInt();

        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter firstName : ");
        removeName = input2.nextLine();

        if (num1 == 1) {
            findIndex(array1);
            remove(array1, index, count1);
            count1--;
            if(count1 == 5 && waiting[0]!= null){
                addWaiting();
                count1++;
            }

        } else if (num1 == 2) {
            findIndex(array2);
            remove(array2, index, count2);
            count2--;
            if(count2 == 5 && waiting[0]!= null){
                addWaiting();
                count2++;
            }
        } else if (num1 == 3) {
            findIndex(array3);
            remove(array3, index, count3);
            count3--;
            if(count3 == 5 && waiting[0]!= null){
                addWaiting();
                count3++;
            }
        } else if (num1 == 4) {
            findIndex(array4);
            remove(array4, index, count4);
            count4--;
            if(count4 == 5 && waiting[0]!= null){
                addWaiting();
                count4++;
            }
        } else if (num1 == 5) {
            findIndex(array5);
            remove(array5, index, count5);
            count5--;
            if(count5 == 5 && waiting[0]!= null){
                addWaiting();
                count5++;
            }
        }
    }

    //104 or PCQ: Remove a served customer.
    public static void removeServedCustomer() {
        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter pump number : ");
        int num1 = input3.nextInt();

        if (num1 == 1) {
            remove(array1, 0, count1);
            count1--;
            if(count1 == 5 && waiting[0]!= null){
                addWaiting();
                count1++;
            }
        } else if (num1 == 2) {
            remove(array2, 0, count2);
            count2--;
            if(count2 == 5 && waiting[0]!= null){
                addWaiting();
                count2++;
            }
        } else if (num1 == 3) {
            remove(array3, 0, count3);
            count3--;
            if(count3 == 5 && waiting[0]!= null){
                addWaiting();
                count3++;
            }
        } else if (num1 == 4) {
            remove(array4, 0, count4);
            count4--;
            if(count4 == 5 && waiting[0]!= null){
                addWaiting();
                count4++;
            }
        } else if (num1 == 5) {
            remove(array5, 0, count5);
            count5--;
            if(count5 == 5 && waiting[0]!= null){
                addWaiting();
                count5++;
            }
        }
    }

    //105 or VCS: View Customers Sorted in alphabetical order.
    public static void alphabeticalOrder(FuelQueue[] ra, int num) {

        String str[] = new String[6];

        for (int i = 0; i < 6; i++) {
            str[i] = ra[i].getFirstName();
        }
        Arrays.sort(str);

        String joined = Arrays.toString(str).replace("[", "").replace("]", " ")
                .replace(",", "").replace("firstName", "").replace("/t", "");
        System.out.println("pump" + num + " : " + joined);

    }

    //106 or SPD: Store Program Data into file.
    public static void storeProgramData() {

        System.out.println("----Program Store successfully----");
        System.out.println();
        try {

            File file = new File("Queue file.txt");
            PrintStream writer = new PrintStream(file);

            writer.println("Queue 1 : ");
            for (int i = 0; i < count1; ++i) {
                writer.println((i + 1) + " : " + array1[i].getFirstName() + ", " + array1[i].getSecondName() + ", "
                        + array1[i].getVehicleNo() + ", " + array1[i].getLitersRequired());
            }writer.println("Queue 2 : ");
            for (int i = 0; i < count2; ++i) {
                writer.println((i + 1) + " : " + array2[i].getFirstName() + ", " + array2[i].getSecondName() + ", "
                        + array2[i].getVehicleNo() + ", " + array2[i].getLitersRequired());
            }writer.println("Queue 3 : ");
            for (int i = 0; i < count3; ++i) {
                writer.println((i + 1) + " : " + array3[i].getFirstName() + ", " + array3[i].getSecondName() + ", "
                        + array3[i].getVehicleNo() + ", " + array3[i].getLitersRequired());
            }writer.println("Queue 4 : ");
            for (int i = 0; i < count4; ++i) {
                writer.println((i + 1) + " : " + array4[i].getFirstName() + ", " + array4[i].getSecondName() + ", "
                        + array4[i].getVehicleNo() + ", " + array4[i].getLitersRequired());
            }writer.println("Queue 5 : ");
            for (int i = 0; i < count5; ++i) {
                writer.println((i + 1) + " : " + array5[i].getFirstName() + ", " + array5[i].getSecondName() + ", "
                        + array5[i].getVehicleNo() + ", " + array5[i].getLitersRequired());
            }
            writer.println();
            writer.println("Remaining Fuel Stock : " + full);
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //107 or LPD: Load Program Data from file.
    public static void loadProgramData() {

        File Queue_file = new File("Queue file.txt");

        try {
            Scanner reader = new Scanner(Queue_file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //108 or STK: View Remaining Fuel Stock.
    public static void remainingFuelStock() {

        full = full + removed;

        System.out.println("Remaining Fuel Stock : " + full);
        System.out.println();

        if (full == 6600) {
            System.out.println("---Fuel Stock Full---");
            System.out.println();
        }
    }

    //109 or AFS: Add Fuel Stock.
    public static void addFuel() {

        if (full >= 6600) {
            System.out.println("---Fuel Stock is Full Can't Add Fuel---");
            System.out.println();
        } else {

            System.out.println("Empty Space : " + (6600 - full));
            Scanner AFS = new Scanner(System.in);
            System.out.print("Add Fuel Stock : ");
            int menu_6 = AFS.nextInt();
            if ((6600 - full) >= menu_6) {
                full = full + menu_6;
                System.out.println("Remaining Fuel Stock : " + full);
            } else {
                System.out.println("---No Space---");
            }
        }
    }

    //110 or IFQ Fuel Income.
    public static void income(FuelQueue[] in, int count, int number) {
        int num = 0;

        for (int i = 0; i < count; ++i) {
            num = num + in[i].getLitersRequired();
        }
        int income = num * 430;
        System.out.println("Pump " + number + " : " + income);
    }

    //Initialize the arrays.
    public static void initialize(FuelQueue[] var) {
        for (int i = 0; i < var.length; i++) {
            var[i] = new FuelQueue();
        }
    }

    //Check the minimum Queue.
    public static void minQ() {
        System.out.println();
        for (int i = 0; i <= 6; i++) {
            if (count1 == i) {
                minQ = 1;
                break;
            } else if (count2 == i) {
                minQ = 2;
                break;
            } else if (count3 == i) {
                minQ = 3;
                break;
            } else if (count4 == i) {
                minQ = 4;
                break;
            } else if (count5 == i) {
                minQ = 5;
                break;
            }
        }
    }

    //Remove
    static void remove(FuelQueue[] removeArray, int location, int count) {
        for (int i = location; i < (count); i++) {
            removed = removed + removeArray[i].getLitersRequired();
            if (removeArray[i + 1] != null) {
                removeArray[i].setFirstName(removeArray[i + 1].getFirstName());
                removeArray[i].setSecondName(removeArray[i + 1].getSecondName());
                removeArray[i].setVehicleNo(removeArray[i + 1].getVehicleNo());
                removeArray[i].setLitersRequired(removeArray[i + 1].getLitersRequired());
            } else {
                removeArray[i].setFirstName(null);
                removeArray[i].setSecondName(null);
                removeArray[i].setVehicleNo(null);
                removeArray[i].setLitersRequired(0);
            }
        }
    }

    //Find Index.
    static void findIndex(FuelQueue[] farray) {

        for (int i = 0; i < farray.length; i++) {
            if (farray[i] != null) {
                if (farray[i].getFirstName().equals(removeName)) {
                    index = i;
                }
            }
        }
    }

    //Add Waiting Queue.
    static void addWaiting() {
        for (int i = 0; i < count6; i++) {
            if (waiting[i + 1] != null) {
                waiting[i].setFirstName(waiting[i + 1].getFirstName());
                waiting[i].setSecondName(waiting[i + 1].getSecondName());
                waiting[i].setVehicleNo(waiting[i + 1].getVehicleNo());
                waiting[i].setLitersRequired(waiting[i + 1].getLitersRequired());
            } else {
                waiting[i].setFirstName(null);
                waiting[i].setSecondName(null);
                waiting[i].setVehicleNo(null);
                waiting[i].setLitersRequired(0);
            }
        }
    }
}





