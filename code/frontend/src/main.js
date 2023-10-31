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

// 引入路由
import router from './router';
// 引入状态管理
import store from './vuex/store';

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
