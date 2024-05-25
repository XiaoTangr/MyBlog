<template>
    <div class="EP-Container">

        <el-card class="EP-Content-Container">
            <div id="vditor"></div>
        </el-card>

    </div>
</template>
<script setup lang="ts">
import { onMounted, ref, watch } from 'vue'
import { useDark } from '@vueuse/core'
import { Upload, MessageBox } from '@element-plus/icons-vue';

// md编辑器2
import Vditor from 'vditor'
import 'vditor/dist/index.css';



let isDark = useDark();

// 监听主题变化，应用到markdown编辑器
watch(isDark, () => {
    if (isDark.value) {
        vditor.value.setTheme("dark");
    } else {
        vditor.value.setTheme("classic");
    }
})

// markdown编辑器初始化
const vditor = ref()
onMounted(() => {
    vditor.value = new Vditor("vditor", {
        theme: isDark.value === true ? "dark" : "classic",
        lang: "zh_CN",
        mode: "ir",
        cache: {
            "enable": false
        },
        height: "100%",
        width: "100%",
        placeholder: "请输入内容",
        preview: {
            hljs: {
                style: 'github',
                lineNumber: true,
            },
        }
    });
});

</script>

<style scoped>
.EP-Container {
    display: flex;
        flex: 1;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        overflow: auto;
        padding: 1em;
}

.EP-Content-Container {
    overflow: auto;
}
</style>