<template>
  <div class="home">
    <img alt="Logo" src="../assets/logo.png" />
  </div>
</template>

<script>
// @ is an alias to /src
export default {
  name: "home",
};
</script>

<style scoped>
@keyframes ruch
{
  0% {background-position:0 0, 0 0, 0 0;}
  100% {background-position:10000px 0, 7500px 0, 5000px 0;}
}

img {
  background: linear-gradient(0deg, rgba(27,118,179,1) 0%, rgba(196,187,187,1) 100%);

  width: -moz-available;
  border-radius: 20em;
  margin-top: 5em;
  margin-left: 25em;
  margin-right: 25em;
  margin-right: 25em;
  /*
  border:3px solid #EEE;
  animation:ruch 300s linear infinite alternate;
  -webkit-animation:ruch 300s linear infinite alternate;
  background-image:url('https://webkod.pl/images/para1.png'),
  url('https://webkod.pl/images/para2.png'),
  url('https://webkod.pl/images/para3.png');
  */
}
</style>
