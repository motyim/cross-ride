package com.crossover.techtrial.dto;

import com.crossover.techtrial.model.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 10/7/2018
 */
public class RideDTO {
    Long id;
    String startTime;
    String endTime;
    Long distance;
    PersonDTO driver;
    PersonDTO rider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
