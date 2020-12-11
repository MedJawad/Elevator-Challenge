package com.sqli.elevators.states;

public class ElevatorStopped implements ElevatorState{

    @Override
    public int calculateDistance(int currentFloor, int floor,int numberOfFloors) {
        return -1;
    }
}
