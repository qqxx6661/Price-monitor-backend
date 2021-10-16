package com.pricemonitor.pm_backend.controller;

import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.pojo.MonitorClass;
import com.pricemonitor.pm_backend.service.MonitorClassService;
import com.pricemonitor.pm_backend.util.JwtUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yzd
 */
@RestController
@RequestMapping(value="/monitorClass")
public class MonitorClassController {

    private final MonitorClassService monitorClassService;

    @Autowired
    public MonitorClassController(MonitorClassService monitorClassService) {
        this.monitorClassService = monitorClassService;
    }


    /**
     * 添加品类监控
     * @param monitorClass
     * @param request
     * @return
     */
    @ApiOperation(value="添加品类监控", notes="添加品类监控")
    @RequestMapping(value = "/addClassByClassId", method = {RequestMethod.POST})
    public ResponseData<String> addClassByClassId(@RequestBody MonitorClass monitorClass,
                                                  HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<String> responseData = new ResponseData<>();
        if (monitorClassService.checkByUserIdAndClassId(monitorClass.getClassId(), userId)) {
            responseData.jsonFill(2, "该用户已经订阅该类别", null);
        } else {
            try {
                monitorClassService.insert(monitorClass.getClassId(), monitorClass.getExpectedDiscount(), userId);
                responseData.jsonFill(1, null, null);
            } catch (Exception e) {
                e.printStackTrace();
                responseData.jsonFill(2, e.getMessage(), null);
            }
        }
        return responseData;
    }

    /**
     * 删除品类监控
     * @param id
     * @param request
     * @return
     */
    @ApiOperation(value="删除品类监控", notes="删除品类监控")
    @RequestMapping(value = "/deleteClassByClassId", method = {RequestMethod.GET})
    public ResponseData<String> deleteClassByClassId(@ApiParam("数据库自增id") @RequestParam("id") int id,
                                                     HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<String> responseData = new ResponseData<>();
        try {
            if (monitorClassService.delete(id, userId)) {
                responseData.jsonFill(1, null, null);
            } else {
                responseData.jsonFill(2, "未找到该订阅，删除失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    /**
     * 用户品类监控总数
     * @param request
     * @return
     */
    @ApiOperation(value="用户品类监控总数", notes="用户品类监控总数")
    @RequestMapping(value = "/count", method = {RequestMethod.GET})
    public ResponseData<Integer> count(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<Integer> responseData = new ResponseData<>();
        responseData.jsonFill(1, null, monitorClassService.count(userId));
        return responseData;
    }

    /**
     * 分页查询品类监控
     * @param startRow
     * @param pageSize
     * @param request
     * @return
     */
    @ApiOperation(value="分页查询品类监控", notes="分页查询品类监控")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ResponseData<List<MonitorClass>> list(@ApiParam("起始行数") @RequestParam("startRow") int startRow,
                                                 @ApiParam("每页显示数量") @RequestParam("pageSize") int pageSize,
                                                 HttpServletRequest request){
        String token = request.getHeader("Authorization");
        int userId = JwtUtil.getUserId(token);
        ResponseData<List<MonitorClass>> responseData = new ResponseData<>();
        try {
            List<MonitorClass> monitorClassList = monitorClassService.list(startRow, pageSize, userId);
            responseData.jsonFill(1, null, monitorClassList);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

}