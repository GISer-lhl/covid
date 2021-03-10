<template>
    <el-row class='container'>
        <el-row class='lefttop'>
            <el-col :span=24>
                <el-carousel :interval="3000" height='138'>
                    <el-carousel-item>
                       <el-card class='confirmNum' shadow='always'>
                           <p style='font-size:15px'>中国人口</p>
                           {{confirmedTotalNum}}
                       </el-card>
                    </el-carousel-item>
                    <el-carousel-item>
                       <el-card class='confirmNum' shadow='always'>
                           <p style='font-size:15px'>世界人口</p>
                           {{confirmedTotalNum}}
                       </el-card>
                    </el-carousel-item>
                    <el-carousel-item>
                       <el-card class='confirmNum' shadow='always'>
                           <p style='font-size:15px'>美国人口</p>
                           {{confirmedTotalNum}}
                       </el-card>
                    </el-carousel-item>
                </el-carousel>
            </el-col>
        </el-row>
        <el-row class='leftbottom'>
            <el-col :span=24  class='provinceConfirmedSort'>
                <div class="title">现存人数</div>
                <dv-scroll-ranking-board :config="config"/>
            </el-col>
        </el-row>
    </el-row>
</template>
<script>
import {getConfirmNum} from '@/api/main'
export default {
    name:'LeftAsider',
    data(){
        return{
            confirmedTotalNum:1236,
            config:{
                rowNum:6,
                data: [
                    {name: '周口',value: 55},
                    {name: '南阳',value: 120},
                    {name: '西峡',value: 78},
                    {name: '驻马店',value: 66},
                    {name: '新乡',value: 80},
                    {name: '青岛',value: 55},
                    {name: '济南',value: 120},
                    {name: '滨州',value: 78},
                    {name: '烟台',value: 66},
                    {name: '菏泽',value: 80}
                ],
                unit: '个'
            }
        }
    },
    conputed(){
        document.getElementsByClassName('el-carousel__container').style.height=138+'px'
    },
    mounted(){
        this.init()
    },
    methods:{
        init(){
            getConfirmNum().then(res=>{
                console.log(res)
            })
        }
    }
}
</script>
<style scoped>

    .el-carousel__item h3 {
        color: #475669;
        font-size: 18px;
        opacity: 0.75;
        margin: 0;
    }

    .el-carousel{
        height:140px;
        overflow: hidden;
    }
    .container{
        
    }
    .lefttop{
        height:140px;
        margin: 2%;
    }
    .confirmNum{
        height: 136px;
        font-family: '黑体';
        font-size: 2.5rem;
        font-weight: bolder;
        color: red;
        background-color: #303133;
    }
    .leftbottom{
        margin: 2%;
        color: #fff;
    }
    .title{
        margin: 1%;
        text-align: center;
        font-size: 1rem;
        font-family: '黑体';
        color: red;
    }
    .provinceConfirmedSort{
        height:440px;
        background-color: #303133;
        border: 1px #fff solid;
        border-radius: 3px;
    }
</style>