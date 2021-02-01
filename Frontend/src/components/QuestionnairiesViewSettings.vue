<template>
  <div class="questionnairiesViewSettings">
    <div class="viewsList">
      <b-dropdown id="dropdown-offset" offset="25" text="Wyświetl na stronie" class="m-2">
        <b-dropdown-item href="#">10</b-dropdown-item>
        <b-dropdown-item href="#">30</b-dropdown-item>
        <b-dropdown-item href="#">ALL</b-dropdown-item>
      </b-dropdown>
    </div>
    <div id="sortLista">
      <b-dropdown id="dropdown-offset" offset="25" text="Sortuj" class="m-2">
        <b-dropdown-item href="#">Data</b-dropdown-item>
        <b-dropdown-item href="#">Alfabetycznie</b-dropdown-item>
      </b-dropdown>
    </div>
    <button style="margin-right: 2%" class="btn btn-outline-dark" type="button" >Zastosuj</button>
  </div>
</template>

<script>
export default {
  name: "QuestionnairiesViewSettings",
}
</script>

<style scoped>

</style>
