<<<<<<< HEAD
<!-- 
    change the Dark mode of the theme
    copy from my another project
    see the link below
-->
<!--
    https://github.com/XiaoTangr/XTBlog_edu/blob/main/Client/VUE/src/components/theisdark.vue
    Author :XiaoTangr
    License :MIT
-->
<template>
    <div >
        <el-tooltip :placement="placement" :content="isDark ? 'Dark Mode' : 'Light Mode'">
            <el-button size='large' plain @click="toggleDark" :color="isDark ? '#181818' : '#cdcdcd'"
                :icon="DarkIcon" />
        </el-tooltip>
    </div>
</template>

<script setup lang="ts">
import { useDark } from '@vueuse/core'
import { onBeforeMount, onMounted, ref, watch } from 'vue';
import { MoonNight, PartlyCloudy } from '@element-plus/icons-vue'
const isDark = useDark();
const DarkIcon = ref(isDark.value ? MoonNight : PartlyCloudy)

const props = defineProps({
    placement: {
        type: String,
        default: 'left'
    }
})

const toggleDark = () => {
    isDark.value = !isDark.value
}
const body = document.body as HTMLBodyElement;
onMounted(() => {

    if (isDark.value) {
        DarkIcon.value = MoonNight
        body.classList.add('darkbody')
    } else {
        DarkIcon.value = PartlyCloudy
        body.classList.remove('darkbody')
    }
})
// 监听主题更新
watch(isDark, () => {
    if (isDark.value) {
        DarkIcon.value = MoonNight
        body.classList.add('darkbody')

    } else {
        DarkIcon.value = PartlyCloudy
        body.classList.remove('darkbody')
    }
})

</script>

=======
<!-- 
    change the Dark mode of the theme
    copy from my another project
    see the link below
-->
<!--
    https://github.com/XiaoTangr/XTBlog_edu/blob/main/Client/VUE/src/components/theisdark.vue
    Author :XiaoTangr
    License :MIT
-->
<template>
    <div >
        <el-tooltip :placement="placement" :content="isDark ? 'Dark Mode' : 'Light Mode'">
            <el-button size='large' plain @click="toggleDark" :color="isDark ? '#181818' : '#cdcdcd'"
                :icon="DarkIcon" />
        </el-tooltip>
    </div>
</template>

<script setup lang="ts">
import { useDark } from '@vueuse/core'
import { onBeforeMount, onMounted, ref, watch } from 'vue';
import { MoonNight, PartlyCloudy } from '@element-plus/icons-vue'
const isDark = useDark();
const DarkIcon = ref(isDark.value ? MoonNight : PartlyCloudy)

const props = defineProps({
    placement: {
        type: String,
        default: 'left'
    }
})

const toggleDark = () => {
    isDark.value = !isDark.value
}
const body = document.body as HTMLBodyElement;
onMounted(() => {

    if (isDark.value) {
        DarkIcon.value = MoonNight
        body.classList.add('darkbody')
    } else {
        DarkIcon.value = PartlyCloudy
        body.classList.remove('darkbody')
    }
})
// 监听主题更新
watch(isDark, () => {
    if (isDark.value) {
        DarkIcon.value = MoonNight
        body.classList.add('darkbody')

    } else {
        DarkIcon.value = PartlyCloudy
        body.classList.remove('darkbody')
    }
})

</script>

>>>>>>> af044e551b938f60addbbd51843ba5de60571109
<style scoped></style>