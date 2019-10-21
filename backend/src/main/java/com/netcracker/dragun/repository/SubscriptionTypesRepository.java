package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.SubscriptionTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionTypesRepository  extends JpaRepository<SubscriptionTypes, Long> {
}
