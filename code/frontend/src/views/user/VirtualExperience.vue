<template>
  <div style="margin: 0 50px">
    <el-row :gutter="20">
      <el-col :span="6" :xs="24" align="center" style="margin-top: 20px" v-for="item in list_data" :key="item.id">
        <el-card :body-style="{ padding: '0px' }">
          <div class="bottom clearfix">
            <span style="float: left; margin-left: 20px; margin-top: 10px">{{item.name}}</span>
            <el-button style="float: right; margin-right: 20px; margin-top: 10px"
                       size="small" type="primary" class="button" @click="handleClick(item.id)">体验</el-button>
          </div>
<!--          <div class="sketchfab-embed-wrapper">
            <iframe title="铜官窑茶杯" frameborder="0"
                    allowfullscreen mozallowfullscreen="true"
                    webkitallowfullscreen="true" allow="autoplay; fullscreen; xr-spatial-tracking"
                    xr-spatial-tracking
                     web-share
                    :src="item.imgUri">
            </iframe>
          </div>-->
          <model-viewer :src="item.modelUri" alt="VR Headset" auto-rotate auto-rotate-delay="1500" camera-controls ar ios-src="assets/scene.gltf"></model-viewer>

          <div style="padding: 14px;">
            <span class="my-icon">
              <i class="el-icon-thumb"></i>{{item.likes}}
            </span>
            <i class="el-icon-chat-round my-icon"></i>
            <i class="el-icon-more-outline"></i>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import {ModelViewer} from "@google/model-viewer"
export default {
  name: "VirtualExperience",
  components: {
    ModelViewer
  },
  data() {
    return {
      list_data: [
        {
          id: 1,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model1/scene.gltf",
          likes: 10,
        },
        {
          id: 2,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model2/scene.gltf",
          likes: 10,
        },
        {
          id: 3,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model3/scene.gltf",
          likes: 10,
        },
        {
          id: 4,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model4/scene.gltf",
          likes: 10,
        },
        {
          id: 5,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model5/scene.gltf",
          likes: 10,
        },
        {
          id: 6,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model6/scene.gltf",
          likes: 10,
        },
        {
          id: 7,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model7/scene.gltf",
          likes: 10,
        },
        {
          id: 8,
          name: "铜官窑制作",
          description: "",
          modelUri: "assets/model8/scene.gltf",
          likes: 10,
        },
      ]
    }
  },
  methods: {
    handleClick(id) {
      console.log(id)
    }
  }
}
</script>

<style scoped>
.bottom {
  margin-bottom: 10px;
}

.image {
  width: 100%;
  height: 250px;
}

.my-icon {
  margin-right: 80px;
}
</style>
