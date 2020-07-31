import Vue from 'vue'
import VueRouter from 'vue-router'
const AdminLogin = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/adminLogin.vue')
const UserHeader = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/userHeader.vue')
const AdminHeader = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/adminHeader.vue')

Vue.use(VueRouter)

const routes = [
  {
    path: '/adminLogin',
    name: 'adminLogin',
    component: AdminLogin
  },
  {
    path: '/header',
    name: 'userHeader',
    component: UserHeader
  },
  {
    path: '/adminHeader',
    name: 'adminHeader',
    component: AdminHeader
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
