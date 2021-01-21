import Vue from 'vue'
import Router from 'vue-router'
import Register from '../components/StuPage/Register'
import Login from '../components/StuPage/Login'
import Home from '../components/StuPage/Home'
import StuReg from '../components/StuPage/StuReg'
import Pay from '../components/StuPage/pay'
import Dormitory from '../components/StuPage/Dormitory'

import AdminLogin from '../components/AdminPage/AdminLogin'
import AdminHome from '../components/AdminPage/AdminHome'
import SetStuInfo from '../components/AdminPage/SetStuInfo'
import Payments from '../components/AdminPage/Payments'
import SetDormitory from '../components/AdminPage/SetDormitory'
import PayList from '../components/AdminPage/PayList'
import RegList from '../components/AdminPage/RegList'
import StuList from '../components/AdminPage/StuList'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/home/stureg',
      name: 'StuReg',
      component: StuReg
    },
    {
      path: '/home/pay',
      name: 'Pay',
      component: Pay
    },
    {
      path: '/home/dormitory',
      name: 'Dormitory',
      component: Dormitory
    },





    {
      path: '/adminlogin',
      name: 'AdminLogin',
      component: AdminLogin
    },
    {
      path: '/adminhome',
      name: 'AdminHome',
      component: AdminHome
    },
    {
      path: '/adminhome/setstuinfo',
      name: 'SetStuInfo',
      component: SetStuInfo
    },
    {
      path: '/adminhome/payments',
      name: 'Payments',
      component: Payments
    },
    {
      path: '/adminhome/setdormitory',
      name: 'SetDormitory',
      component: SetDormitory
    },
    {
      path: '/adminhome/paylist',
      name: 'PayList',
      component: PayList
    },
    {
      path: '/adminhome/reglist',
      name: 'RegList',
      component: RegList
    },
    {
      path: '/adminhome/stulist',
      name: 'StuList',
      component: StuList
    }
  ]
})
