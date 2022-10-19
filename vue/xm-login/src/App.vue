<template>
  <div id="app">
    <Header v-if="$route.meta.show" />
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
  /**防止页面刷新丢失store数据 Begin*/
  created() {
    // 在页面加载时读取sessionStorage里的状态信息
    if (sessionStorage.getItem('store')) {
      this.$store.replaceState(
        Object.assign(
          {},
          this.$store.state,
          JSON.parse(sessionStorage.getItem('store'))
        )
      )
    }

    // 在页面刷新时将vuex里的信息保存到sessionStorage里
    // beforeunload事件在页面刷新时先触发
    window.addEventListener('beforeunload', () => {
      sessionStorage.setItem('store', JSON.stringify(this.$store.state))
    })
  }
  /**防止页面刷新丢失store数据 End*/
}
</script>

<style>
body {
  background: rgb(251 55 146 / 15%);
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

a {
  text-decoration-line: none;
}

/**
 * 隐藏滚动条
 */
/*
html{
  height: 100%;
  width: 100%;
  overflow: -moz-hidden-unscrollable;
}
body{
  height: 100%;
  width: 100%;
  -ms-overflow-style: none;
  overflow: auto;
}
body::-webkit-scrollbar { display: none; }
*/
</style>
