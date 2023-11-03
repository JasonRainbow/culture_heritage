<template>
  <div style="margin: 0 50px">
    <el-row :gutter="20">
      <el-col :span="6" :xs="24" align="center" style="margin-top: 20px" v-for="item in list_data" :key="item.id">
        <el-card :body-style="{ padding: '0px' }">
          <div class="bottom clearfix">
            <span class="modelName">{{item.modelName}}</span>
            <el-button style="float: right; margin-right: 20px; margin-top: 10px"
                       size="small" type="primary" class="button" @click="handleClick(item.modelUri)">体验</el-button>
          </div>

          <model-viewer :src="item.modelUri" alt="VR Headset" auto-rotate auto-rotate-delay="1500" camera-controls ar ios-src="assets/scene.gltf"></model-viewer>

          <div style="padding: 14px;">
            <span class="my-icon">
              <i class="el-icon-thumb"></i>  {{item.likes}}
            </span>
            <el-popover
                class="my-icon"
                placement="bottom"
                :title="item.modelName"
                width="30"
                trigger="click"
                :content="item.description">
              <i class="el-icon-view" slot="reference"></i>
            </el-popover>

            <i class="el-icon-more-outline" style="cursor: pointer"></i>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import {ModelViewer} from "@google/model-viewer"
import {getDigitalCultureHeritageByPage} from "@/api/digital_culture_heritage_api";
export default {
  name: "VirtualExperience",
  components: {
    ModelViewer
  },
  data() {
    return {
      query_params: {
        pageNum: 1,
        pageSize: 10
      },
      list_data: [
        {
          id: 1,
          modelName: "铜官窑制作",
          description: "",
          modelUri: "assets/model1/scene.gltf",
          likes: 10,
        },

      ]
    }
  },
  methods: {
    handleClick(modelUri) {
      this.$store.commit("SET_MODEL_URI", modelUri)
      this.$router.push("/big-screen")
    },
    getData() {
      getDigitalCultureHeritageByPage(this.query_params).then((res)=>{
        if (res.code === "0") {
          this.list_data = res.data.records
        }
      })
    }
  },
  created() {
    this.getData()
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
  cursor: pointer;
}

.modelName {
  display: inline-block;
  max-width: 180px;
  max-height: 20px;
  overflow: hidden;
  float: left;
  margin-left: 20px;
  margin-top: 10px
}
</style>
