<template>
    <el-form class="loginForm" :model="loginForm" :rules="rules" ref="loginForm" label-width="100px"
        label-position="top" @keyup.enter.native="submitForm('loginForm')" >
        <h3>初心后台管理</h3>
        <el-form-item label="账号" prop="account">
            <el-input placeholder="请输入账号" v-model="loginForm.account" autocomplete="off" clearable>
            </el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input placeholder="请输入密码" v-model="loginForm.password" autocomplete="off" clearable show-password>
            </el-input>
        </el-form-item>
        <br>
        <el-form-item>
            <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
            <el-button @click="resetForm('loginForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import { login } from '@/api/login'
export default {
    name: 'Login',
    data() {
        var validateAccount = (rule, value, callback) => {
            if (value === '') {
                callback(new Error("请输入账号"))
            } else {
                callback()
            }
        }
        var validatePassWord = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                callback()
            }
        };
        return {
            loginForm: {
                account: '',
                password: '',
            },
            rules: {
                account: [
                    { validator: validateAccount, required: true, trigger: 'blur' }
                ],
                password: [
                    { validator: validatePassWord, required: true, trigger: 'blur' }
                ],

            }
        };
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    login(this.loginForm).then(resp => {
                        let data = resp.data
                        if (data.code === 200) {
                            this.$message({
                                type: 'success',
                                message: data.message
                            })
                            localStorage.setItem("user",JSON.stringify(data.data))
                            this.$router.push({path:"/"})
                            
                        } else if (data.code === 404) {
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
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>

<style>
.loginForm {
    width: 30%;
    border: 1px solid #00000021;
    padding: 2%;
    margin: 5% auto;
    text-align: left;
    border-radius: 3%;
    box-shadow: 15px 15px 15px #00000066;
}
</style>