/**
 * router.js
 * @author: 一颗橘子唐
 * @description: 路由配置
 * @create: 2024年3月27日15:20:19
 */
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/views/HomePage.vue'),
      children: [
        {
          path: '/',
          name: 'home',
          component: () => import('@/views/PostsListPage.vue'),
        },
        {
          path: '/post',
          name: 'post',
          component: () => import('@/views/PostPage.vue'),
        },
        {
          path: '/about',
          name: 'about',
          component: () => import('@/views/AboutPage.vue'),
        },
        {
          path: "/Categories",
          name: "categories",
          component: () => import('@/views/CategoriesPage.vue'),
        }
      ]
    },
    {
      path: '/edit',
      name: 'edit',
      component: () => import('@/views/EditPage.vue'),
    },
    {
      path: '/Admin',
      name: 'admin',
      component: () => import('@/views/AdminPage.vue'),
    },
    {
      path: '/Login',
      name: 'login',
      component: () => import('@/views/LoginPage.vue'),
    },
  ]
})

export default router
