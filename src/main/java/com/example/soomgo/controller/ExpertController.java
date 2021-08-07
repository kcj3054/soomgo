package com.example.soomgo.controller;

import com.example.soomgo.domain.Expert;
import com.example.soomgo.exception.SoomgoException;
import com.example.soomgo.model.GetExpertResponse;
import com.example.soomgo.model.PostExpertRequest;
import com.example.soomgo.model.PutExpertRequest;
import com.example.soomgo.repository.ExpertRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/experts")
@RestController
@RequiredArgsConstructor
public class ExpertController {

  private final ExpertRepository expertRepository;

  @GetMapping
  public GetExpertResponse getExpert(@RequestParam("userId") Long userId) {
    return expertRepository.findByUserId(userId)
      .map(expert -> {
          GetExpertResponse response = new GetExpertResponse();
          BeanUtils.copyProperties(expert, response);
          return response;
        }
      )
      .orElseThrow(() -> new SoomgoException("고수 정보 없음"));
  }

  @PostMapping
  public void post(@RequestBody PostExpertRequest request) {
    expertRepository.findByUserId(request.getUserId())
      .ifPresent(p -> {
        throw new SoomgoException("고수 프로필이 이미 등록되어 있습니다.");
      });
    Expert expert = new Expert();
    BeanUtils.copyProperties(request, expert);
    expertRepository.save(expert);
  }

  @PutMapping("{expertId}")
  public void put(@PathVariable("expertId") Long expertId, @RequestBody PutExpertRequest request) {
    Expert expert = expertRepository.findById(expertId)
      .orElseThrow(() -> new SoomgoException("고수 프로필이 없습니다."));
    if (!Objects.equals(expert.getUserId(), request.getUserId())) {
      throw new SoomgoException("잘못된 요청입니다.");
    }
    BeanUtils.copyProperties(request, expert);
    expertRepository.save(expert);
  }

}
