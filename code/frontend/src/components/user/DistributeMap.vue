<template>
    <div id="worldMapChart" class="mapStyle" :style="{margin: 'auto', height: height, width: '100%'}"></div>

</template>

<script>
import jsonData from "../../assets/data/hunan_map.json"

export default {
  name: "DistributeMap",
  props: {
    height: {
      type: String,
      default: "200px",
    },
    width: {
      type: String,
      default: "300px",
      required: false
    }
  },
  data() {
    return {
      screenWidth: 1536,
      dataList: [
        {
          name: "常德市",
          num: 3,
          value: 0
        },
        {
          name: "郴州市",
          num: 4,
          value: 0
        },
        {
          name: "衡阳市",
          num: 1,
          value: 0
        },
        {
          name: "怀化市",
          num: 1,
          value: 0
        },{
          name: "娄底市",
          num: 4,
          value: 0
        },
        {
          name: "邵阳市",
          num: 2,
          value: 0
        },
        {
          name: "湘潭市",
          num: 1,
          value: 0
        },
        {
          name: "湘西土家族苗族自治州",
          num: 10,
          value: 0
        },
        {
          name: "益阳市",
          num: 1,
          value: 0
        },
        {
          name: "永州市",
          num: 1,
          value: 0
        },
        {
          name: "岳阳市",
          num: 0,
          value: 0
        },
        {
          name: "张家界市",
          num: 1,
          value: 0
        },
        {
          name: "长沙市",
          num: 1,
          value: 0
        },
        {
          name: "株洲市",
          num: 2,
          value: 0
        },
      ]
    }
  },
  methods: {
    initWorldMapChart(){
      let sum = 0
      this.dataList.map((item)=>{
        sum += item.num;
      })
      for(let i = 0; i < this.dataList.length; i++){
        this.dataList[i].value = Math.round(this.dataList[i].num / sum * 100)
      }
      this.option = {
        tooltip: {
          //数据格式化
          formatter: function(params) {
            return (
                params.name + " 共" + params.data.num +  "个，占："+
                params.value+"%"
            );
          },
          backgroundColor: 'rgba(19, 25, 47, 0.6)',
          borderColor: 'deepskyblue',
          textStyle: {
            color: 'white', //设置文字颜色
            fontSize: this.screenWidth * 0.01
          }
        },
        visualMap: {
          textStyle: {
            color: '#b5bb94',
            fontSize: this.screenWidth * 0.009
          },
          itemHeight: this.screenWidth * 0.092,
          itemWidth: this.screenWidth * 0.0131,
          min: 0,
          max: 100,
          left: 65,
          top: 250,

          text: ["高(百分比)", "低"], //取值范围的文字
          inRange: {
            color: [
              // 地图的颜色 从最深 到最浅
              "#efecec",
              "#a693be",
              "#8b75a6",
              "#6e5e8d",
              "#663d74",
              "#2f1136", //紫色 最大
              "#f091a1",
              "#e782a0",
              "#e16c96",
              "#eb3c70", //粉色最大
            ],
            //取值范围的颜色
          },
          show: true, //图注
        },
        geo: {
          map: 'world', //引入地图数据
          roam: true, //不开启缩放和平移
          zoom: 1, //视角缩放比例
          label: {
            show: true,//是否在地图上显示地区名字
            fontSize: this.screenWidth * 0.0066,
            color: "rgb(13,43,133)",
          },
          nameMap:{
            "常德": "常德市",
            "郴州": "郴州市",
            "衡阳": "衡阳市",
            "怀化": "怀化市",
            "娄底": "娄底市",
            "邵阳": "邵阳市",
            "湘潭": "湘潭市",
            "湘西": "湘西土家族苗族自治州",
            "益阳": "益阳市",
            "永州": "永州市",
            "岳阳": "岳阳市",
            "张家界": "张家界市",
            "长沙": "长沙市",
            "株洲": "株洲市",
          },
          emphasis: {
            borderColor: "rgba(0, 0, 0, 0.2)",
            itemStyle:{ //高亮的显示设置
              areaColor: "skyblue", //鼠标选择区域颜色
              shadowOffsetX: 0,
              shadowOffsetY: 0,
              shadowBlur: 20,
              borderWidth: 0,
              shadowColor: "rgba(0, 0, 0, 0.5)",
            },
          },
        },
        // 鼠标悬浮提示框
        series: [
          {
            name: "地级市",
            type: "map",
            geoIndex: 0,
            data: this.dataList,
          },
        ],
      }
      this.worldMapChart = this.$echarts.init(document.getElementById("worldMapChart"));
      this.$echarts.registerMap('world', jsonData)
      this.worldMapChart.setOption(this.option);
    },
  },
  mounted() {
    this.initWorldMapChart()
    window.addEventListener('resize', ()=>{
      this.screenWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
      this.worldMapChart.resize();
    })
  }
}
</script>

<style scoped>

</style>
