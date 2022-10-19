<template>

  <body id="poster">
    <!-- 快捷键登录 @keyup.enter.native="login()" -->
    <el-form class="login-container" label-position="left" label-width="0px" @keyup.enter.native="login()">
      <h3 class="login_title">
        系统登陆
        <el-button @click="toRegister()">注册</el-button>
      </h3>

      <el-form-item label="">
        <el-input type="text" v-model="loginForm.userName" autocomplete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input type="password" v-model="loginForm.password" autocomplete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button class="sub" type="primary" v-on:click="login()">登录</el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
import {login} from '@/api/login';
export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        userName: '',
        password: ''
      }
    }
  },
  methods: {
    login() {
      // console.log('submit!', this.loginForm)
      if (this.loginForm.userName.length <= 0||this.loginForm.password.length <= 0) {
        this.$message({
          message: '请输入账号和密码',
          type: 'error'
        })
      } else {
          login(this.loginForm).then(resp=>{
          let data = resp.data
          if (data.success) {
              this.$message({
                message: data.message,
                type: 'success'
              })
            this.$store.commit('setUser',data.content)//存储user
            this.$store.commit('setStatus',1)//存储状态

            console.log(this.$store.getters.user.id)
            console.log(this.$store.getters.user.userName)
            console.log(this.$store.getters.status)
           
            this.$router.push({ path: '/Index' })
          } else {
            this.$message({
              message: data.message,
              type: 'error'
            })
          }
        }).catch(error=>{
          this.$message({
              message: '后台请求数据失败',
              type: 'error'
            })
        })
      }
    },
    toRegister() {
      this.$router.push({ path: '/Register' })
    },
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
}

body {
  margin: 0px;
  padding: 0px;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;

}
</style>
