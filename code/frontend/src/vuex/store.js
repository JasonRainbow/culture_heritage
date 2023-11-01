import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);
// 登录验证
export default new Vuex.Store({
  state: {
    user: "",
    token: "" // 从cookie中获取token
  },
  mutations: {
  },
  actions: {
  },
})
