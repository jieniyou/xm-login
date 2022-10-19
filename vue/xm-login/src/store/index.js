import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        //需要获取全局的用户信息:user
        user:'',
        member:'',//会员
        status: 0, //0未登录1已登录
        queryResult:'',
        goodsDetails:'',
        wallet:'',

    },
    mutations:{
        // 设置user值,会在登陆后调用
        setUser(state,user){
            state.user=user
        },
        setMember(state,member){
            state.member=member
        },
        setStatus(state,status){
            state.status=status
        },
        setQueryResult(state,queryResult){
            state.queryResult=queryResult
        },
        setGoodsDetails(state,goodsDetails){
            state.goodsDetails=goodsDetails
        },
        setWallet(state,wallet){
            state.wallet=wallet
        }
    },
    getters:{
        // vuex需要使用getters中方法才能访问变量,user
        user:state=>state.user,
        member:state=>state.member,
        status:state=>state.status,
        queryResult:state=>state.queryResult,
        goodsDetails:state=>state.goodsDetails,
        wallet:state=>state.wallet,
    }
})
