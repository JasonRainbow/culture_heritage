import {req} from "@/utils/request";

export const getAllHeritageByPage = (params)=>{
    return req("get", "/getAllHeritageByPage", params)
}

export const searchHeritage = (params,reqBody)=>{
    return req("post", "/searchHeritage", params,reqBody)
}

// 查询非物质文化遗产的分布
export const searchHeritageDistribute = ()=>{
    return req("get", "/searchDistribute")
}

// 分页查询所有的热点非物质文化遗产
export const searchHotHeritagesByPage = (params)=>{
    return req("get", "/searchHotHeritage", params)
}
