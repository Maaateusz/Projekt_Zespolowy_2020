<template>
<!-- TODO  do poprawek typy inputow, tam gdzie liczby to trzeba ustawic liczby-->
  <div>
    <b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input>
    <b-form-input :for="`type-number`" v-model.number="valueMin" placeholder="Wartość minimalna..."></b-form-input>
    <b-form-input :for="`type-number`" v-model.number="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
    {{ (valueMin && valueMax) != null ? valueMin : ""}}
    <b-form-input v-model="anchorLeft" placeholder="Skrajnie lewa wartość..."></b-form-input>
    {{ (valueMin + valueMax)/2 }}
    <b-form-input v-model="anchorCentral" placeholder="Centralna wartość..."></b-form-input>
    {{valueMax}}
    <b-form-input v-model="anchorRight" placeholder="Skrajnie prawa wartość..."></b-form-input>
    <div>
      <input class = "form-control-range" v-model="value" type="range" :min="valueMin" :max="valueMax" step="1" />
      <div class="scaleAnchors">
        <p class="scaleAnchor">{{anchorLeft}}</p>
        <p class="scaleAnchor">{{anchorCentral}}</p>
        <p class="scaleAnchor">{{anchorRight}}</p>
      </div>
      <div class="mt-2">Value: {{ value }}</div>
    </div>
  </div>
</template>

<script>
//import VueSlider from 'vue-slider-component'
import 'vue-slider-component/theme/antd.css'


export default {
  name: "QuestionScale",

  data(){
    return{
      value: 0,
      content: '',
      valueMax: 1,
      valueMin: 0,
      anchorLeft: '',
      anchorCentral: '',
      anchorRight: ''
    }
  }
}
</script>

<style scoped>
.scaleAnchors{
  display: flex;
}

.scaleAnchor{
  flex: 1;
}
text{
  float: left;
  width: 75%;
  margin-top: 6px;
  flex-direction: column;

}
input{
  float: left;
  width: 25%;
  margin-top: 6px;
  flex-direction: column;
  align-self: flex-start;
}
</style>

