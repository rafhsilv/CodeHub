package com.caij.codehub.bean.event;

import com.caij.codehub.bean.Comment;

/**
 * Created by Caij on 2015/10/30.
 */
public class CommitCommentEvent extends BaseEvent {


    /**
     * action : created
     * comment : {"url":"https://api.github.com/repos/baxterthehacker/public-repo/comments/11056394","html_url":"https://github.com/baxterthehacker/public-repo/commit/9049f1265b7d61be4a8904a9a27120d2064dab3b#commitcomment-11056394","id":11056394,"user":{"login":"baxterthehacker","id":6752317,"avatar_url":"https://avatars.githubusercontent.com/u/6752317?v=3","gravatar_id":"","url":"https://api.github.com/users/baxterthehacker","html_url":"https://github.com/baxterthehacker","followers_url":"https://api.github.com/users/baxterthehacker/followers","following_url":"https://api.github.com/users/baxterthehacker/following{/other_user}","gists_url":"https://api.github.com/users/baxterthehacker/gists{/gist_id}","starred_url":"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/baxterthehacker/subscriptions","organizations_url":"https://api.github.com/users/baxterthehacker/orgs","repos_url":"https://api.github.com/users/baxterthehacker/repos","events_url":"https://api.github.com/users/baxterthehacker/events{/privacy}","received_events_url":"https://api.github.com/users/baxterthehacker/received_events","type":"User","site_admin":false},"position":null,"line":null,"path":null,"commit_id":"9049f1265b7d61be4a8904a9a27120d2064dab3b","created_at":"2015-05-05T23:40:29Z","updated_at":"2015-05-05T23:40:29Z","body":"This is a really good change! :+1:"}
     * repository : {"id":35129377,"name":"public-repo","full_name":"baxterthehacker/public-repo","owner":{"login":"baxterthehacker","id":6752317,"avatar_url":"https://avatars.githubusercontent.com/u/6752317?v=3","gravatar_id":"","url":"https://api.github.com/users/baxterthehacker","html_url":"https://github.com/baxterthehacker","followers_url":"https://api.github.com/users/baxterthehacker/followers","following_url":"https://api.github.com/users/baxterthehacker/following{/other_user}","gists_url":"https://api.github.com/users/baxterthehacker/gists{/gist_id}","starred_url":"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/baxterthehacker/subscriptions","organizations_url":"https://api.github.com/users/baxterthehacker/orgs","repos_url":"https://api.github.com/users/baxterthehacker/repos","events_url":"https://api.github.com/users/baxterthehacker/events{/privacy}","received_events_url":"https://api.github.com/users/baxterthehacker/received_events","type":"User","site_admin":false},"private":false,"html_url":"https://github.com/baxterthehacker/public-repo","description":"","fork":false,"url":"https://api.github.com/repos/baxterthehacker/public-repo","forks_url":"https://api.github.com/repos/baxterthehacker/public-repo/forks","keys_url":"https://api.github.com/repos/baxterthehacker/public-repo/keys{/key_id}","collaborators_url":"https://api.github.com/repos/baxterthehacker/public-repo/collaborators{/collaborator}","teams_url":"https://api.github.com/repos/baxterthehacker/public-repo/teams","hooks_url":"https://api.github.com/repos/baxterthehacker/public-repo/hooks","issue_events_url":"https://api.github.com/repos/baxterthehacker/public-repo/issues/events{/number}","events_url":"https://api.github.com/repos/baxterthehacker/public-repo/events","assignees_url":"https://api.github.com/repos/baxterthehacker/public-repo/assignees{/user}","branches_url":"https://api.github.com/repos/baxterthehacker/public-repo/branches{/branch}","tags_url":"https://api.github.com/repos/baxterthehacker/public-repo/tags","blobs_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/blobs{/sha}","git_tags_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/tags{/sha}","git_refs_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/refs{/sha}","trees_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/trees{/sha}","statuses_url":"https://api.github.com/repos/baxterthehacker/public-repo/statuses/{sha}","languages_url":"https://api.github.com/repos/baxterthehacker/public-repo/languages","stargazers_url":"https://api.github.com/repos/baxterthehacker/public-repo/stargazers","contributors_url":"https://api.github.com/repos/baxterthehacker/public-repo/contributors","subscribers_url":"https://api.github.com/repos/baxterthehacker/public-repo/subscribers","subscription_url":"https://api.github.com/repos/baxterthehacker/public-repo/subscription","commits_url":"https://api.github.com/repos/baxterthehacker/public-repo/commits{/sha}","git_commits_url":"https://api.github.com/repos/baxterthehacker/public-repo/git/commits{/sha}","comments_url":"https://api.github.com/repos/baxterthehacker/public-repo/comments{/number}","issue_comment_url":"https://api.github.com/repos/baxterthehacker/public-repo/issues/comments{/number}","contents_url":"https://api.github.com/repos/baxterthehacker/public-repo/contents/{+path}","compare_url":"https://api.github.com/repos/baxterthehacker/public-repo/compare/{base}...{head}","merges_url":"https://api.github.com/repos/baxterthehacker/public-repo/merges","archive_url":"https://api.github.com/repos/baxterthehacker/public-repo/{archive_format}{/ref}","downloads_url":"https://api.github.com/repos/baxterthehacker/public-repo/downloads","issues_url":"https://api.github.com/repos/baxterthehacker/public-repo/issues{/number}","pulls_url":"https://api.github.com/repos/baxterthehacker/public-repo/pulls{/number}","milestones_url":"https://api.github.com/repos/baxterthehacker/public-repo/milestones{/number}","notifications_url":"https://api.github.com/repos/baxterthehacker/public-repo/notifications{?since,all,participating}","labels_url":"https://api.github.com/repos/baxterthehacker/public-repo/labels{/name}","releases_url":"https://api.github.com/repos/baxterthehacker/public-repo/releases{/id}","created_at":"2015-05-05T23:40:12Z","updated_at":"2015-05-05T23:40:12Z","pushed_at":"2015-05-05T23:40:27Z","git_url":"git://github.com/baxterthehacker/public-repo.git","ssh_url":"git@github.com:baxterthehacker/public-repo.git","clone_url":"https://github.com/baxterthehacker/public-repo.git","svn_url":"https://github.com/baxterthehacker/public-repo","homepage":null,"size":0,"stargazers_count":0,"watchers_count":0,"language":null,"has_issues":true,"has_downloads":true,"has_wiki":true,"has_pages":true,"forks_count":0,"mirror_url":null,"open_issues_count":2,"forks":0,"open_issues":2,"watchers":0,"default_branch":"master"}
     * sender : {"login":"baxterthehacker","id":6752317,"avatar_url":"https://avatars.githubusercontent.com/u/6752317?v=3","gravatar_id":"","url":"https://api.github.com/users/baxterthehacker","html_url":"https://github.com/baxterthehacker","followers_url":"https://api.github.com/users/baxterthehacker/followers","following_url":"https://api.github.com/users/baxterthehacker/following{/other_user}","gists_url":"https://api.github.com/users/baxterthehacker/gists{/gist_id}","starred_url":"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/baxterthehacker/subscriptions","organizations_url":"https://api.github.com/users/baxterthehacker/orgs","repos_url":"https://api.github.com/users/baxterthehacker/repos","events_url":"https://api.github.com/users/baxterthehacker/events{/privacy}","received_events_url":"https://api.github.com/users/baxterthehacker/received_events","type":"User","site_admin":false}
     */

    private String action;
    private Comment comment;

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
