<template>
  <div>
    <div>
      tresc pytania
      statyczna ilosc głosow
    </div>
    <div>
<!--      dodac 4 przykladowe odpowiedzi-->
      <div>
        tresc odpowiedzi
        ilosc głosow
      </div>
    </div>
    <div class="columnsTable">
      <div class="tableColumn">
        <div class="tableCell">Suma</div>
        <div class="tableCell">Srednia</div>
        <div class="tableCell">Mediana</div>
        <div class="tableCell">Dominanta</div>
        <div class="tableCell">Odchylenie st</div>
      </div>
      <div class="tableColumn">
        <div class="tableCell">bedzie wyliczoneS</div>
        <div class="tableCell">bedzie wyliczones</div>
        <div class="tableCell">bedzie wyliczoneM</div>
        <div class="tableCell">bedzie wyliczoneD</div>
        <div class="tableCell">bedzie wyliczoneO</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name:"QuestionStatistics"
}
</script>

<style scoped>
/*.tableCell{*/
/*  float: left;*/
/*  width: 50%;*/
/*}*/
/*.tableColumn:after{*/
/*  content: "";*/
/*  display: table;*/
/*}*/
.columnsTable {
  column-count: 2;
  border-style: solid;

  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.tableCell{
  border-style: groove;
  padding: 0.5em;
}
</style>