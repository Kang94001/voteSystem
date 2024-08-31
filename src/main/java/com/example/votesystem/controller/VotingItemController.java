package com.example.votesystem.controller;

import com.example.votesystem.payload.request.VotingItemRequest;
import com.example.votesystem.payload.response.VotingItemResponse;
import com.example.votesystem.service.VotingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class VotingItemController {

    @Autowired
    private VotingItemService votingItemService;

    // 取得所有投票項目
    @GetMapping("/items")
    public ResponseEntity<List<VotingItemResponse>> getAllVoteItems() {
        List<VotingItemResponse> items = votingItemService.getAllVoteItems();
        return ResponseEntity.ok(items);
    }

    // 新增投票項目
    @PostMapping("/items")
    public ResponseEntity<VotingItemResponse> addVoteItem(@RequestBody VotingItemRequest votingItemRequest) {
        VotingItemResponse newItem = votingItemService.addVoteItem(votingItemRequest);
        return ResponseEntity.ok(newItem);
    }

    // 更新指定的投票項目
    @PostMapping("/items/{id}")
    public ResponseEntity<VotingItemResponse> updateVoteItem(@PathVariable Long id,
                                                             @RequestBody VotingItemRequest votingItemRequest) {
        VotingItemResponse updatedItem = votingItemService.updateVoteItem(id, votingItemRequest);
        return ResponseEntity.ok(updatedItem);
    }

    // 刪除指定的投票項目
    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteVoteItem(@PathVariable Long id) {
        votingItemService.deleteVoteItem(id);
        return ResponseEntity.noContent().build();
    }

}
