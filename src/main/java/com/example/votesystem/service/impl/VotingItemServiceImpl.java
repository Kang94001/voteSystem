package com.example.votesystem.service.impl;

import com.example.votesystem.entity.VotingItem;
import com.example.votesystem.payload.request.VotingItemRequest;
import com.example.votesystem.payload.response.VotingItemResponse;
import com.example.votesystem.repository.VotingItemRepository;
import com.example.votesystem.service.VotingItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VotingItemServiceImpl implements VotingItemService {

    @Autowired
    VotingItemRepository votingItemRepository;

    // 取得所有投票項目
    @Override
    public List<VotingItemResponse> getAllVoteItems() {
        return votingItemRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // 新增投票項目
    @Override
    public VotingItemResponse addVoteItem(VotingItemRequest votingItemRequest) {
        VotingItem votingItem = new VotingItem();
        BeanUtils.copyProperties(votingItemRequest, votingItem);
        VotingItem savedItem = votingItemRepository.save(votingItem);
        return convertToResponse(savedItem);
    }

    // 更新指定的投票項目
    @Override
    public VotingItemResponse updateVoteItem(Long id, VotingItemRequest votingItemRequest) {
        Optional<VotingItem> votingItemOptional = votingItemRepository.findById(id);
        if (votingItemOptional.isPresent()) {
            VotingItem votingItem = votingItemOptional.get();
            BeanUtils.copyProperties(votingItemRequest, votingItem);
            VotingItem updatedItem = votingItemRepository.save(votingItem);
            return convertToResponse(updatedItem);
        }
        throw new RuntimeException("Voting item not found");
    }

    // 刪除指定的投票項目
    @Override
    public void deleteVoteItem(Long id) {
        votingItemRepository.deleteById(id);
    }

    // 將 VotingItem 轉換為 VotingItemResponse
    private VotingItemResponse convertToResponse(VotingItem votingItem) {

        VotingItemResponse votingItemResponse = new VotingItemResponse();
        BeanUtils.copyProperties(votingItem, votingItemResponse);

        return votingItemResponse;
    }
}
