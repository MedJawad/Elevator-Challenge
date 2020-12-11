package com.sqli.elevators.states;

public interface ElevatorState {
    public int  calculateDistance(int currentFloor, int floor,int numberOfFloors);
}
