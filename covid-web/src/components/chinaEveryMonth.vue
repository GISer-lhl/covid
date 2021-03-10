<template>
    <div id='container'>
        <ve-line
        height="200px"
          :x-axis="chartSettings.xAxis"
          :y-axis="chartSettings.yAxis"
          :legend="chartSettings.legend"       
          :data="chartData">
        </ve-line>
    </div>  
</template>

<script>
  export default {
    
    data () {
      this.chartSettings = {
        metrics: ['确诊数','死亡数','康复数'],
        dimension: ['日期'],
        yAxis:{
          type:'value',
          axisLine:{
            show:true,
            lineStyle:{
              color:'#fff'
            }
          },
          splitLine:{
            show:false
          },
          axisLabel:{
            show:true,
            textStyle:{
              color:'#fff'
            }
          }
        },
        xAxis:{
          type:'category',
          axisLine:{
            show:true,
            lineStyle:{
              color:'#fff'
            }
          },
          splitLine:{
            show:false
          },
          axisLabel:{
            show:true,
            textStyle:{
              color:'#fff'
            }
          }
        },
        legend:{
          textStyle:{
            color:'#fff'
          }
        }
      }
      return {
        chartData: {
          columns: ['日期', '确诊数', '死亡数', '康复数'],
          rows: [
            { '日期': '2020年1月', '确诊数': 1393, '死亡数': 1093, '康复数': 32 },
            { '日期': '2020年2月', '确诊数': 3530, '死亡数': 3230, '康复数': 26 },
            { '日期': '2020年3月', '确诊数': 2923, '死亡数': 2623, '康复数': 76 },
            { '日期': '2020年4月', '确诊数': 1723, '死亡数': 1423, '康复数': 49 },
            { '日期': '2020年5月', '确诊数': 3792, '死亡数': 3492, '康复数': 323 }
          ]
        }
      }
    },
    mounted(){
        
    }
  }
</script>
<style scoped>
    #container{
        width: 100%;
        height:250px;
    }
    .ve-line{
        height: 200px;
    }
</style>