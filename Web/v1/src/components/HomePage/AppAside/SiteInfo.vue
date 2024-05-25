<template>
    <div>
        <el-card class="SiteInfo-Container">
            <div class="Avatar-Container">
                <el-avatar :src="data.SiteAvatar" size="large" />
                <h2>
                    {{ data.SiteName }}
                </h2>
                <p>
                    {{ data.SiteDesc }}
                </p>
            </div>
            <div class="SocialLink-Container">
                <SocialIcon href="https://www.baidu.com">
                    <Link />
                </SocialIcon>
                <SocialIcon href="https://www.baidu.com" desc="你好">
                    <Link />
                </SocialIcon>
            </div>
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import SocialIcon from './components/SocialIcon.vue'
import { Link } from '@element-plus/icons-vue';


const data = ref({
    SiteAvatar: "/favicon.jpg",
    SiteName: "站点名称",
    SiteDesc: "一只小唐的Blog",
})
</script>

<style scoped>
.SiteInfo-Container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.Avatar-Container {
    display: flex;
    flex-direction: column;
    align-items: center
}

.SocialLink-Container {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}

.SocialLink-Container div {
    margin: .25em;
}
</style>