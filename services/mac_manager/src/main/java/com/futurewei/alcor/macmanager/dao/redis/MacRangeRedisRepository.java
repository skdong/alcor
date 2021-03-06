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
package com.futurewei.alcor.macmanager.dao.redis;

import com.futurewei.alcor.common.logging.Logger;
import com.futurewei.alcor.common.logging.LoggerFactory;
import com.futurewei.alcor.common.repo.ICacheRepository;
import com.futurewei.alcor.macmanager.entity.MacRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.logging.Level;

@Repository
public class MacRangeRedisRepository implements ICacheRepository<MacRange> {

    private String KEY = "mac_range";

    private RedisTemplate<String, MacRange> redisMacRangeTemplate;

    private HashOperations hashOperations;

    @Autowired
    public MacRangeRedisRepository(RedisTemplate<String, MacRange> redisMacRangeTemplate) {

        this.redisMacRangeTemplate = redisMacRangeTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisMacRangeTemplate.opsForHash();
    }

    @Override
    public synchronized MacRange findItem(String id) {

        return (MacRange) hashOperations.get(KEY, id);
    }

    @Override
    public synchronized Map<String, MacRange> findAllItems() {
        return hashOperations.entries(KEY);
    }

    @Override
    public synchronized void addItem(MacRange newItem) {
        Logger logger = LoggerFactory.getLogger();
        logger.log(Level.INFO, "mac address:" + newItem.getRangeId());
        hashOperations.putIfAbsent(KEY, newItem.getRangeId(), newItem);
    }

    @Override
    public synchronized void deleteItem(String id) {
        hashOperations.delete(KEY, id);
    }

    public synchronized void updateItem(MacRange newItem) {
        hashOperations.put(KEY, newItem.getRangeId(), newItem);
    }
}

