/**
 * 
 */
package com.crossover.techtrial.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.StreamSupport;

import com.crossover.techtrial.dto.TopDriverDTO;
import com.crossover.techtrial.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.crossover.techtrial.model.Ride;
import com.crossover.techtrial.repositories.RideRepository;

/**
 * @author crossover
 *
 */
@Service
public class RideServiceImpl implements RideService{

  @Autowired
  RideRepository rideRepository;
  
  public Ride save(Ride ride) {
    //check date condition
    LocalDateTime endTime = ride.getEndTime();
    LocalDateTime startTime = ride.getStartTime();

    if(endTime.isBefore(startTime) || endTime.isEqual(startTime))
      throw new RuntimeException("Error in Date");

    return rideRepository.save(ride);
  }
  
  public Ride findById(Long rideId) {
    Optional<Ride> optionalRide = rideRepository.findById(rideId);
    if (optionalRide.isPresent()) {
      return optionalRide.get();
    }else return null;
  }


  public List<TopDriverDTO> findTopDriver(LocalDateTime start , LocalDateTime end , Long count){

    Optional<List> topDriver = rideRepository.findTopDriver(start, end,PageRequest.of(0,count.intValue()));

    if(!topDriver.isPresent())
      return null;

    List<TopDriverDTO> topDriverDTOS = new ArrayList<>();
    List list = topDriver.get();

    for (int i = 0; i < list.size(); i++) {
      Object [] ob = (Object[]) list.get(i);

      Person person = (Person) ob[0];
      Long distance = (Long) ob[1];


      Iterable<Ride> itr = rideRepository.findAllByDriver(person);


      long max = StreamSupport.stream(itr.spliterator(), false)
              .mapToLong(r -> r.getStartTime().until(r.getEndTime(), ChronoUnit.SECONDS))
              .max().getAsLong();

      double average = StreamSupport.stream(itr.spliterator(), false)
              .mapToLong(r -> r.getStartTime().until(r.getEndTime(), ChronoUnit.SECONDS))
              .average().getAsDouble();

      topDriverDTOS.add(new TopDriverDTO(person.getName(),person.getEmail(),distance,max,average));
    }



  return topDriverDTOS;


  }


}
