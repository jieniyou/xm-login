<template>
  <div class='footer'>
    <span class="scroll"></span>
      <el-divider></el-divider>
  </div>
</template>
<style>
  .el-divider{
    background-color: rgb(84, 92, 100);
  }
</style>
<style scoped>
.footer {
  position: relative;
  height: 50px;
  top: -110%;
  right: 0;
  bottom: 0;
  left: 0;
}
.footer{
      cursor: pointer;
    }
    .copyright{
      font-size: 12px;
    }
    .info{
      font-size: 14px;
      color: #72767b;
      line-height: 25px;
    }
    .footer .scroll{
      display: inline-block;
      width: 20px;
      height: 20px;
      border-radius: 5px;
      border:1px solid #448aff;
      background-color: rgba(68,138,255,0.2);
      position: absolute;
      left: 5%;
      top: -25px;
      z-index: 10;
      animation: scrollA infinite 20s linear alternate;
    }
    @keyframes scrollA {
      0% {left: 5%;transform: rotate(180deg);};
      10% {left: 5%;transform: rotate(270deg);}
      20% {left: 5%;transform: rotate(450deg);}
      25% {left: 10%;transform: rotate(540deg);}
      30% {left: 20%;transform: rotate(720deg);}
      35% {left: 30%;transform: rotate(900deg);}
      40% {left: 40%;transform: rotate(1080deg);}
      45% {left: 50%;transform: rotate(1260deg);}
      50% {left: 60%;transform: rotate(1440deg);}
      55% {left: 70%;transform: rotate(1620deg);}
      60% {left: 80%;transform: rotate(1800deg);}
      80% {left: 90%;transform: rotate(2610deg);}
      90% {left: 90%;transform: rotate(2340deg);}
      100% {left: 90%;transform: rotate(2520deg);}
    }
</style>
<script>
export default {
  name: 'Footer',
  data () {
    return {
      drawer: false,
      direction: 'btt'
    }
  },
  methods: {
    handleClose (done) {
      done()
    }
  }
}
</script>