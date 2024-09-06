<script setup>
import axios from "axios";
import {ref} from 'vue'
import instance from '@/common.js'
</script>

<template>
    <div>
        <div>
            <h2>Please Sign-In</h2>
            <div id="loginForm">
                <form @submit.prevent="submitForm">
                <p>
                    <input v-model="LoginForm.email" class="input-email" name="email" autocomplete='off' placeholder="Enter your ID"><br>
                </p>
                <p>
                    <input v-model="LoginForm.password" class="input-password" name="password" autocomplete='off' placeholder="Enter your password" type="password">
                </p>
                <p>
                    <button type="submit" class="btn">sign-in</button>
                </p>
                </form>
            </div>
        </div>
  </div>
</template>

<script>
const LoginForm = ref({
  "email": "",
  "password": ""
});

const submitForm = () => {
    console.log(process.env)
    const url = instance.backendURL + '/account/sign-in';
    const data = LoginForm.value;

    axios.post(url, data)
    .then(res => {
        if (res.data.accessToken) {
            localStorage.setItem('user', JSON.stringify(res.data));
        }
        location.href = "/list";
    })
    .catch(res => {
        console.log("error response",res.response);
        console.error("error", res);
        localStorage.removeItem('user');
    });
}
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

#loginForm {
  width: 500px;
  margin: auto;
}
</style>
  