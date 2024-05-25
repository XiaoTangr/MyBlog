<template>
    <div class="postItem-Container">
        <el-card v-for="(item, index) in postItemData" :key="index" class="posts-item">
            <div class="Item-Header">
                <RouterLink class="posts-item-title" :to="'/post/' + item.id">
                    <h3>
                        {{ item.title }}
                    </h3>
                </RouterLink>
                <div class="Item-DateInfo">
                    <p>
                        创建于:{{ item.create_date }}
                    </p>
                    <p>
                        更新于:{{ item.update_date }}
                    </p>

                </div>
            </div>
            <div class="">
                <p>{{ item.summary }}</p>
            </div>

        </el-card>
    </div>
</template>

<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import axios from 'axios';
import { computed, onMounted, ref } from 'vue'

const postItemCount = ref(0)
const postItemData = ref([{
    title: '测试',
    summary: '测试',
    create_date: '2023-04-10',
    update_date: '2023-04-10',
    id: 1
}])


onMounted(() => {
    getPostCount().then((res) => {
        postItemCount.value = res.data
    })
    getPostData().then((res) => {
        postItemData.value = res.data
    })
})


const getPostData = async () => {
    try {
        const response = await axios.post('/api/getpostdata');
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}


const getPostCount = async () => {
    try {
        const response = await axios.post('/api/getPostCount');
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}


const count = ref(10)
const loading = ref(false)
const noMore = computed(() => count.value >= 20)
const disabled = computed(() => loading.value || noMore.value)
const load = () => {
    loading.value = true
    setTimeout(() => {
        count.value += 2
        loading.value = false
    }, 2000)
}




</script>

<style scoped>
.postItem-Container {
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
}

.posts-item {
    width: 70%;
    margin: 1em;
    margin-top: 0;
    background: var(--floatbar-bg-color);
    backdrop-filter: blur(1em);
    -webkit-backdrop-filter: blur(1em);
}

.posts-item:first-child {
    margin-top: 1em;
}


.Item-Header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 1em;
}
.Item-DateInfo{
    font-size: .7em;
    color: gray;
    display: flex;
}
.Item-DateInfo p{
    padding: 0 1em;
}
.posts-item-title {
    text-decoration: none;
    color: var(--text-color);
}

.posts-item-title:hover {
    color: var(--text-hover-color);
}

.posts-item-title:active {
    color: var(--text-active-color);
}
</style>