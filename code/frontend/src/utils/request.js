import axios from 'axios'
import router from "@/router";
import { Message, Loading, Notification } from 'element-ui'
import { saveAs } from 'file-saver'
import {getToken} from "./auth";
import store from "../vuex/store";

let errorCode = {
  '401': '认证失败，无法访问系统资源',
  '403': '当前操作没有权限',
  '404': '访问资源不存在',
  'default': '系统未知错误，请反馈给管理员'
}
// axios.defaults.baseURL =
//   process.env.NODE_ENV === "development" ? "" : "http://120.79.225.116:9090";

const request = axios.create({
    baseURL: "/api",
    timeout: 5000,
})

const request2 = axios.create({
  baseURL: "/algo",
  timeout: 20000,
})

// 请求白名单，如果请求在白名单里面，将不会被拦截校验权限
const whiteUrls = ["/login", '/loginAdmin',
  '/register'
  ]

const userAuth = ["/user/pass", "/user/profile",
  '/monitor-work/recommendByUserId', '/monitor-request/click-add']

let downloadLoadingInstance;

// request 拦截器
// 可以自请求发送前对请求做一些处理
// 比如统一加token，对请求参数统一加密
request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    // 取出localStorage里面缓存的管理员信息
    // console.log(adminJson)
    const token = store.state.token
    if (!whiteUrls.includes(config.url) && token) {  // 校验请求白名单
      config.headers['Authorization'] = token;  // 设置请求头  加上token凭证
    }
    return config
}, error => {
    return Promise.reject(error)
});

// 验证是否为blob格式
export function blobValidate(data) {
  return data.type !== 'application/json'
}

// response 拦截器
// 可以在接口响应后统一处理结果
request.interceptors.response.use(
    response => {
        let res = response.data;
        // 如果是返回的文件
        if (response.config.responseType === 'blob') {
            return res
        }
        // 兼容服务端返回的字符串数据
        /*if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }*/
        // 验证token
        if (res.code === '1015') {
            console.error("token过期，请重新登录")
            handle_un_auth()
            router.push("/home")
        }
        else if (res.code === "1016") { // 用户认证失败，即用户没有登录
          if (router.history.current.path !== "/home") {
            Message.error("token过期，请重新登陆！")
            handle_un_auth()
            router.push("/home")
          }
        }
        else if (res.code !== "0") {
          Notification.error(res.msg)
          return Promise.reject(new Error(res.msg))
        }
        return res;
    },
    error => {
      let { message } = error
        console.log('err' + error) // for debug
        if (message.includes("Request failed with status code 401")) {
          handle_un_auth()
        } else if (message.includes("timeout")) { // 请求响应超时
          Notification.error("请求超时，请联系系统管理员！")
        }
        return Promise.reject(error)
    }
)

const handle_un_auth = ()=>{
  store.dispatch("ClearUserInfo").then(()=>{

  })
}

const req = (method, url, params, reqBody) => {
  return request({
    method: method,
    url: url,
    headers: {
      'Content-Type': "application/x-www-form-urlencoded",
      // token: localStorage.getItem('token')
    },
    params: params,
    data: reqBody,
    traditional: true,
    // transformRequest: [
    //   function(data) {
    //     let ret = ''
    //     for (let it in data) {
    //       ret +=
    //         encodeURIComponent(it) +
    //         '=' +
    //         encodeURIComponent(data[it]) +
    //         '&'
    //     }
    //     return ret
    //   }
    // ]
  });
};


const req2 = (method, url, params, reqBody) => {
  return request2({
    method: method,
    url: url,
    headers: {
      'Content-Type': "application/x-www-form-urlencoded",
      // token: localStorage.getItem('token')
    },
    params: params,
    data: reqBody,
    traditional: true,
    // transformRequest: [
    //   function(data) {
    //     let ret = ''
    //     for (let it in data) {
    //       ret +=
    //         encodeURIComponent(it) +
    //         '=' +
    //         encodeURIComponent(data[it]) +
    //         '&'
    //     }
    //     return ret
    //   }
    // ]
  });
};


/**
 * 参数处理
 * @param {*} params  参数
 */
export function tansParams(params) {
  let result = ''
  for (const propName of Object.keys(params)) {
    const value = params[propName];
    var part = encodeURIComponent(propName) + "=";
    if (value !== null && value !== "" && typeof (value) !== "undefined") {
      if (typeof value === 'object') {
        for (const key of Object.keys(value)) {
          if (value[key] !== null && value[key] !== "" && typeof (value[key]) !== 'undefined') {
            let params = propName + '[' + key + ']';
            var subPart = encodeURIComponent(params) + "=";
            result += subPart + encodeURIComponent(value[key]) + "&";
          }
        }
      } else {
        result += part + encodeURIComponent(value) + "&";
      }
    }
  }
  return result
}

// 通用下载方法
export function download(url, params, filename, config) {
  downloadLoadingInstance = Loading.service({ text: "正在下载数据，请稍候", spinner: "el-icon-loading", background: "rgba(0, 0, 0, 0.7)", })
  return request.post(url, params, {
    transformRequest: [(params) => { return tansParams(params) }],
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    responseType: 'blob',
    ...config
  }).then(async (data) => {
    const isBlob = blobValidate(data);
    if (isBlob) {
      const blob = new Blob([data])
      saveAs(blob, filename)
    } else {
      const resText = await data.text();
      const rspObj = JSON.parse(resText);
      const errMsg = errorCode[rspObj.code] || rspObj.msg || errorCode['default']
      Message.error(errMsg);
    }
    downloadLoadingInstance.close();
  }).catch((r) => {
    console.error(r)
    Message.error('下载文件出现错误，请联系管理员！')
    downloadLoadingInstance.close();
  })
}

export {
  request,
  req,
  req2,
  request2
}

