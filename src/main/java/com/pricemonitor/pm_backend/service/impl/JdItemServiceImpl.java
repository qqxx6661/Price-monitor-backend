package com.pricemonitor.pm_backend.service.impl;


import com.pricemonitor.pm_backend.bean.pojo.Class;
import com.pricemonitor.pm_backend.bean.pojo.JdItem;
import com.pricemonitor.pm_backend.bean.pojo.JdItemExample;
import com.pricemonitor.pm_backend.mapper.JdItemMapper;
import com.pricemonitor.pm_backend.service.ClassService;
import com.pricemonitor.pm_backend.service.JdItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "jdItem")
public class JdItemServiceImpl implements JdItemService {

    @Autowired
    private JdItemMapper jdItemMapper;
    @Autowired
    private ClassService classService;

    /**
     * 若无大类id，则直接查询总数
     * 若有大类id，则先查询大类所有小类id，再通过小类id统计总数
     * @param classTopId
     * @return
     */
    @Cacheable
    @Override
    public int count(Integer classTopId, String sort) {
        JdItemExample jdItemExample = new JdItemExample();
        JdItemExample.Criteria criteria = jdItemExample.createCriteria();
        if(classTopId!=null){
            List<Long> categoryIdList = ConvertClassCategoryToCategoryId(classTopId);
            criteria.andCategoryIdIn(categoryIdList);
        }
        if(sort!=null) {
            if (sort.equals("price_asc") || sort.equals("price_desc")) {
                criteria.andPriceNotEqualTo("暂无报价");
            }
            if (sort.equals("discount_asc") || sort.equals("discount_desc")) {
                criteria.andDiscountIsNotNull();
            }
        }
        return jdItemMapper.countByExample(jdItemExample);
    }

    @Cacheable
    @Override
    public List<JdItem> list(int startRow, int pageSize, Integer classTopId, String sort) {
        JdItemExample jdItemExample = new JdItemExample();
        jdItemExample.setPageSize(pageSize);
        jdItemExample.setStartRow(startRow);
        JdItemExample.Criteria criteria = jdItemExample.createCriteria();
        if(classTopId!=null){
            // 如有参数：大类
            List<Long> categoryIdList = ConvertClassCategoryToCategoryId(classTopId);
            criteria.andCategoryIdIn(categoryIdList);
        }
        if(sort!=null) {
            // 如有参数：排序
            if (sort.equals("price_asc")) {
                criteria.andPriceNotEqualTo("暂无报价");
                jdItemExample.setOrderByClause("price + 0 ASC");
            }
            if (sort.equals("price_desc")) {
                criteria.andPriceNotEqualTo("暂无报价");
                jdItemExample.setOrderByClause("price + 0 DESC");
            }
            if (sort.equals("discount_asc")) {
                criteria.andDiscountIsNotNull();
                jdItemExample.setOrderByClause("discount + 0 ASC");
            }
            if (sort.equals("discount_desc")) {
                criteria.andDiscountIsNotNull();
                jdItemExample.setOrderByClause("discount + 0 DESC");
            }
        }
        return jdItemMapper.selectByExample(jdItemExample);
    }

    /**
     * 将Class表中的class_category的String数组转换为JdItem表中category_id的Long数组
     * @param classTopId
     * @return
     */
    private List<Long> ConvertClassCategoryToCategoryId(Integer classTopId){
        List<Class> classList = classService.findByClassTopId(classTopId);
        List<Long> categoryIdList = new ArrayList<>();
        for(Class eachClass: classList){
            // Class表中的小类id是String(9987,653,655)，JdItem表中是Long(9987653655)
            categoryIdList.add(Long.valueOf(eachClass.getClassCategory().replaceAll(",","")));
        }
        return categoryIdList;
    }
}