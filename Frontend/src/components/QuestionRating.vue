<!--TODO prawdopodobnie do poprawy w zwiazku z istnieniem w bootstrapie
https://bootstrap-vue.org/docs/components/form-rating#accessibility -->
<template>
  <div>
    <form>
      <b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input>
      <b-form-input v-model="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
      <b-form-input v-model="valueMin" placeholder="Wartość minimalna..."></b-form-input>
      <b-form-group label="Mark Type">
        <b-form-radio checked="checked" v-model="markType" name="markTypeRadios" value="hearts">
          <div v-html="dictionary.heart+dictionary.heart+dictionary.heart"/>
        </b-form-radio>
        <b-form-radio v-model="markType" name="markTypeRadios" value="stars">
          <div v-html="dictionary.star + dictionary.star + dictionary.star"/>
        </b-form-radio>
      </b-form-group>
    </form>
  </div>
</template>

<script>
import {Dictionary} from "@/Util/Dictionary";

export default {
  name: "QuestionRating",
  data(){
    return{
      content: '',
      markType: 'hearts',
      valueMax: 0,
      valueMin: 0,
      dictionary: Dictionary
    }
  },
}
</script>

<style scoped>

</style>