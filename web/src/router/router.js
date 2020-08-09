import Vue from 'vue'
import VueRouter from 'vue-router'
const AdminLogin = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/adminLogin.vue')
const NewUserRegister = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/newUserRegister.vue')
const MainTop = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/mainTop.vue')
const Blog = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/blog.vue')
const AdminTop = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/adminTop.vue')
const EditArticle = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/editArticle.vue')
const EditAdmin = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/editAdmin.vue')

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
  },
  {
    path: '/blog',
    name: 'blog',
    component: Blog
  },
  {
    path: '/adminTop',
    name: 'adminTop',
    component: AdminTop
  },
  {
    path: '/editArticle',
    name: 'editArticle',
    component: EditArticle
  },
  {
    path: '/editAdmin',
    name: 'editAdmin',
    component: EditAdmin
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
