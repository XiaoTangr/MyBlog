import { createRouter, createWebHistory } from 'vue-router'



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Index',
      component: () => import('@/views/IndexView.vue'),
      children: [
        {
          path: '/',
          name: 'Home',
          component: () => import('@/views/Index/HomeView.vue')
        },
        {
          path: '/categories',
          name: 'Categories',
          component: () => import('@/views/Index/CategoriesView.vue')
        },
        {
          path: '/about',
          name: 'About',
          component: () => import('@/views/Index/AboutView.vue')
        }
      ]
    },
    {
      path: '/post',
      name: 'Post',
      component: () => import('@/views/PostView.vue')
    },
    {
      path: '/admin',
      name: 'Admin',
      component: () => import('@/views/AdminView.vue')
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/views/LoginView.vue'),
    },
    // 打算直接使用未匹配的路径名称导航到该路径，这是必要的
    {
      path: '/:pathMatch(.*)*',
      name: 'not-found',
      component: () => import('@/views/Public/404.vue')
    },
    // 如果你省略了最后的 `*`，在解析或跳转时，参数中的 `/` 字符将被编码
    {
      path: '/:pathMatch(.*)',
      name: 'bad-not-found',
      component: () => import('@/views/Public/404.vue')
    },
  ]
})

export default router
