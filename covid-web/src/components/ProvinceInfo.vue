<template>
    <el-row class="container">
        <el-col :span="24">
            <el-row class='pTitle'>
                {{this.provinceInfo.name}}
            </el-row>
            <el-row class="pContent" style="color:red">
                <el-col :span="12">
                    确诊人数：
                </el-col>
                <el-col :span="12">
                    {{this.provinceInfo.confirmed}}
                </el-col>                
            </el-row>
            <el-row class="pContent">
                <el-col :span="12">
                    死亡人数：
                </el-col>
                <el-col :span="12">
                    {{this.provinceInfo.death}}
                </el-col>                
            </el-row>
            <el-row class="pContent" style="color:green;">
                <el-col :span="12">
                    康复人数：
                </el-col>
                <el-col :span="12">
                    {{this.provinceInfo.recovered}}
                </el-col>                
            </el-row>
        </el-col>
    </el-row>
</template>
<script>
export default {
    name:'ProvinceInfo',
    props:{
        provinceInfo:{
            type: Object,
            default: function () {
                return { 
                    name:'北京',
                    confirmed:100000,
                    death:0,
                    recovered:0
                }
            }
        }
    },
    data(){
        return{
            provinceInfoD:this.provinceInfo
        }
    },
    methods:{
        init(){

        }
    }
}
</script>
<style scoped>
    .container{
        width:100%;
        border:1px #fff solid;
        border-radius: 3px;
        background-color: #303133;
        color: white;
    }
    .pTitle{
        width:100%;
        font-size: 2rem;
        font-family: '黑体';
        margin: 8% 1%;
    }
    .pContent{
        width:100%;
        padding: 8% 1%;
        font-size: 1rem;
        font-family: '黑体';
    }
</style>