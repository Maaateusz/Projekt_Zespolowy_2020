<template>
  <div class="Questionnaire">
    <form >
      <input class="form-control" type="text" name="questionaryName" value="" placeholder="Nazwa ankiety..." v-model="Questionary.questionaryName"/>
      <textarea class="form-control" v-model="Questionary.description" placeholder="Opis ankiety"/>
<!--      <div v-for="question in Questionary.questions"  :key="answer" :aria-describedby="ariaDescribedby">-->

<!--      </div>-->
      <QuestionsAddingArea v-on:newQuestionToAdd="newQuestion" />
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
          questions: [],
          questionsByType: [
            {
              choices: [
                {
                  type: 'single',
                  questions: []
                },
                {
                  type: 'multiple',
                  questions: []
                }
              ],
              ratings: [],
              scales: [],
              sliders: []
            }
          ],
          finishDate: ''
        }
    }
  },
  components:{
    QuestionsAddingArea
  },
  methods:{
    newQuestion: function (type){
      try {
        if (type == "singleChoice"){
          console.log("singleChoice")
        }else if (type == "multipleChoice"){
          console.log("multipleChoice")
        }else if (type == "scale"){
          console.log("scale")
        }else if (type == "slider"){
          console.log("slider")
        }else if (type == "rating"){
          console.log("rating")
        }else{
          throw("Bad question type");
        }
      }catch (msg){
        console.log(msg)
      }
    }
  }
};
</script>
<style scoped>
input{
  margin-bottom: 1em;
}
textarea{
  margin-bottom: 1em;
}
div{
  margin-bottom: 1em;
}
</style>