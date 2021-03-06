/*Copyright 2019 The Alcor Authors.

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
package com.futurewei.alcor.macmanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.futurewei.alcor.macmanager.utils.MacUtil;
import lombok.Data;


@Data
public class MacRange {
    @JsonProperty("range_id")
    private String rangeId;

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("state")
    private String state;

    public MacRange() {
    }

    public MacRange(MacRange range) {
        this(range.rangeId, range.from, range.to, range.state);
    }

    public MacRange(String rangeId, String from, String to, String state) {
        this.rangeId = rangeId;
        this.from = from;
        this.to = to;
        this.state = state;
    }

    public void createDefault(String oui) {
        rangeId = MacUtil.DEFAULT_RANGE;
        String strFrom  = MacAddress.longToMac(0);
        String strTo = MacAddress.longToMac((long)Math.pow(2,MacAddress.NIC_LENGTH) - 1);
        from = new MacAddress(oui, strFrom).getMacAddress();
        to = new MacAddress(oui, strTo).getMacAddress();
        state = MacUtil.MAC_RANGE_STATE_ACTIVE;
    }
}


