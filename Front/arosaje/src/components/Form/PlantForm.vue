<template>
  <div class="box-form">
    <h2 class="title-form">Plante</h2>
    <div class="container-form">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description" />
        </fieldset>
        <fieldset class="form-group">
          <label>Nom</label>
          <input type="text" class="form-control" v-model="name" />
        </fieldset>
        <fieldset class="form-group">
          <label>Nom Latin</label>
          <input type="text" class="form-control" v-model="latinName" />
        </fieldset>
        <fieldset class="form-group">
          <label>Espèce</label>
          <input type="text" class="form-control" v-model="species" />
        </fieldset>
        <fieldset class="form-group">
          <label>Exposition au soleil (en h)</label>
          <input type="number" class="form-control" v-model="sunExposure" />
        </fieldset>
        <fieldset class="form-group">
          <label>Fréquence d'arosage (nombre de fois / j)</label>
          <input
            type="number"
            class="form-control"
            v-model="wateringFrequency"
          />
        </fieldset>
        <button type="submit" class="save-button">Save</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

import { API_BASE_URL } from "@/constants.js";

export default {
  name: "PlantForm.vue",
  data() {
    return {
      plant: null,
    };
  },
  methods: {
    validateAndSubmit() {
      let plant = {
        description: this.description,
        latinName: this.latinName,
        name: this.name,
        species: this.species,
        sunExposure: this.sunExposure,
        wateringFrequency: this.wateringFrequency,
        image: null,
      };
      this.addPlant(plant, 2);
    },
    addPlant(plant, botanistId) {
      console.log(API_BASE_URL);
      axios
        .post(`${API_BASE_URL}/plant/add?botanistId=${botanistId}`, plant)
        .then((response) => {
          this.plant = response.data;
        });
    },
  },
};
</script>

<style scoped>
.box-form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container-form {
  max-width: 450px;
  padding: 0 20px;
  margin-top: 275px;
}

.title-form {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 175px;
}

form {
  position: relative;
  max-width: 422px;
  width: 100%;
  height: 422px;
}

fieldset {
  border: none;
  font-weight: 400;
  font-size: 16px;
  line-height: 24px;
  color: #515151;
  border-bottom: 1px solid #3d3b36;
  padding-bottom: 15px;
  margin-top: 15px;
}

input {
  margin: 10px;
}

.save-button {
  width: 190px;
  height: 50px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  text-align: center;
  color: #fafafa;
  margin: 15px;
}
</style>
