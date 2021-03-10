<template>
  <div id="app">
    <el-row class='header'>
      <el-col :span='6' class='banner'>
        {{title}}
      </el-col>
      <el-col :span='18'>
        <Menu></Menu>
      </el-col>
    </el-row>
    <el-row class='main'>
      <el-col :span=24>
        <transition :name='transitionName'>
          <keep-alive>
            <router-view v-if='$route.meta.keepAlive'/>
          </keep-alive>
        </transition>        
      </el-col>
    </el-row>
  </div>
</template>

<script>
import Menu from './components/Menu'
import Main from './components/Main'
export default {
  name: 'App',
  components:{
    Menu,Main
  },
  data(){
    return {
      title:'前端Vue测试框架展示',
      transitionName:'slide-left'
    }
  }
}
</script>

<style>
body{
  margin: 0;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #000;
}

.banner{
  text-align: center;
  color: aliceblue;  
}

.header{
  width: 100%;
  background-color:#303133;
  border-bottom: 1px #fff solid;
}

.main{
  width:100%;
}
</style>
