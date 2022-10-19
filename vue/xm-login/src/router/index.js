import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import Register from '@/views/Register'
import Index from '@/views/Index'
import MyCart from '@/components/MyCart';
import QueryPage from '@/components/QueryPage';
import GoodsDetailsPage from '@/components/GoodsDetailsPage';
import WalletPage from '@/components/WalletPage';
import Address from '@/components/Address';
import MyInfo from '@/components/MyInfo';
import ShoppingCart from '@/components/ShoppingCart';
import HasTaked from '@/components/HasTaked';

// 避免路由重复/冗余报错
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Login',
      name: 'Login',
      component: Login,
      meta: {
        show: false,//设置是否显示Header
        title: '初心-登录'
      }
    }, {
      path: '/Register',
      name: 'Register',
      component: Register,
      meta: {
        show: false,
        title: '初心-注册'
      }
    }, {
      path: '/',
      name: 'Index',
      component: Index,
      meta: {
        show: true
      }
    }, {
      path: '/Index',
      name: 'Index',
      component: Index,
      meta: {
        show: true
      }
    }, {
      path: '/MyCart',
      name: 'MyCart',
      component: MyCart,
      meta: {
        show: true,
        title: '我的初心'
      }
    }, {
      path: '/QueryPage',
      name: 'QueryPage',
      component: QueryPage,
      meta: {
        show: true,
        title: '初心搜索'
      }
    }, {
      path: '/GoodsDetailsPage',
      name: 'GoodsDetailsPage',
      component: GoodsDetailsPage,
      meta: {
        show: true,
        title: '初心-宝贝详情'
      }
    }, {
      path: '/WalletPage',
      name: 'WalletPage',
      component: WalletPage,
      meta: {
        show: true,
        title: '初心-我的钱包'
      }
    }, {
      path: '/Address',
      name: 'Address',
      component: Address,
      meta: {
        show:true,
        title:'初心-地址管理'
      }
    }, {
      path: '/MyInfo',
      name: 'MyInfo',
      component: MyInfo,
      meta: {
        show:true,
        title:'初心-我的信息'
      }
    }, {
      path: '/ShoppingCart',
      name: 'ShoppingCart',
      component: ShoppingCart,
      meta: {
        show:true,
        title:'初心-购物车'
      }
    }, {
      path: '/HasTaked',
      name: 'HasTaked',
      component: HasTaked,
      meta: {
        show:true,
        title:'初心-购物车'
      }
    }
  ]
})
