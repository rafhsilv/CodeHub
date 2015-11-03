package com.caij.codehub.bean.event;

import com.caij.codehub.bean.Entity;
import com.caij.codehub.bean.Repository;
import com.caij.codehub.bean.User;

/**
 * Created by Caij on 2015/10/30.
 */
public class CreateEvent extends BaseEvent{


    /**
     * ref : 0.0.1
     * ref_type : tag
     * master_branch : master
     * description :
     * pusher_type : user
     * repository : {"id":35129377,"name":"public-repo","full_name":"baxterthehacker/public-repo","owner":{"login":"baxterthehacker","id":6752317,"avatar_url":"https://avatars.githubusercontent.com/u/6752317?v=3","gravatar_id":"","url":"https://api.github.com/users/baxterthehacker","html_url":"https://github.com/baxterthehacker","followers_url":"https://api.github.com/users/baxterthehacker/followers","following_url":"https://api.github.com/users/baxterthehacker/following{/other_user}","gists_url":"https://api.github.com/users/baxterthehacker/gists{/gist_id}","starred_url":"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/baxterthehacker/subscriptions","organizations_url":"https://api.github.com/users/baxterthehacker/orgs","repos_url":"https://api.github.com/users/baxterthehacker/repos","events_url":"https://api.github.com/users/baxterthehacker/events{/privacy}","received_events_url":"https://api.github.com/users/baxterthehacker/received_events","type":"User","site_admin":false},"private":false,"html_url":"https://github.com/baxterthehacker/public-repo","description":"","fork":false,"url":"https://api.github.com/repos/baxterthehacker/public-repo","forks_url":"https://api.github.com/repos/baxterthehacker/public-repo/forks","keys_url":"https://api.github.com/repos/baxterthehacker/public-repo/keys{/key_id}","collaborators_url":"https://api.github.com/repos/baxterthehacker/public-repo/collaborators{/collaborator}","teams_url":"https://api.github.com/repos/baxterthehacker/public-repo/teams","hooks_url":"https://api.github.com/repos/baxterthehacker/public-repo/hooks","issue_events_url":"https://api.github.com/repos/baxterthehacker/public-repo/issues/events{/number}","events_url":"https://api.github.com/repos/baxterthehacker/public-repo/events","assignees_url":"https://api.github.com/repos/baxterthehacker/public-repo/assignees{/user}","branches_url":"https://api.github.com/repos/baxterthehacker/public-repo/branches{/branch}","tags_url":"https://api.github.com/repos/baxterthehacker/public-repo/tags","blobs_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/blobs{/sha}","git_tags_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/tags{/sha}","git_refs_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/refs{/sha}","trees_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/trees{/sha}","statuses_url":"https://api.github.com/repos/baxterthehacker/public-repo/statuses/{sha}","languages_url":"https://api.github.com/repos/baxterthehacker/public-repo/languages","stargazers_url":"https://api.github.com/repos/baxterthehacker/public-repo/stargazers","contributors_url":"https://api.github.com/repos/baxterthehacker/public-repo/contributors","subscribers_url":"https://api.github.com/repos/baxterthehacker/public-repo/subscribers","subscription_url":"https://api.github.com/repos/baxterthehacker/public-repo/subscription","commits_url":"https://api.github.com/repos/baxterthehacker/public-repo/commits{/sha}","git_commits_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/commits{/sha}","comments_url":"https://api.github.com/repos/baxterthehacker/public-repo/comments{/number}","issue_comment_url":"https://api.github.com/repos/baxterthehacker/public-repo/issues/comments{/number}","contents_url":"https://api.github.com/repos/baxterthehacker/public-repo/contents/{+path}","compare_url":"https://api.github.com/repos/baxterthehacker/public-repo/compare/{base}...{head}","merges_url":"https://api.github.com/repos/baxterthehacker/public-repo/merges","archive_url":"https://api.github.com/repos/baxterthehacker/public-repo/{archive_format}{/ref}","downloads_url":"https://api.github.com/repos/baxterthehacker/public-repo/downloads","issues_url":"https://api.github.com/repos/baxterthehacker/public-repo/issues{/number}","pulls_url":"https://api.github.com/repos/baxterthehacker/public-repo/pulls{/number}","milestones_url":"https://api.github.com/repos/baxterthehacker/public-repo/milestones{/number}","notifications_url":"https://api.github.com/repos/baxterthehacker/public-repo/notifications{?since,all,participating}","labels_url":"https://api.github.com/repos/baxterthehacker/public-repo/labels{/name}","releases_url":"https://api.github.com/repos/baxterthehacker/public-repo/releases{/id}","created_at":"2015-05-05T23:40:12Z","updated_at":"2015-05-05T23:40:30Z","pushed_at":"2015-05-05T23:40:38Z","git_url":"git://github.com/baxterthehacker/public-repo.git","ssh_url":"git@github.com:baxterthehacker/public-repo.git","clone_url":"https://github.com/baxterthehacker/public-repo.git","svn_url":"https://github.com/baxterthehacker/public-repo","homepage":null,"size":0,"stargazers_count":0,"watchers_count":0,"language":null,"has_issues":true,"has_downloads":true,"has_wiki":true,"has_pages":true,"forks_count":0,"mirror_url":null,"open_issues_count":2,"forks":0,"open_issues":2,"watchers":0,"default_branch":"master"}
     * sender : {"login":"baxterthehacker","id":6752317,"avatar_url":"https://avatars.githubusercontent.com/u/6752317?v=3","gravatar_id":"","url":"https://api.github.com/users/baxterthehacker","html_url":"https://github.com/baxterthehacker","followers_url":"https://api.github.com/users/baxterthehacker/followers","following_url":"https://api.github.com/users/baxterthehacker/following{/other_user}","gists_url":"https://api.github.com/users/baxterthehacker/gists{/gist_id}","starred_url":"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/baxterthehacker/subscriptions","organizations_url":"https://api.github.com/users/baxterthehacker/orgs","repos_url":"https://api.github.com/users/baxterthehacker/repos","events_url":"https://api.github.com/users/baxterthehacker/events{/privacy}","received_events_url":"https://api.github.com/users/baxterthehacker/received_events","type":"User","site_admin":false}
     */

    private String ref;
    private String ref_type;
    private String master_branch;
    private String description;
    private String pusher_type;

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setRef_type(String ref_type) {
        this.ref_type = ref_type;
    }

    public void setMaster_branch(String master_branch) {
        this.master_branch = master_branch;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPusher_type(String pusher_type) {
        this.pusher_type = pusher_type;
    }

    public String getRef() {
        return ref;
    }

    public String getRef_type() {
        return ref_type;
    }

    public String getMaster_branch() {
        return master_branch;
    }

    public String getDescription() {
        return description;
    }

    public String getPusher_type() {
        return pusher_type;
    }

}