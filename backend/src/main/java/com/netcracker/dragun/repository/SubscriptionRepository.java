package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query(value = "select * from subscription order by id" , nativeQuery = true)
    List<Subscription> findSubscriptionByUserId(Long id);
    Subscription findSubscriptionById(Long id);
}
