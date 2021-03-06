import Vue from 'vue'
import App from './App.vue'
import router from './router/router.js'
import store from './store/index.js'
import ElementUI from 'element-ui'
import locale from 'element-ui/lib/locale/lang/ja'
import 'element-ui/lib/theme-chalk/index.css'
import vuetify from './plugins/vuetify'

Vue.config.productionTip = false
Vue.use(ElementUI, { locale })

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
