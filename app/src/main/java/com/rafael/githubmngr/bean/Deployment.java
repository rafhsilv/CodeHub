package com.rafael.githubmngr.bean;

public class Deployment {

    private String url;
    private int id;
    private String sha;
    private String ref;
    private String task;
    private String environment;
    private Object description;
    private String created_at;
    private String updated_at;
    private String statuses_url;
    private String repository_url;
    private String payload;
    private User creator;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setStatuses_url(String statuses_url) {
        this.statuses_url = statuses_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public String getSha() {
        return sha;
    }

    public String getRef() {
        return ref;
    }

    public String getTask() {
        return task;
    }

    public String getEnvironment() {
        return environment;
    }

    public Object getDescription() {
        return description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getStatuses_url() {
        return statuses_url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
