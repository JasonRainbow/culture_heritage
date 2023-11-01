<template>
    <div style="width: 100%;">
        <el-card class="box-card1">
            <div v-for="o in 4" :key="o" class="text item">
                <el-card class="box-card2">
                    <div style="float:left;width:20%">
                        <img src="../assets/logo.png" style="height:200px;width: 200px;"/>
                    </div>
                    <div style="width: 78%;float: right;">
                        <h2 style="margin-bottom: 10px;">湖南非遗论坛</h2>
                        <div>
                            <span style="float:left;font-size: larger;margin-bottom: 10px;">2023.10.19</span>
                        </div>
            
                        <div>
                            <span style="float:left;font-size: large;text-align: left;margin-bottom: 15px;">2023年10月12日，广受瞩目的第八届中国成都国际非物质文化遗产节开幕。其中的重要板块——非遗成都论坛以“《保护非物质文化遗产公约》20周年非物质文化遗产保护实践回顾与探索”为主题，邀请国内外非遗领域的知名专家学者多侧面多角度展开学术探讨，并分享国际社会在文...
                            </span>
                        </div>
                        <div>
                            <a style="float:left;font-size: larger;text-decoration: none;" href="http://www.baidu.com">查看讨论</a>
                        </div>
                    </div>
                </el-card>
            </div> 
            <el-pagination
                background
                layout="prev, pager, next"
                :total="1000">
                </el-pagination>   
        </el-card>
    </div>
</template>
  
  <script>
  export default {
    name: 'HelloWorld',
    props: {
      msg: String
    },
    data() {
      return {
        input: ''
      }
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
  