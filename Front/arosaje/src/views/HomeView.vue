<script setup>
import SearchAskComponent from "../components/SearchAskComponent.vue";
</script>

<template>
  <link
    href="https://fonts.googleapis.com/css?family=Montserrat"
    rel="stylesheet"
  />
  <main>
    <div class="box">
      <div class="background"></div>

      <div class="hometitle">
        <h2>Les</h2>
        <h1>Fleurs</h1>
        <h2>C'est mieux quand ça sent la rose ...</h2>

        <p>Utiliser A'rosa-je afin de les entretenir</p>

        <RouterLink to="/carte"
          ><button class="explore">Commencer à explorer</button></RouterLink
        >
      </div>
      <SearchAskComponent />
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

.hometitle {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 100px;
}

p {
  font-weight: 400;
  font-size: 14px;
  line-height: 17px;
  color: #777777;
  margin: 10px;
}

.explore {
  max-width: 210px;
  width: 100%;
  height: 60px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #fafafa;
  cursor: pointer;
  margin: 10px;
}
</style>
