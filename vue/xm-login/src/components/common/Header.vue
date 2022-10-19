<template>
    <el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect"
        background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
        <el-menu-item index="1" @click="toIndex()">初心首页</el-menu-item>
        <el-menu-item index="2" disabled style="cursor: pointer">欢迎来到初心</el-menu-item>
        <el-menu-item index="3" @click="myDIYBtn(btns)">Hi! {{loginStatus}}
        </el-menu-item>
        <el-menu-item index="4" @click="myDIYBtn_1(btns)">{{loginStatus_1}}</el-menu-item>
        <el-submenu index="5">
            <template slot="title">我的初心</template>
            <el-menu-item index="5-1">已买到的宝贝</el-menu-item>
            <el-menu-item index="5-2">我的钱包</el-menu-item>
            <!-- <el-menu-item index="5-3">选项3</el-menu-item>
            <el-submenu index="5-4">
                <template slot="title">选项4</template>
                <el-menu-item index="5-4-1">选项1</el-menu-item>
                <el-menu-item index="5-4-2">选项2</el-menu-item>
                <el-menu-item index="5-4-3">选项3</el-menu-item>
            </el-submenu> -->
        </el-submenu>
        <el-menu-item index="6">购物车</el-menu-item>
        <el-menu-item index="7">联系客服</el-menu-item>
        <el-submenu v-if="this.$store.getters.user!=''" index="8" style="float:right">
            <template slot="title">
                <el-avatar :size="40" :src=this.$store.getters.user.userAvatar />
            </template>
            <el-menu-item index="8-1">我的信息</el-menu-item>
            <el-menu-item index="8-2">我的收货地址</el-menu-item>
        </el-submenu>
    </el-menu>
</template>
<script>
export default {
    name: 'Header',
    data() {
        return {
            activeIndex: '1',
            activeIndex2: '1',
            loginStatus: '请登录',
            loginStatus_1: '免费注册',
            btns: {
                btnEvent: 'this.$router.push({path:"/Login"})',
                btnEvent_1: 'this.$router.push({path:"/Register"})',
            }

        };
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
            if (key == "5-1") {
                if(this.$store.getters.user!=''){
                    this.$router.push({ path: '/HasTaked' })
                }else{
                    this.$message({
                        type:"error",
                        message:"请先登录"
                    })
                    this.$router.push({path:"/Login"})
                }
            }
            if (key == "5-2") {
                if(this.$store.getters.user!=''){
                    this.$router.push({ path: '/WalletPage' })
                }else{
                    this.$message({
                        type:"error",
                        message:"请先登录"
                    })
                    this.$router.push({path:"/Login"})
                }
            }
            if (key == "6") {
                if(this.$store.getters.user!=''){
                    this.$router.push({ path: '/ShoppingCart' })
                }else{
                    this.$message({
                        type:"error",
                        message:"请先登录"
                    })
                    this.$router.push({path:"/Login"})
                }
            }
            if (key == "8-1") {
                // this.$router.push({ path: '/MyInfo' })
                this.$confirm('不想做,所以不允许你更改信息! Do You Know ????', '忠告', {
                    confirmButtonText: '确定',
                    cancelButtonText: '确定',
                    type: 'warning'
                })
            }
            if (key == "8-2") {
                this.$router.push({ path: '/Address' })
            }
        },
        myDIYBtn(btn) {
            eval(btn.btnEvent)
            console.log('btn==>' + btn)
        },
        myDIYBtn_1(btn) {
            eval(btn.btnEvent_1)
            console.log('btn==>' + btn)
        },
        toIndex() {
            this.$router.push({ path: '/Index' })
        },
        getStatus() {
            if (this.$store.getters.status === 0) {
                this.loginStatus = '请登录'
                this.loginStatus_1 = '免费注册'
            } else {
                this.loginStatus = this.$store.getters.user.netName
                this.loginStatus_1 = '退出'
                let event = "this.$router.push({path:'/MyCart'})"
                let event_1 = 'this.$router.push({path:"/Login"}),'
                    + 'this.$store.commit("setStatus",0),'
                    + 'this.$store.commit("setMember",""),'
                    + 'this.$store.commit("setUser",""),'
                    + 'this.$store.commit("setWallet","")'

                this.btns.btnEvent = event
                this.btns.btnEvent_1 = event_1
            }
        }
    },
    mounted() {
        this.getStatus()
    }
}
</script>