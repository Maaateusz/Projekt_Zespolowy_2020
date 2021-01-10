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

</style>