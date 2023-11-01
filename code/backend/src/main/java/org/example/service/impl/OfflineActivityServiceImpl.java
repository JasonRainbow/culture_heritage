package org.example.service.impl;

import org.example.mapper.OfflineActivityMapper;
import org.example.service.OfflineActivityService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfflineActivityServiceImpl implements OfflineActivityService {

    @Autowired
    OfflineActivityMapper offlineActivityMapper;

    @Override
    public Result getAllOfflineActivity() {

        return null;
    }
}
