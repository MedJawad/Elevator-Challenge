package com.sqli.elevators.states;

public class ElevatorGoingUp implements ElevatorState{

    @Override
    public int calculateDistance(int currentFloor, int floor,int numberOfFloors) {
        if(currentFloor>floor){
            return 2*numberOfFloors - (currentFloor+floor);
        }
        return floor-currentFloor;
    }
}
