package org.example.controller;

import org.example.service.OfflineActivityService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfflineActivityController {

    @Autowired
    OfflineActivityService offlineActivityService;

    @GetMapping("/getAllOfflineActivity")
    public Result getAllOfflineActivity(){

        return offlineActivityService.getAllOfflineActivity();
    }
}
