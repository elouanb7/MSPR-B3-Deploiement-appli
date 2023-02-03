<script setup>
import SearchComponent from '../components/SearchComponent.vue'
import AskCard from '../components/AskCard.vue'
</script>

<template>
  <main>
    <div class="box">
      <div class="background"></div>

      <div class="hometitle">
        <h2>Trouvez une</h2>
        <h1>Plante</h1>
        <h2>à garder</h2>
      </div>

      <SearchComponent />

      <div class="cards">
        <AskCard />
        <AskCard />
        <AskCard />
      </div>

      <a href="">
        <button class="more-ask">Plus de plantes</button>
      </a>
    </div>
  </main>
</template>

<style>
.box {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.background {
  position: relative;
  max-width: 422px;
  width: 100%;
  height: 422px;
  background: #C5FFDC;
  filter: blur(125px);
  opacity: 0.25;
}

.hometitle {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 175px;
}

.cards {
    display: flex;
    flex-wrap: wrap;
    columns: 3;
    align-items: center;
}

.more-ask {
    width: 210px;
    height: 60px;
    background: #060825;
    box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
    border-radius: 30px;
    font-weight: 500;
    font-size: 16px;
    line-height: 20px;
    text-align: center;
    color: #FAFAFA;
    cursor: pointer;
}
</style>