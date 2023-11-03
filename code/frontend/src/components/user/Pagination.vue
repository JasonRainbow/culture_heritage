/**
* 分页组件
*/
<template>
  <el-pagination class="page-box" @size-change="handleSizeChange"
                 @current-change="handleCurrentChange" background :current-page="childMsg.currentPage"
                 :page-sizes="[10, 20, 30, 40]" :page-size="childMsg.pageSize" layout="total, sizes, prev, pager, next, jumper"
                 :total="childMsg.total">
  </el-pagination>
</template>
<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Pagination',
  props: ['childMsg'],
  data() {
    return {
      pageParam: {
        pageNumber: this.childMsg.currentPage,
        pageSize: this.childMsg.pageSize
      },
    }
  },
  created() {},
  methods: {
    handleSizeChange(val) {
      /**
       * 子传父
       * 参数1 父元素方法
       * 参数2 数据
       */
      this.pageParam.pageNumber=1
      this.pageParam.pageSize=val
      this.$emit('callFather', this.pageParam)
    },
    handleCurrentChange(val) {
      /**
       * 子传父
       * 参数1 父元素方法
       * 参数2 数据
       */
      this.pageParam.pageNumber=val
      this.$emit('callFather', this.pageParam)
    }
  }
}
</script>

<style>
.page-box {
  margin: 10px auto;
}
</style>
