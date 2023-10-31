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
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
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
export default {
  name: "VirtualExperience",
  data() {
    return {
      list_data: [
        {
          id: 1,
          name: "铜官窑制作",
          description: "",
          imgUri: "",
          likes: 10,
        },
        {
          id: 2,
          name: "铜官窑制作",
          description: "",
          imgUri: "",
          likes: 10,
        },
        {
          id: 3,
          name: "铜官窑制作",
          description: "",
          imgUri: "",
          likes: 10,
        },
        {
          id: 4,
          name: "铜官窑制作",
          description: "",
          imgUri: "",
          likes: 10,
        },
        {
          id: 5,
          name: "铜官窑制作",
          description: "",
          imgUri: "",
          likes: 10,
        },
        {
          id: 6,
          name: "铜官窑制作",
          description: "",
          imgUri: "",
          likes: 10,
        },
        {
          id: 7,
          name: "铜官窑制作",
          description: "",
          imgUri: "",
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
