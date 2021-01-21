<template>
  <div id="StuList" :style="backgroundImg">
    <AdminMenu></AdminMenu>
    <div id="login-box">
      <h1>STUDENTS LIST</h1>
      <form>
        <table id="customers">
          <tr>
            <th>STUDENT ID</th>
            <th>NAME</th>
            <th>GRADE</th>
            <th>MAJOR</th>
            <th>COLLEGE</th>
            <th>CLASS</th>
            <th>DELETE</th>
          </tr>

          <tr v-for="(student,index) in students" :key="student.stuId">
            <td>{{student.stuId}}</td>
            <td>{{student.name}}</td>
            <td>{{student.grade}}</td>
            <td>{{student.major}}</td>
            <td>{{student.college}}</td>
            <td>{{student.claSs}}</td>
            <td>
              <button id="remove" @click="remove(index)">删除</button>
            </td>
          </tr>
        </table>
        <button id="init" @click="init">INIT</button>
      </form>
    </div>
  </div>
</template>

<script>
import AdminMenu from "./AdminMenu";
export default {
  name: "PayList",
  components: {
    AdminMenu
  },
  inject: ["reload"],
  methods: {
    remove(index) {
      console.log(index);
      console.log(this.students[index].stuId);
      var stuId = this.students[index].stuId;
      this.$axios({
        url: "stu/remove",
        method: "post",
        params: {
          stuId
        }
      })
        .then(res => {
          if (res.data.state) {
            this.reload(); //页面重载
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
    init() {
      this.$axios({
        url: "stu/init",
        method: "post",
        params: {}
      })
        .then(res => {
          console.log(res.data)
          if (res.data.state) {
            this.reload(); //页面重载
          }
        })
        .catch(err => {
          console.log(err);
        });
    }
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
      students: []
    };
  },
  created() {
    this.$axios({
      url: "/stu/getList",
      method: "get"
    })
      .then(res => {
        console.log(res.data.stuInfoList);
        this.students = res.data.stuInfoList;
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>

<style>
#PayList {
  position: absolute;
}
#login-box {
  width: 50%;
  height: 58%;
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

#remove {
  border: none;
  background: transparent;
  color: #fff;
  font-size: 1em;
}

#remove:hover {
  cursor: pointer;
  animation: cute 0.5s;
  /* animation: animate 4s linear infinite alternate; 动画: 名称 时间 线性 循环 播放完回退播放 */
}

#login-box #init {
  position: absolute;
  top: 74%;
  /* top: 40%; */
  /* margin-top: 17%; */
  margin-left: -4%;
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

#login-box #init:hover {
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
</style>