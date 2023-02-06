<script>
import PlantCard from "@/components/PlantCard.vue";
import SearchPlantComponent from "@/components/SearchPlantComponent.vue";

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
  <main>
    <div class="box">
      <div class="background"></div>

      <div class="plantstitle">
        <h2>La Liste des</h2>
        <h1>Plantes</h1>
      </div>
      <SearchPlantComponent />
      <div class="cards">
        <PlantCard
          v-for="(plant, index) in plants"
          :key="index"
          :plant="plant"
        />
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

.plantstitle {
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
  columns: 4;
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
  color: #fafafa;
  cursor: pointer;
  margin-bottom: 60px;
}
</style>