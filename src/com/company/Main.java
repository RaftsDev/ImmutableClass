package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        // Create rooms
        
        //Add exits to each room
        
        //central room
        Map<String, Integer> tempExits = new HashMap<String, Integer>();
        tempExits.put("N",1);
        tempExits.put("W",2);
        tempExits.put("E",3);
        tempExits.put("S",4);
        locations.put(0,new Location(0,"Central room", tempExits));

        //Northern room
        tempExits = new HashMap<String, Integer>();
        tempExits.put("W",2);
        tempExits.put("S",0);
        locations.put(1, new Location(1,"Northern room", tempExits));

        //Western room
        tempExits = new HashMap<String, Integer>();
        tempExits.put("E",0);
        tempExits.put("N",1);
        locations.put(2,new Location(2,"Western room", tempExits));

        //Eastern room
        tempExits = new HashMap<String, Integer>();
        tempExits.put("W",0);
        locations.put(3,new Location(3,"Eastern room", tempExits));


        //Southern room
        tempExits = new HashMap<String, Integer>();
        tempExits.put("N",0);
        locations.put(4,new Location(4,"Southern room", tempExits));


        //Code of walking

        Scanner scanner = new Scanner(System.in);

        int currentRoom = 0;
        int roomNumber;
        String direction;
        while(true){
            // check immutability
            tempExits.remove("S");

            //print current location
            System.out.println("Your are in: "+locations.get(currentRoom).getDescription());
            System.out.println("Your directions of exits: ");
            System.out.print("| ");
            for(String key : locations.get(currentRoom).getExits().keySet()){
                roomNumber = locations.get(currentRoom).getExits().get(key);
                System.out.print(key+" - "+locations.get(roomNumber).getDescription()+" | ");
            }
            System.out.println();
            direction = scanner.nextLine().toUpperCase();

            if(direction.equals("Q")){
                System.out.println("Quiting...");
                break;
            }else{
                System.out.println("Your choose direction: "+direction);
            }

            if(locations.get(currentRoom).getExits().containsKey(direction)){
                System.out.println("You going to: "+direction);
                // moving action
                currentRoom = locations.get(currentRoom).getExits().get(direction);
            }else{
                System.out.println("No exit in this direction");
            }

        }

    }
}
