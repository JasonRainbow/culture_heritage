<!--首页展示-->
<template>
  <vuescroll>
    <el-container class="user-index">
      <el-header class="no-padding" style="height: 150px">
        <HeaderBar2></HeaderBar2>
      </el-header>
      <el-main>
        <keep-alive :include="['']">
          <router-view></router-view>
        </keep-alive>
      </el-main>
      <el-footer class="no-padding" style="margin-top: 20px"><MyFooter></MyFooter></el-footer>
    </el-container>
  </vuescroll>
</template>

<script>
import HeaderBar2 from "@/components/user/HeaderBar2";
import MyFooter from "@/components/user/MyFooter";
import vuescroll from "vuescroll";



export default {
  name: "UserIndex",
  components: {
    HeaderBar2,
    MyFooter,
    vuescroll
  }
}
</script>

<style scoped>
.user-index,el-main{
  background-color: #ecf5ff;
}

</style>

