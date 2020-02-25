<template>
    <div style="width:300px"> 
<el-upload
  class="upload-demo"
  ref="upload"
  action="http://localhost:8080/other/addExcelForItem"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :file-list="fileList"
  :auto-upload="false">
  <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
  <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
  <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
</el-upload>
     <form action="http://localhost:8080/other/addUser" enctype="multipart/form-data" method="post">
            
      <input type="file" name="file" value="请选择文件夹">
    <input type="submit"   value="上传"> 
     </form>

     <form id="upload-form" action="http://localhost:8080/other/addUser" method="post" enctype="multipart/form-data" >
　　　<input type="file" id="upload" name="upload" /> <br />
　　　<input type="submit" value="Upload" />


</form>
     
    </div>
   
    
</template>

<script>
  export default {
    data() {
      return {
        fileList: []
      };
    },
    methods: {
      submitUpload() {
           alert(JSON.stringify(this.fileList));
          
        this.$refs.upload.submit();
            /* const axios = require('axios');
              const that=this;
             let formData = new FormData();
                formData.append("file1", that.fileList[0].name);
               
                axios.defaults.withCredentials = true;
                axios.defaults.baseURL = "/api";
                axios.defaults.timeout = 50000;
                
                   axios.defaults.headers.post['Content-Type'] = 'multipart/form-data';
               console.log(this.$refs.upload.submit())
           axios.post('http://localhost:8080/zhibing_mybatis_war_exploded/muserController/upload.do',formData)
              .then(function (response) {
                // handle success
                
                console.log(response);
              
               
               
                
                
              })
              .catch(function (error) {
                // handle error
                console.log(error);
              })
              .finally(function () {
                // always executed
              });
           */
           

      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      beforeUpload: function (file) {
        /*console.log(file)
        //这里是重点，将文件转化为formdata数据上传
        let fd = new FormData()
        fd.append('file', file)
        this.$http.post('', fd).then((res) => {
          console.log(res)
        }, (res) => {
          
          console.log(res)
        });
        return false;  */
      },
      addExcel(){
          this.$router.push('/');
          
       }
     
    

    }
  }
</script>

<style>

</style>
