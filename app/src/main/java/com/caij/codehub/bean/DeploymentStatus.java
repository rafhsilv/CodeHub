package com.caij.codehub.bean;


public class DeploymentStatus {

    private String url;
    private int id;
    private String state;
    private Object description;
    private Object target_url;
    private String created_at;
    private String updated_at;
    private String deployment_url;
    private String repository_url;
    private User creator;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public void setTarget_url(Object target_url) {
        this.target_url = target_url;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setDeployment_url(String deployment_url) {
        this.deployment_url = deployment_url;
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

    public String getState() {
        return state;
    }

    public Object getDescription() {
        return description;
    }

    public Object getTarget_url() {
        return target_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getDeployment_url() {
        return deployment_url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
