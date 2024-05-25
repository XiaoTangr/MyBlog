<template>
    <div v-html="markdownToHtml" class="markdown-body"></div>
</template>
<script setup lang="ts">
import { marked } from 'marked';
import { onMounted, ref } from 'vue';
// 代码高亮组件
import hljs from 'highlight.js'
import 'highlight.js/styles/github.css'
import 'highlight.js/lib/common'

const props = defineProps(["markdown"])

const render = new marked.Renderer()
marked.setOptions({
    renderer: render, // 这是必填项
    gfm: true,	// 启动类似于Github样式的Markdown语法
    pedantic: false, // 只解析符合Markdwon定义的，不修正Markdown的错误
    sanitize: false, // 原始输出，忽略HTML标签（关闭后，可直接渲染HTML标签）
    tables: true, // 支持Github形式的表格，必须打开gfm选项
    breaks: false, // 支持Github换行符，必须打开gfm选项
})
const markdownToHtml = ref()
markdownToHtml.value = marked(props.markdown)

onMounted(() => {
    // 代码高亮
    const CodeList = document.querySelectorAll('code');
    CodeList.forEach((item) => {
        hljs.highlightElement(item);
        item.innerHTML = `<ol><li>${item.innerHTML.replace(
            /\n/g,
            `</li><li class="line">`
        )}</li></ol>`;
    });
})
</script>
<style>
pre {
    margin: 1em 0;
    position: relative;
    border: var(--el-border-width) var(--el-border-style) var(--el-border-color);
    box-shadow: var(--el-box-shadow);
    border-radius: var(--el-card-border-radius);
    overflow-x: auto;
}

.hljs {
    background: var(--el-bg-color-overlay) !important;
    display: block;
    min-width: 600px;
    width: 100%;
    margin: 0;
    padding: 1px;
    color: var(--el-text-color-primary);
    font-weight: 200;
    font-size: 0.9rem;
    font-family: Menlo, Monaco, Consolas, Courier, monospace;
    line-height: 1.5;
    white-space: pre-wrap;
    border: 0;
}

.hljs ol {
    margin: 0 0 0 35px;
    padding: 0;
    list-style-type: decimal;
}

.hljs ol li {
    padding: 5px;
    padding-left: 10px;
    color: #abb2bf;
    white-space: pre;
    list-style: decimal-leading-zero;
    list-style-position: outside;
    border-left: 1px solid #c5c5c5;
}

.markdown-body p:has(> img) {
    display: flex;
    justify-content: center;
    align-items: center;
}

.markdown-body img {
    max-height: 360px;

    object-fit: cover;
}
</style>