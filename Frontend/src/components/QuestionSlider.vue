<template>
  <div>
    <b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input>
    <b-form-input :type="`number`" v-model="valueMin" placeholder="Wartość minimalna..."></b-form-input>
    <b-form-input :type="`number`" v-model="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
    <b-form-input :type="`number`" v-model="interval" placeholder="Wielkość kroku..."></b-form-input>
    <div>
      <label for="range-2">{{content}}</label>
      <b-form-input id="range-2" v-model="tempValue" type="range" :min="valueMin" :max="valueMax" :step="interval"></b-form-input>
      <div class="sliderAnchors">
        <p style="text-align: left" class="sliderAnchor">{{valueMin}}</p>
        <p style="text-align: right" class="sliderAnchor">{{valueMax}}</p>
      </div>
      <div class="mt-2">Value: {{ tempValue }}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "QuestionSlider",
  data(){
    return{
      content: '',
      valueMax: 1,
      valueMin: 0,
      interval: 1,
      tempValue: 0 //TODO prawdopodobnie do wywalenia
    }
  }
}
</script>

<style scoped>
.sliderAnchors{
  display: flex;
}

.sliderAnchor{
  flex: 1;
}
</style>