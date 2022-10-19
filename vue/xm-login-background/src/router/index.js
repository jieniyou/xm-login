import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login';
import Index from '@/views/Index';
import AdminAdd from '@/views/AdminAddPage';
import AdminRemove from '@/views/AdminRemovePage';
import DeliverGoods from '@/views/DeliverGoodsController';
import Goods from '@/views/GoodsController';
import SlideShow from '@/views/SlideShowController';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Login',
      name: 'Login',
      component: Login,
      meta: {
        show: false,
      }
    },
    {
      path: "/",
      name: "Index",
      component: Index,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/AdminAdd",
      name: "AdminAdd",
      component: AdminAdd,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/AdminRemove",
      name: "AdminRemove",
      component: AdminRemove,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/DeliverGoods",
      name: "DeliverGoods",
      component: DeliverGoods,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/Goods",
      name: "Goods",
      component: Goods,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/SlideShow",
      name: "SlideShow",
      component: SlideShow,
      meta: {
        requireAuth: true
      }
    }
  ]
})
