import {req} from "@/utils/request";

export const getAllOfflineActivityByPage = (params)=>{
    return req("get", "/getAllOfflineActivityByPage", params)
}