<template>
  <div>
    <el-row style="display: flex; justify-content: center">
      <el-col :span="17" :xs="24" align="center">
<!--        <slide-show></slide-show>-->
        轮播图
      </el-col>
    </el-row>
    <el-row :gutter="40">
      <el-col :span="10" :xs="24" :sm="24" :lg="10">
        <el-card class="box-card grid-content" shadow="always">
          <div class="card-title">热点非物质文化遗产</div>
          <el-card v-for="item in works" :key="item.id"
                   class="box-card2 animate__animated animate__slideInLeft" shadow="hover"
          >
            <el-row>
              <el-col :span="6" class="left-des" style="display: inline">
<!--              referrerpolicy="no-referrer" 不携带引源信息 -->
                <img :src="item.imgUrl" referrerpolicy="no-referrer" alt="作品介绍图片" style="width: 80px;height: 100px"/>
              </el-col>
              <el-col :span="18">
                <div class="right-des" style="display: inline">
                  <div class="report-title">
                    {{item.workName}}
                  </div>
                  <div class="report-content">
                    {{item.content}}
                  </div>
                  <div class="report-bottom">
                    <span style="float: right"><a :href="item.citeUrl" target="_blank" >查看详情</a></span>
                  </div>
                </div>
              </el-col>
            </el-row>
          </el-card>
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
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="40" type="flex" justify="center">
      <el-col :span="18" :xs="24" :sm="24" :lg="18" style="margin-top: 20px">
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  components: {
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
      works: [
        {
          workName: '湘绣',
          content: '湘绣是中国四大名绣之一，是以湖南长沙为中心的带有鲜明湘楚文化特色的湖南刺绣产品的总称，它起源于湖南的民间刺绣，吸取了苏绣和粤绣的优点而发展起来，已经有2000多年历史。',
          imgUrl: 'https://ts1.cn.mm.bing.net/th/id/R-C.b97d614e674c78cb4a46b95eb23cdbc?rik=%2f%2bDCXWH7GGlcLA&riu=http%3a%2f%2fwww.wylylxx.com%2fuploadpic%2fm2339.jpg&ehk=ZPajZjw6wXqBvH%2fot0W1%2f%2fEjteBbSXd8FqTdsUAC0Dc%3d&risl=&pid=ImgRaw&r=0',
          citeUrl: 'https://baike.baidu.com/item/%E6%B9%98%E7%BB%A3/300254'
        },
        {
          workName: '土家族织锦',
          content: '土家族织锦的工艺复杂，在织造上，使用古老的纯木质腰式斜织机织造，需经过纺捻线、染色、倒线、牵线、装筘、滚线、捡综、翻篙、捡花、捆杆上机、织布、挑织等12道工序制作而成。',
          imgUrl: 'https://ts1.cn.mm.bing.net/th/id/R-C.890d59fa3153d1a41be005e0bdb8b9eb?rik=g3z1xq1Ew1AZsg&riu=http%3a%2f%2fy3.ifengimg.com%2fffa2ab525f4343e9%2f2015%2f0427%2frdn_553d91582f486.jpg&ehk=gE2O4DNMCdr2p%2b6R7DwuJNUWoyZuw6y%2fRHhA%2bIwz4XE%3d&risl=&pid=ImgRaw&r=0',
          citeUrl: 'https://baike.baidu.com/item/%E5%9C%9F%E5%AE%B6%E6%97%8F%E7%BB%87%E9%94%A6%E6%8A%80%E8%89%BA/3148060'
        },
        {
          workName: '蓝印花布印染技艺',
          content: '蓝印花布印染技艺分纯蓝花布印染和彩蓝花布印染两大类：纯蓝花布布面素净，没有花纹图案，一般用以制作衣服和头帕；彩蓝花布有复杂的花纹图案，一般用以制作被面、垫单、帐檐、围裙、围腰、门帘、桌布、围布等。',
          imgUrl: 'https://ts1.cn.mm.bing.net/th/id/R-C.85cbc1fe0a91fb1974868a8e03d546c0?rik=C5BPOtfKAyh9Pw&riu=http%3a%2f%2fimg3.jc001.cn%2fimg%2f001%2f1%2f1702%2f1758a1511304efb.jpg&ehk=WtyHvvQTRhWTuWZOInvGMNb2ZvwCdeNN6hOcFQJkQZ0%3d&risl=&pid=ImgRaw&r=0',
          citeUrl: 'https://baike.baidu.com/item/%E8%93%9D%E5%8D%B0%E8%8A%B1%E5%B8%83%E5%8D%B0%E6%9F%93%E6%8A%80%E8%89%BA'
        }
      ],
      workId: 1,
      totalRecords: 3,
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
