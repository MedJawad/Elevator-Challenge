package com.sqli.elevators;

import com.sqli.elevators.states.*;

public class Elevator {
    private final String elevatorId;
    private ElevatorState state;
    private int currentFloor;

    public Elevator(String elevatorId, int currentFloor) {
        this.state = new ElevatorResting();
        this.elevatorId = elevatorId;
        this.currentFloor = currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(String state) {
        switch (state.toUpperCase()) {
            case "UP": {
                this.state = new ElevatorGoingUp();
                break;
            }
            case "DOWN": {
                this.state = new ElevatorGoingDown();
                break;
            }
            case "STOP": {
                this.state = new ElevatorStopped();
                break;
            }
            default:
                this.state = new ElevatorResting();
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public Integer getDistanceFromFloor(int floor, int numberOfFloors) {
        return state.calculateDistance(currentFloor, floor, numberOfFloors);
    }
}
