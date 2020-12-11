package com.sqli.elevators.states;

public class ElevatorGoingDown implements ElevatorState {
    @Override
    public int calculateDistance(int currentFloor, int floor,int numberOfFloors) {
        System.out.println(currentFloor+" "+floor+" "+numberOfFloors);
        if(currentFloor<floor){
            return currentFloor+floor-2;
        }
        return floor-currentFloor;
    }
}
