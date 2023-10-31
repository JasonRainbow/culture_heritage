<template>
  <vuescroll>
    <el-container class="user-index">
      <el-header class="no-padding" style="height: 150px">
        <HeaderBar2></HeaderBar2>
      </el-header>
      <el-main>
        <keep-alive :include="['EffectPage']">
          <router-view></router-view>
        </keep-alive>
      </el-main>
      <el-footer class="no-padding" style="margin-top: 20px"><MyFooter></MyFooter></el-footer>
    </el-container>
  </vuescroll>
</template>

<script>
export default {
  name: "UserIndex"
}
</script>

<style scoped>

</style>
