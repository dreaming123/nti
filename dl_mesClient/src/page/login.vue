<template>
  <div class="Login" >
       <el-form ref="form" :model="form" label-width="80px">
          <div class="manage_tip">
		  			<p>后台管理登陆</p>
		  		</div>
      <el-form-item label="用户名">
        <el-input v-model="form.name" placeholder="请输入登陆的用户名"></el-input>
      </el-form-item>
       <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入登陆的密码"></el-input>
      </el-form-item>

      
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登陆</el-button>
        <el-button type="primary" @click="addExcel">上传文件</el-button>
        <el-button>取消</el-button>
      </el-form-item>
</el-form>
      
    <router-link to="/manager/test1">Go to Foo</router-link>
    <router-link to="/manager/test1">Go to Bar</router-link>
    
  </div>
</template>


<script>
export default {
    data(){
        return {
           
             form: {
                    name: '',
                    password:'',
                    
                    }
         
        }
    },
     methods: {
      onSubmit() {
      
       this.$message({
          message: '恭喜你，登陆成功',
          type: 'success'
        });

        //  alert("登陆成功");
          this.$router.push('manager')
      },
       addExcel(){
          this.$router.push('addExcel');
          
       }
     }
    
}
</script>


<style lang="less" >

.manage_tip{
	//	position:absolute;
		width: 100%;
		top: 100px;
    margin: 20px;
    
		p{
			font-size: 34px;
			color: #fff;
		}
	}
   .Login{
       width:400px;
        height: 200px;
        background-color: bisque;
      
       margin:0 auto;
        margin-top:200px;
        padding: 180px
        
   }
   input{
       float: left;
       
   }

  
</style>
