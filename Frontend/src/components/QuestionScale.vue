<template>
  <div class="questionScale">
    <div><b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input></div>
    <div class="scaleValue">
        <b-form-input :type="`number`" v-model.number="valueMin" placeholder="Wartość minimalna..."></b-form-input>
        <b-form-input :type="`number`" v-model.number="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
        </div>
        <div class="scaleValueTxt">
          <b-form-input v-model="anchorLeft" placeholder="Skrajnie lewa wartość..."></b-form-input>
          <b-form-input v-model="anchorCentral" placeholder="Centralna wartość..."></b-form-input>
          <b-form-input v-model="anchorRight" placeholder="Skrajnie prawa wartość..."></b-form-input>
          </div>
          <div class="txtValue">
            <div class="1">{{ (typeof valueMax === 'number' && typeof valueMin === 'number') ? valueMin : ""}}</div>
            <div class="1">{{ (typeof valueMax === 'number' && typeof valueMin === 'number') ? (valueMin + valueMax)/2 : "" }}</div>
            <div class="1">{{ (typeof valueMax === 'number' && typeof valueMin === 'number') ? valueMax : "" }}</div>
          </div>
      <div>
      <div class="mt-2">Value: {{ value }}</div>
      <input class = "form-control-range"  v-model="value" type="range" :min="valueMin" :max="valueMax" :step="(valueMax-valueMin)/4" />
      <div class="scaleAnchors">
        <p style="text-align: left" class="scaleAnchor">{{anchorLeft}}</p>
        <p class="scaleAnchor">{{anchorCentral}}</p>
        <p style="text-align: right" class="scaleAnchor">{{anchorRight}}</p>
      </div>
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
.questionScale{
  padding: 0.5em;
  border: 0.20em outset #ccc;
  border-radius: 0.15em;
}
.scaleAnchors{
  display: flex;
}

.scaleAnchor{
  flex: 1;
}
.scaleValueTxt,.mt-2,.scaleValue{
  margin:auto;
  display: flex;
  width: auto;
  padding-top: 1em;
}
.txtValue{
  display: flex;
  justify-content: space-between;
}
</style>

