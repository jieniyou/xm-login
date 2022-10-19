<template>
    <div class="sidebar">

        <span class="accountName">欢迎 <span style="color:red"> {{ userInfo.account }} </span> 登录</span>
        <el-menu default-active="1" router class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
            :collapse="isCollapse" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-user-solid"></i>
                    <span slot="title">初心管理</span>
                </template>
                <el-menu-item-group>
                    <span slot="title">轮播</span>
                    <el-menu-item index="/SlideShow">轮播管理</el-menu-item>
                </el-menu-item-group>
                <el-menu-item-group title="商品">
                    <el-menu-item index="/Goods">商品管理</el-menu-item>
                </el-menu-item-group>
                <el-menu-item-group>
                    <span slot="title">商品状态</span>
                    <el-menu-item index="/DeliverGoods">发货管理</el-menu-item>
                </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
                <template slot="title">
                    <i class="el-icon-s-tools"></i>
                    <span slot="title">管理员管理</span>
                </template>
                <el-menu-item index="/AdminAdd" :disabled=isAddAccount>
                    <i class="el-icon-circle-plus"></i>
                    <span slot="title">新增管理员</span>
                </el-menu-item>
                <el-menu-item index="/AdminRemove" :disabled=isAddAccount>
                    <i class="el-icon-remove"></i>
                    <span slot="title">开除管理员</span>
                </el-menu-item>
            </el-submenu>

        </el-menu>
    </div>
</template>

<script>
export default {
    name: "LeftSideBar",
    data() {
        return {
            isAddAccount: true,
            isCollapse: true,
            value: '关',
            userInfo: {
                account: JSON.parse(localStorage.getItem("user")).account,
            },
        }
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        isShow() {
            this.isCollapse = this.isCollapse == true ? false : true
        }
    }
}
</script>

<style>
.sidebar {
    text-align: left;
}

.accountName {
    position: relative;
    float: right;
    text-align: right;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
}
</style>