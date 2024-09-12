const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  runtimeCompiler: true,
  pages: {
    index: {
        name: 'login',
        entry: 'src/main.js',
        template: 'public/index.html',
        filename: 'index.html',
        title: 'Login Page'
    },
    main: {
        name: 'main',
        entry: 'src/apps/main/MainApp.js',
        template: 'public/main.html',
        filename: 'main.html',
        title: 'Main Page'
    },
  }
})
