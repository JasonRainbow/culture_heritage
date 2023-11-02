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
          path: "http://whyimg.wentiyun.cn/feiyi/20230628/de78e8ef-a5b5-43b0-8a89-d31bfbd1b11f.png"
        },
        {
         id: 2,
         path: "http://whyimg.wentiyun.cn/feiyi/20220527/3b5f64a1-1511-41e5-97dd-b95f933e7ae0.png"
        },
        {
          id: 3,
          path: require('../../assets/img/banner2.png')
        },
        {
          id: 4,
          path: require('../../assets/img/banner3.png')
        },{
          id: 5,
          path: require('../../assets/img/banner4.gif')
        },
        {
          id: 6,
          path: require('../../assets/img/banner1.png')
        }
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
