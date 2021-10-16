package com.pricemonitor.pm_backend.schedule;

import com.alibaba.fastjson.JSONObject;
import com.pricemonitor.pm_backend.bean.pojo.MonitorItem;
import com.pricemonitor.pm_backend.service.MonitorItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangzhendong01
 */
@Component
public class JdMonitorSchedule {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdMonitorSchedule.class);

    @Autowired
    private MonitorItemService monitorItemService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 每天22点将创建时间在三个月以外的数据is_alert置为0
     */
    @Scheduled(cron="0 0 22 * * ?")
//    @Scheduled(fixedRate = 999999)
    public void updateJdMonitorItemStatusSchedule(){
        try {
            LOGGER.info("Task: updateJdMonitorItemStatusSchedule started!");
            int crawlItemList = monitorItemService.updateIsAlertByGmtCreate(90);
            LOGGER.info("更新了 [{}] 个监控条目的状态", crawlItemList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.info("Task: updateJdMonitorItemStatusSchedule finished!");
    }

    /**
     * 每60分钟向爬虫消费者推送待爬数据
     */
    @Scheduled(fixedDelay= 60 * 60 * 1000)
    public void pushJdMonitorItemSchedule(){
        LOGGER.info("Task: pushJdMonitorItemSchedule started!");
        try {
            List<MonitorItem> crawlItemList = monitorItemService.getByIsAlert();
            LOGGER.info("需要发送爬取任务条目数： [{}]", crawlItemList.size());
            for (MonitorItem crawlItem: crawlItemList) {
                JSONObject jdItem = new JSONObject();
                jdItem.put("id", crawlItem.getId());
                jdItem.put("item_id", crawlItem.getItemId());
                rabbitTemplate.convertAndSend("jd_crawl", jdItem.toJSONString());
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.info("Task: pushJdMonitorItemSchedule finished!");
    }
}
