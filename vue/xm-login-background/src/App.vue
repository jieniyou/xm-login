<template>
  <div id="app">
    <LeftSideBar v-if="$route.meta.show!=false"/>
    <router-view />
  </div>
</template>

<script>
import LeftSideBar from './components/LeftSideBar.vue';
export default {
    name: "App",
    components: { LeftSideBar }
}
</script>

<style>
html,
body {
  width: 99%;
  height: 94%;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
