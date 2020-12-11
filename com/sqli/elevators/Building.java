package com.sqli.elevators;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final int numberOfFloors;
    private final List<Elevator> elevators;

    public Building(int numberOfFloors, String... elevatorInfos) {
        this.numberOfFloors = numberOfFloors;
        this.elevators = new ArrayList<>();
        for (String elevatorInfo : elevatorInfos) {
            String id = elevatorInfo.split(":")[0];
            int floor = Integer.parseInt(elevatorInfo.split(":")[1]);
            elevators.add(new Elevator(id, floor));
        }
    }

    public String requestElevator() {
        return requestElevator(numberOfFloors);
    }

    public String requestElevator(int requestedFloor) {

        String closestElevatorId=elevators.get(0).getElevatorId();
        int closestElevatorDistance=elevators.get(0).getDistanceFromFloor(requestedFloor,numberOfFloors);

        for (Elevator elevator : elevators) {
            int elevatorDistance = elevator.getDistanceFromFloor(requestedFloor,numberOfFloors);
            if(elevatorDistance<0) continue;
            if(elevatorDistance<closestElevatorDistance){
                closestElevatorId = elevator.getElevatorId();
                closestElevatorDistance = elevatorDistance;
            }
        }
        return closestElevatorId;
    }

    public void move(String elevatorId, String nextState) {
        Elevator elevator = findElevatorById(elevatorId);
        assert elevator != null;
        elevator.setState(nextState);
    }

    public void stopAt(String elevatorId, int stoppingFloor) {
        Elevator elevator = findElevatorById(elevatorId);
        assert elevator != null;
        elevator.setState("STOP");
        elevator.setCurrentFloor(stoppingFloor);

    }
    private Elevator findElevatorById(String elevatorId) {
        return elevators.stream()
                .filter(elevator1 -> elevatorId.equals(elevator1.getElevatorId()))
                .findAny()
                .orElse(null);
    }
}
