<template>
    <div>
        <el-tooltip v-if="Show" :placement="placement" content="随机一张背景图片">
            <el-button color="#626aef" plain size='large' :icon="PictureFilled" @click="UpdateBG(API)"></el-button>
        </el-tooltip>
    </div>
</template>

<script setup lang="ts">
import axios from 'axios';
import { onMounted, ref, watch } from 'vue';
import { PictureFilled } from '@element-plus/icons-vue'

const body = document.body as HTMLBodyElement;

const props = defineProps({
    Show: {
        type: Boolean,
        default: false
    },
    placement: {
        type: String,
        default: 'left'
    }
});

const APIs = [
    {
        url: 'https://api.unmz.net/free/api/images/girl/getRandomGirlUrl?size=10',
        getres: (res: any) => {
            if (res.data.msg === 'success') {
                let index = Math.random() * res.data.data.length | 0;
                return res.data.data[index];
            }
        }
    }, {
        url: 'http://www.wudada.online/Api/ScTp',
        getres: (res: any) => {
            if (res.data.msg === "请求成功") {
                return res.data.data;
            }
        }
    }, {
        URL: "https://api.lucksss.com/api/cosbz",
        getres: (res: any) => {
            return "https://api.lucksss.com/api/cosbz"
        }
    }
];

let API = APIs[1]

const UpdateBG = (API: any) => {
    axios.get(API.url)
        .then((res: any) => {
            body.style.backgroundImage = `url(${API.getres(res)})`;
        })
        .catch((error: any) => {
            console.error('Error fetching data:', error);
        });
}

onMounted(() => {
    const html = `<div class="fullscreen-background"></div>`
    // body.innerHTML += html;
    UpdateBG(API)
})
</script>
<style>
body {
    background-position: center center;
    background-size: cover;
    background-attachment: fixed;
    background-repeat: no-repeat;
    transition: all 0.5s ease-in-out;
}

.darkbody::before {
    content: "";
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.77);
    /* 设置半透明背景色 */
    z-index: -1;
    /* 确保蒙层在其他内容之上 */
}
</style>