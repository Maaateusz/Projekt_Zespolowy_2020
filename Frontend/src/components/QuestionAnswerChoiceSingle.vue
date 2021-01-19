<template>
  <div>
    <div class="radioButton">
      <b-form-group label="Treść pytania jednokrotnego wyboru:" >
        <b-form-radio v-model="radioButton" checked="checked" value="odpowiedz1">odpowiedz1</b-form-radio>
        <b-form-radio v-model="radioButton" checked="checked" value="odpowiedz2">odpowiedz2</b-form-radio>
        <b-form-radio v-model="radioButton" checked="checked" value="odpowiedz3">odpowiedz3</b-form-radio>
        <b-form-radio v-model="radioButton" checked="checked" value="odpowiedz4">odpowiedz4</b-form-radio>
      </b-form-group>
    </div>
  </div>
</template>

<script>
export default {
  name:"QuestionAnswerChoiceSingle",
  data(){
    return{
      radioButton:'odpowiedz1'
    }
  }
}
</script>

<style scoped>

</style>