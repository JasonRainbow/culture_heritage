package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pojo.OfflineActivity;
import org.example.service.OfflineActivityService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="线下活动",description = "线下活动相关接口")
@RestController
public class OfflineActivityController {

    @Autowired
    OfflineActivityService offlineActivityService;

    @Operation(summary = "查询", description = "查询所有审批通过的线下活动")
    @GetMapping("/getAllOfflineActivity")
    public Result getAllOfflineActivity(){

        return offlineActivityService.getAllOfflineActivity();
    }

    @Operation(summary = "查询", description = "分页查询所有审批通过的线下活动")
    @GetMapping("getAllOfflineActivityByPage")
    public Result getAllOfflineActivityByPage(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNumber") Integer pageNumber){
        return offlineActivityService.getAllOfflineActivityByPage(pageSize,pageNumber);
    }
    @Operation(summary = "申请", description = "用户申请线下宣传活动")
    @PostMapping("/activityPromotionApply")
    public Result activityPromotionApply(@RequestBody OfflineActivity offlineActivity){
        return offlineActivityService.activityPromotionApply(offlineActivity);
    }
}
