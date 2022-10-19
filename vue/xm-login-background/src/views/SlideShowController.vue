<template>
    <div class="slideshow">
        <h3>轮播管理</h3>
        <el-button type="primary" size="small" style="float:right" @click="addFormVisible = true">新增
        </el-button>
        <el-table :data="tableData" stripe border style="width: 100%;" max-height=450 :key="key">
            <el-table-column fixed type='index' label="序号" width="50">
            </el-table-column>
            <el-table-column prop="slideshowName" label="轮播图名称" width="150">
            </el-table-column>
            <el-table-column prop="slideshowAddress" label="图片地址" width="850">
            </el-table-column>
            <el-table-column sortable prop="slideshowStatus" :formatter="formatStatus" label="轮播状态" width="120">
                <template slot-scope="scope">
                    <span :style="{color: scope.row.slideshowStatus==0?'red':'green'}">{{scope.row.slideshowStatus==1?'已启用':'已禁用'}}</span>
                </template>
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">

                    <el-button @click="changeStatus(scope.row)" type="text" size="small">
                        {{scope.row.slideshowStatus==0?'启用':'禁用'}}</el-button>

                    <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>

                    <el-popconfirm confirm-button-text='好的' cancel-button-text='不用了' icon="el-icon-info"
                        icon-color="red" title="这是一段内容确定删除吗？" @confirm="remove(scope.$index,scope.row,tableData)">
                        <el-button type="text" size="small" slot="reference">删除</el-button>
                    </el-popconfirm>

                </template>
            </el-table-column>
        </el-table>

        <el-dialog title="新增轮播" :visible.sync="addFormVisible">
            <el-form :model="slideshowform" ref="slideshowform" :rules="rules" style="text-align:left"
                @keyup.native.enter="add(slideshowform)">
                <el-form-item label="名称" :label-width="formLabelWidth" prop="slideshowName">
                    <el-input v-model="slideshowform.slideshowName" placeholder="请输入名称" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图片地址" :label-width="formLabelWidth" prop="slideshowAddress">
                    <el-input v-model="slideshowform.slideshowAddress" placeholder="请输入图片地址" autocomplete="off">
                    </el-input>
                </el-form-item>
                <el-form-item label="状态" :label-width="formLabelWidth" prop="slideshowStatus">
                    <el-select v-model="slideshowform.slideshowStatus" placeholder="请选择轮播状态">
                        <el-option label="启用" value="1"></el-option>
                        <el-option label="禁用" value="0"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="addFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="add(slideshowform)">确 定</el-button>
            </div>
        </el-dialog>

        <el-dialog title="修改轮播" :visible.sync="editFormVisible">
            <el-form :model="row_slideshow" ref="row_slideshow" 
            :rules="rules" style="text-align:left"
            @keyup.native.enter="toEdit(row_slideshow)"
            >
                <el-form-item label="名称" :label-width="formLabelWidth" prop="slideshowName">
                    <el-input v-model="row_slideshow.slideshowName" placeholder="请输入名称" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图片地址" :label-width="formLabelWidth" prop="slideshowAddress">
                    <el-input v-model="row_slideshow.slideshowAddress" placeholder="请输入图片地址" autocomplete="off">
                    </el-input>
                </el-form-item>
                <el-form-item label="状态" :label-width="formLabelWidth" prop="slideshowStatus">
                    <el-select v-model="row_slideshow.slideshowStatus" placeholder="请选择轮播状态" >
                        <el-option label="启用" value="1"></el-option>
                        <el-option label="禁用" value="0"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="editFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="toEdit(row_slideshow)">提 交</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import { selectSlideshow, insertSlideshow, delSlideshow, updateSlideshow, editSlideshow } from '@/api/other'
export default {
    name: "slideshow",
    methods: {
        add(slideshowform) {
            this.$refs.slideshowform.validate((valid => {
                if (valid) {
                    insertSlideshow(slideshowform).then(resp => {
                        let data = resp.data
                        if (data.code === 200) {
                            this.$message({
                                type: "success",
                                message: data.message
                            })
                            this.addFormVisible = false
                            this.querySlideshow()
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
        changeStatus(row) {
            let status = '';
            if (row.slideshowStatus === 0) {
                status = 1
            } else {
                status = 0
            }
            updateSlideshow(row.id, status).then(resp => {
                let data = resp.data
                if (data.code === 200) {
                    this.$message({
                        type: "success",
                        message: data.message
                    })
                    this.dialogFormVisible = false
                    this.querySlideshow()
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
        edit(row) {
            this.editFormVisible = true
            this.row_slideshow = row
        },
        toEdit(row_slideshow) {
            this.$refs.row_slideshow.validate((valid => {
                if (valid) {
                    editSlideshow(row_slideshow).then(resp => {
                        let data = resp.data
                        if (data.code === 200) {
                            this.$message({
                                type: "success",
                                message: data.message
                            })
                            this.editFormVisible = false
                            this.querySlideshow()
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
        remove(index, row, rows) {
            delSlideshow(row.id).then(resp => {
                let data = resp.data
                if (data.code === 200) {
                    this.$message({
                        type: "success",
                        message: data.message
                    })
                    this.dialogFormVisible = false
                    rows.splice(index)
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
            return row.slideshowStatus === 0 ? '已禁用' : '已启用'
        },
        querySlideshow() {
            selectSlideshow().then(resp => {
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
            row_slideshow: {},
            slideshowform: {
                slideshowName: '',
                slideshowAddress: '',
                slideshowStatus: '',
            },
            formLabelWidth: '120px',

            rules: {
                slideshowName: [{ required: true, message: '请输入名称', trigger: 'blur' }],
                slideshowAddress: [{ required: true, validator: validatorUrl, trigger: ['blur', 'change'] }],
                slideshowStatus: [{ required: true, message: '请选择', trigger: 'blur' }],

            }
        }
    },
    mounted() {
        this.querySlideshow();
    }
}
</script>

<style>
body {
    background: url('/static/img/leaf.jpg');
}

.slideshow {
    position: absolute;
    top: 10%;
}
</style>