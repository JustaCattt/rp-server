<template>
  <div id="AdminHome" :style="backgroundImg">
    <AdminMenu></AdminMenu>
    <h1 data-spotlight="Welcome To My System !">Welcome To My System</h1>
  </div>
</template>

<script>
import AdminMenu from './AdminMenu'
export default {
  name: "AdminHome",
  components: {
    AdminMenu
  },
  data() {
    return {
      backgroundImg: {
        backgroundImage:
          "url(" +
          require("../../assets/img/天空夕阳插画风景4k动漫壁纸3840x2160_彼岸图网.jpg") +
          ")",
        width: "100vw",
        height: "100vh",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center center",
        backgroundSize: "100% 100%"
      }
    };
  }
};
</script>

<style scoped>
html {
  font-size: 15px;
}

body {
  background-color: #222;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

h1 {
  color: #333;
  font-family: Helvetica;
  margin: 150px;
  padding: 100px;
  font-size: 8rem;
  letter-spacing: -0.3rem;
  position: relative;
}

h1::after {
  content: attr(data-spotlight);
  color: transparent;
  position: absolute;
  top: 100px;
  left: 100px;
  -webkit-clip-path: ellipse(100px 100px at 0% 50%);
  clip-path: ellipse(100px 100px at 0% 50%);
  animation: spotlight 5s infinite;
  background-image: url(https://images.unsplash.com/photo-1579547621869-0ddb5f237392?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80);
  background-size: 150%;
  background-position: center center;
  -webkit-background-clip: text;
  background-clip: text;
}

@keyframes spotlight {
  0% {
    -webkit-clip-path: ellipse(100px 100px at 0% 50%);
    clip-path: ellipse(100px 100px at 0% 50%);
  }
  
  50% {
    -webkit-clip-path: ellipse(100px 100px at 100% 50%);
    clip-path: ellipse(100px 100px at 100% 50%);
  }
  
  100% {
    -webkit-clip-path: ellipse(100px 100px at 0% 50%);
    clip-path: ellipse(100px 100px at 0% 50%);
  }
}
</style>