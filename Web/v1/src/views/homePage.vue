<template>
    <el-container>
        <el-aside class="Aside-Container" width="380px">
            <ApppAside />
        </el-aside>
        <el-main>
            <el-card class="Main-Container">
                <RouterView />
            </el-card>
        </el-main>
    </el-container>
</template>

<script setup lang="ts">
import ApppAside from '@/components/HomePage/AppAside.vue';
</script>

<style scoped>
.Aside-Container {
    padding: 20px;
    padding-right: 0;
}

.Main-Container {
    height: calc(100vh - 40px);

    overflow-y: auto;
}
</style>