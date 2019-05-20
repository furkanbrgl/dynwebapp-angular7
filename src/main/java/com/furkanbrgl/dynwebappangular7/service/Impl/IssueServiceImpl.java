package com.furkanbrgl.dynwebappangular7.service.Impl;

import com.furkanbrgl.dynwebappangular7.dto.IssueDto;
import com.furkanbrgl.dynwebappangular7.entity.Issue;
import com.furkanbrgl.dynwebappangular7.repository.IssueRepository;
import com.furkanbrgl.dynwebappangular7.service.IssueService;
import com.furkanbrgl.dynwebappangular7.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public IssueDto save(IssueDto issue) {
        // Bussiness Logic

        if (issue.getDate() == null) {
            throw new IllegalArgumentException("Issue Date cannot be null");
        }

        Issue issueEntity = modelMapper.map(issue, Issue.class);

        issueEntity = issueRepository.save(issueEntity);

        issue.setId(issueEntity.getId());
        return issue;
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> respnose = new TPage<IssueDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }

}
