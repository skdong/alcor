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

package com.futurewei.alcor.subnet.service.implement;

import com.futurewei.alcor.common.repo.ICachePublisher;
import com.futurewei.alcor.subnet.entity.SubnetState;
import com.futurewei.alcor.subnet.entity.VpcState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

//@Service
public class RedisPublisherServiceImpl implements ICachePublisher {

    private RedisTemplate<String, SubnetState> redisTemplate = new RedisTemplate<>();

    @Autowired
    private ChannelTopic topic;

    public RedisPublisherServiceImpl() {
    }

    public RedisPublisherServiceImpl(final RedisTemplate<String, SubnetState> redisTemplate, final ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public void publish(final String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
