<!--展示线下相关文化的体验地点-->
<template>
    <div class="parent-container">
      <el-card class="box-card1" shadow="always">
        <div class="activity-apply" @click="$router.push('/apply')">活动宣传申请>></div>
        <el-card class="box-card2" v-for="item in activityArr" :key="item.activityId" shadow="hover">
          <el-row>
            <el-col :span="6" class="left-des" style="display: inline">
              <img :src="item.activityPhoto" referrerpolicy="no-referrer" alt="线下活动图片" style="width: 180px;height: 150px"/>
            </el-col>
            <el-col :span="18">
              <div class="right-des" style="display: inline">
                <h2 style="font-weight: bold;color: #2f2f2f">{{item.activityName}}</h2>
                <div class="report-content">
                  {{item.introduction}}
                </div>
                <div class="report-bottom" style="margin-top: 15px">
                  <span style="float: right;color: #405db4"><a :href="item.detail" target="_blank" >查看详情</a></span>
                </div>
              </div>
            </el-col>
          </el-row>
        </el-card>
        <el-pagination
            style="margin-bottom: 5px; margin-top: 10px"
            background
            small
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page.sync="searchParams.pageNumber"
            :page-size="searchParams.pageSize"
            layout="prev, pager, next"
            :total="total">
        </el-pagination>
      </el-card>
    </div>
</template>

<script>
import {getAllOfflineActivityByPage} from "@/api/offline_activity_api";

export default {
  data () {
    return {
      searchParams: {
        pageNumber: 1,
        pageSize: 5,
      },
      totalRecords: 6,
      activityArr: [
        {
          activityId: 1,
          activityName: '沙坪湘绣文化艺术节开幕',
          imgUrl: 'https://news-vod.voc.com.cn/9/2023/09/28/cb655cbad6e7a33287d71d6aed23c8025370f8b51695910575965.jpg?pid=7487987',
          content: '9月28日，2023长沙·沙坪湘绣文化艺术节暨“绣美长沙 礼好开福”创新创意大赛在长沙市开福区沙坪湘绣文化广场开幕。本次活动以“一节两赛一专场”和主题活动等形式，全面传递湘绣的国风国潮韵味、时尚锐意气息和创新创意特质，助力沙坪湘绣实现文化与经济“双面秀”。',
          citeUrl: 'https://www.hunantoday.cn/news/xhn/202309/18762951.html'
        },

      ],
      current:1,
      total:1
    }
  },
  created() {

  },
  mounted(){
    this.getData()
  },
  methods: {
    handleSizeChange () {
    },
    handleCurrentChange (val) {
      this.searchParams.pageNumber = val
      this.getData()
    },
    getData() {
      getAllOfflineActivityByPage(this.searchParams).then(res=>{
        if(res.code === '0'){
          this.activityArr = res.data.records;
          this.current=res.data.current;
          this.total=res.data.total
        }
      })
    }
  }
}
</script>

<style scoped>
.parent-container {
  flex: 1;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-content: center;
  padding: 10px 0;
  overflow: auto;
  margin-bottom: 30px;
}
.box-card1 {
  width: 60%;
  margin: 5px;
  background-color: #e7edfd;
  font-size: 15px;
}
.box-card2 {
  width: 100%;
  margin: 5px 10px;
  background-color: #F2F6FC;
  color: #909399;
  font-size: 15px;
}
.activity-apply {
  float: right;
  margin-bottom: 15px;
  color:#409EFF;
  font-weight: bold;
  cursor: pointer;
}
</style>
