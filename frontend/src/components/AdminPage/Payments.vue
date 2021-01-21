<template>
  <div id="Payments" :style="backgroundImg">
    <AdminMenu></AdminMenu>
    <div id="login-box">
      <h1>UPDATE PAYMENTS</h1>
      <form>
        <div class="item">
          <input type="text" placeholder="TUITION" v-model="tuition" />
        </div>
        <div class="item">
          <input type="text" placeholder="DORM FEE" v-model="accPay" />
        </div>
        <button @click="savePayInfo">SUBMIT</button>
      </form>
    </div>
  </div>
</template>

<script>
import AdminMenu from "./AdminMenu";
export default {
  name: "Payments",
  components: {
    AdminMenu
  },
  inject: ['reload'],
  data: function() {
    return {
      backgroundImg: {
        backgroundImage:
          "url(" +
          require("../../assets/img/星空背景绘画夜空4k壁纸_彼岸图网.jpg") +
          ")",
        width: "100vw",
        height: "100vh",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center center",
        backgroundSize: "100% 100%"
      },
      tuition: "",
      accPay: ""
    };
  },
  methods: {
    savePayInfo() {
      if (!this.tuition) {
        alert("学费不能为空");
        return;
      }
      if (!this.accPay) {
        alert("住宿费不能为空");
        return;
      }
      let data = {
        tuition: this.tuition,
        accPay: this.accPay
      };
      this.$axios({
        url: "/payments/update",
        method: "post",
        params: {},
        data: JSON.stringify(data),
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        }
      })
        .then(res => {
          console.log(res.data);
          if(res.data.state){
            alert(res.data.msg)
            this.reload()   //页面重载
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
#SetPayments {
  position: absolute;
}
#login-box {
  width: 25%;
  height: 34%;
  margin: 0 auto;
  margin-top: 7%;
  text-align: center;
  background: #00000070;
  padding: 20px 50px;
  border-radius: 25px;
}

#login-box h1 {
  color: #fff;
}

#login-box form {
  color: #fff;
}

#login-box form .item {
  margin-top: 45px;
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
  width: 130px;
  height: 40px;
  font-size: 18px;
  font-weight: 700;
  color: #ffffff90;

  /* background: linear-gradient(
    135deg,#db3125,sandybrown, 
  rgb(207, 207, 197),skyblue,#578bc3);
  background-size: 300%; */

  background: linear-gradient(
    135deg,#578bc3,skyblue, 
  rgb(207, 207, 197),sandybrown,#db3125);
  background-size: 300%;
  
  border: 0;
  border-radius: 60px;
  box-shadow: 0px 5px 7px rgba(200, 200, 200, 0.8);
}

#login-box button:hover {
  cursor: pointer;
  /* animation: cute 0.5s; */
  animation: animate 4s linear infinite alternate; /*动画: 名称 时间 线性 循环 播放完回退播放*/
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
</style>