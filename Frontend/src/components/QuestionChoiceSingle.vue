<template>
  <div>
    <b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input>
    <b-form-group v-slot="{ ariaDescribedby }">
      <b-form-radio disabled="true" v-for="answer in answers"  :key="answer" :aria-describedby="ariaDescribedby"  name="answers">
        <input type="text" v-model="answer.content" :key="index"/>
      </b-form-radio>
    </b-form-group>
    <b-button v-on:click="addNewAnswer" pill variant="success">+</b-button>
  </div>
</template>

<script>
export default {
  name: "QuestionChoiceSingle",
  data() {
    return{
      content: '',
      answers: []
    }
  },
  methods: {
    addNewAnswer: function () {
      try {
        this.answers.push({content: ''})
      }catch (msg){
        console.log(msg)
      }
    }
  }
}
</script>

<style scoped>

</style>