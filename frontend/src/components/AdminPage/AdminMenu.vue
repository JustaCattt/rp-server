<template>
  <div id="AdminMenu">
    <nav class="nav">
      <a href="#/adminhome" class="nav-item is-active" active-color="orange">HOME</a>
      <a href="#/adminhome/setstuinfo" class="nav-item" active-color="green">IMPORT</a>
      <a href="#/adminhome/payments" class="nav-item" active-color="blue">PAYMENT</a>
      <a href="#/adminhome/setdormitory" class="nav-item" active-color="red">DORMITORY</a>
      <a
        @mouseover="show"
        @mouseout="hidden"
        href="#/adminhome/stulist"
        class="nav-item"
        active-color="red"
      >VIEW LIST</a>
      <a href="#/login" class="nav-item" active-color="rebeccapurple" @click="init">EXIT</a>
      <span class="nav-indicator"></span>
    </nav>
    <div class="menu" v-show="isShow" @mouseover="onTop" @mouseout="out">
      <li id="li1">
        <a href="#/adminhome/paylist">PAYERS</a>
      </li>
      <li id="li2">
        <a href="#/adminhome/reglist">REGISTRARS</a>
      </li>
      <li id="li3">
        <a href="#/adminhome/stulist">STUDENTS</a>
      </li>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminMenu",
  data() {
    return {
      isShow: false
    };
  },
  methods: {
    show() {
      this.isShow = true;
    },
    hidden() {
      this.isShow = false;
    },
    onTop() {
      this.isShow = true;
    },
    out() {
      this.isShow = false;
    },
    init(){
      localStorage.clear();
    }
  }
};
</script>

<style scoped>
.menu {
  position: absolute;
  background-color: #ffffff90;
  width: 100px;
  height: 135px;
  margin: 0 57.65%;
  margin-top: -2%;
}

.menu #li1 {
  text-align: left;
  position: absolute;
  list-style: none;
  margin: 10px 21px;
}
.menu #li2 {
  text-align: left;
  position: absolute;
  list-style: none;
  margin: 55px 2px;
}
.menu #li3 {
  text-align: left;
  position: absolute;
  list-style: none;
  margin: 100px 9px;
}

.menu #li1 a {
  text-decoration-line: none;
  font-family: "Roboto Condensed", sans-serif;
  font-size: 16px;
  color: #000000;
}

.menu #li2 a {
  text-decoration-line: none;
  font-family: "Roboto Condensed", sans-serif;
  font-size: 16px;
  color: #000000;
}

.menu #li3 a {
  text-decoration-line: none;
  font-family: "Roboto Condensed", sans-serif;
  font-size: 16px;
  color: #000000;
}

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
  /* max-width: 100%; */
  width: 40%;
  background-color: #fff;
  padding: 0 20px;
  border-radius: 40px;
  box-shadow: 0 10px 40px rgba(159, 162, 177, 0.8);
  margin: 2% 30%;
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