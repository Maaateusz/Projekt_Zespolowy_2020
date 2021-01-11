<template>
  <header>
    <h1>AnkietBud</h1>
    <div id="nav">
      <router-link to="/">Strona Główna</router-link> |
      <router-link to="/NewestQuestionnairies">Najnowsze Ankiety</router-link> |
      <router-link to="/NewQuestionnaire">Nowa Ankieta</router-link> |
      <router-link to="/QuestionnairiesResults">Wyniki Ankiet</router-link>
    </div>
  </header>
</template>

<script>
export default {
  name: "MyHeader"
}
</script>

<style scoped>
header {
  font-family: "Comic Sans MS", cursive, sans-serif;
  font-size: 20px;
  letter-spacing: 0px;
  word-spacing: 0px;
  background: -webkit-linear-gradient(#1b76b3,#c4bbbb, #1b76b3, #060607);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  font-weight: 400;
  font-style: normal;
  font-variant: small-caps;
  text-transform: none;
}
</style>