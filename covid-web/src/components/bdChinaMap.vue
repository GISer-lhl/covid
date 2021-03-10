<template>
    <ve-heatmap class='heatmap' :data="chartData" :settings="chartSettings" :events="chartEvents"></ve-heatmap>
</template>

<script>
  export default {
    data () {
      this.chartSettings = {
        position: 'china',
        type: 'map',
        geo: {
          show:true,
          roam:true,
          label: {
            emphasis: {
              show: true
            },
            //formatter:'{b}:{c}',
            color:'#fff'
          },
          itemStyle: {
            normal: {
              areaColor: 'blue',
              borderColor: '#01FFFF',
              shadowColor: '#01FFFF',
              color:'#fff'
            },
            emphasis: {
              areaColor: '#795DFF'
            }
          }
        },
        legend:{
          textStyle:{
            color:'#fff'
          }
        }
      }
      this.chartEvents = {
        click: (v) => {
          alert(v.name)
          this.$emit('getProvinceName',v.name)
        }
      }
      return {
        chartData: {}
      }
    },
    mounted(){
      this.init()
    },
    methods:{
      init(){
        var chartDatas={
          columns: ['lat', 'lng', '人数'],
          rows: [
            { 'lat': 115.892151, 'lng': 28.676493, '人数': 1000 },
            { 'lat': 117.000923, 'lng': 36.675807, '人数': 400 },
            { 'lat': 113.665412, 'lng': 34.757975, '人数': 800 },
            { 'lat': 114.298572, 'lng': 30.584355, '人数': 200 },
            { 'lat': 112.982279, 'lng': 28.19409, '人数': 100 },
            { 'lat': 113.280637, 'lng': 23.125178, '人数': 300 },
            { 'lat': 110.33119, 'lng': 20.031971, '人数': 800 },
            { 'lat': 104.065735, 'lng': 30.659462, '人数': 700 },
            { 'lat': 108.948024, 'lng': 34.263161, '人数': 300 },
            { 'lat': 103.823557, 'lng': 36.058039, '人数': 500 }
          ]
        }
        this.chartData=chartDatas
      }
    }
  }
</script>
<style scoped>
    .heatmap{
        margin: 1%;
        /* border:1px #fff solid;
        border-radius: 3px; 
        background-color: #303133;*/
        height:350px;
        color: white;
    }
</style>