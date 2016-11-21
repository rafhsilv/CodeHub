package com.rafael.githubmngr.bean;

public class Team extends Entity{

    private String name;
    private int id;
    private String slug;
    private String permission;
    private String url;
    private String members_url;
    private String repositories_url;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMembers_url(String members_url) {
        this.members_url = members_url;
    }

    public void setRepositories_url(String repositories_url) {
        this.repositories_url = repositories_url;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getPermission() {
        return permission;
    }

    public String getUrl() {
        return url;
    }

    public String getMembers_url() {
        return members_url;
    }

    public String getRepositories_url() {
        return repositories_url;
    }
}
