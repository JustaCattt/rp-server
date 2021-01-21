<template>
  <div id="Pay" :style="backgroundImg">
    <Menu></Menu>
    <div id="box">
      <h1>PAY BILL</h1>
      <form action>
        <div class="item">
          <h3>
            TUITION：
            <span>{{tuition}}</span>
          </h3>
        </div>
        <div class="item">
          <h3>
            DORM FEE：
            <span>{{accPay}}</span>
          </h3>
        </div>
        <div class="item">
          <h3>
            TOTAL：
            <span>{{total}}</span>
          </h3>
        </div>
        <button @click="pay">PAY</button>
      </form>
    </div>
  </div>
</template>

<script>
import Menu from "./Menu";
import axios from "axios";
export default {
  name: "Pay",
  components: {
    Menu
  },
  data() {
    return {
      backgroundImg: {
        backgroundImage:
          "url(" + require("../../assets/img/112541-158165074199b4.jpg") + ")",
        width: "100vw",
        height: "100vh",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center center",
        backgroundSize: "100% 100%"
      },
      tuition: "",
      accPay: "",
      total: ""
    };
  },
  created() {
    this.$axios({
      url: "/payments/get",
      method: "get",
      params: {}
    })
      .then(res => {
        console.log(res.data.payInfo);
        this.tuition = res.data.payInfo.tuition;
        this.accPay = res.data.payInfo.accPay;
        this.total = parseInt(this.tuition) + parseInt(this.accPay) + "元";
      })
      .catch(err => {
        console.log(err);
      });
  },

  methods: {
    pay() {
      this.$axios({
        url: "/pay/save",
        method: "post",
        params: {
          userId: localStorage.getItem("userId"),
          stuId: localStorage.getItem("stuId")
        }
      })
        .then(res => {
          if (res.data.state) {
            console.log(res.data.payerInfo);
            alert("支付成功！");
          } else {
            alert("您已经缴过费了，请勿重复操作！");
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
/* * {
  box-sizing: border-box;
} */
body {
  text-align: center;
  display: flex;
  height: 100vh;
  width: 100%;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
}
#Pay {
  position: absolute;
}
#box {
  width: 35%;
  height: 35%;
  margin: 0 auto;
  margin-top: 6%;
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
  margin-top: 30px;
  margin-right: 80%;
}

#box button {
  margin-top: 30px;
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
    135deg,
    #578bc3,
    skyblue,
    rgb(207, 207, 197),
    sandybrown,
    #db3125
  );
  background-size: 300%;

  border: 0;
  border-radius: 60px;
  box-shadow: 0px 5px 7px rgba(200, 200, 200, 0.8);
}

#box button:hover {
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
@keyframes animate {
  0% {
    background-position: 0%; /*修改背景定位，实现渐变色炫光*/
  }
  50% {
    background-position: 100%;
  }
  100% {
    background-position: 0%;
  }
}

span {
  margin-left: 9%;
  position: fixed;
}
</style>