import Vue from 'vue'
import VueRouter from 'vue-router'
const AdminLogin = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/adminLogin.vue')
const NewUserRegister = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/newUserRegister.vue')
const MainTop = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/mainTop.vue')

Vue.use(VueRouter)

const routes = [
  {
    path: '/adminLogin',
    name: 'adminLogin',
    component: AdminLogin
  },
  {
    path: '/userRegister',
    name: 'userRegister',
    component: NewUserRegister
  },
  {
    path: '/mainTop',
    name: 'mainTop',
    component: MainTop
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
