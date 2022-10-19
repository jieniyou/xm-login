<template>
  <div class="delivergoods">
    <h3>发货管理</h3>
    <el-table :data="tableData" stripe border style="width: 100%;" max-height=450 :key="key">
      <el-table-column fixed type='index' label="序号" width="50">
      </el-table-column>
      <el-table-column prop="shoppingcartId" label="购物id" width="100">
      </el-table-column>
      <el-table-column prop="goodsId" label="商品id" width="100">
      </el-table-column>
      <el-table-column prop="goodsName" label="商品名称" width="200">
      </el-table-column>
      <el-table-column prop="goodsPrice" label="商品单价" width="100">
      </el-table-column>
      <el-table-column prop="goodsNumber" label="商品数量" width="100">
      </el-table-column>
      <el-table-column prop="goodsTotalPrice" label="用户实付总价" width="150">
      </el-table-column>
      <el-table-column sortable prop="goodsDeliveryStatus" :formatter="formatStatus" label="发货状态" width="120">
        <template slot-scope="scope">
          <span
            :style="{color: scope.row.goodsDeliveryStatus==0?'red':'green'}">{{scope.row.goodsDeliveryStatus==1?'已发货':'未发货'}}</span>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="50">
        <template slot-scope="scope">
          <el-button @click="changeStatus(scope.row)" v-if="scope.row.goodsDeliveryStatus==0" type="text" size="small">
            发货</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { selectDeliverGoods, updateDeliverGoods, } from '@/api/other'
export default {
  name: "delivergoods",
  methods: {

    changeStatus(row) {
      let status = '';
      if (row.goodsDeliveryStatus === 0) {
        status = 1
      } else {
        status = 0
      }
      updateDeliverGoods(row.shoppingcartId, status).then(resp => {
        let data = resp.data
        if (data.code === 200) {
          this.$message({
            type: "success",
            message: data.message
          })
          this.queryDeliverGoods()
        } else {
          this.$message({
            type: "error",
            message: data.message
          })
        }
      }).catch(() => {
        this.$message({
          type: "error",
          message: '网络异常'
        })
      })
    },
    formatStatus(row) {
      return row.goodsDeliveryStatus === 0 ? '未发货' : '已发货'
    },
    queryDeliverGoods() {
      selectDeliverGoods().then(resp => {
        let data = resp.data
        if (data.code == 200) {
          this.$message({
            type: 'success',
            message: data.message
          })
          this.tableData = data.data
        } else {
          this.$message({
            type: 'error',
            message: data.message
          })
        }
      }).catch(error => {
        this.$message({
          type: 'error',
          message: '网络异常'
        })
      })
    },
  },
  data() {
    return {
      key: 0,
      tableData: [],
      formLabelWidth: '120px',
    }
  },
  mounted() {
    this.queryDeliverGoods();
  }
}
</script>

<style>
body {
  background: url('/static/img/leaf.jpg');
}

.delivergoods {
  position: absolute;
  top: 10%;
  left: 15%;
}
</style>