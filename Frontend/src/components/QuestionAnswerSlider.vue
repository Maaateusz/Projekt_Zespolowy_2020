<!--TODO znacznik nad sliderem -->

<template>
  <div>
    <label >Tresc pytania suwak</label>
    <div class="sliderBox">
      <b-form-input id="range-2" v-model="value" type="range" :min="valueMin" :max="valueMax" :step="interval"></b-form-input>
      <div class="mt-2">Value: {{ value }}</div>
     </div>
  </div>
</template>

<script>
export default {
  name:"QuestionAnswerSlider",
  data() {
    return {
      valueMin: 0,
      valueMax: 50,
      interval: 5,
      value: 0
    }
  }
}
</script>

<style scoped>
.sliderBox{
  display: flex;
  padding-left: 39em;
  padding-right: 39em;
}
</style>