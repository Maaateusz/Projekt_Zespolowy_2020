<template>
  <div class="Questionnaire">
    <form >
      <input class="form-control" type="text" name="questionaryName" value="" placeholder="Nazwa ankiety..." v-model="Questionary.questionaryName"/>
      <textarea class="form-control" v-model="Questionary.description" placeholder="Opis ankiety"/>
      <QuestionsAddingArea/>
      <input style="margin: 2%; width:96%" class="form-control" type="date"/>
      <button style="margin-right: 2%" class="btn btn-outline-dark" type="button" >Zapisz</button>
    </form>
  </div>
</template>

<script>
import QuestionsAddingArea from "@/components/QuestionsAddingArea";
export default {
  name: "newQuestionnaire",
  data(){
    return{
      Questionary: {
          questionaryName: '',
          description: '',
          questions: [
            {}
          ],
          finishDate: ''
        }
    }
  },
  components:{
    QuestionsAddingArea
  }
};
</script>
<style scoped>

</style>