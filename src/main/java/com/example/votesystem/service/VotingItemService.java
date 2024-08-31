package com.example.votesystem.service;

import com.example.votesystem.payload.request.VotingItemRequest;
import com.example.votesystem.payload.response.VotingItemResponse;

import java.util.List;

public interface VotingItemService {
    // 取得所有投票項目
    List<VotingItemResponse> getAllVoteItems();

    // 新增投票項目
    VotingItemResponse addVoteItem(VotingItemRequest votingItemRequest);

    // 更新指定的投票項目
    VotingItemResponse updateVoteItem(Long id, VotingItemRequest votingItemRequest);

    // 刪除指定的投票項目
    void deleteVoteItem(Long id);
}
