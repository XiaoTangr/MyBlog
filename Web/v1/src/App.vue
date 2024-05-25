<template>
  <div class="App-Container">
    <RouterView />
    <AppFloatBar />
  </div>
</template>
<script setup lang="ts">
import { onBeforeMount } from 'vue';
import { useSiteData } from '@/stores/index';
import { RouterView } from 'vue-router';
import AppFloatBar from './components/AppPartial/AppFloatBar.vue';

const SiteData = useSiteData();
onBeforeMount(() => {

  // 初始化时获取当前图标名称
  var currentIcon = SiteData.siteFavicon;

  // 修改或者创建站点图标标签
  var link: any = document.querySelector("link[rel*='icon']") || document.createElement('link');
  link.type = 'image/x-icon';
  link.rel = 'shortcut icon';
  link.href = currentIcon;
})
</script>

<style scoped>
.App-Container{
  height: 100%;
  width: 100%;
}
</style>