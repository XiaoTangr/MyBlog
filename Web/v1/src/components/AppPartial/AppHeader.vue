<<<<<<< HEAD
<template>

    <div class="Header-Out-Container">
        <div class="header-Container">
            <div class="header-siteinfo-Container">
                <img class="siteinfo-favicon" src="/favicon.jpg" alt="">
                <h2 class="siteinfo-title">{{ props.SiteTitle }}</h2>
            </div>
            <div class="header-main-Container">
                <h2 class="header-main-top">{{ props.PageTitle }}</h2>
            </div>
            <div class="header-right-Container">
                ddddeee
            </div>
        </div>
        <div class="breadcrumb-Container">
            <BreadCrumb />
        </div>

    </div>
</template>

<script setup lang="ts">
import BreadCrumb from "../utils/BreadCrumb.vue";

const props = defineProps([
    "SiteTitle",//站点标题
    "PageTitle",//站点副标题
])
</script>

<style scoped>
.Header-Out-Container {
    display: flex;
    flex-direction: column;
    position: sticky;
    z-index: 10;
    background: var(--el-bg-color-overlay);
    top: 0;
    box-shadow: var(--el-box-shadow);
    height: var(--Header-Out-Container-Height);
    margin-bottom: var(--header-margin-bottom);
}

.header-Container {
    height:var( --header-Container-Height);
    display: flex;
    flex-direction: row;
}
.breadcrumb-Container{
    height: var(--breadcrumb-Container-Height)
}
.header-siteinfo-Container,
.header-main-Container,
.header-right-Container {
    height: 100%;
    display: flex;
    padding: .5em;
}

.header-siteinfo-Container {
    justify-self: center;
    align-items: center;
}

.header-main-Container {
    flex: 1;
    flex-direction: column;
    justify-content: center;
    padding: 0 .5em;
}

.header-right-Container {
    display: flex;
    justify-content: flex-end;
    align-items: center;
}

.siteinfo-favicon {
    height: 100%;
    border-radius: 50%;
    border: 1px solid var(--el-border-color);
}

.siteinfo-title {
    margin: 0 .5em;
}
=======
<template>

    <div class="Header-Out-Container">
        <div class="header-Container">
            <div class="header-siteinfo-Container">
                <img class="siteinfo-favicon" src="/favicon.jpg" alt="">
                <h2 class="siteinfo-title">{{ props.SiteTitle }}</h2>
            </div>
            <div class="header-main-Container">
                <h2 class="header-main-top">{{ props.PageTitle }}</h2>
            </div>
            <div class="header-right-Container">
                ddddeee
            </div>
        </div>
        <div class="breadcrumb-Container">
            <BreadCrumb />
        </div>

    </div>
</template>

<script setup lang="ts">
import BreadCrumb from "../utils/BreadCrumb.vue";

const props = defineProps([
    "SiteTitle",//站点标题
    "PageTitle",//站点副标题
])
</script>

<style scoped>
.Header-Out-Container {
    display: flex;
    flex-direction: column;
    position: sticky;
    z-index: 10;
    background: var(--el-bg-color-overlay);
    top: 0;
    box-shadow: var(--el-box-shadow);
    height: var(--Header-Out-Container-Height);
    margin-bottom: var(--header-margin-bottom);
}

.header-Container {
    height:var( --header-Container-Height);
    display: flex;
    flex-direction: row;
}
.breadcrumb-Container{
    height: var(--breadcrumb-Container-Height)
}
.header-siteinfo-Container,
.header-main-Container,
.header-right-Container {
    height: 100%;
    display: flex;
    padding: .5em;
}

.header-siteinfo-Container {
    justify-self: center;
    align-items: center;
}

.header-main-Container {
    flex: 1;
    flex-direction: column;
    justify-content: center;
    padding: 0 .5em;
}

.header-right-Container {
    display: flex;
    justify-content: flex-end;
    align-items: center;
}

.siteinfo-favicon {
    height: 100%;
    border-radius: 50%;
    border: 1px solid var(--el-border-color);
}

.siteinfo-title {
    margin: 0 .5em;
}
>>>>>>> af044e551b938f60addbbd51843ba5de60571109
</style>