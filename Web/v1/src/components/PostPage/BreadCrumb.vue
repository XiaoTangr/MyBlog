<<<<<<< HEAD
<template>
    <div v-if="showbread === true" class="breadcrumb-Container">
        <el-breadcrumb separator="/" default="/">
            <el-breadcrumb-item :to="{ path: '/' }">home</el-breadcrumb-item>
            <el-breadcrumb-item v-for="(item, index) in routeList" :key="index" :to="{ path: item.path }">
                {{ item.name }}
            </el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue';
import { useRoute, useRouter } from 'vue-router';

import { useSiteData } from '@/stores';

const SiteData = useSiteData()
const route = useRoute()
const router = useRouter()

let routeList = ref(route.matched.filter(item => item.name))

let showbread = ref(true)
watch(
    // 路由更新时执行操作
    () => route.path,
    () => {
        updateRouteList();
        isRootPath();
        updateSiteTitle();
    })
/**
 * 更新路由列表
 */
const updateRouteList = () => {
    routeList.value = route.matched.filter(item => item.name)
}

/**
 * 判断是否是根路径
 */
const isRootPath = () => {
    if (router.currentRoute.value.path === "/") {
        showbread.value = false
    } else {
        showbread.value = true
    }
}
/**
 * 更新网站标题
 */
const updateSiteTitle = () => {
    SiteData.siteSubTitle = route.name as string;
}

</script>

=======
<template>
    <div v-if="showbread === true" class="breadcrumb-Container">
        <el-breadcrumb separator="/" default="/">
            <el-breadcrumb-item :to="{ path: '/' }">home</el-breadcrumb-item>
            <el-breadcrumb-item v-for="(item, index) in routeList" :key="index" :to="{ path: item.path }">
                {{ item.name }}
            </el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue';
import { useRoute, useRouter } from 'vue-router';

import { useSiteData } from '@/stores';

const SiteData = useSiteData()
const route = useRoute()
const router = useRouter()

let routeList = ref(route.matched.filter(item => item.name))

let showbread = ref(true)
watch(
    // 路由更新时执行操作
    () => route.path,
    () => {
        updateRouteList();
        isRootPath();
        updateSiteTitle();
    })
/**
 * 更新路由列表
 */
const updateRouteList = () => {
    routeList.value = route.matched.filter(item => item.name)
}

/**
 * 判断是否是根路径
 */
const isRootPath = () => {
    if (router.currentRoute.value.path === "/") {
        showbread.value = false
    } else {
        showbread.value = true
    }
}
/**
 * 更新网站标题
 */
const updateSiteTitle = () => {
    SiteData.siteSubTitle = route.name as string;
}

</script>

>>>>>>> af044e551b938f60addbbd51843ba5de60571109
<style scoped></style>