/**
 * 
 */
package com.crossover.techtrial.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.crossover.techtrial.model.Ride;
import com.crossover.techtrial.repositories.RideRepository;

import javax.persistence.criteria.Path;

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
    LocalDateTime endTime = LocalDateTime.parse(ride.getEndTime());
    LocalDateTime startTime = LocalDateTime.parse(ride.getStartTime());

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

  @Override
  public void findTopDriver(Long count, LocalDateTime startTime, LocalDateTime endTime) {

//    Stream<Ride> stream = StreamSupport.stream(rideRepository.findAll().spliterator(),false);
//    List<Ride> list = stream.parallel()
//            .filter(ride ->{
//              LocalDateTime startedDate = LocalDateTime.parse(ride.getStartTime());
//              return startedDate.isAfter(startTime) && startedDate.isBefore(endTime); }).collect(Collectors.toList());
//
//    list Collect
//    list.stream().forEach();

    List topDriver = rideRepository.findTopDriver(startTime.toString(), endTime.toString());
    System.out.println(topDriver.size());
  }

}
