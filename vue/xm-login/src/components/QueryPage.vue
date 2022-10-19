<template>
    <div>
        <span
            style="position: relative;top: 15px;float: left;font-size: 10px;color: rgba(193, 0, 0, 0.66);">"您的查询结果为":</span>
        <br />
        <!-- 商品 -->
        <el-row class="querygoods">
            <el-col class="card" :span="5" v-for="result in results" :key="result.id" :offset="index = 2">
                <el-card :body-style="{ padding: '0px' }">
                    <img @click="queryGoodsDetails(result.id)" :src="result.phoneImg" class="image">
                    <div style="padding: 14px;">
                        <div style="cursor:pointer" @click="queryGoodsDetails(result.id)">
                            <span class="span-style">{{result.phoneModel}}:{{result.phoneDescription}}</span>
                        </div>
                        <div class="bottom clearfix">
                            <span style="color:#545c64; font-size: 20px; font-family: 楷体;">¥
                                {{result.phonePrice}}</span>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>

        <Footer v-if="$route.meta.show" />
    </div>
</template>

<script>
import Footer from '@/components/common/Footer';
import { getGoodsDetails } from '@/api/goods';
export default {
    name: 'QueryPage',
    components: { Footer },
    data() {
        return {
            results: '',
        }
    },
    methods: {
        getResult() {
            let resultList = this.$store.getters.queryResult
            this.results = resultList
        },
        queryGoodsDetails(id) {
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
    },
    mounted() {
        this.getResult();
    }
}
</script>

<style>
/* 商品 */
.querygoods {
    position: relative;
    margin-top: 2%;
}

.card {
    margin-bottom: 10px;
}

.card div>div:hover {
    color: tomato
}

.span-style {
    /*强制span不换行*/
    white-space: nowrap;
    /*将span当做块级元素对待*/
    display: inline-block;
    /*限制宽度*/
    width: 100%;
    /*超出宽度部分隐藏*/
    overflow: hidden;
    /*超出部分以点号代替*/
    text-overflow: ellipsis;
    /*数字与之前的文字对齐*/
    line-height: 0.9;

}

.time {
    font-size: 13px;
    color: #999;
}

.bottom {
    margin-top: 13px;
    line-height: 12px;
}

.button {
    padding: 0;
    float: right;
}

.image {
    width: 100%;
    height: 180px;
    display: block;
}
</style>