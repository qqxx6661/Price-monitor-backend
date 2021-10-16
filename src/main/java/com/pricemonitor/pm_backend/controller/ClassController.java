package com.pricemonitor.pm_backend.controller;

import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.pojo.Class;
import com.pricemonitor.pm_backend.service.ClassService;
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
@RequestMapping(value="/class")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    /**
     * 品类总数
     * @return
     */
    @ApiOperation(value="品类总数", notes="品类总数")
    @RequestMapping(value = "/count", method = {RequestMethod.GET})
    public ResponseData<Integer> count(){
        ResponseData<Integer> responseData = new ResponseData<>();
        responseData.jsonFill(1, null, classService.count());
        return responseData;
    }

    /**
     * 分页查询品类
     * @param startRow
     * @param pageSize
     * @return
     */
    @ApiOperation(value="分页查询品类", notes="分页查询品类")
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ResponseData<List<Class>> list(@ApiParam("起始行数") @RequestParam("startRow") int startRow,
                                          @ApiParam("每页显示数量") @RequestParam("pageSize") int pageSize){
        ResponseData<List<Class>> responseData = new ResponseData<>();
        try {
            List<Class> classList = classService.list(startRow, pageSize);
            responseData.jsonFill(1, null, classList);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

    @ApiOperation(value="根据大类查询品类", notes="根据大类查询品类")
    @RequestMapping(value = "/findByClassTopId", method = {RequestMethod.GET})
    public ResponseData<List<Class>> findByClassTopId(@ApiParam("大类编号") @RequestParam("classId") int classId){
        ResponseData<List<Class>> responseData = new ResponseData<>();
        try {
            List<Class> classList = classService.findByClassTopId(classId);
            responseData.jsonFill(1, null, classList);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }
}