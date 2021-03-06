/*
Copyright 2019 The Alcor Authors.

Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/

package com.futurewei.alcor.macmanager.utils;

import com.futurewei.alcor.common.exception.*;
import com.futurewei.alcor.macmanager.entity.MacRange;
import com.futurewei.alcor.macmanager.entity.MacState;
import org.thymeleaf.util.StringUtils;

public class RestPreconditionsUtil {
    public static void verifyParameterNotNullorEmpty(String resourceId) throws ParameterNullOrEmptyException {
        if (StringUtils.isEmpty(resourceId)) {
            throw new ParameterNullOrEmptyException("Empty parameter");
        }
    }

    public static void verifyParameterNotNullorEmpty(MacState resource) throws ParameterNullOrEmptyException {
        if (resource == null) {
            throw new ParameterNullOrEmptyException("null parameter");
        }
    }

    public static void verifyParameterNotNullorEmpty(MacRange resource) throws ParameterNullOrEmptyException {
        if (resource == null) {
            throw new ParameterNullOrEmptyException("null parameter");
        }
    }

    public static void populateResourceProjectId(MacState resource, String projectId, String vpcId, String portId) {
        String resourceProjectId = resource.getProjectId();
        String resourceVpcId = resource.getVpcId();
        String resourcePortId = resource.getPortId();

        if (StringUtils.isEmpty(resourceProjectId)) {
            resource.setProjectId(projectId);
        } else if (!resourceProjectId.equalsIgnoreCase(projectId)) {
            System.out.println("Resource id not matched " + resourceProjectId + " : " + projectId);
            resource.setProjectId(projectId);
        }

        if (StringUtils.isEmpty(resourceVpcId)) {
            resource.setVpcId(vpcId);
        } else if (!resourceVpcId.equalsIgnoreCase(vpcId)) {
            System.out.println("Resource vpc id not matched " + resourceVpcId + " : " + vpcId);
            resource.setVpcId(vpcId);
        }

        if (StringUtils.isEmpty(resourcePortId)) {
            resource.setPortId(portId);
        } else if (!resourcePortId.equalsIgnoreCase(portId)) {
            System.out.println("Resource port is not matched " + resourcePortId + " : " + portId);
            resource.setPortId(portId);
        }
    }

    public static void populateResourceProjectId(MacState resource, String projectId) {
        String resourceProjectId = resource.getProjectId();
        if (StringUtils.isEmpty(resourceProjectId)) {
            resource.setProjectId(projectId);
        } else if (!resourceProjectId.equalsIgnoreCase(projectId)) {
            System.out.println("Resource id not matched " + resourceProjectId + " : " + projectId);
            resource.setProjectId(projectId);
        }
    }

    public static void populateResourceVpcId(MacState resource, String vpcId) {
        String resourceVpcId = null;
        if (resource instanceof MacState) {
            resourceVpcId = resource.getVpcId();
        }

        if (StringUtils.isEmpty(resourceVpcId)) {
            resource.setVpcId(vpcId);
        } else if (!resourceVpcId.equalsIgnoreCase(vpcId)) {
            System.out.println("Resource vpc id not matched " + resourceVpcId + " : " + vpcId);
            resource.setVpcId(vpcId);
        }
    }

    public static void populateResourcePort(MacState resource, String portId) {
        String resourcePortId = null;
        if (resource instanceof MacState) {
            resourcePortId = resource.getPortId();
        }

        if (StringUtils.isEmpty(resourcePortId)) {
            resource.setPortId(portId);
        } else if (!resourcePortId.equalsIgnoreCase(portId)) {
            System.out.println("Resource port is not matched " + resourcePortId + " : " + portId);
            resource.setPortId(portId);
        }
    }
}