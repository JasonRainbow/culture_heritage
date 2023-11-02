import {req} from "@/utils/request";

export const getAllHeritageByPage = (params)=>{
    return req("get", "/getAllHeritageByPage", params)
}

export const getAllForum = (params)=>{
    return req("get", "/getAllForum", params)
}
