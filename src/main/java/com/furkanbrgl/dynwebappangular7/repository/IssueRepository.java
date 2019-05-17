package com.furkanbrgl.dynwebappangular7.repository;
import com.furkanbrgl.dynwebappangular7.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}