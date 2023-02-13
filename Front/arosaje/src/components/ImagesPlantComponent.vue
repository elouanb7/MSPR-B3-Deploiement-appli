<template>
    <div class="fixed-images-container">
      <div class="fixed-image-left">
        <div class="background-image-left"></div>
        <img :src="leftImage" alt="left image"/>
      </div>
      <div class="fixed-image-right">
        <div class="background-image-right"></div>
        <img :src="rightImage" alt="right image"/>
      </div>
    </div>
</template>
  
<script>
  export default {
    data() {
      return {
        leftImage: "/images/plant-left",
        rightImage: "/images/plant-right"
      };
    }
  };
</script>
  
<style>
  .fixed-images-container {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    display: flex;
  }

  .background-image-left {
    position: relative;
    max-width: 422px;
    width: 100%;
    height: 422px;
    left: 0px;
    top: 147px;
    background: #c5ffdc;
    filter: blur(125px);
    opacity: 0.25;
  }

  .background-image-right {
    position: relative;
    max-width: 422px;
    width: 100%;
    height: 422px;
    right: 0px;
    top: 147px;
    background: #c5ffdc;
    filter: blur(125px);
    opacity: 0.25;
  }
  
  .fixed-image-left {
    position: absolute;
    width: 266px;
    height: 323px;
    left: 0px;
    top: 701px;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .fixed-image-right {
    position: absolute;
    width: 247px;
    height: 465px;
    right: 0px;
    top: 147px;
    right: 0;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  img {
    max-width: 100%;
    max-height: 100%;
  }
</style>