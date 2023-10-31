// 导入组件
import Vue from 'vue';
import Router from 'vue-router';
// 登录

// 管理员首页
import index from '../views/index';

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
      path: "/",
      name: "客户端", // 客户端网页的首页
      component: index,
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

      ]
    }
  ]
})

// 对路由进行权限控制
// 全局路由拦截器  前置路由守卫
router.beforeEach((to, from, next) => {
  next()
})

// 全局后置路由守卫——初始化的时候被调用、每次路由切换后被调用
router.afterEach((to) => {
  document.title = to.name
})

export default router