package com.furkanbrgl.dynwebappangular7.service;

import com.furkanbrgl.dynwebappangular7.dto.IssueDto;
import com.furkanbrgl.dynwebappangular7.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issue);

    IssueDto update(Long id, IssueDto project);
}