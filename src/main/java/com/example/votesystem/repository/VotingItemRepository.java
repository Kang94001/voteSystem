package com.example.votesystem.repository;

import com.example.votesystem.entity.VotingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingItemRepository extends JpaRepository<VotingItem, Long> {

}
