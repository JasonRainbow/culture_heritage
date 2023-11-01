<template>
    <div style="width: 100%;">
        <el-card class="box-card1">
            <div v-for="(item,index) in forumData" :key="index" class="text item">
                <el-card class="box-card2">
                    <div style="float:left;width:20%">
                        <img :src="item.imageUrl" style="height:200px;width: 200px;"/>
                    </div>
                    <div style="width: 78%;float: right;">
                        <h2 style="margin-bottom: 10px;">{{item.title}}</h2>
                        <div>
                            <span style="float:left;font-size: larger;margin-bottom: 10px;">{{item.time}}</span>
                        </div>
            
                        <div>
                            <span style="float:left;font-size: large;text-align: left;margin-bottom: 15px;">{{item.content}}
                            </span>
                        </div>
                        <div>
                            <a style="float:left;font-size: larger;text-decoration: none;" :href="item.url">查看讨论</a>
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
        input: '',
        forumData:[
          {
            title:'蓝印花布技艺',    //论坛标题
            time:'2023年12月17日',     //论坛时间
            //论坛描述
            content:'邵阳蓝印花布又称豆浆布，是一种用石灰豆浆防染花靛蓝色的双色布。深重的蓝，纯净的白，质朴的色彩，古拙的纹样，显现出浓烈的乡土气息。邵阳蓝印花布源自远古时代苗族、瑶族人的“阑干斑布”和“蜡缬”。',
            //图片url
            imageUrl:'https://cn.bing.com/images/search?view=detailV2&ccid=ctvT2j8k&id=595335409A7E1DF37B74AE1C6F7040565859E5D0&thid=OIP.ctvT2j8kaih7fdYnmuxF7wHaJp&mediaurl=https%3a%2f%2fts1.cn.mm.bing.net%2fth%2fid%2fR-C.72dbd3da3f246a287b7dd6279aec45ef%3frik%3d0OVZWFZAcG8crg%26riu%3dhttp%253a%252f%252fimg.hnol.net%252fbbsimg%252f2005-08-20%252f11%252f2005820110351180.jpg%26ehk%3dq%252fIxBH7ihF4%252f5SrEoBWidrf8T0tRc48AevA4HzHEn2Q%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=651&expw=500&q=%e8%93%9d%e5%8d%b0%e8%8a%b1%e5%b8%83%e5%9b%be%e7%89%87&simid=608008524649954473&FORM=IRPRST&ck=894801FB3E8C25D28DB4F9AE17735A32&selectedIndex=14&ajaxhist=0&ajaxserp=0',
            //具体讨论的超链接
            url:'https://sy.rednet.cn/content/2019/12/17/6381470.html'
          },
          {
            title:'苗族银饰锻制技艺',
            time:'2023年10月23日',
            content:'苗族银饰锻制技艺历史悠久，先后经历了从原始装饰品到岩石贝壳装饰品、从植物花卉饰品到金银饰品的演进历程，传承延续下来，才有了模式和形态基本定型的银饰，其品种式样至今还在不断地翻新，由此形成的饰品链条成为苗族社会演进的象征之一。',
            imageUrl:'https://cn.bing.com/images/search?view=detailV2&ccid=8W98Rcey&id=86183A3A2889FA822607A514760954D47831063D&thid=OIP.8W98RceyWjgjP9tAcT7EpQHaGE&mediaurl=https%3a%2f%2fp1.ssl.qhmsg.com%2ft0191d5eee538bac1e4.jpg&exph=655&expw=800&q=%e8%8b%97%e6%97%8f%e9%93%b6%e9%a5%b0&simid=608051976812515528&FORM=IRPRST&ck=D6C03BF90BCF7360038FF97F2DC93467&selectedIndex=3&ajaxhist=0&ajaxserp=0',
            url:'https://www.ihchina.cn/art/detail/id/9874.html'
          },
          {
            title:'醴陵釉下五彩瓷烧制技艺',
            time:'2023年11月08日',
            content:'醴陵釉下五彩瓷烧制技艺，从原料制作到产品烧成要经过近百道工序，全部靠手工完成，突破了釉下单彩的传统工艺，调配出丰富多彩的陶瓷绘画色料，讲究淡雅用色的表现手法，采用双勾分水的独特技法，烧制成的瓷器釉面晶莹润泽、釉胎白泛青，近乎写真效果。',
            imageUrl:'https://cn.bing.com/images/search?view=detailV2&ccid=NzAKOgMl&id=23DF1595BC472CB74186515D46EDA7916DD66FDA&thid=OIP.NzAKOgMlM2nnNQXKYsD9uwHaKc&mediaurl=https%3a%2f%2fimg1.artron.net%2fauction%2f2016%2fart509672%2fd%2fart5096726325.jpg&exph=2000&expw=1418&q=%e9%86%b4%e9%99%b5%e9%87%89%e4%b8%8b%e4%ba%94%e5%bd%a9%e7%93%b7&simid=608030008059395887&FORM=IRPRST&ck=2F812E7CBACBA87647CC9F095D429EF8&selectedIndex=1&ajaxhist=0&ajaxserp=0',
            url:'https://baijiahao.baidu.com/s?id=1669438379411300840'
          },
          {
            title:'制扇技艺（岳州扇制作技艺）',
            time:'2023年9月15日',
            content:'岳州扇是中国三大名扇之一，始于明末清初。岳州扇以湖南本地产的优质竹子为扇骨，牛角为钉，宣纸为面，就制作技艺来说，分扇骨和扇面制作两大程序，包括锯筒、劈片、边骨推青、小骨推青、镶边骨、取边、打磨、钻眼等72道工序。',
            imageUrl:'https://cn.bing.com/images/search?view=detailV2&ccid=M5SKnRuh&id=4C6798D996B207BB36309B5C40038EA3B8143887&thid=OIP.M5SKnRuheekYu-QGsmdJCQHaE6&mediaurl=https%3a%2f%2fts1.cn.mm.bing.net%2fth%2fid%2fR-C.33948a9d1ba179e918bbe406b2674909%3frik%3dhzgUuKOOA0Bcmw%26riu%3dhttp%253a%252f%252fwww.szfan.com%252fuploadfiles%252fpictures%252fnews%252f20170712085508_5840.jpg%26ehk%3dPTJSBeNdR%252fm%252fkvhU39oFSsjlpwnljZHUS7tcjeDWbpw%253d%26risl%3d%26pid%3dImgRaw%26r%3d0%26sres%3d1%26sresct%3d1%26srh%3d799%26srw%3d1205&exph=365&expw=550&q=%e5%b2%b3%e5%b7%9e%e6%89%87&simid=608000196636463372&FORM=IRPRST&ck=57CFCC5FE58F31434E8E2607312AC4FF&selectedIndex=4&ajaxhist=0&ajaxserp=0',
            url:'http://www.xinhuanet.com/culture/20220701/7ac919e400a845bca7b6ae1ed12691cb/c.html'
          },
        ]
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
  