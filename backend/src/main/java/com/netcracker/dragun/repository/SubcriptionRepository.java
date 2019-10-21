package com.netcracker.dragun.repository;


import com.netcracker.dragun.entity.Subcription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcriptionRepository  extends JpaRepository<Subcription, Long> {
}
