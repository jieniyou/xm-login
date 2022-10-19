<template>
    <div class="goods">
        <h3>商品管理</h3>
        <el-table :data="tableData" stripe border style="width: 100%;" max-height=450 max-width=500 :key="key">
            <el-table-column fixed type='index' label="序号" width="50">
            <!-- phone -->
            </el-table-column>
            <el-table-column prop="phone.phoneModel" label="手机名称" width="150">
            </el-table-column>
            <el-table-column prop="phone.phoneCpu" label="手机处理器" width="150">
            </el-table-column>
            <el-table-column prop="phone.phonePrice" label="手机价格" width="100">
            </el-table-column>
            <el-table-column :show-overflow-tooltip="true" prop="phone.phoneImg" label="图片地址" width="250">
            </el-table-column>
            <el-table-column :show-overflow-tooltip="true" prop="phone.phoneDescription" label="手机描述" width="250">
            </el-table-column>
            <!-- category -->
            <el-table-column prop="category.categoryName" label="手机类别" width="200">
            </el-table-column>
            <!-- color -->
            <el-table-column prop="colors.phoneColor" label="手机颜色" width="150">
            </el-table-column>
            <!-- ms -->
            <el-table-column prop="mss.msMemory" label="手机内存" width="100">
            </el-table-column>
            <el-table-column prop="mss.msSignals" label="手机网络" width="150">
            </el-table-column>
            <!-- origin -->
            <el-table-column prop="origins.categoryOrigin" label="手机源产地" width="100">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="50">
                <template slot-scope="scope">

                    <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>

                </template>
            </el-table-column>
        </el-table>

        <el-dialog title="修改商品" :visible.sync="editFormVisible">
            <el-form :model="row_phones" ref="row_phones" :rules="rules" style="text-align:left"
                @keyup.native.enter="toEdit(row_phones)">
                <el-form-item label="手机名称" :label-width="formLabelWidth" prop="phoneModel">
                    <el-input disabled v-model="row_phones.phoneModel" placeholder="请输入手机名称" autocomplete="off">
                    </el-input>
                </el-form-item>
                <el-form-item label="手机类型" :label-width="formLabelWidth" prop="phoneCategory">
                    <el-input disabled v-model="row_category.categoryName" placeholder="请输入手机类型" autocomplete="off">
                    </el-input>
                </el-form-item>
                <el-form-item label="手机处理器" :label-width="formLabelWidth" prop="phoneCpu">
                    <el-input v-model="row_phones.phoneCpu" placeholder="请输入手机处理器" autocomplete="off">
                    </el-input>
                </el-form-item>
                <el-form-item label="手机价格" :label-width="formLabelWidth" prop="phonePrice">
                    <el-input type="number" min="0" v-model="row_phones.phonePrice" placeholder="请输入手机价格" autocomplete="off">
                    </el-input>
                </el-form-item>
                <el-form-item label="手机图片" :label-width="formLabelWidth" prop="phoneImg">
                    <el-input v-model="row_phones.phoneImg" placeholder="请输入图片地址" autocomplete="off">
                    </el-input>
                </el-form-item>
                <el-form-item label="手机描述" :label-width="formLabelWidth" prop="phoneDescription">
                    <el-input v-model="row_phones.phoneDescription" placeholder="请输入手机描述" autocomplete="off">
                    </el-input>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="editFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="toEdit(row_phones)">提 交</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import { selectGoods, delGoods, editGoods } from '@/api/other'
export default {
    name: "goods",
    methods: {
        edit(row) {
            this.editFormVisible = true
            this.row_phones = row.phone
            this.row_category=row.category
        },
        toEdit(row_phones) {
            console.log(row_phones)
            this.$refs.row_phones.validate((valid => {
                if (valid) {
                    editGoods(row_phones).then(resp => {
                        let data = resp.data
                        if (data.code === 200) {
                            this.$message({
                                type: "success",
                                message: data.message
                            })
                            this.editFormVisible = false
                            this.queryGoods()
                            this.key += 1
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
                } else {
                    console.log('error submit!!');
                    return false;
                }
            }))
        },
        queryGoods() {
            selectGoods().then(resp => {
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
        let validatorUrl = function (rule, value, callback) {
            if (value === '') {
                return callback(new Error("请输入地址"))
            }
            let isUrl = /(https?|ftp|file):\/\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|].(gif|jpeg|png|jpg|bmp|webp)/
            if (!isUrl.test(value)) {
                return callback(new Error("请输入正确的网络地址"))
            } else {
                callback()
            }
        }
        return {
            key: 0,
            tableData: [],
            addFormVisible: false,
            editFormVisible: false,
            formLabelWidth: '120px',
            row_phones: {},
            row_category:{},

            rules: {
                phoneCpu: [{ required: true, message: '请输入手机处理器', trigger: 'blur' }],
                phonePrice: [{ required: true, message: '请输入手机价格', trigger: 'blur' }],
                phoneImg: [{ required: true, validator: validatorUrl, trigger: ['blur', 'change'] }],
                phoneDescription: [{ required: true, message: '请填写描述', trigger: 'blur' }],

            }
        }
    },
    mounted() {
        this.queryGoods();
    }
}
</script>

<style>
body {
    background: url('/static/img/leaf.jpg');

}

.goods {
    position: absolute;
    width: 99%;
    top: 10%;
}
</style>

