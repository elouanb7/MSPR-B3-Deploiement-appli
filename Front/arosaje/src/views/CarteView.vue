<script setup>
import SearchAskComponent from "../components/SearchAskComponent.vue";
import AskCard from "../components/AskCard.vue";
</script>

<template>
  <main>
    <div class="box">
      <div class="background"></div>

      <div class="maptitle">
        <h2>Trouvez une</h2>
        <h1>Plante</h1>
        <h2>à garder</h2>
      </div>

      <SearchAskComponent />

      <div class="cards">
        <AskCard />
        <AskCard />
        <AskCard />
      </div>
      <button class="more-ask">Plus de plantes</button>
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
  background: #c5ffdc;
  filter: blur(125px);
  opacity: 0.25;
}

.maptitle {
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
  background: var(--main-color);
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  text-align: center;
  color: #fafafa;
  cursor: pointer;
  margin-bottom: 60px;
}
</style>
