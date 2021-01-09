<template>
  <div class="home">
    <img alt="Logo" src="../assets/logo.png" />
    <Hello msg="Welcome" />
  </div>
</template>

<script>
// @ is an alias to /src
import Hello from "@/components/Hello";
export default {
  name: "Home",
  components: {
    Hello
  }
};
</script>
