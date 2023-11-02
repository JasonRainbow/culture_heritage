import {req} from "@/utils/request";

export const user_login = (params)=>{
    return req("post", "/user/login", null, params)
}

export const user_register = (params)=>{
    return req("post", "/user/register", null, params)
}

export const update_user_info = (data)=>{
    return req("put", "/user/update", null, data)
}

export const modify_user_password = (data)=>{
    return req("put", "/user/rpassword", null, data)
}

// 上传用户头像并保存
export const uploadUserAvatar = (params)=>{
    return req("put", "/user/uploadAvatar", null, params)
}

