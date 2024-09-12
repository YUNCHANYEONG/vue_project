import { createApp } from 'vue'
import MainApp from '@/apps/main/views/MainView.vue'
import router from '@/apps/main/router'

createApp(MainApp)
.use(router)
.mount('#app')
