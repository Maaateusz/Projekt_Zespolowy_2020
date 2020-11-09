<template>
  <div class="makenewform">
    <p id="title"><img alt="MakeNewForm" src="./make_new_form.png"></p>
    <p>Nazwa ankiety: <input type="text" placeholder="Wpisz nazwę ankiety" v-model="name"></p>
    <button type="button" @click="addQuestion">Dodaj nowe pytanie</button>
    <p><input v-if="clicked === true" type="text" placeholder="Wpisz treść pytania">
    <select v-if="clicked === true" name="Wybierz rodzaj pytania">
      <option value="text">tekstowe</option>
      <option value="checkbox">wielokrotnego wyboru</option>
      <option value="radio">jednokrotnego wyboru</option>
    </select>
    <button v-if="clicked === true" type="button" @click="addAnswers">Dodaj odpowiedzi</button></p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      clicked: false,
      id: 0,
      questions: []
    }
  },
  methods: {
    addQuestion() {
      this.clicked = true;
    },
    addAnswers() {
      this.clicked = false;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
div.makenewform {
  text-align: left;
  margin-left: 14cm;
  margin-right: 14cm
}

#title {
  text-align: center;
}
</style>
