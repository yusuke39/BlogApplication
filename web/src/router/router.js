import Vue from 'vue'
import VueRouter from 'vue-router'
const AdminLogin = () => import(/* webpackChunkName: 'AdminLogin' */'../views/adminLogin.vue')

Vue.use(VueRouter)

const routes = [
  {
    path: '/adminLogin',
    name: 'adminLogin',
    component: AdminLogin
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
