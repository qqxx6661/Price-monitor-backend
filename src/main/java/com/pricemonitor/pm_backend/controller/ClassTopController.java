package com.pricemonitor.pm_backend.controller;

import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.pojo.ClassTop;
import com.pricemonitor.pm_backend.service.ClassTopService;
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
@RequestMapping(value="/classTop")
public class ClassTopController {

    private final ClassTopService classTopService;

    @Autowired
    public ClassTopController(ClassTopService classTopService) {
        this.classTopService = classTopService;
    }

    @ApiOperation(value="查询大类", notes="查询大类")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ResponseData<List<ClassTop>> list(){
        ResponseData<List<ClassTop>> responseData = new ResponseData<>();
        try {
            List<ClassTop> classList = classTopService.list();
            responseData.jsonFill(1, null, classList);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }
}