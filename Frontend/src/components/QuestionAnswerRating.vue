<template>
  <div>
    <p>Tresc pytania oceny</p>
    <div class="ratingBox">
      <b-form-rating v-model="value" variant="primary" class="mb-2" stars="5" ></b-form-rating>
    </div>
  </div>
</template>

<script>
export default {
  name:"QuestionAnswerRating",
  data() {
    return {
      value: null
    }
  }
}
</script>

<style scoped>
.ratingBox{
  display: flex;
  padding-left: 39em;
  padding-right: 39em;
}

</style>