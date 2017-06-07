package com.dddsample.ec2.domain.instance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by azhu on 25/05/2017.
 */
@Entity
public class Instance {

    public String getInstanceId() {
        return instanceId;
    }

    @Id
    private String instanceId;

    private String flavorId;
    private String az;

    @Column(name = "STATUS")
    private VMStatus  vmStatus = VMStatus.Pending;

    public enum VMStatus {Pending, Running, ShuttingDown, Rebooting, Terminated}

    public Instance() {
    }

    public Instance(String flavorId) {
        this.flavorId = flavorId;
    }

    public VMStatus status() {
        return vmStatus;
    }

    public boolean launch() {
        if (vmStatus == null) {
            vmStatus = VMStatus.Pending;
            return true;
        }
        return false;
    }

    //TODO how notify resource context to retire instance physically
    public boolean moveStatusTo(VMStatus vmStatus) {
        if (vmStatus == VMStatus.Running) {
            if (this.vmStatus == VMStatus.Pending) {
                this.vmStatus = VMStatus.Running;
                return true;
            } else if (this.vmStatus == VMStatus.Rebooting) {
                this.vmStatus = VMStatus.Running;
                return true;
            }else {
                return false;
            }
        }

        if (vmStatus == VMStatus.Terminated) {
            if (this.vmStatus == VMStatus.ShuttingDown) {
                this.vmStatus = VMStatus.Terminated;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public boolean reboot() {
        if (this.vmStatus == VMStatus.Running) {
            vmStatus = VMStatus.Rebooting;
            return true;
        }
        return false;
    }

    public boolean terminate() {
        if (vmStatus == VMStatus.Running) {
            vmStatus = VMStatus.ShuttingDown;
            return true;
        }
        return false;
    }

    public void setAZ(String AZ) {
        this.az = AZ;
    }

    public String getAZ() {
        return az;
    }

    public String getFlavorId() {
        return flavorId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

}