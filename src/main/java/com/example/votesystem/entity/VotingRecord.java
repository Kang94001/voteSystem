package com.example.votesystem.entity;

import jakarta.persistence.*;

@Entity
public class VotingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投票人
    private String voterName;

    @ManyToOne
    @JoinColumn(name = "votingItemId", nullable = false)
    private VotingItem votingItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public VotingItem getVotingItem() {
        return votingItem;
    }

    public void setVotingItem(VotingItem votingItem) {
        this.votingItem = votingItem;
    }
}
