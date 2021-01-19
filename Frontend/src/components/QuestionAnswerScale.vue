<template>
  <div>
    <label >Tresc pytania skali</label>
    <div class="scaleBox">
      <input class = "form-control-range"  v-model="value" type="range" :min="0" :max="10" :step="10/4" />
      <div class="mt-2">Value: {{ value }}</div>
    </div>
  </div>
</template>

<script>
export default {
  name:"QuestionAnswerScale",
  data() {
    return {
      value: 0
    }
  }
};
</script>

<style scoped>
.scaleBox{
  display: flex;
  padding-left: 39em;
  padding-right: 39em;
}
</style>