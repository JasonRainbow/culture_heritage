<template>
  <div>
    <el-carousel :interval="2000" type="card" height="300px" indicator-position="outside">
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
          path: require('../../assets/img/banner_img1.jpg')
        },
        {
          id: 2,
          path: require('../../assets/img/banner_img2.jpg')
        },
        {
          id: 3,
          path: require('../../assets/img/banner_img3.jpg')
        },{
          id: 4,
          path: require('../../assets/img/banner_img4.jpg')
        },{
          id: 5,
          path: require('../../assets/img/banner_img5.jpg')
        },
        {
          id: 6,
          path: require('../../assets/img/banner_img6.jpg')
        },
      ]
    }
  }
}
</script>

<style scoped>

.banner_img {
  height: 300px;
  width: 100%;
  border-radius: 30px;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
