package com.sqli.elevators.states;

public class ElevatorResting implements ElevatorState{

    @Override
    public int calculateDistance(int currentFloor, int floor,int numberOfFloors) {
        return Math.abs(floor-currentFloor);
    }
}
