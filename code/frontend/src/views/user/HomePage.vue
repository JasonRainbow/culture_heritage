<template>
  <div>
    <el-row style="display: flex; justify-content: center">
      <el-col :span="14" :xs="24" align="center">
        <slide-show></slide-show>
      </el-col>
    </el-row>
    <el-row style="display: flex; justify-content: center">
      <el-col :span="18" :xs="24" align="center">
        <el-card class="box-card grid-content" shadow="always">
          <Search></Search>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="40">
      <el-col :span="10" :xs="24" :sm="24" :lg="10">8
        <el-card class="box-card grid-content" shadow="always">
          <div class="card-title">热点文化作品</div>
<!--          <el-card v-for="item in messages" :key="item.id"
                   class="box-card2 animate__animated animate__slideInLeft" shadow="hover"
          >
            <el-row>
              <el-col :span="6" class="left-des" style="display: inline">
&lt;!&ndash;               referrerpolicy="no-referrer" 不携带引源信息 &ndash;&gt;
                <img :src="item.imgUrl" referrerpolicy="no-referrer" alt="作品介绍图片" style="width: 80px;height: 100px"/>
              </el-col>
              <el-col :span="18">
                <div class="right-des" style="display: inline">
                  <div class="report-title">
                    {{item.name}}
                  </div>
                  <div class="report-content">
                    {{item.content}}
                  </div>
                  <div class="report-bottom">
                    <span>{{item.category}}</span>
                    <span style="margin-left: 15px">{{item.postTime}}</span>
                    <span style="float: right" @click="clickDetails(item.id)"><a :href="item.citeUrl" target="_blank" >查看详情</a></span>
                  </div>
                </div>
              </el-col>
            </el-row>
          </el-card>-->
          <el-pagination
            style="margin-bottom: 5px"
            small
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page.sync="searchParams.pageNum"
            :page-size="searchParams.pageSize"
            layout="prev, pager, next"
            :total="totalRecords">
          </el-pagination>
        </el-card>
      </el-col>
      <el-col :span="14" :xs="24" :sm="24" :lg="14">
        <el-card class="box-card grid-content" shadow="always" align="center">
          <div class="card-title">湖南省传统技艺类非物质文化遗产分布地图</div>
          <distribute-map height="550px"></distribute-map>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import SlideShow from "@/components/user/SlideShow";
import DistributeMap from "@/components/user/DistributeMap";
import Search from "@/components/user/Search";

export default {
  name: "HomePage",
  components: {
    SlideShow,
    DistributeMap,
    Search
  },
  data() {
    return {
      searchParams: {
        searchName: null,
        searchCategory: null,
        pageNum: 1,
        pageSize: 7
      },
      offset: 1,
      loading: false,
      noMore: false,
      messages: [
        /*{
          id: null,
          title: "",
          content: "",
          imgUrl: "",
          citeUrl: "",
          postTime: "",
          category: ""
        }*/
      ],
      currentPage: 1,
      totalRecords: 10,
      workId: 1,
      works: [
        {
          id: 1,
          name: "流浪地球"
        }
      ],
      userId:null
    }
  },
  methods: {
    handleCurrentChange(val) {
      this.searchParams.pageNum = val
      this.load()
    },
    handleSizeChange() {

    }
  },
  async created() {

  },
  mounted(){
    // this.selectChanged()
  }
}
</script>

<style scoped lang="scss">
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  background-color: #e7edfd;
}

.box-card2 {
  background-color: #F2F6FC;
  margin-bottom: 15px;
  max-height: 160px;
  overflow: hidden;
}

.card-title {
  font-size: 23px;
  color: #1f2d3d;
  font-family: 微软雅黑;
  margin-bottom: 25px;
}

.show-chart1 {
  margin-top: 40px;
}

.report-title {
  font-size: 1.2rem;
  font-color: #000;
}

a {
  color: #409EFF;
}

.report-content {
  height: 60px;
  overflow: hidden;
  color: #909399;
  font-size: 14px;
}

.report-bottom {
  color: #405db4;
  font-size: 16px;
}

.el-row {
  margin-bottom: 20px;
&:last-child {
   margin-bottom: 0;
 }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
