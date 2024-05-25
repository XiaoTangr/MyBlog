/// <reference types="vite/client" />

interface ImportMetaEnv {
    readonly APP_NODE_ENV: string;//定义提示信息 数据是只读的无法被修改
    readonly APP_API_URL: string;
    //多个变量定义多个...
}
declare module '*.vue' {
    import { ComponentOptions } from 'vue'
    const componentOptions: ComponentOptions
    export default componentOptions
}
declare module 'axios'