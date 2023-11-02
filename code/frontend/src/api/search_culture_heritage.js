import {req} from "@/utils/request";

export const getAllHeritageByPage = (params)=>{
    return req("get", "/getAllHeritageByPage", params)
}

export const searchHeritage = (params,reqBody)=>{
    return req("post", "/searchHeritage", params,reqBody)
}