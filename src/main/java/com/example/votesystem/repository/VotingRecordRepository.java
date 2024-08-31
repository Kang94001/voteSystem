package com.example.votesystem.repository;

import com.example.votesystem.entity.VotingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRecordRepository extends JpaRepository<VotingRecord, Long> {
}
