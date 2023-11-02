// 导入组件
import Vue from 'vue';
import Router from 'vue-router';
import store from '@/vuex/store'

import PersonPage from '../views/user/profile/index';
import HomePage from "@/views/user/HomePage";
import UserRegister from "@/views/user/UserRegister";
import UserLogin from "@/views/user/UserLogin";
import UserIndex from "../views/index"
import OffLineActivity from "@/views/user/OffLineActivity";
import ActivityApply from "@/views/user/ActivityApply";
import VirtualExperience from "@/views/user/VirtualExperience";
import Forum from "@/views/user/Forum.vue";
import DisplayModel from "@/views/user/DisplayModel";
import NotLogin from "@/views/user/NotLogin"

// 启用路由
Vue.use(Router);

// 导出路由
const router = new Router({
  mode: 'hash',
  routes: [
      {
      path: '/login',
      name: '用户登录',
      component: UserLogin,
      hidden: true,
      meta: {
        title: '用户登录',
        requireAuth: false
      }
    }, {
      path: '/register',
      name: '用户注册',
      component: UserRegister,
      hidden: true,
      meta: {
        title: '用户注册',
        requireAuth: false
      }
    },
    {
      path: '/big-screen',
      name: '模型大屏展示',
      component: DisplayModel,
      props: {

      },
      meta: {
        title: '模型大屏展示',
        requireAuth: false
      }
    },
    {
      path: '/apply',
      name: '活动宣传申请',
      component: ActivityApply,
      hidden: true,
    },
    {
      path: "/",
      name: "客户端", // 客户端网页的首页
      component: UserIndex,
      meta: {
        requireAuth: false
      },
      redirect: "/home",
      children: [ // 子路由
        {
          path: "/home",
          name: "客户端首页",
          component: HomePage,
          meta: {
            requireAuth: false
          }
        },
        {
          path: "/experience",
          name: "虚拟体验",
          component: VirtualExperience,
          meta: {
            requireAuth: false
          }
        },
        {
          path: "/offlineActivity",
          name: "线下活动",
          component: OffLineActivity,
          meta: {
            requireAuth: false
          },
        },
        {
          path: "/personal",
          name: "用户个人中心",
          component: PersonPage,
          meta: {
            requireAuth: false
          }
        },
        {
          path: "/forum",
          name: "论坛",
          component: Forum,
          meta: {
            requireAuth: false
          }
        },
        {
          path: "/not-login",
          name: "未登录", // 未登录时个人中心展示页面
          component: NotLogin,
          meta: {
            requireAuth: false
          }
        }
      ]
    }
  ]
})

// 对路由进行权限控制
// 全局路由拦截器  前置路由守卫
router.beforeEach((to, from, next) => {
  /*if (to.matched.length !== 0) {
    next()
  } else {
    next({
      path: "/home",
      query: {redirect: to.fullPath}
    })
  }*/
  const user = store.state.user
  if(to.path !== '/personal'){
    if (to.path === "/not-login" && user) {
      next("/personal")
    } else {
      next()
    }
  }else{
    if(user === ''){  // 用户未登录
      next('/not-login')
    }else{
      next()
    }
  }
})

// 全局后置路由守卫——初始化的时候被调用、每次路由切换后被调用
router.afterEach((to) => {
  document.title = to.name
})

export default router
