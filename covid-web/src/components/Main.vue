<template>
  <div id="app">    
    <el-row class='main'>
      <el-col :span=5>
        <left-asider></left-asider>
      </el-col>
      <el-col :span=14>
        <el-row style="width:100%;border:1px #fff solid;border-radius: 3px;">
          <el-col :span=6>
            <province-info :provinceInfo='getprovinceInfo'></province-info>
          </el-col>
          <el-col :span=18>
            <bdChinaMap @getProvinceName='getPName'></bdChinaMap>
          </el-col>
        </el-row>        
        <el-row>
          <china-every-month></china-every-month>
        </el-row>
      </el-col>
      <el-col :span=5>
        <right-asider></right-asider>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import bdChinaMap from './bdChinaMap'
import LeftAsider from './LeftAsider'
import RightAsider from './RightAsider'
import ProvinceInfo from './ProvinceInfo'
import ChinaEveryMonth from './chinaEveryMonth'
export default {
  name: 'Main',
  components:{
    bdChinaMap,LeftAsider,RightAsider,ProvinceInfo,ChinaEveryMonth
  },
  data(){
    return {
      getprovinceInfo:{}
    }
  },
  methods:{
    init(){

    },
    getPName(pname){
      this.getprovinceInfo={
        name:'山东',
        confirmed:5000,
        death:10,
        recovered:100000
      }
    }
  }
}
</script>

<style scoped>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
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