<<<<<<< HEAD
<template>
    <div @click="openLink()">
        <el-tooltip :content="desc" placement="bottom" effect="light">
            <el-icon :size="size">
                <slot>
                    <Link />
                </slot>
            </el-icon>
        </el-tooltip>
    </div>
</template>

<script setup lang="ts">
import { Link } from '@element-plus/icons-vue';

const props = defineProps({
    icon: {
        type: String,
    },
    desc: {
        type: String,
        default: "输入提示文本"
    },
    size: {
        type: String || Number,
        default: '20' // 'default' | 'small' | 'large' | number
    },
    href: {
        type: String,
        required: true,
        default: '#'
    },
    target: {
        type: String,
        default: '_blank'
    }
});

const openLink = () => {
    window.open(props.href, props.target);
}

</script>

<style scoped>
div {
    cursor: pointer;
}

div:hover {
    color: #409eff;
    /* 鼠标悬停时的颜色 */
}
=======
<template>
    <div @click="openLink()">
        <el-tooltip :content="desc" placement="bottom" effect="light">
            <el-icon :size="size">
                <slot>
                    <Link />
                </slot>
            </el-icon>
        </el-tooltip>
    </div>
</template>

<script setup lang="ts">
import { Link } from '@element-plus/icons-vue';

const props = defineProps({
    icon: {
        type: String,
    },
    desc: {
        type: String,
        default: "输入提示文本"
    },
    size: {
        type: String || Number,
        default: '20' // 'default' | 'small' | 'large' | number
    },
    href: {
        type: String,
        required: true,
        default: '#'
    },
    target: {
        type: String,
        default: '_blank'
    }
});

const openLink = () => {
    window.open(props.href, props.target);
}

</script>

<style scoped>
div {
    cursor: pointer;
}

div:hover {
    color: #409eff;
    /* 鼠标悬停时的颜色 */
}
>>>>>>> af044e551b938f60addbbd51843ba5de60571109
</style>