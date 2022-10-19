<template >
  <div class="address">
    <div class="addressForm">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="地址信息" prop="address">
          <el-cascader placeholder="请选择地址" v-model="selectedOptions" size="large" :options="options"
            @change="handleChange">
          </el-cascader>
        </el-form-item>

        <el-form-item label="详细地址" prop="addressStreet">
          <el-input placeholder="请输入详细地址" v-model="ruleForm.addressStreet"></el-input>
        </el-form-item>

        <el-form-item label="邮政编码" prop="postalCode">
          <el-input placeholder="请输入邮政编码" v-model="ruleForm.postalCode"></el-input>
        </el-form-item>

        <el-form-item label="收货人姓名" prop="consigneeName">
          <el-input placeholder="请输入姓名" v-model="ruleForm.consigneeName"></el-input>
        </el-form-item>

        <el-form-item label="手机号码" prop="addressPhone">
          <el-input placeholder="(+86)" v-model="ruleForm.addressPhone"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">保存</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <div class="addressInfo">
      <!-- filter数据过滤 -->
      <!-- key 通过:key重新渲染 -->
      <el-table :key="key" :data="tableData.filter((status)=>status.addressStatus!=0)" style="width: 100%"
        max-height="400">
        <el-table-column label="序号" type="index" width="50" fixed>
        </el-table-column>
        <el-table-column prop="consigneeName" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="address" label="地址信息" width="200">
        </el-table-column>
        <el-table-column prop="addressStreet" label="详细地址" width="300">
        </el-table-column>
        <el-table-column prop="postalCode" label="邮政编码" width="100">
        </el-table-column>
        <el-table-column prop="addressPhone" label="手机号" width="120">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="120">
          <template slot-scope="scope">
            <!-- scope.row 获取当前行的信息 -->
            <!-- scope.row.addressId 获取当前行的指定信息-->
            <el-button @click.native.prevent="deleteRow(scope.$index,scope.row.addressId, tableData)" type="text"
              size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>

</template>

<script>
import { regionData, CodeToText } from 'element-china-area-data'
import { getAddressByUserId, delAddressByAddressId, addAddress } from '@/api/address';
export default {
  name: 'Address',
  components: {},
  data() {
    var phoneValidate = (rule, value, callback) => {
      let mobileReg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
      if (mobileReg.test(value)) {
        callback();
      } else {
        this.$message({
          message: '请输入手机号的正确格式',
          type: 'warning'
        })
        return callback(new Error('请输入手机号的正确格式'));
      }
    }
    var postalCodeValidate=(rule,value,callback)=>{
      let codeReg=/^[1-9]\d{5}(?!\d)$/g;
      if(codeReg.test(value)){
        callback();
      }else {
        this.$message({
          message: '请输入正确的邮编',
          type: 'warning'
        })
        return callback(new Error('请输入正确的邮编'));
      }
    }
    return {
      options: regionData,
      selectedOptions: [],
      addtions: {},			//存储地址数据
      ruleForm: {
        userId: this.$store.getters.user.id,
        address: '',
        addressStreet: '',
        postalCode: '',
        consigneeName: '',
        addressPhone: '',
        addressStatus: 1,
      },
      rules: {
        address: [{ required: true, message: '请选择地址信息', trigger: 'blur' },],
        addressStreet: [{ required: true, message: '请输入详细地址', trigger: 'blur' },],
        postalCode: [{ validator:postalCodeValidate, required: true, message: '请输入邮政编码', trigger: 'blur' },],
        consigneeName: [{ required: true, message: '请输入收货人姓名', trigger: 'blur' },],
        addressPhone: [{ validator: phoneValidate, required: true, message: '请输入手机号码', trigger: 'blur' },],
      },
      tableData: [],

      key: 0,

    }
  },
  methods: {
    handleChange(value) {
      //我们选择地址后，selectedOptions 会保存对应的区域码，例如北京的区域码为'110000'
      //我们要取出区域码对应的汉字，就需要用CodeToText(区域码)进行输出
      this.addtions.selectedOptions = value
      var name = ''
      this.selectedOptions.map(item => name += CodeToText[item] + '/')
      this.addtions.names = name
      let lastIndexOf = name.lastIndexOf('/')
      let address = name.substring(0, lastIndexOf)
      this.ruleForm.address = address
      console.log(this.addtions.names)
      console.log(this.addtions)
      console.log(address)
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.insertAddress(this.ruleForm)
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    // vue使用key标记组件身份，当key改变时就是释放原始组件，重新加载新的组件。
    isToRefresh() {
      this.key += 1
      console.info(this.key)
    },

    insertAddress(ruleForm) {
      addAddress(ruleForm).then(resp => {
        let data = resp.data
        if (data.success) {
          this.$message({
            type: 'success',
            message: '添加成功'
          })
          this.isToRefresh()
          this.ruleForm = {}
        } else {
          this.$message({
            type: 'error',
            message: '添加失败'
          })
          this.isToRefresh()
        }
      }).catch(error => {
        this.$message({
          type: 'error',
          message: '网络异常'
        })
        this.isToRefresh()
      })
    },

    deleteRow(index, addressId, rows) {
      rows.splice(index, 1)
      this.del(addressId)
    },
    queryAddressByUserId() {
      let id = this.$store.getters.user.id
      getAddressByUserId(id).then(resp => {
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
    del(id) {
      delAddressByAddressId(id).then(resp => {
        let data = resp.data
        if (data.success) {
          this.$message({
            type: 'success',
            message: '删除成功'
          })
        } else {
          this.$message({
            type: 'error',
            message: '删除失败'
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
  watch: {

  },
  computed: {},
  created() {

  },
  mounted() {
    this.queryAddressByUserId()
  },
  beforeDestrory() {

  },
  destroyed() {

  },
}
</script>

<style>
.address {
  height: 87vh;
  /* overflow: hidden; */
  border: 2px solid #00000033;
  border-radius: 4px;
}

.addressForm {
  text-align: left;
  position: relative;
  width: 23%;
  top: 9vh;
  left: 5%;
  /* border: 1px #ff000030 solid; */
  background: #ff86862b;
  border-radius: 10px;
  padding: 8px;
  box-shadow: 10px 10px 5px;
}

.addressInfo {
  position: relative;
  right: -34%;
  top: -52vh;
  width: 63%;
  height: auto;
  /* border: 1px solid black; */
  box-shadow: 5px 5px 5px;

}
</style>

