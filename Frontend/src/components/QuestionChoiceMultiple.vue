<template>
  <div class="questionChoiceMultiple">
   <div><b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input></div>
    <b-form-group v-slot="{ ariaDescribedby }">
      <div class="answerValue">
      <div><b-form-checkbox disabled="true" v-for="answer in answers"  :key="answer" :aria-describedby="ariaDescribedby"  name="answers">
        <input class="form-control form-rounded" type="text" v-model="answer.content" :key="index"/>
      </b-form-checkbox>
      </div>
  </div>
    </b-form-group>
  <b-button v-on:click="addNewAnswer" pill variant="success">+</b-button>
  </div>
</template>

<script>
export default {
  name: "QuestionChoiceMultiple",
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

.questionChoiceMultiple{
  padding: 0.5em;
  border: 0.20em outset #ccc;
  border-radius: 0.15em;
}
.answerValue{
  flex-direction: column;
  display: flex;
  float: left;
  width: auto;
  padding: 1em;
}

</style>