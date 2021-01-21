<template>
  <div id="login-box">
    <h1>Admin Login</h1>
    <form>
      <div class="item">
        <input type="text" placeholder="Username" v-model="user.username" />
      </div>
      <div class="item">
        <input type="password" placeholder="Password" v-model="user.password" />
      </div>
      <a id="admin" href="#/login">Student Login</a>
      <button @click="login">Login</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Login",
  data: function() {
    return {
      user: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    login() {
      let params = {
        username: this.user.username,
        password: this.user.password
      };
      this.$axios({
        url: "/admin/login",
        method: "post",
        data: JSON.stringify(params),
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        }
      })
        .then(res => {
          console.log(res.data);
          localStorage.setItem("adminId: ",res.data.userId);//将userId存到localstorge中，作为后续用户登录标识
          if(res.data.state){
            alert(res.data.msg + "点击确认进入主页");
            location.href="#/adminhome"
          }else{
            alert(res.data.msg);
          }
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>

<style scoped>
#login-box {
  width: 15%;
  height: 30%;
  margin: 0 auto;
  margin-top: 15%;
  text-align: center;
  background: #00000070;
  padding: 20px 50px;
  border-radius: 25px;
}

#login-box h1 {
  color: #fff;
  /* text-shadow: 0px 5px 7px sandybrown; */
}

#login-box form {
  color: #fff;
}

#login-box form .item {
  margin-top: 25px;
}

#login-box form .item i {
  font-size: 18px;
  color: #fff;
}

#login-box form .item input {
  width: 180px;
  font-size: 18px;
  border: 0;
  border-bottom: 2px solid #ffffff;
  padding: 5px 10px;
  background: #ffffff00;
  color: #fff;
}

#login-box button {
  margin-top: 15px;
  width: 120px;
  height: 35px;
  font-size: 18px;
  font-weight: 700;
  color: #ffffff;

  /* background: linear-gradient(
    135deg,#db3125,sandybrown, 
  rgb(207, 207, 197),skyblue,#578bc3);
  background-size: 300%; */

  background: linear-gradient(
    45deg,#578bc3,skyblue, 
  rgb(207, 207, 197),sandybrown,#db3125);
  background-size: 105%;
  
  border: 0;
  border-radius: 60px;
  box-shadow: 0px 5px 7px rgba(200, 200, 200, 0.8);
}

#login-box button:hover {
  cursor: pointer;
  animation: cute 0.5s;
  /* animation: animate 4s linear infinite alternate; 动画: 名称 时间 线性 循环 播放完回退播放 */
}

/*Q弹按钮*/
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

/*渐变按钮*/
@keyframes animate{
  0%{
    background-position: 0%; /*修改背景定位，实现渐变色炫光*/
  }
  50%{
    background-position: 100%;
  }
  100%{
    background-position: 0%;
  }
}

#admin{
  text-decoration-line: none;
  color: #a6c1ee;
  margin-left: 50%;
  line-height: 45px;
}
</style>