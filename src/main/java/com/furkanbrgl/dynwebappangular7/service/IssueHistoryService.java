package com.furkanbrgl.dynwebappangular7.service;

import com.furkanbrgl.dynwebappangular7.dto.IssueHistoryDto;
import com.furkanbrgl.dynwebappangular7.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistoryDto save(IssueHistoryDto issueHistory);

    IssueHistoryDto getById(Long id);

    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistoryDto issueHistory);

}
