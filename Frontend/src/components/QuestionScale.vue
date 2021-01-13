<template>
<!-- TODO  do poprawek typy inputow, tam gdzie liczby to trzeba ustawic liczby-->
  <div>
    <b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input>
    <b-form-input v-model="valueMin" placeholder="Wartość minimalna..."></b-form-input>
    <b-form-input :for="`type-number`" v-model="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
    {{ (valueMin && valueMax) != null ? valueMin : ""}}
    <b-form-input v-model="anchorLeft" placeholder="Skrajnie lewa wartość..."></b-form-input>
    {{ (valueMin+valueMax)/2}}
    <b-form-input v-model="anchorCentral" placeholder="Centralna wartość..."></b-form-input>
    {{valueMax}}
    <b-form-input v-model="anchorRight" placeholder="Skrajnie prawa wartość..."></b-form-input>
    <div>
      <label for="range-2">{{content}}</label>
      <b-form-input id="range-2" v-model="tempValue" type="range" :min="valueMin" :max="valueMax" step="1"></b-form-input>
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
export default {
  name: "QuestionScale",
  data(){
    return{
      content: '',
      valueMax: 1,
      valueMin: 0,
      anchorLeft: '',
      anchorCentral: '',
      anchorRight: '',
      tempValue: 0 //TODO same as in slider
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
</style>