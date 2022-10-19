<template>
  <div id="poster">
    <!-- 快捷键登录 @keyup.enter.native="login()" -->
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" label-position="left"
      class="register-container" @keyup.enter.native="submitForm(ruleForm)">
      <h3 class="register_title">
        系统注册
        <el-button @click="toLogin()">登录</el-button>
      </h3>
      <el-form-item label="" prop="userName">
        <el-input type="text" onkeyup="this.value=this.value.replace(/[, ]/g,'')" v-model="ruleForm.userName"
          placeholder="用户名" prefix-icon="el-icon-user-solid" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="" prop="netName">
        <el-input type="text" onkeyup="this.value=this.value.replace(/[, ]/g,'')" v-model="ruleForm.netName"
          placeholder="网名(默认'小三')" prefix-icon="el-icon-user" autocomplete="off">
        </el-input>
      </el-form-item>
      <el-form-item label="" prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="密码"
          prefix-icon="el-icon-lock"></el-input>
      </el-form-item>
      <el-form-item label="" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" placeholder="确认密码"
          prefix-icon="el-icon-lock"></el-input>
      </el-form-item>
      <el-form-item label="" prop="email">
        <el-input type="email" onkeyup="this.value=this.value.replace(/[, ]/g,'')" v-model="ruleForm.email"
          autocomplete="off" placeholder="请输入邮箱" prefix-icon="el-icon-message" style="width: 60%;float: left;">
        </el-input>
        <!-- 倒计时按钮 -->
        <el-button type="primary" :disabled="disable" :class="{ codeGeting:isGeting }" @click="getVerifyCode()">
          {{getCode}}
        </el-button>
      </el-form-item>
      <el-form-item label="" prop="code">
        <el-input type="text" onkeyup="this.value=this.value.replace(/[, ]/g,'')" v-model="ruleForm.code"
          autocomplete="off" placeholder="请输入验证码" style="width: 40%;float: left;;">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="background: #505458;border: none;" @click="submitForm('ruleForm')">注册
        </el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
import { register } from '@/api/login';
import { getEmailCode } from '@/api/email';
export default {
  name: 'Register',
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      getCode: '获取验证码',
      isGeting: false,
      isClick: false,
      count: 60,
      disable: false,
      ruleForm: {
        userName: '',
        password: '',
        netName: '',
        checkPass: '',
        email: '',
        code: ''
      },
      rules: {
        userName: [{
          required: true,
          message: '请输入用户名',
          trigger: 'blur'
        },
        {
          min: 2,
          max: 9,
          message: '长度2~9个字符',
          trigger: 'blur'
        }
        ],
        password: [{
          validator: validatePass,
          trigger: 'blur'
        }],
        checkPass: [{
          validator: validatePass2,
          trigger: 'blur'
        }],
        email: [{
          required: true,
          message: '请输入邮箱',
          trigger: 'blur'
        }],
        code: [{
          required: true,
          message: '请输入验证码',
          trigger: 'blur'
        }]
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (!valid) {
          // this.$message({
          //       message: '请填写全部信息',
          //       type: 'error',
          //     })
          return false;
        } else if (this.isClick != true) {
          this.$message({
            message: '请先获取验证码',
            type: 'info',
          })
        } else {
          register(this.ruleForm).then(resp => {
            let data = resp.data
            if (data.success) {
              this.ruleForm = {},
                this.$message({
                  message: data.message,
                  type: 'success',
                })
            } else {
              this.$message({
                message: data.message,
                type: 'error',
              })
            }
          }).catch(error => {
            this.$message({
              message: '网络异常',
              type: 'error',
            })
          })

        }
      });
      /*
      if(this.ruleForm.userName.length<=0||
         this.ruleForm.netName.length<=0||
         this.ruleForm.password.length<=0||
         this.ruleForm.checkPass.length<=0||
         this.ruleForm.email.length<=0||
         this.ruleForm.code.length<=0){
        this.$message({
              message: '请填写全部信息',
              type: 'error',
            })
      }else if(this.isClick!=true){
        this.$message({
              message: '请先获取验证码',
              type: 'info',
            })
      }else{
          register(this.ruleForm).then(resp => {
        let data = resp.data
        if (data.success) {
          this.ruleForm = {},
            this.$message({
              message: data.message,
              type: 'success',
            })
        } else {
          this.$message({
            message: data.message,
            type: 'error',
          })
        }
      }).catch(error=>{
        this.$message({
            message: '网络异常',
            type: 'error',
          })
      })
      }
      */
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    toLogin() {
      this.$router.push({ path: '/Login' })
    },
    getVerifyCode() {
      let emailAddress = this.ruleForm.email.toString()
      console.log(emailAddress)
      // var regEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
      var regEmail = /^([a-zA-Z0-9]+[-_\.]?)+@[a-zA-Z0-9]+\.[a-z]+$/
      if (regEmail.test(emailAddress)) {
        // this.$message({
        //   message: '发送成功',
        //   type: 'success'
        // })
        var countDown = setInterval(() => {
          if (this.count < 1) {
            this.isGeting = false
            this.disable = false
            this.getCode = '获取验证码'
            this.count = 60
            clearInterval(countDown)
          } else {
            this.isGeting = true
            this.disable = true
            this.getCode = this.count-- + 's后重发'
          }
        }, 1000)
        // this.axios.get('http://localhost:8080/sys-user/sendEmail?' + `emailAddress=${emailAddress}`)
        getEmailCode(emailAddress)
          .then(res => {
            this.$message({
              message: '发送成功',
              type: 'success'
            })
            this.isClick = true
          }).catch(error => {
            this.$message({
              message: '发送失败!QQ邮箱不存在',
              type: 'error'
            })
            this.count = 0
            this.isClick = false
          })
      } else {
        this.$message({
          message: '邮箱格式不正确',
          type: 'error'
        })
        this.isClick = false
      }
    }
  }
}
</script>

<style>
.sub {
  width: 100%;
  background: #505458;
}

#poster {
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
  margin: 0px;
  padding: 0px;
}

.register-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 10px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.register_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;

}

.codeGeting {
  background: #cdcdcd;
  border-color: #cdcdcd;
}
</style>
