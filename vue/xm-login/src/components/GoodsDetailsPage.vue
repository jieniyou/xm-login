<template>
    <div>
        <div class="title-icon">
            <!-- 图片api接口返回来的，由于请求是异步的，所以在请求没有回来之前el-image渲染的时候图片路径是undefined，所以给了个v-if，使得这个组件再次渲染。 -->
            <el-image v-if="phone.phoneImg!==undefined" style="width: 100%; height: 100%" :src="phone.phoneImg"
                :preview-src-list="[phone.phoneImg]">
            </el-image>
        </div>
        <div class="right-bar">
            <p class="description">{{phone.phoneDescription}}</p>
            <div class="right-bar-bottom">
                <div class="price">
                    <p class="p">
                        价格&nbsp;&nbsp;&nbsp;
                        <span v-if="this.$store.getters.member==''" class="price-1">¥{{price}}</span>
                        <span v-if="this.$store.getters.member!=''">
                            <span class="price-1">¥{{memberPrice}}</span>
                            &nbsp;&nbsp;<del>¥{{price}}</del>
                        </span>
                    </p>
                    <p class="p" v-if="this.$store.getters.member!=''">您是尊贵的&nbsp;&nbsp;&nbsp;
                        <span class="member">{{this.$store.getters.member.memberName}}</span>
                    </p>
                </div>
                <p class="p p-1">机身颜色&nbsp;&nbsp;&nbsp;<span style="color:yellowgreen">温馨提示:若不选择默认提交的为第一项</span></p>
                <div>
                    <el-radio-group v-model="color">
                        <el-radio-button v-for="color in colors" :key="color.colorId" :label="color.phoneColor">
                        </el-radio-button>
                    </el-radio-group>
                </div>
                <p class="p p-1">生产商</p>
                <el-radio-group v-model="origin">
                    <el-radio-button v-for="origin in origins" :key="origin.originId" :label="origin.categoryOrigin">
                    </el-radio-button>
                </el-radio-group>
                <p class="p p-1">存储容量</p>
                <el-radio-group v-model="msM">
                    <el-radio-button v-for="msM in mss" :key="msM.msId" :label="msM.msMemory">
                    </el-radio-button>
                </el-radio-group>
                <p class="p p-1">网络类型</p>
                <el-radio-group v-model="msS">
                    <el-radio-button v-for="msS in mss" :key="msS.msId" :label="msS.msSignals">
                    </el-radio-button>
                </el-radio-group>
                <p class="p p-1">数量&ensp;&ensp;<span style="color:tomato">'一次性限购10部'</span></p>
                <el-input-number class="count" v-model="count" @change="getTotalPrice()" :min="1" :max="10">
                </el-input-number>
                &ensp;&ensp;<span class="price-1">¥{{totalPrice}}</span>
                <br /><br /><br />
                <el-button type="danger" @click="shopping" plain>立即购买</el-button>
                <el-button type="danger" @click="join">加入购物车</el-button>
                <el-button type="success" @click="selectAddress">选择地址</el-button>
            </div>

            <el-drawer title="初心-选择地址" :visible.sync="drawer" :direction="direction" :before-close="handleClose">
                <el-table ref="singleTable" :data="addressInfo" highlight-current-row @row-click="selectedAddress"
                    @current-change="handleCurrentChange" style="width: 100%">
                    <el-table-column type="index" label="序号" width="50">
                    </el-table-column>
                    <el-table-column property="address" label="省/市/区县" width="120">
                    </el-table-column>
                    <el-table-column property="addressStreet" label="详细地址" width="120">
                    </el-table-column>
                    <el-table-column property="consigneeName" label="联系人">
                    </el-table-column>
                    <el-table-column property="addressPhone" label="手机">
                    </el-table-column>
                </el-table>
            </el-drawer>

        </div>
        <Footer v-if="$route.meta.show" />
    </div>
</template>

<script>
import Footer from '@/components/common/Footer';
import { shopping } from '@/api/goods';
import { addShoppingCart } from '@/api/mycart'
import { getAddressByUserId } from '@/api/address';
export default {
    name: "GoodsDetailsPage",
    components: { Footer },
    data() {
        let user = this.$store.getters.user
        let goods = this.$store.getters.goodsDetails.phone
        return {
            goodsDetails: '',
            phone: '',
            colors: '',
            mss: '',
            origins: '',
            price: '',
            memberPrice: '',
            color: '',
            origin: '',
            msM: '',
            msS: '',
            count: 1,
            totalPrice: '',
            wallet: {
                walletId: '',
                balance: '',
            },


            drawer: false,
            direction: 'rtl',
            addressInfo: [],
            ShoppingCart: {
                userId: user.id,
                goodsId: goods.id,
                addressId: 0,
                goodsImg: goods.phoneImg,
                goodsName: goods.phoneModel,
                goodsPrice: goods.phonePrice,
                goodsNumber: 1,
                goodsTotalPrice: goods.phonePrice,
                goodsPayStatus: 0,

            },

            //留着玩
            phone_srcList: [
                'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
                'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
            ]
        }
    },
    methods: {
        getGoodsDetails() {
            let goodsDeatilList = this.$store.getters.goodsDetails
            this.goodsDetails = goodsDeatilList
            this.phone = goodsDeatilList.phone
            this.colors = goodsDeatilList.colors
            this.mss = goodsDeatilList.mss
            this.origins = goodsDeatilList.origins

            let price = goodsDeatilList.phone.phonePrice
            this.price = price
            let memberDiscount = this.$store.getters.member.memberDiscount
            this.memberPrice = (price * memberDiscount).toFixed(2)

        },
        handleChange(value) {
            console.log(value);
        },
        getTotalPrice() {
            this.wallet.walletId = this.$store.getters.user.id
            if (this.$store.getters.member == '') {
                this.totalPrice = Number(this.price) * Number(this.count).toFixed(2)
                this.wallet.balance = this.totalPrice

                this.ShoppingCart.goodsNumber = this.count
                this.ShoppingCart.goodsTotalPrice = this.totalPrice
            } else if (this.$store.getters.member != '') {
                this.totalPrice = (Number(this.memberPrice) * Number(this.count)).toFixed(2)
                this.wallet.balance = this.totalPrice

                this.ShoppingCart.goodsNumber = this.count
                this.ShoppingCart.goodsTotalPrice = this.totalPrice
            } else {
                this.totalPrice = 99999999999999
                this.$message({
                    message: '数据异常',
                    type: 'error'
                })
            }
        },
        shopping() {
            if (this.$store.getters.user != '') {
                if (this.ShoppingCart.addressId == '') {
                    this.$confirm("请先选择地址", "温馨提示", {

                    }).then(() => {
                        this.drawer = true
                    })
                } else {
                    this.$confirm('您即将花费' + this.totalPrice + '购买此产品是否支付', '初心', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning',
                        center: true
                    }).then(() => {
                        if (this.totalPrice > this.wallet.balance) {
                            this.$message({
                                type: 'warning',
                                message: '余额不足,请充值'
                            });
                        } else {
                            this.ShoppingCart.goodsPayStatus = 1
                            let that = this
                            addShoppingCart(this.ShoppingCart).then(resp => {
                                let data = resp.data
                                that.pay(that.wallet);
                            }).catch(error => {
                                this.$message({
                                    type: 'error',
                                    message: '网络异常'
                                })
                            })
                        }
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消支付'
                        });
                    });
                }
            } else {
                this.$message({
                    type: 'error',
                    message: '请先登录'
                })
                this.$router.push({ path: '/Login' })
            }

        },
        join() {
            if (this.$store.getters.user != '') {
                if (this.ShoppingCart.addressId == '') {
                    this.$confirm("请先选择地址", "温馨提示", {

                    }).then(() => {
                        this.drawer = true
                    })
                } else {

                    this.ShoppingCart.goodsPayStatus = 0
                    let that = this
                    addShoppingCart(this.ShoppingCart).then(resp => {
                        let data = resp.data
                        if (data.success) {
                            this.$message({
                                type: 'success',
                                message: '加入成功!'
                            });
                        }
                    }).catch(error => {
                        this.$message({
                            type: 'error',
                            message: '网络异常'
                        })
                    })
                }
            } else {
                this.$message({
                    type: 'error',
                    message: '请先登录'
                })
                this.$router.push({ path: '/Login' })
            }

        },
        pay(wallet) {
            shopping(wallet).then(resp => {
                let data = resp.data
                if (data.success) {
                    this.$message({
                        message: '支付成功',
                        type: 'success'
                    })
                } else {
                    this.$message({
                        message: '余额不足',
                        type: 'warning'
                    })
                }
            }).catch(error => {
                this.$message({
                    message: '网络异常',
                    type: 'error'
                })
            })
        },
        selectAddress() {
            this.drawer = true
        },
        selectedAddress(row, event, column) {
            this.ShoppingCart.addressId = row.addressId
            console.log(row, event, column)
        },
        queryAddressByUserId() {
            let id = this.$store.getters.user.id
            getAddressByUserId(id).then(resp => {
                let data = resp.data
                if (data.success) {
                    this.addressInfo = data.content
                }
            }).catch(error => {
                this.$message({
                    message: '请先登录',
                    type: 'error',
                })
            })
        }

    },
    mounted() {
        this.getGoodsDetails();
        this.getTotalPrice();
        this.queryAddressByUserId();
    }

}
</script>

<style>
.title-icon {
    position: relative;
    border-radius: 12px;
    background-color: rgba(0, 255, 255, 0.192);
    width: 32%;
    height: 423px;
    top: 43px;
    left: 6%;
}

.el-image {
    border-radius: 12px;
}

.right-bar {
    position: relative;
    text-align: left;
    top: -380px;
    left: 40%;
    border-right: 1px solid rgba(0, 0, 0, 0.349);
    width: 39%;
    height: auto;
}

.description {
    font-size: 16px;
    font-weight: 700;
}

.price {
    padding: 1px 10px;
    background: rgb(0 0 0 / 9%);
    border-radius: 15px;
}

.p {
    color: #999;
    font-size: 12px;
}

.p-1 {
    position: relative;
    left: 13px;
}

.price-1 {
    color: #FF0036;
    font-size: 24px;
    font-weight: bolder;
}

.member {
    color: #FF0036;
    font-size: 14px;
    font-weight: 200;
}

.right-bar-bottom {
    width: auto;
    border-radius: 15px;
}

.count {
    border: none;
    border-radius: 12px;
}
</style>