<template>
  <div class="card">
    <div class="container">
      <div class="card_title"><h2>Plantes</h2></div>
      <div class="card-image">
        <img
          src="https://www.pngmart.com/files/21/Aesthetic-Plant-Transparent-PNG.png"
        />
      </div>
      <div class="card-button">
        <button type="button" class="voirbtn">Voir plus</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PlantCard",
  data() {
    return {
      asks: [],
    };
  },
  methods: {
    getAsks() {
      AsksService.getAsks().then((response) => {
        this.asks = response.data;
      });
    },
  },
  created() {
    this.getAsks();
  },
};

import axios from "axios";

const ASKS_API_BASE_URL = "http://localhost:8080/api/plants";

class AsksService {
  getAsks() {
    return axios.get(ASKS_API_BASE_URL);
  }
}
</script>

<style scoped>
.card { 
  width: 300px;
  margin: 30px;
  background: #ffffff;
  box-shadow: 0px 0px 70px rgba(19, 59, 83, 0.15);
  border-radius: 10px;
  color: black;
}

.card-image {
  height: 250px;
  position: relative;
  overflow: hidden;
}

.card-image img {
  width: 150%;
  position: absolute;
  left: -20%;
}

.container {
  text-align: center; /*1*/
  padding: 15px 20px; /*2*/
  box-sizing: border-box; /*3*/
}

.card_title,
.card-description {
  font-family: "Playfair Display", serif;
}

.card-description,
.card_title {
  text-align: center;
  text-transform: uppercase;
  font-weight: bold;
}

.card-button button {
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 5px;
  color: white;
}
</style>