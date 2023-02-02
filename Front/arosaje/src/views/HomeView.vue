<script setup>
import SearchComponent from '../components/SearchComponent.vue'
</script>

<template>
  <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
  <main>
    <div class="box">
      <div class="background"></div>

      <div class="head">
        <h2>Les</h2>
        <h1>Fleurs</h1>
        <h2>C'est mieux quand ça sent la rose ...</h2>

        <p>Utiliser A'rosa-je afin de les entretenir</p>

        <button class="explore">Commencer à explorer</button>
      </div>
      <SearchComponent />
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

.head {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 40px;
}

h1 {
  font-family: 'Montserrat';
  font-weight: 700;
  font-size: 72px;
  line-height: 88px;
  color: #060825;
}

h2 {
  font-family: 'Montserrat';
  font-size: 27px;
  line-height: 33px;
  color: #060825;
}

p {
  font-family: 'Montserrat';
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
  font-family: 'Montserrat';
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #FAFAFA;
  cursor: pointer;
  margin: 10px;
}
</style>