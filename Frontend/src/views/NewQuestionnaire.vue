<template>
  <div class="Questionnaire">
    <form >
      <input class="form-control" type="text" name="questionaryName" value="" placeholder="Nazwa ankiety..." v-model="Questionary.questionaryName"/>
      <textarea class="form-control" v-model="Questionary.description" placeholder="Opis ankiety"/>
<!--      <div v-for="question in Questionary.questions"  :key="answer" :aria-describedby="ariaDescribedby">-->

<!--      </div>-->
      <p>Suwak</p>
      <QuestionSlider />
      <p>Skala</p>
      <QuestionScale />
      <p>Ocena</p>
      <QuestionRating />
      <p>Pytanie jednokrotnego wyboru</p>
      <QuestionChoiceSingle />
      <p>Pytanie wielokrotnego wyboru</p>
      <QuestionChoiceMultiple />
      <QuestionsAddingArea v-on:newQuestionToAdd="newQuestion" />
      <input style="margin: 2%; width:96%" class="form-control" type="date"/>
      <button style="margin-right: 2%" class="btn btn-outline-dark" type="button" v-on:click.prevent="post">Zapisz</button>
    </form>
  </div>
</template>

<script>
import QuestionsAddingArea from "@/components/QuestionsAddingArea";
import QuestionSlider from "@/components/QuestionSlider";
import QuestionScale from "@/components/QuestionScale";
import QuestionRating from "@/components/QuestionRating";
import QuestionChoiceSingle from "@/components/QuestionChoiceSingle";
import QuestionChoiceMultiple from "@/components/QuestionChoiceMultiple";
export default {
  name: "NewQuestionnaire",
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
    QuestionChoiceMultiple,
    QuestionChoiceSingle,
    QuestionRating,
    QuestionScale,
    QuestionSlider,
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
    },
    post: function (){
      this.$http.post('https://ankietbud2020.herokuapp.com/surveyService/vote',{
       // id_survey: 13,
       // id_questions: [14, 15, 16, 17, 18],
       // id_answers: [[1], [1, 2], [3], [7], [1]]
      //   survey:{
      //       name:"AgataXD!!!!!1111",
      //       description:"SurveyTest1 opis",
      //       status:"open",
      //       creationDate:"2021-01-07T18:31:33",
      //       endDate:"2021-11-07T20:00:00"
      // },
      //   choices:[
      //   {
      //     content:"Choice_single_1",
      //     votes:[
      //       0,
      //       0,
      //       0
      //     ],
      //     sum:0,
      //     type:"single",
      //     answers:[
      //       "Answer_1",
      //       "Answer_2",
      //       "Answer_3"
      //     ]
      //   },
      //   {
      //     content:"Choice_multiple_1",
      //     votes:[
      //       0,
      //       0,
      //       0
      //     ],
      //     sum:0,
      //     type:"multiple",
      //     answers:[
      //       "Answer_1",
      //       "Answer_2",
      //       "Answer_3"
      //     ]
      //   }
      // ],
      //     ratings:[
      //   {
      //     content:"Rating_1",
      //     votes:[
      //       0,
      //       0,
      //       0,
      //       0,
      //       0,
      //       0
      //     ],
      //     sum:0,
      //     type:"stars",
      //     value_max:6,
      //     value_min:1
      //   }
      // ],
      //     scales:[
      //   {
      //     content:"Scale_1",
      //     votes:[
      //       0,
      //       0,
      //       0,
      //       0,
      //       0,
      //       0,
      //       0,
      //       0,
      //       0,
      //       0
      //     ],
      //     sum:0,
      //     anchor_central:"Central",
      //     anchor_left:"Left",
      //     anchor_right:"Right",
      //     value_max:10,
      //     value_min:1
      //   }
      // ],
      //     sliders:[
      //   {
      //     content:"Slider_1",
      //     votes:[
      //       0,
      //       0
      //     ],
      //     sum:0,
      //     value_min:10,
      //     value_max:20,
      //     interval:10
      //   }
      // ]
    }).then(function(data){
        console.log(data);
      });
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