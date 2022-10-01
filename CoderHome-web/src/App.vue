<template>
    <router-view></router-view>
</template>

<style>
  html, body{
    margin: 0px;
    height: 100%;
  }
  #app{
    height: 100%;
  }
</style>

<script>
import Index from "@/views/Index";
export default {
  components: {Index}
}
</script>
