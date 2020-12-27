import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Scanner;

public class Home {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String[] lot = null;
        String[] temp = null;
        Boolean status = false;

        int perulangan = 1;
        while (perulangan > 0){
            String requestUser = input.nextLine().trim();
            String[] requestUserArray = requestUser.split(" ");

            /*Request Program Exit*/
            if (requestUserArray.length == 1 && requestUserArray[0].toLowerCase().equals("exit")){
                break;
            }

            /*Peroses Parking*/
            switch (requestUserArray[0].toLowerCase()){
                case "create_parking_lot":
                    if (requestUserArray.length == 2){
                        if (lot == null) {
                            lot =  new String[Integer.parseInt(requestUserArray[1])];
                            System.out.println("Created a parking lot with " +lot.length+ " slots");
                        } else {
                            System.out.println("Sorry,You have " +lot.length+ " slots parking lot");
                        }
                    } else {
                        System.out.println("Request Error!");
                    }
                    break;
                case "park":
                    if (requestUserArray.length == 3){
                        if (lot == null){
                            System.out.println("Create parking lot, before add park");
                        } else  {
                            for (int i = 0; i < lot.length; i++) {
                                if (lot[i] == null){
                                    lot[i] = requestUserArray[1] + " " +requestUserArray[2];
                                    System.out.println("Allocated slot number : " +(i+1));
                                    status = true;
                                    break;
                                } else {
                                    status = false;
                                }
                            }
                            if (status == false) {
                                System.out.println("Sorry, parking lot is full");
                            }
                        }
                    } else {
                        System.out.println("Request Error!");
                    }
                    break;
                case "leave":
                    if (requestUserArray.length == 2){
                        if (lot == null){
                            System.out.println("You don't have parking lot");
                        } else {
                            lot[Integer.parseInt(requestUserArray[1]) - 1] = null;
                            System.out.println("Slot number " + requestUserArray[1] + " is free");
                        }
                    } else {
                        System.out.println("Request Error!");
                    }
                    break;
                case "status":
                    if (requestUserArray.length == 1){
                        if (lot == null){
                            System.out.println("You don't have parking lot");
                        } else {
                            for (int i = 0; i < lot.length; i++) {
                                System.out.println((i+1)+ " " +lot[i]);
                            }
                        }
                    } else  {
                        System.out.println("Request Error!");
                    }
                    break;
                case "registration_numbers_for_cars_with_colour":
                    if (requestUserArray.length == 2){
                        status = false;
                        if (lot == null){
                            System.out.println("You don't have parking lot");
                        } else {
                            temp = null;
                            for (int i = 0; i < lot.length; i++) {
                                temp = lot[i].split(" ");
                                if (temp[1].equals(requestUserArray[1])) {
                                    System.out.println(temp[0]);
                                    status = true;
                                }
                            }
                            if (status == false) {
                                System.out.println("Sorry, registration number for cars with colour " +requestUserArray[1]+ " not avalible");
                            }
                        }
                    } else {
                        System.out.println("Request Error!");
                    }
                    break;
                case "slot_number_for_cars_with_colour" :
                    if (requestUserArray.length == 2) {
                        status = false;
                        if (lot == null){
                            System.out.println("You don't have parking lot");
                        } else {
                            temp = null;
                            for (int i = 0; i < lot.length; i++) {
                                temp = lot[i].split(" ");
                                if (temp[1].equals(requestUserArray[1])) {
                                    System.out.println(i + 1);
                                    status = true;
                                }
                            }
                            if (status == false) {
                                System.out.println("Sorry, slot number for cars with colour " +requestUserArray[1]+ " not avalible");
                            }
                        }
                    } else {
                        System.out.println("Request Error!");
                    }
                    break;
                case "slot_number_for_registration_number":
                    if (requestUserArray.length == 2) {
                        if (lot == null){
                            System.out.println("You don't have parking lot");
                        } else {
                            temp = null;
                            for (int i = 0; i < lot.length; i++) {
                                temp = lot[i].split(" ");
                                if (temp[0].equals(requestUserArray[1])) {
                                    System.out.println(i + 1);
                                    status = true;
                                    break;
                                } else {
                                    status = false;
                                }
                            }
                            if (status == false) {
                                System.out.println("Sorry, slot number for registration number " +requestUserArray[1]+ " not avalible");
                            }
                        }
                    } else {
                        System.out.println("Request Error!");
                    }
                    break;
                default:
                    System.out.println("Request Error!");
            }
            perulangan++;
        }

        System.out.println("ok");

    }


}
