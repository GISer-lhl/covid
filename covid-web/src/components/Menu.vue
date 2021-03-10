<template>
  <div class="container">
    <el-menu
        :default-active="this.$route.path"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#303133"
        text-color="#fff"
        router
        active-text-color="#ffd04b">
        <el-menu-item index="/main">中国疫情总览</el-menu-item>
        <el-submenu index="2">
            <template slot="title">疫情发展</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
            <el-menu-item index="2-3">选项3</el-menu-item>
            <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项1</el-menu-item>
            <el-menu-item index="2-4-2">选项2</el-menu-item>
            <el-menu-item index="2-4-3">选项3</el-menu-item>
            </el-submenu>
        </el-submenu>
        <el-menu-item index="/track">疫情追踪</el-menu-item>
        <el-menu-item index="4">世界疫情总览</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
    name:"Menu",
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style scoped>
  /* .container{
      height: 100px;
  } */
</style>