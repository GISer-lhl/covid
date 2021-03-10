<template>
    <el-row class='container'>
        <el-carousel :interval="5000" style='height:600px;border: 1px #fff solid; border-radius: 3px;'>
            <el-carousel-item  style='height:570px;'>
                <el-row class='right'>
                    <el-col :span=24 class='provinceDeathSort' >
                        <div class="title">死亡人数</div>
                        <dv-scroll-ranking-board :key='0' :config="configDeath"/>
                    </el-col>
                </el-row>
            </el-carousel-item>
            <el-carousel-item  style='height:570px;'>
                <el-row class='right'>
                    <el-col :span=24 class='provinceDeathSort' >
                        <div class="title" style="color:green;">康复人数</div>
                        <dv-scroll-ranking-board :key='1' :config="configRecoveryed"/>
                    </el-col>
                </el-row>
            </el-carousel-item>
        </el-carousel>
    </el-row>
</template>
<script>
export default {
    name:'RightAsider',
    data(){
        return{
            configDeath:{
                rowNum:8,
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
            },
            configRecoveryed:{
                rowNum:8,
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
        //document.getElementsByClassName('el-carousel__container').style.height=138+'px'
    },
    methods:{
        init(){

        }
    }
}
</script>
<style scoped>

    .container{
        
    }
    .right{
        /* margin: 2%; */
    }
    .provinceDeathSort{
        height:600px;
        background-color: #303133;
    }
    .title{
        margin: 1%;
        text-align: center;
        font-size: 1rem;
        font-family: '黑体';
        color: #fff;
    }
</style>