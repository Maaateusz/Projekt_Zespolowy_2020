<template>
  <div class="QuestionAddingArea">
    <p>#</p>
    <p>slider</p>
    <question-slider/>
    <p>rating</p>
    <question-rating/>
    <p>scale</p>
    <question-scale/>
    <p>choice single</p>
    <question-choice-single/>
    <p>choice multiple</p>
    <question-choice-multiple/>
  </div>
</template>

<script>
import QuestionScale from "@/components/QuestionScale";
import QuestionChoiceSingle from "@/components/QuestionChoiceSingle";
import QuestionChoiceMultiple from "@/components/QuestionChoiceMultiple";
import QuestionRating from "@/components/QuestionRating";
import QuestionSlider from "@/components/QuestionSlider";
export default {
  name: "QuestionAddingArea",
  components: {
    QuestionSlider,
    QuestionChoiceMultiple,
    QuestionChoiceSingle,
    QuestionScale,
    QuestionRating
  }
}
</script>

<style scoped>

</style>