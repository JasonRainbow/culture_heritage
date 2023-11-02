<template>
  <div class="app-container">
    <el-row :gutter="40">
      <el-col :span="8" :xs="24">
        <el-card class="box-card animate__animated animate__slideInLeft">
          <div slot="header" class="clearfix">
            <span>基本信息</span>
          </div>
          <div>
            <div class="text-center">
              <userAvatar />
            </div>
            <ul class="list-group list-group-striped">
              <li class="list-group-item">
                <i class="el-icon-user"></i>用户名
                <div class="pull-right">{{ user.username }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-postcard"></i>用户昵称
                <div class="pull-right">{{ user.name }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-mobile"></i>手机号码
                <div class="pull-right">{{ user.phone }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-message"></i>用户邮箱
                <div class="pull-right">{{ user.email }}</div>
              </li>
              <li class="list-group-item">
                <i class="el-icon-office-building"></i>工作单位
                <div class="pull-right">{{ user.workUnit }}</div>
              </li>
            </ul>
          </div>
        </el-card>
      </el-col>
      <el-col :span="16" :xs="24">
        <el-card class="box-card animate__animated animate__slideInRight">
          <div slot="header" class="clearfix">
            <span>个人信息</span>
            <el-button style="float: right" type="danger" size="mini" @click="logout">退出登录</el-button>
          </div>
          <el-tabs v-model="activeTab" type="border-card" id="info-tab">
            <el-tab-pane label="基本资料" name="userinfo">
              <userInfo :user="user" />
            </el-tab-pane>
            <el-tab-pane label="修改密码" name="resetPwd">
              <resetPwd :userName="user.username"/>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import userAvatar from "./userAvatar";
import userInfo from "./userInfo";
import resetPwd from "./resetPwd";
import { parseLocalStorageItem,removeLocalStorageUser } from "@/utils/storage";
import 'animate.css'

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Profile",
  components: {
    userAvatar,
    userInfo,
    resetPwd,
  },
  data() {
    return {
      user: {},
      roleGroup: "用户",
      postGroup: "",
      activeTab: "userinfo"
    };
  },
  created() {
    this.getUser();
  },
  mounted() {

  },
  methods: {
    //获取用户个人信息
    getUser() {
      this.user = parseLocalStorageItem("user")
      console.log(this.user)
    },
    logout() {
      this.$confirm('退出登录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          this.$message({
            type: 'success',
            message: '已退出登录!'
          })
          removeLocalStorageUser("user")
          this.$store.commit("SET_USER","") // 更新仓库用户信息
          this.$router.push("/home")
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          })
        })
    }
  }
};
</script>

<style scoped lang="scss">
.box-card {
  background-color: #dde5f3;
}

.app-container {
  overflow: hidden;
}

#info-tab {
  //background-color: #f1f1f5;
}
</style>
