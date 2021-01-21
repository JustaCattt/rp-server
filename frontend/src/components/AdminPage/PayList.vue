<template>
  <div id="PayList" :style="backgroundImg">
    <AdminMenu></AdminMenu>
    <div id="login-box">
      <h1>PAYERS LIST</h1>
      <form>
        <table id="customers">
          <tr class="header">
            <th>ID</th>
            <th>USERNAME</th>
            <th>STUDENT ID</th>
            <th>REAL NAME</th>
          </tr>

          <tr v-for="(payer,index) in payers" :key="index">
            <td>{{payer.userId}}</td>
            <td>{{payer.username}}</td>
            <td>{{payer.stuId}}</td>
            <td>{{payer.realName}}</td>
          </tr>
        </table>
      </form>
    </div>
  </div>
</template>

<script>
import AdminMenu from './AdminMenu'
export default {
  name: "PayList",
  components: {
    AdminMenu
  },
  data() {
    return {
      backgroundImg: {
        backgroundImage:
          "url(" +
          require("../../assets/img/北极光星空夜景4k风景壁纸3840x2160_彼岸图网.jpg") +
          ")",
        width: "100vw",
        height: "100vh",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center center",
        backgroundSize: "100% 100%"
      },
      payers:[]
    };
  },
  created() {
    this.$axios({
      url: "/pay/getList",
      method: "get"
    })
      .then(res => {
        console.log(res.data.payerInfoList);
        this.payers = res.data.payerInfoList;
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>

<style>
#PayList{
  position: absolute;
}
#login-box {
  width: 35%;
  height: 500px;
  margin: 0 auto;
  margin-top: 3%;
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

#customers {
  width: 100%;
  border-collapse: collapse;
}

#customers td,
#customers th {
  font-size: 1em;
  border: 1px solid #c0c0c060;
  padding: 3px 7px 2px 7px;
}

#customers th {
  font-size: 1.1em;
  text-align: left;
  padding-top: 5px;
  padding-bottom: 4px;
  background-color: #c0c0c060;
  color: #ffffff;
}

</style>