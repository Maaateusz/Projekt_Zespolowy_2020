<template>
  <div class="about">
    <h3>TEXTBOX</h3>
    <input v-model="name" placeholder="Enter Name" />
    <h3>
      <p>Name entered is : {{ name }}</p>
    </h3>
    <hr />
    <h3>Textarea</h3>
    <textarea v-model="textmessage" placeholder="Add Details"></textarea>
    <h3>
      <p>Text: {{ textmessage }}</p>
    </h3>
    <hr />
    <h3>Checkbox</h3>
    <input type="checkbox" id="checkbox" v-model="checked" /> {{ checked }}
    <hr />
    <h3>Radio</h3>
    <input type="radio" id="black" value="Black" v-model="picked" />Black
    <input type="radio" id="white" value="White" v-model="picked" />White
    <h3>Radio element clicked : {{ picked }}</h3>
    <hr />
    <h3>Select</h3>
    <select v-model="languages">
      <option disabled value="">Please select one</option>
      <option>A</option>
      <option>B</option>
      <option>C</option>
      <option>D</option>
    </select>
    <h3>Languages Selected is : {{ languages }}</h3>
    <hr />
  </div>
</template>

<script>
export default {
  name: "about",
  props: {
    name: String,
    textmessage: String,
    languages: String,
    picked() {}
  }
};
</script>
