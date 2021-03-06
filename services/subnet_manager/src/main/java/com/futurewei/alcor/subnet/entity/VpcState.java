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

package com.futurewei.alcor.subnet.entity;

import com.futurewei.alcor.common.entity.CustomerResource;
import lombok.Data;

import java.util.List;

@Data
public class VpcState extends CustomerResource {

    private String cidr;

    private List<RouteWebObject> routes;

    public VpcState() {
    }

    public VpcState(String projectId, String id, String name, String cidr, List<RouteWebObject> routeWebObjectList) {
        this(projectId, id, name, cidr, null, routeWebObjectList);
    }

    public VpcState(VpcState state) {
        this(state.getProjectId(), state.getId(), state.getName(), state.getCidr(), state.getDescription(), state.getRoutes());
    }

    public VpcState(String projectId, String id, String name, String cidr, String description, List<RouteWebObject> routeWebObjectList) {

        super(projectId, id, name, description);
        this.cidr = cidr;
        this.routes = routeWebObjectList;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public List<RouteWebObject> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteWebObject> routes) {
        this.routes = routes;
    }
}


