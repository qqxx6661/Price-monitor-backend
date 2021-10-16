package com.pricemonitor.pm_backend.controller;


import com.pricemonitor.pm_backend.bean.action.ResponseData;
import com.pricemonitor.pm_backend.bean.pojo.JdItem;
import com.pricemonitor.pm_backend.service.JdItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * @author yzd
 */
@RestController
@RequestMapping(value="/jdItem")
public class JdItemController {

    @Autowired
    private JdItemService jdItemService;

    /**
     * 京东商品总数
     * @return
     */
    @ApiOperation(value="京东商品总数", notes="京东商品总数")
    @RequestMapping(value = "/count", method = {RequestMethod.GET})
    public ResponseData<Integer> count(
            @ApiParam("大类编号") @RequestParam(value = "classTopId", required = false) Integer classTopId,
            @ApiParam("排序方式") @RequestParam(value = "sort", required = false) String sort){
        ResponseData<Integer> responseData = new ResponseData<>();
        try {
            responseData.jsonFill(1, null, jdItemService.count(classTopId, sort));
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
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
    public ResponseData<List<JdItem>> list(@ApiParam("起始行数") @RequestParam("startRow") int startRow,
                                           @ApiParam("每页显示数量") @RequestParam("pageSize") int pageSize,
                                           @ApiParam("大类编号") @RequestParam(value = "classTopId", required = false) Integer classTopId,
                                           @ApiParam("排序方式") @RequestParam(value = "sort", required = false) String sort,
                                           HttpServletRequest request){
        ResponseData<List<JdItem>> responseData = new ResponseData<>();
        try {
            if(startRow > 50 || pageSize > 50) {
                // 大于100条的数据，需要登录权限后可查看
                Principal user = request.getUserPrincipal();
                if (user == null) {
                    responseData.jsonFill(2, "请登录后查看更多数据", null);
                    return responseData;
                }
            }
            if(startRow > 100 || pageSize > 100) {
                // 不展示
                responseData.jsonFill(2, "如需查看更多数据，请联系站长处理。", null);
                return responseData;
            }
            List<JdItem> classList = jdItemService.list(startRow, pageSize, classTopId, sort);
            responseData.jsonFill(1, null, classList);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }

}