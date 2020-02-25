<template>
  <div id="app" class="fillcontain">
     <!-- <img src="./assets/logo.png">  -->
       <router-link to="/test1">Go to Foo</router-link>
   <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style  lang="less">
	 @import './style/common'; 
/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  
   padding:auto;
  
  
  
}  */
 
</style>
