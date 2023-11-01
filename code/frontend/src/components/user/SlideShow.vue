<template>
  <div>
    <el-carousel :interval="6000" height="500px" indicator-position="outside">
      <el-carousel-item v-for="item in show_images" :key="item.id" align="center">
        <img :src="item.path" class="banner_img"/>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "SlideShow",
  data() {
    return {
      show_images: [
        {
          id: 1,
          path: require('../../assets/img/banner1.png')
        },
        {
          id: 2,
          path: require('../../assets/img/banner2.png')
        },
        {
          id: 3,
          path: require('../../assets/img/banner3.png')
        },{
          id: 4,
          path: require('../../assets/img/banner4.gif')
        },
      ]
    }
  }
}
</script>

<style scoped>
.banner_img {
  width: 100%;
  height: 500px;
  border-radius: 20px;
}

</style>
