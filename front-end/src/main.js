import { createApp } from 'vue'
import App from '@/apps/login/App.vue'
import router from '@/apps/login/router'

createApp(App)
.use(router)
.mount('#app')
