<script>
import AskCard from "../components/AskCard.vue";
import PlantCard from "../components/AskCard.vue";

import axios from "axios";

const PLANTS_API_BASE_URL = "http://localhost:8080/api/plants";

export default {
  name: "PlantList",
  components: { SearchPlantComponent, PlantCard },
  data() {
    return {
      plants: [],
    };
  },
  methods: {
    getPlants() {
      axios.get(PLANTS_API_BASE_URL).then((response) => {
        this.plants = response.data;
      });
    },
  },
  created() {
    this.getPlants();
  },
};
</script>

<template>
    <div class="box">
        <div class="background"></div>

        <div class="my-account-title">
            <h2>Mon</h2>
            <h1>Compte</h1>
        </div>

        <div class="edit-infos">
            <input type="email" placeholder="Email" class="saisie-text">
            <input type="password" placeholder="Mot de passe" class="saisie-text">

            <button class="edit">Modifier</button>
        </div>

        <h2>Plantes Gardées</h2>

        <PlantCard 
            v-for="(plant, index) in plants"
          :key="index"
          :plant="plant"
        />
    </div>
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

.my-account-title {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 120px;
}

.edit-infos {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.saisie-text {
    width: 340px;
    height: 60px;
    background: #FFFFFF;
    border: 1px solid #060825;
    border-radius: 5px;
    padding: 15px;
    margin: 10px;
}

.edit {
    width: 210px;
    height: 60px;
    background: #060825;
    box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
    border-radius: 5px;
    font-weight: 500;
    font-size: 16px;
    line-height: 20px;
    color: #FFFFFF;
    padding: 15px;
    margin: 10px;
}

.back {
  position: relative;
  max-width: 911px;
  width: 100%;
  height: 511px;
  background: #c5ffdc;
  filter: blur(125px);
  opacity: 0.25;
}


.my-plant {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

@media screen and (max-width: 1024px) {
  .edit-infos {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
}
</style>