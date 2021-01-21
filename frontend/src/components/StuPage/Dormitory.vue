<template>
  <div id="GetDormitory" :style="backgroundImg">
    <Menu></Menu>
    <div id="box">
         <h1>DORMITORY</h1>
    <form action>
      <div class="item">
        <h3>
          BUILD：
          <span>{{build}}</span>
        </h3>
      </div>
      <div class="item">
        <h3>
          ROOM：
          <span>{{room}}</span>
        </h3>
      </div>
      <!-- <div class="msg">
        <a href="#/home">返回主页</a>
      </div> -->
    </form>
    </div>
  </div>
</template>

<script>
import Menu from './Menu'
import axios from "axios";
export default {
  name: "GetDormitory",
  components:{
    Menu
  },
  data() {
    return {
      backgroundImg: {
        backgroundImage:
          "url(" +
          require("../../assets/img/女子车站4k动漫壁纸_彼岸图网.jpg") +
          ")",
        width: "100vw",
        height: "100vh",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center center",
        backgroundSize: "100% 100%",
      },
      build: "",
      room: ""
    };
  },
    created() {
    this.$axios({
      url: "/dormitory/get",
      method: "get",
      params: {
          stuId: localStorage.getItem("stuId")
      }
    }).then(res => {
      console.log(res.data.dormInfo);
      this.build = res.data.dormInfo.build;
      this.room = res.data.dormInfo.room;
    }).catch((err)=>{
      console.log(err);
    });
  },

};
</script>

<style>
#GetDormitory{
  position: absolute;
}
#box {
  width: 30%;
  height: 25%;
  margin: 0 auto;
  margin-top: 9%;
  text-align: center;
  background: #00000070;
  padding: 20px 50px;
  border-radius: 25px;
}
#box form {
  color: #fff;
}

#box h1 {
  color: #fff;
  /* text-shadow: 0px 5px 7px sandybrown; */
}

h3 {
  color: #fff;
  /* text-shadow: 0px 5px 7px sandybrown; */
}

#box form .item {
  margin-top: 40px;
  margin-right: 80%;
}

#box button {
  margin-top: 30px;
  width: 130px;
  height: 36px;
  font-size: 20px;
  font-weight: 700;
  color: #fff;
  background-image: linear-gradient(to right, sandybrown 0%, #578bc3 100%);
  /* background-image: linear-gradient(to right, #fbc2eb 0%, #a6c1ee 100%); */
  border: 0;
  border-radius: 15px;
  box-shadow: 0px 5px 7px rgba(200, 200, 200, 0.8);
  text-shadow: 0px 5px 7px sandybrown;
  /* box-shadow: 0px 5px 7px ; */
}

#box button:hover {
  cursor: pointer;
  animation: cute 0.5s;
}

@keyframes cute {
  0%,
  100% {
    transform: scale(1, 1);
  }

  25%,
  75% {
    transform: scale(1.1, 0.9);
  }

  50% {
    transform: scale(0.9, 1.1);
  }
}

/* #box .msg a {
  text-decoration-line: none;
  color: #578bc3;
  text-shadow: 0px 5px 7px #578bc3;
  margin-left: 80%;
} */

span {
  margin-left: 9%;
  position: fixed;
}
</style>