package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        // Create rooms
        locations.put(0,new Location(0,"Central room"));
        locations.put(1, new Location(1,"Northern room"));
        locations.put(2,new Location(2,"Western room"));
        locations.put(3,new Location(3,"Eastern room"));
        locations.put(4,new Location(4,"Southern room"));

        //Add exits to each room

        //central room
        locations.get(0).addExit("N",1);
        locations.get(0).addExit("W",2);
        locations.get(0).addExit("E",3);
        locations.get(0).addExit("S",4);

        //Northern room
        locations.get(1).addExit("W",2);
        locations.get(1).addExit("S",0);

        //Western room
        locations.get(2).addExit("E",0);
        locations.get(2).addExit("N",1);

        //Eastern room
        locations.get(3).addExit("W",0);

        //Southern room
        locations.get(4).addExit("N",0);

        //Code of walking

        Scanner scanner = new Scanner(System.in);

        int currentRoom = 0;
        int roomNumber;
        String direction;
        while(true){
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
