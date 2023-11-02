<template>
  <div>
    <div style="margin-bottom: 20px">
      <el-select style="width: 150px; margin-right: 10px" v-model="search_data.area" placeholder="请选择地区">
        <el-option
            v-for="(item,index) in options.area"
            :key="index"
            :label="item"
            :value="item">
        </el-option>
      </el-select>
      <el-select style="width: 180px; margin-right: 10px" v-model="search_data.postTime" placeholder="请选择公布时间">
        <el-option
            v-for="(item,index) in options.postTime"
            :key="index"
            :label="item"
            :value="item">
        </el-option>
      </el-select>
      <el-input
                style="width: 220px; margin-right: 20px"
                v-model="search_data.name"
                placeholder="请输入关键词：项目名称"
                clearable>
      </el-input>
      <el-button type="primary" @click="searchCultureHeritage()">搜索</el-button>
    </div>

    <!--列表-->
    <el-table :data="list_data" highlight-current-row v-loading="loading"
              border element-loading-text="拼命加载中"

              style="width: 100%; font-size: 14px; ">
      <el-table-column sortable prop="cultureId" label="ID" width="80" >
      </el-table-column>
      <el-table-column prop="name" label="名称" width="150" >
      </el-table-column>
      <el-table-column prop="category" label="类别" width="150" >
      </el-table-column>
      <el-table-column prop="kind" label="类型" width="140" >
      </el-table-column>
      <el-table-column sortable prop="announcementTime" label="公布时间" width="100" >
      </el-table-column>
      <el-table-column prop="declaringUnit" label="申报地区或单位" >
      </el-table-column>
      <el-table-column prop="protectionUnit" label="保护单位"  >
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <Pagination v-bind:child-msg="pageParam" @callFather="callFather"></Pagination>
  </div>
</template>

<script>
import Pagination from "@/components/user/Pagination";
import {getAllHeritageByPage} from "@/api/forum_api";
import {searchHeritage} from "@/api/search_culture_heritage";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Search",
  components: {
    Pagination
  },
  data() {
    return {
      loading: false, //是显示加载
      // 分页参数
      searchParam: {
        pageNumber: 1,
        pageSize: 10,
        //total: 10
      },
      pageParam:{
        currentPage:1,
        pageSize:10,
        total:10
      },
      search_data: {
        area:null,
        postTime:null,
        name: null,
        pageSize:10,
        pageNumber:1
      },
      list_data: [
        {
          id: 1,
          name: "土家族织锦技艺",
          category: "传统技艺",
          releaseTime: "2006",
          type: "新增项目",
          applicant: "湖南省湘西土家族苗族自治州",
          protectionUnit: "湘西土家族苗族自治州非物质文化遗产保护中心"
        },
        {
          id: 1,
          name: "土家族织锦技艺",
          category: "传统技艺",
          releaseTime: "2006",
          type: "新增项目",
          applicant: "湖南省湘西土家族苗族自治州",
          protectionUnit: "湘西土家族苗族自治州非物质文化遗产保护中心"
        },
        {
          id: 1,
          name: "土家族织锦技艺",
          category: "传统技艺",
          releaseTime: "2006",
          type: "新增项目",
          applicant: "湖南省湘西土家族苗族自治州",
          protectionUnit: "湘西土家族苗族自治州非物质文化遗产保护中心"
        },
        {
          id: 1,
          name: "土家族织锦技艺",
          category: "传统技艺",
          releaseTime: "2006",
          type: "新增项目",
          applicant: "湖南省湘西土家族苗族自治州",
          protectionUnit: "湘西土家族苗族自治州非物质文化遗产保护中心"
        },
        {
          id: 1,
          name: "土家族织锦技艺",
          category: "传统技艺",
          releaseTime: "2006",
          type: "新增项目",
          applicant: "湖南省湘西土家族苗族自治州",
          protectionUnit: "湘西土家族苗族自治州非物质文化遗产保护中心"
        },
      ],
      options: {
        area: [

        ],
        postTime: [

        ],
      }
    }
  },
  mounted(){
    this.getAllHeritagePaged(this.searchParam)
  },
  methods: {
    // 分页插件事件
    callFather(param) {
      // this.search_data.area=null;
      // this.search_data.postTime=null;
      // this.search_data.name=null;
      // this.getAllHeritagePaged(param)
      this.search_data.pageSize = param.pageSize;
      this.search_data.pageNumber = param.pageNumber;
      this.searchCultureHeritage();
    },
    searchCultureHeritage(){
      console.log(this.search_data.postTime)
      searchHeritage(null,this.search_data).then(res=>{
        console.log(res.data)
        if(res.code === '0'){
          this.list_data=res.data.records;
          this.pageParam.total=res.data.total
        }
      })
    },
    getAllHeritagePaged(param){
      getAllHeritageByPage(param).then(res=>{
        console.log(res.data)
        if(res.code === '0'){
          this.list_data=res.data.records;
          this.options.postTime=res.data.postTimeList;
          this.options.area=res.data.areaList;
          this.pageParam.currentPage=res.data.current;
          this.pageParam.pageSize=res.data.size;
          this.pageParam.total=res.data.total
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
