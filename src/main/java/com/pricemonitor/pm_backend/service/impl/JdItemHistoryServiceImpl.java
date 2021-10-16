package com.pricemonitor.pm_backend.service.impl;


import com.pricemonitor.pm_backend.bean.pojo.JdItemHistory;
import com.pricemonitor.pm_backend.bean.pojo.JdItemHistoryExample;
import com.pricemonitor.pm_backend.mapper.JdItemHistoryMapper;
import com.pricemonitor.pm_backend.service.JdItemHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "jdItemHistory")
public class JdItemHistoryServiceImpl implements JdItemHistoryService {

    @Autowired
    private JdItemHistoryMapper jdItemHistoryMapper;

    /**
     * 在jdItemHistory表中查找itemId对应的价格随着时间的变化
     * @param itemId
     * @return
     */
    @Cacheable
    @Override
    public List<JdItemHistory> findHistoryPriceByItemId(Long itemId) {
        JdItemHistoryExample jdItemHistoryExample = new JdItemHistoryExample();
        JdItemHistoryExample.Criteria criteria = jdItemHistoryExample.createCriteria();
        // String sql = "SELECT * FROM pm_jd_item_history WHERE item_id = " + itemId + " order by gmt_modified;";
        criteria.andItemIdEqualTo(itemId);
        jdItemHistoryExample.setOrderByClause("gmt_modified ASC");
        return jdItemHistoryMapper.selectByExample(jdItemHistoryExample);
    }

}