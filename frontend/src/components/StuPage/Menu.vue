<template>
  <div id="Menu">
    <nav class="nav">
      <a href="#/home" class="nav-item is-active" active-color="orange">HOME</a>
      <a href="#/home/stureg" class="nav-item" active-color="green">REGISTER</a>
      <a href="#/home/pay" class="nav-item" active-color="blue">PAY</a>
      <a href="#/home/dormitory" class="nav-item" active-color="red">DORMITORY</a>
      <a href="#/login" class="nav-item" active-color="rebeccapurple" @click="init">EXIT</a>
      <span class="nav-indicator"></span>
    </nav>
  </div>
</template>

<script>
export default {
  name: "Menu",
  methods:{
    init(){
      localStorage.clear();//清除登录记录
    }
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}
body {
  text-align: center;
  display: flex;
  height: 100vh;
  width: 100%;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
}
.nav {
  display: inline-flex;
  position: relative;
  overflow: hidden;
  max-width: 100%;
  background-color: #fff;
  padding: 0 20px;
  border-radius: 40px;
  box-shadow: 0 10px 40px rgba(159, 162, 177, 0.8);
  margin: 2% 35%;
}
.nav-item {
  color: #83818c;
  padding: 20px;
  text-decoration: none;
  transition: 0.3s;
  margin: 0 6px;
  z-index: 1;
  font-family: "Roboto Condensed", sans-serif;
  font-weight: 500;
  position: relative;
}
.nav-item:before {
  content: "";
  position: absolute;
  bottom: -6px;
  left: 0;
  width: 100%;
  height: 5px;
  background-color: #dfe2ea;
  border-radius: 8px 8px 0 0;
  opacity: 0;
  transition: 0.3s;
}
.nav-item:not(.is-active):hover:before {
  opacity: 1;
  bottom: 0;
}
.nav-item:not(.is-active):hover {
  color: #333;
}
.nav-indicator {
  position: absolute;
  left: 0;
  bottom: 0;
  height: 4px;
  transition: 0.4s;
  height: 5px;
  z-index: 1;
  border-radius: 8px 8px 0 0;
}
@media (max-width: 580px) {
  .nav {
    overflow: auto;
  }
}
</style>