import Vue from 'vue'
import VueRouter from 'vue-router'
const AdminLogin = () => import(/* webpackChunkName: 'AdminLogin' */ '../views/adminLogin.vue')
const NewUserRegister = () => import(/* webpackChunkName: 'NewUserRegister' */ '../views/newUserRegister.vue')
const MainTop = () => import(/* webpackChunkName: 'MainTop' */ '../views/mainTop.vue')
const Blog = () => import(/* webpackChunkName: 'Blog' */ '../views/blog.vue')
const AdminTop = () => import(/* webpackChunkName: 'AdminTop' */ '../views/adminTop.vue')
const EditArticle = () => import(/* webpackChunkName: 'EditArticle' */ '../views/editArticle.vue')
const EditAdmin = () => import(/* webpackChunkName: 'EditAdmin' */ '../views/editAdmin')
const CreateArticle = () => import(/* webpackChunkName: 'CreateArticle' */ '../views/createArticle')
const BlogDetail = () => import(/* webpackChunkName: 'BlogDetail' */ '../views/blogDetail')

Vue.use(VueRouter)

const routes = [
  {
    path: '/adminLogin',
    name: 'adminLogin',
    component: AdminLogin
  },
  {
    path: '/userRegister',
    name: 'NewUserRegister',
    component: NewUserRegister
  },
  {
    path: '/mainTop',
    name: 'MainTop',
    component: MainTop
  },
  {
    path: '/blog',
    name: 'Blog',
    component: Blog
  },
  {
    path: '/adminTop',
    name: 'AdminTop',
    component: AdminTop
  },
  {
    path: '/editArticle',
    name: 'EditArticle',
    component: EditArticle
  },
  {
    path: '/editAdmin',
    name: 'editAdmin',
    component: EditAdmin
  },
  {
    path: '/createArticle',
    name: 'CreateArticle',
    component: CreateArticle
  },
  {
    path: '/blogDetail',
    name: 'BlogDetail',
    component: BlogDetail
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
