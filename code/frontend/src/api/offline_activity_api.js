import {req} from "@/utils/request";

export const getAllOfflineActivityByPage = (params)=>{
    return req("get", "/getAllOfflineActivityByPage", params)
}

export const applyActivity = (data)=>{
    return req("post", "/activityPromotionApply", null, data)
}