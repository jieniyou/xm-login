<template>
    <div>
        <div class="myInfo">
            <el-avatar :size="70" :src=useravatar>
                <img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png" />
            </el-avatar>
            <br>
            <span style="font-weight: 500;font-family: fantasy;">
                {{usernetname}}
            </span>
            <br><br>
            <span>已买到的宝贝</span>
        </div>
        <div class="shoppingcart">
            <!-- filter数据过滤 -->
            <!-- key 通过:key重新渲染 -->
            <el-table :key="key" :data="tableData.filter((payStatus)=>payStatus.goodsTakeStatus!=0)" style="width: 100%"
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
    </div>
</template>

<script>
import { getShoppingCartByUserId } from '@/api/mycart'
import { getGoodsDetails } from '@/api/goods'
export default {
    name: 'ShoppingCart',
    data() {
        let user = this.$store.getters.user
        return {
            tableData: [],
            useravatar: user.userAvatar,
            usernetname: user.netName
        }
    },
    methods: {
        // 购物记录
        queryShoppingCartByUserId(id) {
            getShoppingCartByUserId(id).then(resp => {
                let data = resp.data
                if (data.success) {
                    this.tableData = data.content
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
        }
    },
    mounted() {
        let userId = this.$store.getters.user.id
        this.queryShoppingCartByUserId(userId)
    }
}
</script>

<style>
.myInfo {
    position: relative;
    border: 1px #ff000014 solid;
    max-width: 23%;
    padding: 110px 5px;
    top: 30px;
    left: 2%;
    box-shadow: 15px 15px 15px sandybrown;
    border-radius: 7px;

}

.shoppingcart {
    position: relative;
    top: -333px;
    left: 30%;
    max-width: 65%;

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