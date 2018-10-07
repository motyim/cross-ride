package com.crossover.techtrial.dto;


import java.time.LocalDateTime;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 10/7/2018
 */
public class RideDTO {
    Long id;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Long distance;
    PersonDTO driver;
    PersonDTO rider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public PersonDTO getDriver() {
        return driver;
    }

    public void setDriver(PersonDTO driver) {
        this.driver = driver;
    }

    public PersonDTO getRider() {
        return rider;
    }

    public void setRider(PersonDTO rider) {
        this.rider = rider;
    }
}
