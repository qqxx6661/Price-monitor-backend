package com.pricemonitor.pm_backend.controller;


import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.pojo.JdItemHistory;
import com.pricemonitor.pm_backend.service.JdItemHistoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yzd
 */
@RestController
@RequestMapping(value="/jdItemHistory")
public class JdItemHistoryController {

    private final JdItemHistoryService jdItemHistoryService;

    @Autowired
    public JdItemHistoryController(JdItemHistoryService jdItemHistoryService) {
        this.jdItemHistoryService = jdItemHistoryService;
    }

    @ApiOperation(value="商品价格变动", notes="商品价格变动")
    @RequestMapping(value = "/findHistoryPriceByItemId", method = {RequestMethod.GET})
    public ResponseData<List<JdItemHistory>> findHistoryPriceByItemId(
            @ApiParam("商品ID") @RequestParam(value = "itemId") Long itemId){
        ResponseData<List<JdItemHistory>> responseData = new ResponseData<>();
        try {
            responseData.jsonFill(1, null, jdItemHistoryService.findHistoryPriceByItemId(itemId));
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }


}