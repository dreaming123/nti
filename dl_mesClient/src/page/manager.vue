<template>
  <div>
    <el-row>
      <!-- 菜单栏     -->
      <el-col :span="4">
        <div class="grid-content bg-purple">
          <el-menu
            default-active="/test1"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            router
           
           
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group>
                <template slot="title">备件库功能</template>
                <el-menu-item index="/addExcel">物料基础数据导入</el-menu-item>
                <el-menu-item index="/test1">选项2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
              </el-menu-item-group>
              <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项1</el-menu-item>
              </el-submenu>
            </el-submenu>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </el-menu-item>
            <el-menu-item index="3" disabled>
              <i class="el-icon-document"></i>
              <span slot="title">导航三</span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-setting"></i>
              <span slot="title">导航四</span>
            </el-menu-item>
          </el-menu>
        </div>
      </el-col>

      <!-- 中间部分 -->
      <el-col :span="20">
        <!-- <div class="grid-content bg-purple-light">
          <el-row>
            <el-col :span="24">
              <div class="grid-hometop" >
                <el-breadcrumb separator="/">
                  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                  <el-breadcrumb-item>
                    <a href="/">活动管理</a>
                  </el-breadcrumb-item>
                  <el-breadcrumb-item>活动列表</el-breadcrumb-item>
                  <el-breadcrumb-item>活动详情</el-breadcrumb-item>
                </el-breadcrumb>
              </div>
            </el-col>
          </el-row>
        </div> -->
        <!-- <home></home> 
           <home></home> 
           <home></home>  -->
           <router-link to="/test1">Go to Foo</router-link>
    <router-link to="/manager/test1">Go to Bar</router-link>
           <router-view></router-view>
         <!-- <router-view></router-view> -->
      </el-col>
    </el-row>

    <!-- 这是页面底部 -->
    <el-row>
      <el-col :span="24">
        <div class="grid-bottom bg-purple-light">这是底部</div>
      </el-col>
    </el-row>

     
  </div>
</template>

<script>
//import 'element-ui/lib/theme-chalk/index.css';
import home from '../components/home'
import test1 from  '../components/test1'
import test2 from  '../components/test2'

export default {
      
		computed: {
			defaultActive: function(){
			alert(this.$route.path);
				return this.$route.path.replace('/', '');
			}
		},
   
  data(){
     return {
        
     }
     
  },
  components:{
     home
  },
  methods: {
    handleOpen(key, keyPath) {
      this.$message({
        message: key + "-" + keyPath,
        type: "success"
      });
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
  
};
</script>















<style lang='less' >
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
  min-height: 900px;
  .grid-hometop {
    min-height: 50px;
    background: violet;
  }
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.grid-bottom {
  min-height: 40px;
}
</style>
