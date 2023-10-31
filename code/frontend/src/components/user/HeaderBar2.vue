<template>
  <div>
    <div id="header-title">
      中国语言文化作品国际传播效果分析系统
    </div>
    <div id="show-login-div">
      <div id="user-info" v-if="loginFlag"> <!--显示登录用户-->
        <el-avatar :size="45" icon="el-icon-user-solid" :src="avatar" id="inner-user-avatar"></el-avatar>
        <div id="inner-user-nick">{{ nickname }}</div>
      </div>
      <div v-else>  <!--未登录可前往登录-->
        <router-link to="/login" style="color: #6dcdcd; font-weight: bold">前往登录>></router-link>
      </div>
    </div>
    <div id="nav-tab" ref="navtab">
      <div class="nav-tab-item active" v-for="(item,index) in items"
           :key="index"
           @click="switchMenu(index)"
           :style="{'width': `${activeIndex === index ? itemWidth + 10: itemWidth}%`}">
        <router-link :to="item.path" style="text-align: center; width: 100%;height: 100%;padding-top: 12px">
          <i :class='item.icon'></i>
          <p class="nav-tab-item_label" style="margin-top: 4px">{{item.label}}</p>
        </router-link>
      </div>
      <div class="nav-tab-overlay" :style="{'left':`${activeIndex * itemWidth}%`,'width':`${itemWidth + 10}%`}"></div>
    </div>
  </div>
</template>

<script>
import {hasLogin} from "../../utils/auth";

export default {
  name: "HeaderBar2",
  props: {
    /*activeIndex: {
      type: Number,
      require: true
    },
    loginFlag: {
      type: Boolean,
      require: true
    }*/
  },
  data() {
    return {
      items: [
        { icon: 'nav-tab-item_icon iconfont icon-home', label: '首页', path: '/home'},
        { icon: 'nav-tab-item_icon iconfont icon-send-fill', label: '传播效果评估', path: '/effect'},
        { icon: 'nav-tab-item_icon iconfont icon-shujuxianshi', label: '大屏模式', path: '/big-screen'},
        { icon: 'nav-tab-item_icon iconfont icon-zhinengtuijian', label: '作品推荐', path: '/recommend'},
        { icon: 'nav-tab-item_icon iconfont icon-project_info', label: '背景介绍', path: '/background'},
        { icon: 'nav-tab-item_icon iconfont icon-rencaishuangxuanhui', label: '团队介绍', path: '/team'},
        { icon: 'nav-tab-item_icon iconfont icon-a-commandinquiry-fill', label: '常见问题', path: '/question'},
        { icon: 'nav-tab-item_icon iconfont icon-user', label: '个人中心', path: '/personal'},
      ],
      // activeIndex: Number(sessionStorage.getItem("activeIndex")),
      routes_map: {
        "/home": 0,
        "/effect": 1,
        "/recommend": 3,
        "/background": 4,
        "/team": 5,
        "/question": 6,
        "/personal": 7,
        "/not-login": 7,
        "/sentiment-assessment":1
      },
      activeIndex: 0,
      loginFlag: true,
    }
  },
  methods: {
    switchMenu(index) {
      this.activeIndex = index
      // sessionStorage.setItem("activeIndex", index)
    },
    judgeLogin(){ //判断用户是否登录
      this.loginFlag = hasLogin()
    },
  },
  computed: {
    itemWidth() {
      return 90 / this.items.length;
    },
    avatar() {
      return this.$store.getters.avatar
    },
    nickname() {
      return this.$store.getters.nickname
    }
  },
  created() {
    this.judgeLogin()
    this.activeIndex = this.routes_map[this.$route.path]
  },
  mounted() {
    // alert(this.$store.state.user)
    // alert("hello")
    /*let menuId = sessionStorage.getItem("activeIndex")
    alert(menuId)
    if (!menuId) menuId = 0
    if (menuId) {
      this.activeIndex = Number(menuId)
    }*/
  },
  watch: {
    // 监听路由的变化
    $route(to, from) {
      // console.log("路由变化了")
      // console.log("当前页面路由：", to);
      // console.log("上一个路由:", from)
      this.judgeLogin()
      this.activeIndex = this.routes_map[to.path]
    }
  }
}
</script>

<style scoped>
/* 配色方案:
背景:7dbfff,
图标&标签:4298e7,
遮罩:e4f2ff */
* {
  margin: 0;
  padding: 0;
}

body {
  height: 100vh;
  background-color: #7dbfff;

  /* 居中 */
  display: flex;
  justify-content: center;
  align-items: center;
}

#nav-tab {
  position: relative;

  width: 100%;
  height: 80px;
  background-color: #195161;
  display: flex;

  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;

  overflow: hidden;

}

.nav-tab-item {
  height: 100%;

  z-index: 2;
  transition: 0.3s;
  cursor: pointer;

  /* 居中 */
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.nav-tab-item.active {
  width: 210px;
}

.nav-tab-item:hover {
  background-color: #2b729c;
  border-radius: 20px;
}

.nav-tab-item_icon {
  font-size: 26px;
  color: #ffffff;
  transition: 0.3s;
  transform: translate(0, 0px);
}

.active .nav-tab-item_icon {
  transform: translate(0, -10px);
}

.nav-tab-item_label {
  font-size: 18px;
  color: #ffffff;
  opacity: 0;
  transition: 0.3s;
  user-select: none;
}

.active .nav-tab-item_label {
  opacity: 1;
}

.nav-tab-overlay {
  position: absolute;
  left: 0;
  top: 0;

  height: 100%;
  width: 210px;

  background-color: #2b729c;
  border-radius: 20px;

  transition: 0.3s;
}

#header-title {
  height: 80px;
  background-color: #195161;
  color: white;
  font-size: 30px;
  text-align: center;
  padding-top: 20px;
  font-family: Arial, sans-serif;
  text-shadow: 1px 1px white;
}

#show-login-div{
  height: 100px;
  width:  220px;
  background-color: #195161;
  position: absolute;
  top: 25px;
  right: 40px;
}
/*#inner-user-avatar{
  height: 50px;
  width:  50px;
  float: left;
}*/
#inner-user-nick{
  height: 20px;
  width: 155px;
  font-family: 华光中圆_CNKI;
  margin-top: 15px;
  margin-left: 10px;
  font-size: 18px;
  color: #E6A23C;
  float: right;
}

</style>
