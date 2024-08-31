package com.example.votesystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class VotingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 投票項目名稱
    private String name;

    // 累積票數
    private int voteCount;

    // 投票紀錄清單
    @OneToMany(mappedBy = "votingItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VotingRecord> votingRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public List<VotingRecord> getVotingRecords() {
        return votingRecords;
    }

    public void setVotingRecords(List<VotingRecord> votingRecords) {
        this.votingRecords = votingRecords;
    }
}
