<template>
  <div class="QuestionAddingArea">
    <b-button v-on:click="showQuestions" variant="primary">Dodaj nowe pytanie</b-button>
    <div v-if="this.questionVisible==true">
      <div class="questionsDivLine">
        <div v-on:click="addQuestionInParent('singleChoice')" class="questionDivTuple">Pojedynczy wybór</div>
        <div v-on:click="addQuestionInParent('multipleChoice')" class="questionDivTuple">Wielokrotny wybór</div>
      </div>
      <div class="questionsDivLine">
        <div v-on:click="addQuestionInParent('scale')" class="questionDivTuple">Skala</div>
        <div v-on:click="addQuestionInParent('slider')" class="questionDivTuple">Suwak</div>
        <div v-on:click="addQuestionInParent('rating')" class="questionDivTuple">Ocena</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "QuestionAddingArea",
  data(){
    return{
      questionVisible: false
    }
  },
  components: {
  },
  methods: {
    showQuestions: function (){
      try{
        this.questionVisible = !this.questionVisible;
      }catch (msg){
        console.log(msg)
      }
    },
    addQuestionInParent: function (typeOfQuestion){
      this.$emit('newQuestionToAdd', typeOfQuestion)
    }
  }
}
</script>

<style scoped>
.questionsDivLine{
  flex: 1;
  display: flex;
  flex-direction: row;
}
.questionDivTuple{
  flex: 1;
  padding: 0.2em;
  border: 0.1em outset #ccc;
  border-radius: 0.5em;
  margin: 0.2em;
  font-size: 1em;
}
</style>