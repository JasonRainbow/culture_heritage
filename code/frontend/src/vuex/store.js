import Vue from 'vue';
import Vuex from 'vuex';
import {uploadUserAvatar, user_login} from '@/api/user_api'
import {parseLocalStorageItem, setLocalStorageItem} from "@/utils/storage";
import {Message} from "element-ui";
Vue.use(Vuex);
// 登录验证
export default new Vuex.Store({
  state: {
    user: parseLocalStorageItem("user"),
    token: "", // 从cookie中获取token
    modelUri: "assets/model1/scene.gltf"
  },
  mutations: {
    SET_USER(state, user) { // 保存用户信息
      state.user = user
    },
    SET_MODEL_URI(state, uri) {
      state.modelUri = uri
    },
  },
  actions: {
    // 登录系统
    Login({commit}, {userInfo}) {
      const username = userInfo.username.trim()
      const password = userInfo.password
      return new Promise((resolve,reject)=>{
        user_login({username,password}).then((res)=> {
          console.log("登录返回数据："+res)
          setLocalStorageItem("user",res.data)
          commit('SET_USER', res.data)
          resolve()
        }).catch((err)=>{
          // reject(err)
        })
      })
    },
    uploadAvatar({commit, state}, formData) {
      return new Promise((resolve, reject)=>{
        uploadUserAvatar(formData).then(res => { // 上传用户头像并保存
          console.log(res)
          if (res.code === "0") {
            let store_user = state.user
            store_user.avatar = res.data.avatar
            setLocalStorageItem("user", store_user)
            commit("SET_USER", store_user)
            Message.success("修改头像成功");
          } else {
            console.log(res.msg)
          }
          resolve(res)
        }).catch((err)=>{
          reject(err)
        });
      })
    }
  },
  getters: {
    // 获取用户头像
    avatar: state=>{
      if (state.user) {
        if (state.user.avatar) { // 判断用户是否设置了自己的头像
          return state.user.avatar
        } else { // 没有头像用户使用默认头像
          return require("../../public/assets/img/avatar.jpeg")
        }
      } else {
        return ""
      }
    },
    // 获取用户的昵称
    nickname: state=>{
      return state.user.name ? state.user.name : "未知姓名"
    }
  }
})
