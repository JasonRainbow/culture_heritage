<template>
    <div style="width: 100%;">
        <el-card class="box-card1">
            <div v-for="(item,index) in forumData" :key="index" class="text item">
                <el-card class="box-card2">
                    <div style="float:left;width:20%">
                        <img :src="item.picture" style="height:200px;width: 200px;"/>
                    </div>
                    <div style="width: 78%;float: right;">
                        <h2 style="margin-bottom: 10px;">{{item.title}}</h2>
                        <div>
                            <span style="float:left;font-size: larger;margin-bottom: 10px;">{{item.releaseTime}}</span>
                        </div>

                        <div>
                            <span style="float:left;font-size: large;text-align: left;margin-bottom: 15px;">{{item.summary | contentLimit}}
                            </span>
                        </div>
                        <div>
                            <a style="float:left;font-size: larger;text-decoration: none;color: #405db4" :href="item.more">查看讨论</a>
                        </div>
                    </div>
                </el-card>
            </div>
<!--            <el-pagination-->
<!--                background-->
<!--                layout="prev, pager, next"-->
<!--                :total="1000">-->
<!--                </el-pagination>-->
          <div class="block">
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="current"
                :page-sizes="[5, 10, 15, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
          </div>
        </el-card>
    </div>
</template>

  <script>
  import axios from "axios";

  export default {
    name: 'HelloWorld',
    props: {
      msg: String
    },
    data() {
      return {
        input: '',
        forumData:[
          {
            title:'蓝印花布技艺',    //论坛标题
            time:'2023年12月17日',     //论坛时间
            //论坛描述
            content:'邵阳蓝印花布又称豆浆布，是一种用石灰豆浆防染花靛蓝色的双色布。深重的蓝，纯净的白，质朴的色彩，古拙的纹样，显现出浓烈的乡土气息。邵阳蓝印花布源自远古时代苗族、瑶族人的“阑干斑布”和“蜡缬”。',
            //图片url
            imageUrl:'https://pic1.zhimg.com/v2-21f4ca97ec88cb23b77119eb2c117e5d_r.jpg',
            //具体讨论的超链接
            url:'https://sy.rednet.cn/content/2019/12/17/6381470.html'
          },
          {
            title:'苗族银饰锻制技艺',
            time:'2023年10月23日',
            content:'苗族银饰锻制技艺历史悠久，先后经历了从原始装饰品到岩石贝壳装饰品、从植物花卉饰品到金银饰品的演进历程，传承延续下来，才有了模式和形态基本定型的银饰，其品种式样至今还在不断地翻新，由此形成的饰品链条成为苗族社会演进的象征之一。',
            imageUrl: 'https://www.cdstm.cn/gallery/media/mkjx/shijieyichan/201806/W020180627569165446292.jpg',
            url:'https://www.ihchina.cn/art/detail/id/9874.html'
          },
          {
            title:'醴陵釉下五彩瓷烧制技艺',
            time:'2023年11月08日',
            content:'醴陵釉下五彩瓷烧制技艺，从原料制作到产品烧成要经过近百道工序，全部靠手工完成，突破了釉下单彩的传统工艺，调配出丰富多彩的陶瓷绘画色料，讲究淡雅用色的表现手法，采用双勾分水的独特技法，烧制成的瓷器釉面晶莹润泽、釉胎白泛青，近乎写真效果。',
            imageUrl: 'http://www.zhongguociwang.com/upload/2017-09/17091714359793.jpg',
            url:'https://baijiahao.baidu.com/s?id=1669438379411300840'
          },
          {
            title:'制扇技艺（岳州扇制作技艺）',
            time:'2023年9月15日',
            content:'岳州扇是中国三大名扇之一，始于明末清初。岳州扇以湖南本地产的优质竹子为扇骨，牛角为钉，宣纸为面，就制作技艺来说，分扇骨和扇面制作两大程序，包括锯筒、劈片、边骨推青、小骨推青、镶边骨、取边、打磨、钻眼等72道工序。',
            imageUrl: 'http://www.yyx.gov.cn/uploadfiles/202012/20201223151708593.png',
            url:'http://www.xinhuanet.com/culture/20220701/7ac919e400a845bca7b6ae1ed12691cb/c.html'
          },
        ],
        current:1,
        total:0,
        pageSize:5
      }
    },
    filters:{
      contentLimit(value){
        // if(value.length>125){
        //   return value.substr(0,125)+"..."
        // }
        return value
      }
    },
    mounted(){
      let url = "http://localhost:5000/getAllForum"+'/'+this.pageSize+'/'+this.current;
      axios.get(url)
          .then(response =>{
            console.log("1"+response.code)
            //console.log(response.data.current)
            console.log(1,response.data)

              this.forumData=response.data.data.records,
                  //console.log(this)
              //console.log(this.forumData),
              this.current=response.data.data.current,
              this.pageSize=response.data.data.size,
              this.total=response.data.data.total
                  //console.log(this.current)
      });

    },
    methods:{
      handleSizeChange(){
        this.mounted()
      },
      handleCurrentChange(){
        this.mounted()
      },

    }
  }
  </script>

  <style scoped>
     .text {
        font-size: 14px;
    }

    .item {
      padding: 18px 0;
    }

    .box-card1 {
        margin: auto;
        width: 90%;

    }
    .box-card2{
        width: 95%;
        margin: auto;
    }
  </style>
