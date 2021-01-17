<template>
  <div class="questionRating">
    <form>
      <div><b-form-input v-model="content" placeholder="Treść pytania..."></b-form-input></div>
      <div class="ratingValue">
      <b-form-input :type="`number`" v-model="valueMin" placeholder="Wartość minimalna..."></b-form-input>
      <b-form-input :type="`number`" v-model="valueMax" placeholder="Wartość maksymalna..."></b-form-input>
      </div>
      <b-form-group label="Mark Type">
        <div class="markType">
       <div class="mark1">
         <b-form-radio checked="checked" v-model="markType" name="markTypeRadios" value="hearts">
          <div v-html="dictionary.heart+dictionary.heart+dictionary.heart"/>
        </b-form-radio>
       </div>
          <div class="mark1">
        <b-form-radio v-model="markType" name="markTypeRadios" value="stars">
          <div v-html="dictionary.star + dictionary.star + dictionary.star"/>
        </b-form-radio>
        </div>
        </div>
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
      valueMax: '',
      valueMin: '',
      dictionary: Dictionary
    }
  },
}
</script>

<style scoped>
.questionRating{
  padding: 0.5em;
  border: 0.20em outset #ccc;
  border-radius: 0.15em;
}

.ratingValue{
  margin:auto;
  display: flex;
  width: auto;
  padding-top: 1em;
}

.ratingAnchors{
  display: flex;
}

.ratingAnchor{
  flex: 1;
}

b-rating-form{
  display: unset;
}

.markType {
  display: flex;
  justify-content: center;
}
</style>