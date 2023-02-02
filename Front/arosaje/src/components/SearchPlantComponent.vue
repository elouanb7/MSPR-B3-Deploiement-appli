<script>
export default {
  data() {
    return {
      display: false,
      alphabet: "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
    };
  },
};
</script>

<template>
  <div class="SearchBar">
    <div v-if="display === false" id="letters">
      <a v-for="(char, index) in alphabet" :key="index" href="#">
        {{ ` ` + char + ` ` }}
      </a>
    </div>
    <div v-else class="buttons">
      <input type="text" placeholder="" />
      <button>Chercher une plante</button>
    </div>
    <a href="#" @click="display = !display">
      <span v-if="display === false">Afficher la barre de recherche</span>
      <span v-else>Afficher les initiales</span>
    </a>
  </div>
</template>

<style>
.SearchBar {
  max-width: 970px;
  width: 100%;
  background: #ffffff;
  box-shadow: 0px 0px 70px rgba(19, 59, 83, 0.15);
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  padding: 30px;
}

#letters {
  display: flex;
  justify-content: space-between;
}

.buttons {
  display: flex;
  flex-direction: row;
}

h3 {
  margin: 5px;
}

select {
  max-width: 340px;
  width: 100%;
  height: 60px;
  background: #ffffff;
  border: 1px solid #060825;
  border-radius: 5px;
  font-family: "Montserrat";
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #060825;
  padding: 15px;
  margin: 5px;
}

input {
  max-width: 340px;
  min-width: 150px;
  width: 100%;
  height: 60px;
  background: #ffffff;
  border: 1px solid #060825;
  border-radius: 5px;
  font-family: "Montserrat";
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #060825;
  padding: 15px;
  margin: 5px;
}

button {
  max-width: 210px;
  width: 100%;
  height: 60px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 5px;
  font-family: "Montserrat";
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  color: #ffffff;
  margin: 5px;
}

@media screen and (max-width: 1024px) {
  .buttons {
    display: flex;
    flex-direction: column;
  }
}
</style>
