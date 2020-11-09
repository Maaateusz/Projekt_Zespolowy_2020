<template>
  <div id="app">
    <img alt="Logo AnkietBud" src="logo.png">
    <MakeNewForm />
  </div>
</template>

<script>
import MakeNewForm from './components/MakeNewForm.vue'

export default {
  name: 'App',
  components: {
    MakeNewForm
  }
}
</script>

<style>
#app {
  font-family: Helvetica;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #0f0f0f;
  margin-top: 60px;
}
</style>
