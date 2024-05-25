<template>
    <div class="FloatTools-Continer">
        <IsDark />
        <BgImg :Show="true" />
    </div>
</template>

<script setup lang="ts">
import IsDark from "./AppFloatBar/IsDark.vue";
import BgImg from "./AppFloatBar/BgImg.vue";

</script>

<style scoped>
.FloatTools-Continer {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    z-index: 9;
    position: fixed;
    right: .5em;
    bottom: 50%;
    transform: translate(0, 50%);
    background: var(--floatbar-bg-color);
    box-shadow: var(--el-box-shadow);
    border-radius: 4px;
    backdrop-filter: blur(1em);
    -webkit-backdrop-filter: blur(1em);
}

.FloatTools-Continer * {
    padding: 1em;
}

.FloatTools-Continer *:last-child {
    padding-top: 0;
}
</style>