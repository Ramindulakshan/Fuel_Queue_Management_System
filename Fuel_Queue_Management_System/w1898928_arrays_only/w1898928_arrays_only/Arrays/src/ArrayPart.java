import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;


public class ArrayPart {
    static int count1 = 0, count2 = 0, count3 = 0, full = 6600;
    static String pump_1[] = new String[6];
    static String pump_2[] = new String[6];
    static String pump_3[] = new String[6];

    public static void main(String[] args) {

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
                    //Pump_1_Queue
                    System.out.println("Pump_1_Queue : " + Arrays.toString(pump_1).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));
                    //Pump_2_Queue
                    System.out.println("Pump_2_Queue : " + Arrays.toString(pump_2).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));
                    //Pump_3_Queue
                    System.out.println("Pump_3_Queue : " + Arrays.toString(pump_3).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));
                    System.out.println();
                    break;
                case "101":
                case "VEQ":
                    //View all Empty Queues
                    //Pump_1_Queue
                    int space1 = 0;
                    for (int i = 0; i <= pump_1.length - 1; i++) {
                        if (pump_1[i] != null) {
                            space1++;
                        }
                    }
                    String emp1 = null;
                    if (space1 == 0) {
                        emp1 = "empty Queue";
                    }
                    else{
                        emp1 = "Spaces : ";
                    }
                    System.out.println("Pump_1_Queue : " + "(" + (6 - space1) + ") " + emp1 + (Arrays.toString(pump_1)).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));

                    //Pump_2_Queue
                    int space2 = 0;
                    for (int i = 0; i <= pump_2.length - 1; i++) {
                        if (pump_2[i] != null) {
                            space2++;
                        }
                    }
                    String emp2 = null;
                    if (space2 == 0) {
                        emp2 = "empty Queue";
                    }
                    else{
                        emp2 = "Spaces : ";
                    }
                    System.out.println("Pump_2_Queue : " + "("+(6 - space2) + ") " + emp2 + (Arrays.toString(pump_2)).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));

                    //Pump_3_Queue
                    int space3 = 0;
                    for (int i = 0; i <= pump_3.length - 1; i++) {
                        if (pump_3[i] != null) {
                            space3++;
                        }
                    }
                    String emp3 = null;
                    if (space3 == 0) {
                        emp3 = "empty Queue";
                    }
                    else{
                        emp3 = "Spaces : ";
                    }
                    System.out.println("Pump_3_Queue : " + "("+ (6 - space3) + ") " + emp3 + (Arrays.toString(pump_3)).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));
                    System.out.println("");
                    break;

                case "102":
                case "ACQ":
                    //Add customer to a Queue
                    Scanner ACQ = new Scanner(System.in);
                    System.out.print("Enter the pump : ");
                    String menu_2 = ACQ.nextLine();

                    switch (menu_2) {
                        //pump_1_add_customer
                        case "1":
                            count1 = 0;
                            Scanner cs1 = new Scanner(System.in);
                            System.out.print("Enter name : ");
                            String name1 = cs1.nextLine();
                            full = full - 10;
                            System.out.println();
                            for (int i = 0; i <= pump_1.length - 1; i++) {
                                if (pump_1[i] != null) {
                                    count1++;
                                }
                            }
                            pump_1[count1] = name1;

                            break;

                        //pump_2_add_customer
                        case "2":
                            count2 = 0;
                            Scanner cs2 = new Scanner(System.in);
                            System.out.print("Enter name : ");
                            String name2 = cs2.nextLine();
                            full = full - 10;
                            System.out.println();
                            for (int i = 0; i <= pump_2.length - 1; i++) {
                                if (pump_2[i] != null) {
                                    count2++;
                                }
                            }
                            pump_2[count2] = name2;

                            break;

                        //pump_3_add_customer
                        case "3":
                            count3 = 0;
                            Scanner cs3 = new Scanner(System.in);
                            System.out.print("Enter name : ");
                            String name3 = cs3.nextLine();
                            full = full - 10;
                            System.out.println();
                            for (int i = 0; i <= pump_3.length - 1; i++) {
                                if (pump_3[i] != null) {
                                    count3++;
                                }
                            }
                            pump_3[count3] = name3;

                            break;
                    }

                    break;
                case "103":
                case "RCQ":
                    //Remove a customer from a Queue. (From a specific location)
                    //Enter the pump
                    Scanner RCQ = new Scanner(System.in);
                    System.out.print("Enter the pump : ");
                    String menu_3 = RCQ.nextLine();

                    switch (menu_3) {
                        case "1":
                            //Remove a Queue 1 customer
                            String remove1[] = new String[count1];
                            Scanner rem1 = new Scanner(System.in);
                            System.out.print("Enter the name : ");
                            String num1 = rem1.nextLine();
                            full = full + 10;
                            System.out.println();

                            for (int s = 0, l = 0; s < count1 + 1; s++) {
                                if (pump_1[s].equals(num1)) {

                                } else {
                                    remove1[l++] = pump_1[s];
                                }
                            }
                            for(int t=0; t< remove1.length; t++){
                                pump_1[count1] = null;
                                pump_1[t] = remove1[t];
                            }
                            break;

                        case "2":
                            //Remove a Queue 2 customer
                            String remove2[] = new String[count2];
                            Scanner rem2 = new Scanner(System.in);
                            System.out.print("Enter the name : ");
                            String num2 = rem2.nextLine();
                            System.out.println();
                            full = full + 10;

                            for (int s = 0, l = 0; s < count1 + 1; s++) {
                                if (pump_2[s].equals(num2)) {

                                } else {
                                    remove2[l++] = pump_2[s];
                                }
                            }
                            for(int t=0; t< remove2.length; t++){
                                pump_2[count2] = null;
                                pump_2[t] = remove2[t];
                            }
                            break;

                        case "3":
                            //Remove a Queue 3 customer
                            String remove3[] = new String[count3];
                            Scanner rem3 = new Scanner(System.in);
                            System.out.print("Enter the name : ");
                            String num3 = rem3.nextLine();
                            System.out.println();
                            full = full + 10;

                            for (int s = 0, l = 0; s < count3 + 1; s++) {
                                if (pump_3[s].equals(num3)) {

                                } else {
                                    remove3[l++] = pump_3[s];
                                }
                            }
                            for(int t=0; t< remove3.length; t++){
                                pump_3[count3] = null;
                                pump_3[t] = remove3[t];
                            }
                            break;
                    }
                    break;
                case "104":
                case "PCQ":
                    //Remove a served customer
                    Scanner PCQ = new Scanner(System.in);
                    System.out.print("Enter the pump : ");
                    String menu_4 = PCQ.nextLine();

                    switch (menu_4) {
                        case "1":
                            //Remove a Queue 1 served customer
                            System.out.println("");
                            String[] yourArray1 = Arrays.copyOfRange(pump_1, 1, pump_1.length);
                            for(int t=0; t<yourArray1.length; t++) {
                                pump_1[t] = yourArray1[t];
                            }
                            break;

                        case "2":
                            //Remove a Queue 2 served customer
                            System.out.println("");
                            String[] yourArray2 = Arrays.copyOfRange(pump_2, 1, pump_2.length);
                            for(int t=0; t<yourArray2.length; t++) {
                                pump_2[t] = yourArray2[t];
                            }
                            break;

                        case "3":
                            //Remove a Queue 3 served customer
                            System.out.println("");
                            String[] yourArray3 = Arrays.copyOfRange(pump_3, 1, pump_3.length);
                            for(int t=0; t<yourArray3.length; t++) {
                                pump_3[t] = yourArray3[t];
                            }
                            break;

                    }
                    break;
                case "105":
                case "VCS":
                    //View Customers Sorted in alphabetical order
                    //Queue_1 alphabetical order
                    String vcs1[] = new String[count1 + 1];
                    for (int m = 0; m <= count1; m++) {
                        vcs1[m] = pump_1[m];
                    }
                    Arrays.sort(vcs1, Comparator.naturalOrder());
                    System.out.println("Pump_1_Queue_Alphabetical_Order : "+Arrays.toString(vcs1).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));

                    //Queue_2 alphabetical order
                    String vcs2[] = new String[count2 + 1];
                    for (int m = 0; m <= count2; m++) {
                        vcs2[m] = pump_2[m];
                    }
                    Arrays.sort(vcs2, Comparator.naturalOrder());
                    System.out.println("Pump_2_Queue_Alphabetical_Order : "+Arrays.toString(vcs2).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));

                    //Queue_3 alphabetical order
                    String vcs3[] = new String[count3 + 1];
                    for (int m = 0; m <= count3; m++) {
                        vcs3[m] = pump_3[m];
                    }
                    Arrays.sort(vcs3, Comparator.naturalOrder());
                    System.out.println("Pump_3_Queue_Alphabetical_Order : "+Arrays.toString(vcs3).replace("[", "")
                            .replace("]", "").replace(",", " ").replace("null", ""));

                    break;
                case "106":
                case "SPD":
                    //Store Program Data into file
                    System.out.println("----Program Store successfully----");
                    System.out.println();
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("Queue file.txt"));
                        writer.write("Queue_1 : " + Arrays.toString(pump_1).replace("[", "")
                                .replace("]", "").replace(",", " ").replace("null", ""));
                        writer.newLine();
                        writer.write("Queue_2 : " + Arrays.toString(pump_2).replace("[", "")
                                .replace("]", "").replace(",", " ").replace("null", ""));
                        writer.newLine();
                        writer.write("Queue_3 : " + Arrays.toString(pump_3).replace("[", "")
                                .replace("]", "").replace(",", " ").replace("null", ""));
                        writer.newLine();
                        writer.newLine();
                        writer.write("Remaining Fuel Stock : " + full);
                        writer.close();

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                case "107":
                case "LPD":
                    //Load Program Data from file
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

                    break;
                case "108":
                case "STK":
                    //View Remaining Fuel Stock
                    System.out.println("Remaining Fuel Stock : "+full);
                    System.out.println();

                    if (full == 6600) {
                        System.out.println("---Fuel Stock Full---");
                        System.out.println();
                    } else if (full <= 500) {
                        System.out.println("---500 Liters Warning---");
                        System.out.println();
                    } else {
                        System.out.println("---Fuel Stock is not full---");
                        System.out.println();
                    }

                    break;
                case "109":
                case "AFS":
                    //Add Fuel Stock
                    if (full>=6600){
                        System.out.println("---Fuel Stock is Full Cant Add Fuel---");
                        System.out.println();
                    }
                    else {

                        System.out.println("Empty Spase : " + (6600 - full));
                        Scanner AFS = new Scanner(System.in);
                        System.out.print("Add Fuel Stock : ");
                        int menu_6 = AFS.nextInt();
                        if ((6600 - full) >= menu_6){
                            full = full + menu_6;
                            System.out.println("Remaining Fuel Stock : "+full);
                        }
                        else {
                            System.out.println("---No Spase---");
                        }
                    }
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
}


