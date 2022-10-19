<template>
    <div>
        <!-- 侧边栏 -->
        <el-card class="mycart-cart">
            <div slot="header" class="clearfix">
                <span style="color: #545c64; font-weight: 700; font-family: '楷体';">我的初心</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            </div>
            <div v-for="(mycart,index) in mycartList" :key="index" class="text item">
                <span @click="MyDiyBtn(mycart.mycartUrl)" style="cursor:pointer">{{mycart.mycartSidebar}}</span>
            </div>
        </el-card>
        <!-- 我的初心-个人中心页面 -->
        <table class="mycart-self">
            <tr class="th">
                <th style="float:left;margin:10px 10px">
                    <el-avatar :size="70" :src=useravatar @error="errorHandler">
                        <img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png" />
                    </el-avatar>
                    <span style="float: right;margin: 10px;font-weight: 500;font-family: fantasy;">
                        {{netname}}({{username}})
                    </span>
                    <span style="font-size: 10px;float: right;margin-right: 45px;margin-top: -15px;">
                        <span style="color:tomato">{{membername}}</span>
                    </span>
                </th>
                <td><span class="pointer" @click="mycartEvent('1-1')">我的收货地址</span></td>
                <td><span class="pointer" @click="mycartEvent('1-2')">我的优惠信息</span></td>
            </tr>
            <br />
            <tr class="td">
                <td><span class="pointer" @click="mycartEvent('2-1')">待付款</span></td>
                <td><span class="pointer" @click="mycartEvent('2-2')">待发货</span></td>
                <td><span class="pointer" @click="mycartEvent('2-3')">待收货</span></td>
            </tr>
            <br />
        </table>
        <!-- 日历 -->
        <div class="cal">
            <p>我的日历</p>
            <div>
                <p style="font-size: 60px;">{{date.date}}</p>
                <p style="position: relative;top: -45px;">{{date.week}}</p>
                <p style="position: relative;top: -35px;">{{date.year}}.{{date.month}}</p>
            </div>
        </div>
        <div class="logistics">
            <h2>我的购物记录(已付)</h2>
        </div>
        <!-- 我的购物记录 -->
        <div class="mycart-buttom">
            <!-- filter数据过滤 -->
            <!-- key 通过:key重新渲染 -->
            <el-table :data="tableData1" style="width: 100%"
                max-height="265">
                <el-table-column label="序号" type="index" width="50" fixed>
                </el-table-column>
                <el-table-column label="商品图片" width="120">
                    <template slot-scope="scope">
                        <img :src="scope.row.goodsImg" @click="getInfo(scope.row.goodsId)"
                            style="width: 100%;cursor:pointer" />
                    </template>
                </el-table-column>
                <el-table-column prop="goodsName" label="商品名称" width="200">
                </el-table-column>
                <el-table-column label="商品单价" width="300">
                    <template slot-scope="scope">
                        ￥{{scope.row.goodsPrice}}
                    </template>
                </el-table-column>
                <el-table-column prop="goodsNumber" label="商品数量" width="100">
                </el-table-column>
                <el-table-column label="您实付总价" width="120">
                    <template slot-scope="scope">
                        ￥{{scope.row.goodsTotalPrice}}
                    </template>
                </el-table-column>
            </el-table>
        </div>

        <el-drawer title="初心-待发货" size="50%" :visible.sync="drawer1" :direction="direction" :before-close="handleClose">
            <!-- filter数据过滤 -->
            <!-- key 通过:key重新渲染 -->
            <el-table :key="key" :data="tableData2" style="width: 100%"
                max-height="500">
                <el-table-column label="序号" type="index" width="50" fixed>
                </el-table-column>
                <el-table-column label="商品图片" width="120">
                    <template slot-scope="scope">
                        <img :src="scope.row.goodsImg" @click="getInfo(scope.row.goodsId)"
                            style="width: 100%;cursor:pointer" />
                    </template>
                </el-table-column>
                <el-table-column prop="goodsName" label="商品名称" width="200">
                </el-table-column>
                <el-table-column label="商品单价" width="120">
                    <template slot-scope="scope">
                        ￥{{scope.row.goodsPrice}}
                    </template>
                </el-table-column>
                <el-table-column prop="goodsNumber" label="商品数量" width="100">
                </el-table-column>
                <el-table-column prop="goodsTotalPrice" label="您实付总价" width="120">
                </el-table-column>
            </el-table>
        </el-drawer>

        <el-drawer title="初心-待收货" size="50%" :visible.sync="drawer2" :direction="direction" :before-close="handleClose">
            <!-- filter数据过滤 -->
            <!-- key 通过:key重新渲染 -->
            <el-table :key="key" :data="tableData3" style="width: 100%"
                max-height="500">
                <el-table-column label="序号" type="index" width="50" fixed>
                </el-table-column>
                <el-table-column label="商品图片" width="120">
                    <template slot-scope="scope">
                        <img :src="scope.row.goodsImg" @click="getInfo(scope.row.goodsId)"
                            style="width: 100%;cursor:pointer" />
                    </template>
                </el-table-column>
                <el-table-column prop="goodsName" label="商品名称" width="200">
                </el-table-column>
                <el-table-column label="商品单价" width="120">
                    <template slot-scope="scope">
                        ￥{{scope.row.goodsPrice}}
                    </template>
                </el-table-column>
                <el-table-column prop="goodsNumber" label="商品数量" width="100">
                </el-table-column>
                <el-table-column prop="goodsTotalPrice" label="您实付总价" width="120">
                </el-table-column>
                <el-table-column fixed="right" label="操作" width="120">
                    <template slot-scope="scope">
                        <!-- scope.row 获取当前行的信息 -->
                        <!-- scope.row.addressId 获取当前行的指定信息-->
                        <el-button @click.native.prevent="takeGoods(scope.$index,scope.row.shoppingcartId, tableData3)"
                            type="text" size="small">
                            确认收货哦
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-drawer>
    </div>
</template>

<script>
import { getAllCart, getShoppingCartByUserId,updateTakeStatus } from '@/api/mycart'
import { getGoodsDetails } from '@/api/goods'
export default {
    name: 'MyCart',
    data() {
        return {
            netname: this.$store.getters.user.netName,
            username: this.$store.getters.user.userName,
            useravatar: this.$store.getters.user.userAvatar,
            mycartprefix: '您是尊贵的',
            mycartsuffix: '会员',
            membername: this.$store.getters.member.memberName,
            key:0,
            drawer1: false,
            drawer2: false,
            date: {
                date: new Date().getDate() < 10 ? '0' + new Date().getDate() : new Date().getDate(),
                week: this.getWeek(),
                year: new Date().getFullYear(),
                month: new Date().getMonth() + 1
            },
            mycartList: [],
            // 购物记录
            tableData1: [],
            tableData2: [],
            tableData3: [],

        }
    },
    methods: {
        errorHandler() {
            return true
        },
        getWeek() {
            var d = new Date();
            var weekday = new Array(7);
            weekday[0] = "星期天";
            weekday[1] = "星期一";
            weekday[2] = "星期二";
            weekday[3] = "星期三";
            weekday[4] = "星期四";
            weekday[5] = "星期五";
            weekday[6] = "星期六";

            return weekday[d.getDay()];
        },
        queryAllCart() {
            getAllCart().then(resp => {
                let data = resp.data
                if (data.success) {
                    this.mycartList = data.content
                }
            }).catch(error => {
                this.$message({
                    message: '请先登录',
                    type: 'error'
                })
            })
        },
        MyDiyBtn(event) {
            if (this.$store.getters.status != '') {
                this.$router.push({ path: event })
            } else {
                this.$message({
                    message: '请先登录',
                    type: 'error',
                })
                this.$router.push({ path: '/' })
            }

        },
        mycartEvent(index) {
            let that = this
            // 1-1我的收货地址
            if (index == '1-1') { this.$router.push({ path: '/Address' }) }
            // 1-2我的优惠信息
            if (index == '1-2') {
                //  this.$router.push({ path: '/Address' }) 
                let member = this.$store.getters.member
                let discount = this.$store.getters.member.memberDiscount
                if (member != '') {
                    this.$alert('您是尊贵的' + member.memberName + '会员,全场' + (discount * 10) + '折', '您的优惠信息为', {
                        confirmButtonText: '确定',
                        type: 'warning'
                    })
                } else {
                    this.$confirm('不冲会员,你还想要优惠???', '你未开通会员', {
                        confirmButtonText: '充值',
                        cancelButtonText: '好的',
                        type: 'warning'
                    }).then(() => {
                        that.$router.push("/WalletPage")
                    })
                }

            }
            // 2-1待付款
            if (index == '2-1') { this.$router.push({ path: '/ShoppingCart' }) }
            // 2-2待发货
            if (index == '2-2') { this.drawer1=true }
            // 2-3待收货
            if (index == '2-3') { this.drawer2=true }

        },
        // 购物记录
        queryShoppingCartByUserId(id) {
            getShoppingCartByUserId(id).then(resp => {
                let data = resp.data
                if (data.success) {
                    this.tableData1 = data.content.filter((payStatus)=>payStatus.goodsPayStatus!=0)
                    this.tableData2 = data.content.filter((deliveryStatus)=>deliveryStatus.goodsDeliveryStatus!=1)
                    this.tableData3 = data.content.filter((takeStatus)=>takeStatus.goodsTakeStatus!=1)
                }
            }).catch(error => {
                this.$message({
                    type: 'error',
                    message: '网络异常'
                })
            })
        },
        // 物品详细信息
        getInfo(id) {
            getGoodsDetails(id).then(resp => {
                let data = resp.data
                if (data.success) {
                    let goodsDeatils = data.content
                    this.$store.commit("setGoodsDetails", goodsDeatils)
                    this.$router.push({ path: '/GoodsDetailsPage' })
                }
            }).catch(error => {
                this.$message({
                    message: '后端异常',
                    type: 'error'
                })
            })
        },
        // 收货
        takeGoods(index,shoppingcartId,rows){
            updateTakeStatus(shoppingcartId).then(resp=>{
                let data=resp.data
                if(data.success){
                    this.$message({
                        type:'success',
                        message:'收货成功'
                    })
                    rows.splice(index,1)
                }else{
                    this.$message({
                        type:'error',
                        message:'收货失败'
                    })
                }
            }).catch(error=>{
                this.$message({
                        type:'error',
                        message:'网络异常'
                    })
            })
        }

    },
    mounted() {
        this.queryAllCart();
        // 购物记录
        let userId = this.$store.getters.user.id
        this.queryShoppingCartByUserId(userId)

    }
}
</script>

<style>
html,
#app,
body {
    height: 100%;
    min-width: 900px;
}

/* 侧边栏 */
.text {
    margin-left: 7%;
    letter-spacing: 2px;
    font: 12px/1.5 tahoma, arial, 'Hiragino Sans GB', '\5b8b\4f53', sans-serif;
}

.item {
    margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}

.clearfix:after {
    clear: both
}

.mycart-cart {
    position: relative;
    height: 265px;
    text-align: left;
    width: 13%;
    top: 41px;
    left: 6%;
}

/* 我的初心-个人中心页面 */
.mycart-self {
    position: relative;
    width: 50%;
    border-radius: 5px;
    top: -224px;
    left: 21%;
    background: rgba(0, 0, 0, 0.034);
}

.th>td {
    position: relative;
    left: -35px;
}

td>span {
    font-family: tahoma, arial, 'Hiragino Sans GB', 'Microsoft YaHei', \5b8b\4f53, sans-serif;
    font-size: 14px;
    text-align: center;
}

.td>td {
    font-size: 12px;
    width: 10%;
    border-right: solid rgba(255, 0, 0, 0.300) 1px;
}

.td>td:last-child {
    font-size: 12px;
    width: 10%;
    border-right-style: none
}

.pointer {
    cursor: pointer
}

/* 日历 */
.cal {
    position: relative;
    top: -394px;
    width: 22%;
    right: -72%;
}

.cal>p {
    position: relative;
    color: #fff;
    background: rgb(110 200 132);
    height: 45px;
    top: -17px;
    line-height: 45px;
}

.cal>div {
    position: relative;
    color: #55b46c;
    border: 1px solid rgba(0, 0, 0, 0.247);
    border-top-style: none;
    top: -77px;
}

/* 物流信息 */
.logistics {
    position: relative;
    top: -555px;
    float: left;
    left: 21%;
}

/* 购物记录 */
.mycart-buttom {
    position: relative;
    width: 73%;
    top: -547px;
    left: 21%;
}

/**
 * 隐藏滚动条
 */
html {
    height: 100%;
    width: 100%;
    overflow: -moz-hidden-unscrollable;
}

body {
    height: 100%;
    width: 100%;
    -ms-overflow-style: none;
    overflow: auto;
}

body::-webkit-scrollbar {
    display: none;
}
</style>