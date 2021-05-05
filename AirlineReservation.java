package airline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineReservation {

    public static int count = 0;
    public static int rowCount = 0;
    public static int colCount=0;
    public static void print(List<String[][]> list){
        for(int i=0;i<list.size();i++){
            System.out.println();
            String[][] board = list.get(i);
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void fillASeat(List<String[][]> list){
        //find A seats
        for(int i=0;i<list.size();i++){
            if(i==0){
                String[][] board = list.get(i);
                int row = board.length -1;
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = "A";
                }
            }
            else if(i==list.size()-1){
                String[][] board = list.get(i);
                int row = 0;
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = "A";
                }
            }
            else{
                String[][] board = list.get(i);
                int row = 0;
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = "A";
                }
                row = board.length -1;
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = "A";
                }
            }
        }
    }

    public static void fillWSeat(List<String[][]> list){
        //find W seats
        for(int i=0;i<list.size();i++){
            if(i==0)
            {
                String[][] board = list.get(i);
                int row = 0;
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = "W";
                }
            }
            if(i==list.size()-1){
                String[][] board = list.get(i);
                int row = board.length -1;
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = "W";
                }
            }
        }
    }

    public static void fillMSeat(List<String[][]> list){
        //find M seats
        for(int i=0;i<list.size();i++){
            String[][] board = list.get(i);
            for(int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if(board[row][col] ==null){
                        board[row][col] = "M";
                    }
                }
            }
        }
    }

    public static void getMaxRowCount(List<String[][]> list){
        for(int i=0;i<list.size();i++){
            String[][] board = list.get(i);
            int row=board.length;
            colCount = colCount+row;
            int col = board[0].length;
            if(rowCount<col){
                rowCount = col;
            }
        }
    }
    public static void fillASeatWithData(List<String[][]> list,int passengerCount){
        for(int k=0;k<rowCount;k++) {
            for (int i = 0; i < list.size(); i++) {
                String[][] board = list.get(i);
                int row = board.length - 1;
                int col = board[row].length-1;
                if (i == 0) {
                    if (col-k>= 0) {
                        if(count<passengerCount) {
                            board[row][col - k] = String.valueOf(++count);
                        }
                    }else{
                        continue;
                    }
                } else if (i == list.size() - 1) {
                    if (col-k >= 0) {
                        if(count<passengerCount) {
                            board[0][col - k] = String.valueOf(++count);
                        }
                    }else{
                        continue;
                    }
                } else {
                    if (col-k >= 0) {
                        if(count<passengerCount) {
                            board[0][col - k] = String.valueOf(++count);
                            board[row][col - k] = String.valueOf(++count);
                        }
                    }else{
                        continue;
                    }
                }
            }
        }
    }

    public static void fillWSeatWithData(List<String[][]> list,int passengerCount){
        for(int k=0;k<rowCount;k++) {
            for (int i = 0; i < list.size(); i++) {
                String[][] board = list.get(i);
                int row = board.length - 1;
                int col = board[row].length-1;
                if (i == 0) {
                    if (col-k>= 0) {
                        if(count<passengerCount) {
                            board[0][col - k] = String.valueOf(++count);
                        }
                    }else{
                        continue;
                    }
                }
                if (i == list.size() - 1) {
                    if (col-k >= 0) {
                        if(count<passengerCount) {
                            board[row][col - k] = String.valueOf(++count);
                        }
                    }else{
                        continue;
                    }
                }
            }
        }
    }
    public static void fillMSeatWithData(List<String[][]> list,int passengerCount){
        for(int k=0;k<rowCount;k++) {
            for (int i = 0; i < list.size(); i++) {
                String[][] board = list.get(i);
                int row1 = board.length - 1;
                int col = board[row1].length - 1;
                if (col - k >= 0) {
                    for (int row = 0; row <= board.length - 1; row++) {
                        if (row != 0 && row != board.length - 1) {
                            if(count<passengerCount) {
                                board[row][col - k] = String.valueOf(++count);
                            }
                        }
                    }
                } else {
                    continue;
                }
            }

        }
    }

    public static String getCompactString(String str){
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }
    public static boolean isInputArrayDetailsCountEven(String arrayInput){
        arrayInput = getCompactString(arrayInput);
        char [] modifiedStr = arrayInput.toCharArray();
        if(modifiedStr.length %2 == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a 2D array that represents the rows and columns : ");
        System.out.println("Example [[3,4],[4,5],[2,3],[3,4]] ");
        String arrayInput = in.nextLine();
        System.out.println("\n");
        System.out.println("You entered string " + arrayInput.trim());

        if(!isInputArrayDetailsCountEven(arrayInput)){
            System.out.println("You have entered wrong array input");
            System.out.println("Please enter a valid 2D array that represents the rows and columns : ");
            arrayInput = in.nextLine();
            System.out.println("\n");
            System.out.println("You entered string " + arrayInput.trim());
        }
        System.out.println("Number of passengers waiting in queue : ");
        String passengerInput = in.nextLine();
        System.out.println("\n");
        System.out.println("You entered string " + passengerInput.trim());

        System.out.println("Tryout the Pictorial view for A,W,M seats (y/n): ");
        String resp1 = in.nextLine();
        System.out.println("\n");
        System.out.println("You entered string " + resp1.trim());

        System.out.println("Tryout the actual view for A,W,M seats after reservation (y/n): ");
        String resp2 = in.nextLine();
        System.out.println("\n");
        System.out.println("You entered string " + resp2.trim());

        if(!isInputArrayDetailsCountEven(arrayInput)){
            System.out.println("Exited as the input parameter is incorrect");
        }else{
            String str = getCompactString(arrayInput);
            char [] arr = str.toCharArray();
            ArrayList<String[][]> list = new ArrayList<String[][]>();
            for(int i=0;i<arr.length;i=i+2){
                int j=i;
                try {
                    String[][] stringArray = new String[Integer.parseInt(String.valueOf(arr[j]))][Integer.parseInt(String.valueOf(arr[j + 1]))];
                    list.add(stringArray);
                }catch (Exception e){
                    System.out.println("Error in input. "+e.getMessage());
                    e.printStackTrace();
                }
            }
            if(resp1.trim().equalsIgnoreCase("y")){
                try {
                    System.out.println("Dummy picture view for A,W,M seats");
                    System.out.println("==================================");
                    AirlineReservation.fillASeat(list);
                    AirlineReservation.fillWSeat(list);
                    AirlineReservation.fillMSeat(list);
                    AirlineReservation.print(list);
                }catch (Exception e){
                    System.out.println("Error in initializing dummy picture . "+e.getMessage());
                    e.printStackTrace();
                }
            }

            try {
                System.out.println();
                System.out.println("Actual picture view after reservation on A,W,M seats");
                System.out.println("====================================================");
                AirlineReservation.getMaxRowCount(list);
                int passengerCount = 30;
                AirlineReservation.fillASeatWithData(list,passengerCount);
                AirlineReservation.fillWSeatWithData(list,passengerCount);
                AirlineReservation.fillMSeatWithData(list, passengerCount);
                AirlineReservation.print(list);
            }catch (Exception e){
                System.out.println("Error in initializing actual picture . "+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
