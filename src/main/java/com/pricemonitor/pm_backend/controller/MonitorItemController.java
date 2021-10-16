package com.pricemonitor.pm_backend.controller;

import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.action.request.MonitorItemRequest;
import com.pricemonitor.pm_backend.bean.pojo.MonitorItem;
import com.pricemonitor.pm_backend.service.MonitorItemService;
import com.pricemonitor.pm_backend.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yzd
 */
@RestController
@RequestMapping(value="/monitorItem")
public class MonitorItemController {

    @Autowired
    private MonitorItemService monitorItemService;


    /**
     * 添加单个商品监控
     * @param monitorItemRequest
     * @param request
     * @return
     */
    @ApiOperation(value="添加单个商品监控", notes="添加单个商品监控")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public ResponseData<String> insert(@RequestBody MonitorItemRequest monitorItemRequest,
                                       HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<String> responseData = new ResponseData<>();
        if (monitorItemService.findByUserIdAndItemId(monitorItemRequest.getItemId(), userId).size() == 1) {
            responseData.jsonFill(2, "该用户已经监控该商品", null);
        } else {
            try {
                monitorItemService.insert(monitorItemRequest.getItemId(), monitorItemRequest.getUserPrice(),
                        monitorItemRequest.getAlert(), userId);
                responseData.jsonFill(1, null, null);
            } catch (Exception e) {
                e.printStackTrace();
                responseData.jsonFill(2, e.getMessage(), null);
            }
        }
        return responseData;
    }

    /**
     * 删除单个商品监控
     * @param id
     * @param request
     * @return
     */
    @ApiOperation(value="删除单个商品监控", notes="删除单个商品监控")
    @RequestMapping(value = "/deleteItemById", method = {RequestMethod.GET})
    public ResponseData<String> deleteItemById(@ApiParam("数据库自增id") @RequestParam("id") int id,
                                               HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<String> responseData = new ResponseData<>();
        try {
            monitorItemService.delete(id, userId);
            responseData.jsonFill(1, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    /**
     * 更新单个商品监控
     * @param monitorItemRequest
     * @param request
     * @return
     */
    @ApiOperation(value="更新单个商品监控", notes="更新单个商品监控")
    @RequestMapping(value = "/updateItemById", method = {RequestMethod.POST})
    public ResponseData<String> updateItemById(@RequestBody MonitorItemRequest monitorItemRequest,
                                               HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<String> responseData = new ResponseData<>();
        try {
            monitorItemService.update(monitorItemRequest.getId(), monitorItemRequest.getItemId(),
                    monitorItemRequest.getUserPrice(), monitorItemRequest.getAlert(), userId);
            responseData.jsonFill(1, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    /**
     * 用户商品监控总数
     * @param request
     * @return
     */
    @ApiOperation(value="用户商品监控总数", notes="用户商品监控总数")
    @RequestMapping(value = "/count", method = {RequestMethod.GET})
    public ResponseData<Integer> count(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<Integer> responseData = new ResponseData<>();
        responseData.jsonFill(1, null, monitorItemService.count(userId));
        return responseData;
    }

    /**
     * 分页查询用户商品监控列表
     * @param startRow
     * @param pageSize
     * @param request
     * @return
     */
    @ApiOperation(value="分页查询用户商品监控列表", notes="分页查询用户商品监控列表")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ResponseData<List<MonitorItem>> list(@ApiParam("起始行数") @RequestParam("startRow") int startRow,
                                                @ApiParam("每页显示数量") @RequestParam("pageSize") int pageSize,
                                                HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<List<MonitorItem>> responseData = new ResponseData<>();
        try {
            List<MonitorItem> monitorClassList = monitorItemService.list(startRow, pageSize, userId);
            responseData.jsonFill(1, null, monitorClassList);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }



}
