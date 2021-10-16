package com.pricemonitor.pm_backend.controller;

import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.pojo.Constant;
import com.pricemonitor.pm_backend.service.ConstantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yzd
 */
@RestController
@RequestMapping(value="/constant")
public class ConstantController {

    private final ConstantService constantService;

    @Autowired
    public ConstantController(ConstantService constantService) {
        this.constantService = constantService;
    }

    @ApiOperation(value="查询提示信息", notes="查询提示信息")
    @RequestMapping(value = "/alertMessage", method = {RequestMethod.GET})
    public ResponseData<List<Constant>> alertMessage(){
        ResponseData<List<Constant>> responseData = new ResponseData<>();
        try {
            List<Constant> constantList = constantService.alertMessage();
            responseData.jsonFill(1, null, constantList);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    @ApiOperation(value="查询补充备注信息", notes="查询补充备注信息")
    @RequestMapping(value = "/noteMessage", method = {RequestMethod.GET})
    public ResponseData<List<Constant>> noteMessage(){
        ResponseData<List<Constant>> responseData = new ResponseData<>();
        try {
            List<Constant> noteMessage = constantService.noteMessage();
            responseData.jsonFill(1, null, noteMessage);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    @ApiOperation(value="查询banner", notes="查询banner")
    @RequestMapping(value = "/banner", method = {RequestMethod.GET})
    public ResponseData<List<Constant>> banner(){
        ResponseData<List<Constant>> responseData = new ResponseData<>();
        try {
            List<Constant> banner = constantService.banner();
            responseData.jsonFill(1, null, banner);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }
}