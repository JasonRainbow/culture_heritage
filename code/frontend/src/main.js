import Vue from 'vue'
import App from './App.vue'

// 引入element UI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 使用element UI
Vue.use(ElementUI);

// 引入轮播列表
import scroll from 'vue-seamless-scroll';
Vue.use(scroll)

// 引入echarts
import * as echarts from 'echarts'
Vue.prototype.$echarts = echarts

// 引入全局样式
import './assets/styles/index.scss' // global css
import './assets/styles/ruoyi.scss' // ruoyi css

// 引入自定义图标
import './assets/icons2/iconfont.css'

// 引入路由
import router from './router';
// 引入状态管理
import store from './vuex/store';

import AFRAME from "aframe"
require("./utils/myframe/ar-hit-test")
require("./utils/myframe/ar-shadows")
require("./utils/myframe/ar-shadows")
require("./utils/myframe/background-gradient")
require("./utils/myframe/info-message")
require("./utils/myframe/model-viewer")
Vue.use(AFRAME)

// 配置滚动条组件
Vue.prototype.$vuescrollConfig = {
  bar: {
    background: 'rgba(23,4,90,0.47)'
  }
}

Vue.config.productionTip = false

new Vue({
  router,
  store, //使用store vuex状态管理
  render: h => h(App),
}).$mount('#app')
