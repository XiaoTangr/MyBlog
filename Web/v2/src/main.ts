import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import TDesign from 'tdesign-vue-next';
import 'tdesign-vue-next/es/style/index.css';

const app = createApp(App)

router.beforeEach((to, from, next) => {
    // 设置页面标题
    document.title = `${to.meta.title}`;
    next();

})


app.use(createPinia())
app.use(router)
app.use(TDesign);

app.mount('#app')

