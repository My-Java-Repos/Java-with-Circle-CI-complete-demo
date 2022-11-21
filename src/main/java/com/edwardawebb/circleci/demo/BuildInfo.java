package com.edwardawebb.circleci.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BuildInfo {

    @Value("${build.number}")
    private String buildNum;

    @Value("${commit.hash}")
    private String commitHash;

    @Value("${build.user}")
    private String commitUser;

    @Value("${build.repo}")
    private String repoName;

    @Value("${circle.workflow.guid}")
    private String workflowGuid;

    @Value("${MY_POD_NAME}")
    private String podName;

    @Value("${MY_POD_IP}")
    private String instance_ip;


    protected static final String CCI_URL_PREFIX ="https://circleci.com/workflow-run/";
    protected static final String GH_URL_FORMAT ="https://github.com/%s/%s/commit/%s";

    public BuildInfo() {
    }

    public String getWorkflowGuid() {
        return workflowGuid;
    }

    public void setWorkflowGuid(String workflowGuid) {
        this.workflowGuid = workflowGuid;
    }

    public String getWorkflowUrl(){
        return CCI_URL_PREFIX + workflowGuid;
    }


    public String getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(String commitHash) {
        this.commitHash = commitHash;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }


    public String getGithubUrl(){
        return formatGithubUrl(commitUser,repoName,commitHash);
    }

    public String getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(String buildNum) {
        this.buildNum = buildNum;
    }

    public String getPodInfo(){
        return podName + "@" + instance_ip;
    }

    protected String formatGithubUrl(String user, String repo, String commitHash){
        return String.format(GH_URL_FORMAT, user, repo, commitHash);
    }
}
