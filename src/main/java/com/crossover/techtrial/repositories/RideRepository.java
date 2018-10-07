/**
 * 
 */
package com.crossover.techtrial.repositories;

import com.crossover.techtrial.model.Person;
import com.crossover.techtrial.model.Ride;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * @author crossover
 *
 */
@RestResource(exported = false)
public interface RideRepository extends CrudRepository<Ride, Long> {

    @Query("SELECT r.driver ,sum(r.distance)" +
            "FROM Ride r " +
            "where  r.startTime between :startDate and :endDate " +
            "order by sum (r.distance)")
    Optional<List> findTopDriver(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,Pageable pageable);


    Iterable<Ride> findAllByDriver(Person driver);
}
