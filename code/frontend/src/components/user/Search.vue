<template>
  <div>
    <el-form :inline="true" :model="search_data" class="user-search">
      <el-form-item label="搜索：">
        <el-select size="medium" v-model="search_data" placeholder="请选择地区" @change="updateChart">
          <el-option
              v-for="item in emotionOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small"
                  v-model="search_data.searchCountry"
                  placeholder="请输入评论所属的国家"
                  @keypress.enter.native="search"
                  clearable
        >

        </el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small"
                  v-model="search_data.searchPlatform"
                  placeholder="请输入评论所属的平台"
                  @keypress.enter.native="search"
                  clearable
        >

        </el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small"
                  v-model="search_data.searchContent"
                  placeholder="请输入评论的内容"
                  @keypress.enter.native="search"
                  clearable
        >

        </el-input>
      </el-form-item>
    </el-form>
    <!--列表-->
    <el-table size="small" :data="list_data" highlight-current-row v-loading="loading"
              border element-loading-text="拼命加载中" @selection-change="handleSelectionChange" style="width: 100%;">
      <el-table-column sortable prop="id" label="ID" width="80">
      </el-table-column>
      <el-table-column prop="name" label="名称" width="100">
      </el-table-column>
      <el-table-column prop="category" label="类别" width="140">
      </el-table-column>
      <el-table-column prop="type" label="类型" width="140">
      </el-table-column>
      <el-table-column prop="releaseTime" label="公布时间" width="120">
      </el-table-column>
      <el-table-column prop="applicant" label="申报地区或单位" width="100">
      </el-table-column>
      <el-table-column prop="protectionUnit" label="保护单位" width="100">
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
<!--    <Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>-->
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Search",
  data() {
    return {
      search_data: {

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
        }
      ]
    }
  }
}
</script>

<style scoped>

</style>
