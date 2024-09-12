import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/apps/login/views/LoginView.vue'

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  // {
  //   path: "/:catchAll(.*)",
  //   redirect: '/404',
  // },
  // {
  //   path: '/404',
  //   name: 'NotFoundPage',
  //   component: () => import ('@/apps/login/views/NotFoundPage.vue'),
  // },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
