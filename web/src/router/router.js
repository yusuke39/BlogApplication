import Vue from 'vue'
import VueRouter from 'vue-router'
const AdminLogin = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/adminLogin.vue')
const NewUserRegister = () => import(/* webpackChunkName: 'NewUserRegister' */ '../views/newUserRegister.vue')
const MainTop = () => import(/* webpackChunkName: 'MainTop' */ '../views/mainTop.vue')
const Blog = () => import(/* webpackChunkName: 'Blog' */ '../views/blog.vue')
const AdminTop = () => import(/* webpackChunkName: 'AdminTop' */ '../views/adminTop.vue')
const EditArticle = () => import(/* webpackChunkName: 'EditArticle' */ '../views/editArticle.vue')
const EditAdmin = () => import(/* webpackChunkName: 'EditAdmin' */ '../views/editAdmin')
const GoodArticles = () => import(/* webpackChunkName: 'GoodArticle' */ '../views/goodArticles')
const SaveArticles = () => import(/* webpackChunkName: 'SaveArticles' */ '../views/saveArticles')
const Line = () => import(/* webpackChunkName: 'Line' */ '../views/line')

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
  },
  {
    path: '/goodArticles',
    name: 'goodArticles',
    component: GoodArticles
  },
  {
    path: '/saveArticles',
    name: 'saveArticles',
    component: SaveArticles
  },
  {
    path: '/line',
    name: 'Line',
    component: Line
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
