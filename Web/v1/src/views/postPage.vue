<template>
    <div class="pp-Container">
        <div>
            <MDRender :markdown="MDfile" />
        </div>
    </div>

</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue';
import MDRender from "@/components/PostPage/MDRender.vue"
//! 导入markdown文件，用于测试
import MDfile from '@/assets/README.md?raw';

// 媒体查询实现响应式布局
let screendata = ref({
    windowWidth: 0,
    leftspan: 6,
    mainspan: 18,
})
/**
 * 更新屏幕宽度数据
 * @param Width 屏幕宽度
 */
const ChangeWidth = (Width: number) => {
    if (Width < 960) {
        screendata.value.leftspan = 0
        screendata.value.mainspan = 24
    } else {
        screendata.value.leftspan = 6
        screendata.value.mainspan = 18
    }
}

onMounted(() => {
    // 初始化屏幕宽度数据
    screendata.value.windowWidth = document.documentElement.clientWidth;
    ChangeWidth(screendata.value.windowWidth)
    // 监听屏幕宽度变化
    window.onresize = () => {
        screendata.value.windowWidth = document.documentElement.clientWidth;
        ChangeWidth(screendata.value.windowWidth)
    }
})

</script>

<style>
.pp-Container {
    padding: 1em;
    overflow: auto;
}
</style>