import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/apps/main/views/HomeView.vue'
import ToDoList from '@/apps/main/views/ToDoList.vue'

const routes = [
  {
    path: '/main',
    name: 'main'
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('@/apps/main/views/AboutView.vue')
  },
  {
    path: '/list',
    name: 'list',
    component: ToDoList
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
