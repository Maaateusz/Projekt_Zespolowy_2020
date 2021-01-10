<template>
  <div class="Questionnaire">
    <form>
      <input type="text" name="questionaryName" value="" placeholder="Nazwa ankiety..." v-model="Questionary.questionaryName"/>
      <textarea v-model="Questionary.description" placeholder="Opis ankiety"/>
      <QuestionsAddingArea/>
      <input type="date"/>
      <input type="submit" value="Zapisz"> 
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