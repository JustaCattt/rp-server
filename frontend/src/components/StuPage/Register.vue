<template>
  <div id="login-box">
    <h1>Register</h1>
    <form>
      <div class="item">
        <input type="text" placeholder="Username" v-model="user.username" />
      </div>
      <div class="item">
        <input type="password" placeholder="Password" v-model="user.password" />
      </div>
      <div class="item">
        <input type="text" placeholder="Student ID" v-model="user.stuId" />
      </div>
      <div class="item">
        <input type="text" placeholder="Real Name" v-model="user.realName" />
      </div>
      <div class="item">
        <input type="text" placeholder="VerificationCode" v-model="code" />
      </div>
      <button @click="saveUserInfo">Register</button>
      <div class="msg">
        Already have account?
        <a href="#/login">Sign in</a>
      </div>
    </form>
    <img src="api/user/getImage" id="img-vcode" />
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Register",
  data: function() {
    return {
      user: {
        username: "",
        password: "",
        stuId: "",
        realName: ""
      },
      code: "",
    };
  },
  methods: {
    saveUserInfo() {
      if(!this.user.username){
        alert('用户名不能为空');
        return;
      }
      if(!this.user.password){
        alert('密码不能为空');
        return;
      }
      if(!this.code){
        alert('请输入验证码');
        return;
      }
      let data = {
        username: this.user.username,
        password: this.user.password,
        stuId: this.user.stuId,
        realName: this.user.realName
      };
      this.$axios({
        url: "/user/register",
        method: "post",
        params: {
          code: this.code
        },
        data: JSON.stringify(data),
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        }
      })
        .then(res => {
          if(res.data.state){
            alert(res.data.msg+"点击确认跳转登录页面");
            location.href="#/login";
          }else{
            alert(res.data.msg);
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
  }
};
</script>

<style scoped>
#login-box {
  width: 15%;
  height: 46%;
  margin: 0 auto;
  margin-top: 12%;
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
  margin-top: 15px;
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
  margin-top: 45px;
  width: 120px;
  height: 35px;
  font-size: 18px;
  font-weight: 700;
  color: #ffffff;

  background: linear-gradient(
    45deg,#db3125,sandybrown, 
  rgb(207, 207, 197),skyblue,#578bc3);
  background-size: 100%;

  /* background: linear-gradient(
    135deg,#578bc3,skyblue, 
  rgb(207, 207, 197),sandybrown,#db3125);
  background-size: 105%; */
  
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

#login-box .msg {
  text-align: center;
  line-height: 70px;
  color: sandybrown;
  text-shadow: 0px 5px 7px sandybrown;
}

#login-box .msg a {
  text-decoration-line: none;
  color: #a6c1ee;
  text-shadow: 0px 5px 7px #a6c1ee;
}

#img-vcode {
  width: 58px;
  height: 31px;
  position: relative;
  top: -183px;
  left: 71px;
}
</style>