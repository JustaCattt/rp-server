<template>
  <div id="app">
    <router-view v-if="isRouterAlive" />
  </div>
</template>

<script>
export default {
  name: "App",
  provide(){
    return{
      reload: this.reload   //定义页面重载函数
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },
  methods:{
    reload(){
      this.isRouterAlive = false
      this.$nextTick(function(){
        this.isRouterAlive = true
      })
    }
  }
};
</script>

<style>
#app {
  background-image: url(./assets/img/221228-15574975489aa1.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%;
  height: 100%;
  position: fixed;
  width: 100%;
}
</style>
