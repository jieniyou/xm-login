<template>
    <div>
        <div class="wallet-left-1">
            <el-avatar :size="100" :src=user.avatar @error="errorHandler">
                <img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png" />
            </el-avatar>
            <div>
                <p>用户名 : <span>{{user.netname}}</span></p>
                <p>会员等级 : <span style="color:tomato">{{user.member}}</span></p>
            </div>
        </div>
        <div class="wallet-card">
            <span class="wallet-card-0 wallet-card-1">初心钱包</span>
            <img class="wallet-icon-1" src="static/img/wallet/wallet.png">
            <br>
            <div class="wallet-down">
                <p class="wallet-card-0">账户ID : <span>{{user.id}}</span></p>
                <p class="wallet-card-0">账户名 : <span>{{user.username}}</span></p>
                <p class="wallet-card-0">邮箱 : <span>{{user.email}}</span></p>
                <p class="wallet-card-0">您的账户余额为 : <span
                        style="color:tomato;font-weight:bolder;font-size:20px" :key="key">￥{{user.balance}}</span></p>
            </div>
        </div>
        <!-- 快速支付 -->
        <div class="wallet-right">
            <el-button @click="drawer = true" type="primary" style="margin-left: 16px;">
                初心-快速支付
            </el-button>

            <el-drawer title="初心-快速支付" :visible.sync="drawer" :direction="direction" :before-close="handleClose">
                <span>充值成功记得退出重新登陆</span><br /><br />
                <span>若有支付问题,可联系客服为您答疑</span>
                <br /><br /><br />
                <el-button type="primary" @click="toPay(pay.payName[0])">{{pay.payName[0]}}</el-button>
                <el-button type="success" @click="toPay(pay.payName[1])">{{pay.payName[1]}}</el-button>
                <br /><br />
                <div class="pay">
                    <el-image v-if="pay.payImg!==undefined" style="width: 100%; height: 100%" :src="pay.payImg">
                    </el-image>
                </div>
            </el-drawer>

        </div>
    </div>
</template>

<script>
export default {
    name: 'WalletPage',
    data() {
        return {
            key:0,
            user: {
                id: this.$store.getters.user.id,
                username: this.$store.getters.user.userName,
                netname: this.$store.getters.user.netName,
                avatar: this.$store.getters.user.userAvatar,
                email: this.$store.getters.user.email,
                member: this.$store.getters.member != '' ? this.$store.getters.member.memberName : '未开通会员哦!',
                balance: this.$store.getters.wallet.balance,

            },
            /* 快速支付*/
            drawer: false,
            /**
             * ltr-->从左往右开
             * rtl-->从右往左开
             * ttb-->从上往下开
             * btt-->从下往上开
             */
            direction: 'rtl',
            pay: {
                payName: ['支付宝', '微信'],
                payImg: '/static/img/wallet/aliPay.png',
            }
        }
    },
    methods: {
        errorHandler() {
            return true
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => { });
        },
        toPay(payName) {
            if (payName == this.pay.payName[0]) {
                this.pay.payImg = '/static/img/wallet/aliPay.png'
            } else if (payName == this.pay.payName[1]) {
                this.pay.payImg = '/static/img/wallet/wxPay.png'
            }
        }

    },
    mounted() {
        let userid = this.$store.getters.user.id
        // 加载钱包
        if (this.$store.getters.user != '') {
            this.utils.wallet(userid)
        }

    }

}
</script>
<style>
.wallet-left-1 {
    position: relative;
    background: #0000001a;
    width: 30%;
    top: 20px;
    border-radius: 8px;
    padding: 20px 0;
}

.wallet-card {
    position: relative;
    top: -222px;
    left: 35%;
    width: 30%;
    border-radius: 10px;
    border: 1px solid #00000033;
    height: 240px;
}

.wallet-icon-1 {
    position: relative;
    float: right;
    right: 0px;
    width: 50px;
    height: 50px;
}

.wallet-down {
    border-top: 1px solid #0000002a;
    text-align: left;
    position: relative;
    top: 12%;
    height: 79%;
}

.wallet-card-0 {
    position: relative;
    left: 3%;
    font-size: 15px;
    color: #00000096;
}

.wallet-card-1 {
    float: left;
    top: 5%;
}

.wallet-right {
    position: relative;
    top: -465px;
    right: 15%;
    float: right;
}

.pay {
    width: 80%;
    margin: 12px auto;
}
</style>