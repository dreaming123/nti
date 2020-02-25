<template>
  <div>
    <!-- <headTop></headTop>

    <el-card class="box-card">
      <div v-for="o in 4" :key="o" class="text item"  @click="getJson">{{'列表内容 ' + o }}</div>
      <div v-for="o in 4" :key="o">{{t1}}</div>
    </el-card> -->


  <div>
    <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
     <el-table-column
      prop="address"
      label="操作">
    </el-table-column>
  </el-table>
  </div>
  <!--  分页 -->
    <div class="block">
    <!-- <span class="demonstration">完整功能</span> -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[10, 15, 20, 30]"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400">
    </el-pagination>
  </div>

  </div>

  
    

  
</template>

<script>

  import headTop from './headTop'
  
export default {
  data() {
      return {
           t1:1,
           tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
        // 分页
         currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4
      }
  },

  components:{
      headTop
  },
  methods:{
       getJson(){
           console.log(this.t1);
           const axios = require('axios');
           const that=this;
            // Make a request for a user with a given ID
            axios.get('/static/test.json?ID=12345')
              .then(function (response) {
                // handle success
               
                console.log(response);
                that.t1=2;
               
                alert(response.data.data)
                
                
              })
              .catch(function (error) {
                // handle error
                console.log(error);
              })
              .finally(function () {
                // always executed
              });
       },
        handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
  }
	
}
</script>
<style lang="less" scoped>
 .box-card{
    text-align:center;
    width: 500px;
    margin: auto;
    
 }
</style>
