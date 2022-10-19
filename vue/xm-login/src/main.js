// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store';
import ElementUI from 'element-ui'
import Axios from 'axios'
import VueAxios from 'vue-axios'
// element-ui所提供的css样式
import 'element-ui/lib/theme-chalk/index.css'

import Header from './components/common/Header'//引入自定义组件

//自定义公共工具js
import utils from '@/utils/util.js'
Vue.prototype.utils=utils

Vue.config.productionTip = false
Vue.use(ElementUI)
//VueAxios,Axios位置不能交换否则会报错TypeError
Vue.use(VueAxios,Axios)

Vue.use(Header)//使用自定义组件
Vue.component("Header",Header)//初始化自定义组件

/**
 * 配置全局加载动画
 */
import {Loading} from 'element-ui'
//修改原型链，全局使用axios,这样之后可在每个组件的methods中调用$axios命令完成数据请求
Vue.prototype.$Axios=Axios
let loading;
//内存中正在请求的数量
let loadingNum=0;
function startLoading() {    
    if(loadingNum==0){
        loading = Loading.service({
          lock: true,
          text: '拼命加载中...',
          background:'rgba(255,255,255,0.5)',
        })
    }
    //请求数量加1
    loadingNum++;
}
function endLoading() {
    //请求数量减1
    loadingNum--
    if(loadingNum<=0){
        loading.close()
    }
}
 
//请求数据拦截器
Axios.interceptors.request.use(request => {
  startLoading();
  return request
}, err => {
  return Promise.reject(err);
});
 
 
//接收响应拦截器
Axios.interceptors.response.use(response => {
  endLoading();
  return response
}, err => {
  endLoading();
  if (err && err.response) {
    switch (err.response.status) {
      case 400: err.message = '请求错误(400)'; break;
      case 401: this.$router.push('/Login'); break;
      case 403: err.message = '拒绝访问(403)'; break;
      case 404: err.message = '请求出错(404)'; break;
      case 408: err.message = '请求超时(408)'; break;
      case 500: err.message = '服务器错误(500)'; break;
      case 501: err.message = '服务未实现(501)'; break;
      case 502: err.message = '网络错误(502)'; break;
      case 503: err.message = '服务不可用(503)'; break;
      case 504: err.message = '网络超时(504)'; break;
      case 505: err.message = 'HTTP版本不受支持(505)'; break;
      default: err.message = `连接出错(${err.response.status})!`;
    }
  } else {
    err.message = '连接服务器失败!'
  }
  message.error(err.message);
  return Promise.reject(err);
});


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App , Header},
  template: '<App/>'
})

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})
