import {req} from "@/utils/request";

export const getDigitalCultureHeritageByPage = (params)=>{
    return req("get", "/digital_culture_heritage/paging_query", params)
}

