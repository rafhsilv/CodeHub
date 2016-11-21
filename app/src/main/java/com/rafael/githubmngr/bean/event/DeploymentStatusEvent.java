package com.rafael.githubmngr.bean.event;

import com.rafael.githubmngr.bean.Deployment;
import com.rafael.githubmngr.bean.DeploymentStatus;

/**
 * Created by Rafael on 2016/10/30.
 */
public class DeploymentStatusEvent extends BaseEvent{

    private DeploymentStatus deployment_status;
    private Deployment deployment;

    public void setDeployment_status(DeploymentStatus deployment_status) {
        this.deployment_status = deployment_status;
    }

    public DeploymentStatus getDeployment_status() {
        return deployment_status;
    }

    public Deployment getDeployment() {
        return deployment;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }
}
