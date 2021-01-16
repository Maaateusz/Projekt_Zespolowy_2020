<template>
  <div>
    <form>
      <b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input>
      <b-form-input :type="`number`" v-model="valueMin" placeholder="Wartość minimalna..."></b-form-input>
      <b-form-input :type="`number`" v-model="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
      <b-form-group label="Mark Type">
        <b-form-radio checked="checked" v-model="markType" name="markTypeRadios" value="hearts">
          <div v-html="dictionary.heart+dictionary.heart+dictionary.heart"/>
        </b-form-radio>
        <b-form-radio v-model="markType" name="markTypeRadios" value="stars">
          <div v-html="dictionary.star + dictionary.star + dictionary.star"/>
        </b-form-radio>
      </b-form-group>
      <b-form-rating :icon-empty="(markType=='hearts')? 'heart' : 'star' "
                     :icon-half="(markType=='hearts')? 'heart-half' : 'star-half' "
                     :icon-full="(markType=='hearts')? 'heart-fill' : 'star-fill' "
                     disabled
                     :stars="valueMax-valueMin"></b-form-rating>
    </form>
    <div class="ratingAnchors">
      <p style="text-align: left" class="ratingAnchor">{{valueMin}}</p>
      <p style="text-align: right" class="ratingAnchor">{{valueMax}}</p>
    </div>
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
      valueMax: 3,
      valueMin: 0,
      dictionary: Dictionary
    }
  },
}
</script>

<style scoped>
.ratingAnchors{
  display: flex;
}

.ratingAnchor{
  flex: 1;
}

b-rating-form{
  display: unset;
}
</style>