package com.furkanbrgl.dynwebappangular7.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "issue")
public class Issue extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Issue() {
    }

    public Issue(String description, String details, Date date, IssueStatus issueStatus, User assignee, Project project) {
        this.description = description;
        this.details = details;
        this.date = date;
        this.issueStatus = issueStatus;
        this.assignee = assignee;
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;
        Issue issue = (Issue) o;
        return Objects.equals(getId(), issue.getId()) &&
                Objects.equals(getDescription(), issue.getDescription()) &&
                Objects.equals(getDetails(), issue.getDetails()) &&
                Objects.equals(getDate(), issue.getDate()) &&
                getIssueStatus() == issue.getIssueStatus() &&
                Objects.equals(getAssignee(), issue.getAssignee()) &&
                Objects.equals(getProject(), issue.getProject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getDetails(), getDate(), getIssueStatus(), getAssignee(), getProject());
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", date=" + date +
                ", issueStatus=" + issueStatus +
                ", assignee=" + assignee +
                ", project=" + project +
                '}';
    }
}
