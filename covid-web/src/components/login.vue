<template>
    <el-row style="margin-top:100px;">
        <el-col :span="8">
            <input type="text" name="name" id="" placeholder="name">
        </el-col>
        <el-col :span="8">
            <input type="text" name="psw" id="" placeholder="password">
        </el-col>
        <el-col :span="8">
            <input type="button" value="login" @click="login">
        </el-col>
    </el-row>
</template>

<script>
import {login} from '@/api/login'
export default {
    name:'Login',
    data(){
        return{

        }
    },
    mounted(){
        this.init()
    },
    methods:{
        init(){

        },
        login(){
            login('admin','123').then(res=>{
                console.log(res)
            })
        }
    }
}
</script>

<style scoped>

</style>