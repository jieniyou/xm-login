<template>
  <div id="home_page">
    <!-- 初心图片和搜索 -->
    <el-row>
      <div class="sub-title">
        <img src="./../../static/img/title_icon/Wisdom in Essence.png" alt="初心" title="初心" width="150px" />
      </div>
      <el-col :span="12" id="search">
        <el-input class="inline-input" id="el-search" v-model="state" placeholder="请输入搜索内容">
          <button class="btn-search" style="padding-right:10px" slot="suffix" type="text" @click="toSearch()">搜索
          </button>
        </el-input>
      </el-col>
    </el-row>
    <!-- 轮播 -->
    <div class="block">
      <span class="demonstration">初心会员</span>
      <span class="demonstration" @click="toJieNiYou()">解你忧博客</span>
      <span class="demonstration" @click="toJieNiYouBlog()">解你忧Blog</span>
      <el-carousel trigger="click" height="300px">
        <div v-for="(slideshow,index) in slideshows" :key="index">
          <el-carousel-item v-if="slideshow.slideshowStatus===1?true:false">
            <img :src=slideshow.slideshowAddress height="100%" width="100%">
          </el-carousel-item>
        </div>
      </el-carousel>
    </div>
    <!-- 个人中心 -->
    <div class="personal-center">
      <!-- 显示的头像 -->
      <div style="width: 30%;margin: 0 auto;cursor:pointer" @click="toMyCart()">
        <el-avatar :size="80" :src=avatar @error="errorHandler">
          <!-- 头像加载失败 -->
          <img src="https://pic1.zhimg.com/80/v2-28f3c878bc99ad921a7db13ac879e4d8_720w.webp" />
        </el-avatar>
        <br>
        <span>Hi! </span><span class="netname">{{netname}}</span>
      </div>
      <br>
      <span v-if="this.$store.getters.status===1?true:false">
        <span>{{memberprefix}} </span><span>{{membername}}</span><span> {{membersuffix}}</span>
      </span>
    </div>
    <!-- 侧边栏 -->
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span style="color: #545c64; font-weight: 700; font-family: '楷体';">主题市场</span>
      </div>
      <div v-for="(category) in categories" :key="category.id" class="slide-car text item">
        <span @click="queryPhoneByCategory(category.id)">{{ category.categoryName }}</span>
      </div>
    </el-card>

    <!-- 商品 -->
    <el-row class="goods">
      <el-col class="card" :span="5" v-for="(phone, index) in phones" :key="index" :offset="index = 1">
        <el-card :body-style="{ padding: '0px' }">
          <img @click="queryGoodsDetails(phone.id)" :src="phone.phoneImg" class="image">
          <div style="padding: 14px;">
            <div style="cursor:pointer" @click="queryGoodsDetails(phone.id)">
              <span class="span-style">{{phone.phoneModel}}:{{phone.phoneDescription}}</span>
            </div>
            <div class="bottom clearfix">
              <span style="color:#545c64; font-size: 20px; font-family: 楷体;">¥ {{phone.phonePrice}}</span>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <Footer v-if="$route.meta.show" />
  </div>

</template>

<script>
import { getAllSlideshow, getAllCategory, getPhone, getPhoneByModel, getPhoneByCategory, getGoodsDetails, getBalanceById } from '@/api/goods';
import { getMember } from '@/api/member';
import Footer from '../components/common/Footer.vue'//引入自定义组件
export default {
  name: 'Index',
  components: { Footer },
  data() {
    return {
      restaurants: [],
      state: '',
      netname: '',
      memberprefix: '',
      membername: '未开通会员哦!',
      membersuffix: '',
      avatar: '',
      slideshows: [],
      categories: [],
      phones: [],
    };
  },
  methods: {
    errorHandler() {
      return true
    },
    toSearch() {
      let state = this.state.trim()
      if (state == null || state == '' || state == undefined) {
        this.$message({
          message: '您输入的内容为空哦',
          type: 'warning'
        })
        return
      } else {
        getPhoneByModel(state).then(resp => {
          let data = resp.data
          if (data.success) {
            let phones = data.content
            this.$store.commit("setQueryResult", phones)
            this.$router.push({ path: '/QueryPage' })
          } else {
            this.$message({
              message: data.message,
              type: 'warning'
            })
          }
        }).catch(error => {
          this.$message({
            message: '后端请求异常',
            type: 'error'
          })
        })
      }
    },
    queryPhoneByCategory(categoryid) {
      getPhoneByCategory(categoryid).then(resp => {
        let data = resp.data
        if (data.success) {
          let phones = data.content
          this.$store.commit("setQueryResult", phones)
          this.$router.push({ path: '/QueryPage' })
        }
      }).catch(error => {
        this.$message({
          message: '后端请求异常',
          type: 'error'
        })
      })
    },
    toMyCart() {
      if (this.$store.getters.status != '') {
        this.$router.push({ path: '/MyCart' })
      } else {
        return this.$router.push({ path: '/Login' })
      }
    },
    queryMember(id) {
      getMember(id).then(resp => {
        let data = resp.data
        if (data.success) {
          this.$store.commit("setMember", data.content)
          this.membername = this.$store.getters.member.memberName
          this.memberprefix = '您是尊贵的 '
          this.membersuffix = '会员 '
        }
      }).catch(error => {
        this.$message({
          message: '会员信息加载失败',
          type: 'error'
        })
      })
    },
    queryAllSlideshow() {
      getAllSlideshow().then(resp => {
        let data = resp.data
        if (data.success) {
          this.slideshows = data.content
        }
      }).catch(error => {
        this.$message({
          message: '轮播图加载失败',
          type: 'error'
        })
      })
    },
    queryAllCategory() {
      getAllCategory().then(resp => {
        let data = resp.data
        if (data.success) {
          this.categories = data.content
        }
      }).catch(error => {
        this.$message({
          message: '主题市场数据加载失败',
          type: 'error'
        })
      })
    },
    queryAllPhone() {
      getPhone().then(resp => {
        let data = resp.data
        if (data.success) {
          this.phones = data.content
        }
      }).catch(error => {
        this.$message({
          message: '商品数据加载失败',
          type: 'error'
        })
      });
      return this.phones
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
    toJieNiYou() {
      window.open("http://cnblogs.com/jieniyou")
    },
    toJieNiYouBlog() {
      window.open("http://jieniyou.github.io")
    },
  },
  mounted() {
    this.queryAllCategory();
    this.queryAllPhone();
    this.queryAllSlideshow();
    let userid = this.$store.getters.user.id
    this.queryMember(userid);
    // 加载钱包
    if (this.$store.getters.user != '') {
      this.utils.wallet(userid)
    }
    console.log(this.$store.getters.wallet.balance)

    let user = this.$store.getters.user;
    if (this.$store.getters.status === 1) {
      this.netname = user.netName
      this.avatar = user.userAvatar
    } else {
      this.netname = '你好呀!'
    }
  },
}
</script>

<style>
html,
#app,
body {
  height: 100%;
  min-width: 900px;
}
#home_page {
  width: 1230px;
  height: 500px;
  MARGIN-RIGHT: auto;
  MARGIN-LEFT: auto;
}

/* 初心+搜索 */
.sub-title {
  position: relative;
  width: 12%;
  height: auto;
  float: left;
  left: 10%;
}

#search {
  float: left;
}

.inline-input {
  position: relative;
  width: 100%;
  top: 50px;
  left: 30%;
}

#el-search {
  border: 1px #545c64 solid;
  border-radius: 25px;
}

.el-input__suffix {
  right: 0;
}

.btn-search {
  background: #545c64;
    color: #fff;
    width: 80px;
    height: 100%;
    border: none;
    border-radius: 25px;
}

.el-button:focus,
.el-button:hover {
  color: #fff;
  border-color: #545c64;
  background-color: #545c64;
}

/* 轮播 */
.block {
  position: relative;
  width: 500px;
  left: 25%;
}

.demonstration {
  cursor: pointer;
  margin-left: 12px;
  bottom: 15px;
  position: inherit;
}

.demonstration:hover {
  color: slategray;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
  border-radius: 15px;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
  border-radius: 15px;
}

/* 个人中心 */
.personal-center {
  position: relative;
  background-color: rgb(243 170 170 / 36%);
  border-radius: 15px;
  width: 300px;
  height: 260px;
  top: -60%;
  left: 66%;
  padding: 20px 0;
}

.netname:hover {
  color: tomato;
  cursor: pointer;
}

/* 侧边栏 */
.slide-car:hover {
  color: tomato;
  cursor: pointer;
}

.text {
  margin-left: 7%;
  letter-spacing: 2px;
  font: 12px/1.5 tahoma, arial, 'Hiragino Sans GB', '\5b8b\4f53', sans-serif;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.box-card {
  position: relative;
  height: 75%;
  text-align: left;
  width: 24%;
  top: -128%;
  left: 0%;
}

/* 商品 */
.goods {
  top: -120%;
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
