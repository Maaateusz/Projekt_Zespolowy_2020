<template>
  <div class="questionSlider">
    <div><b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input></div>
    <div class="sliderValue">
      <b-form-input :type="`number`" v-model="valueMin" placeholder="Wartość minimalna..."></b-form-input>
      <b-form-input :type="`number`" v-model="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
      <b-form-input :type="`number`" v-model="interval" placeholder="Wielkość kroku..."></b-form-input>
    </div>
    <div>
    </div>
    <div class="mt-2">Value: {{ tempValue }}</div>
      <b-form-input id="range-2" v-model="tempValue" type="range" :min="valueMin" :max="valueMax" :step="interval"></b-form-input>
      <div class="sliderAnchors">
        <p style="text-align: left" class="sliderAnchor">{{valueMin}}</p>
        <p style="text-align: right" class="sliderAnchor">{{valueMax}}</p>
      </div>
  </div>
</template>

<script>
export default {
  name: "QuestionSlider",
  data(){
    return{
      content: '',
      valueMax: '',
      valueMin: '',
      interval: '',
      tempValue: 0 //TODO prawdopodobnie do wywalenia
    }
  }
}
</script>

<style scoped>
.questionSlider{
  padding: 0.5em;
  border: 0.20em outset #ccc;
  border-radius: 0.15em;
}

.sliderAnchors{
  display: flex;
}

.sliderAnchor{
  flex: 1;
}

.sliderValue{
  margin:auto;
  display: flex;
  width: auto;
  padding-top: 1em;
  padding-bottom: 1em;
}
</style>